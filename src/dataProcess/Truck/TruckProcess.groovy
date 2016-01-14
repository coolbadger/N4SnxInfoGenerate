package dataProcess.Truck

import fileLoader.XlsLoader
import fileLoader.XlsRow

/**
 * Created by Badger on 16/1/14.
 */
class TruckProcess extends XlsLoader {

    List<TruckInfo> truckInfoList

    TruckProcess(String filePath) {
        super(filePath)
        truckInfoList = new ArrayList<TruckInfo>()
        processData()
    }

    public def getSnx() {
        return TruckSnxCreater.getSnx(this.truckInfoList)
    }

    public void processData() {

        //暂时取固定批次号
        int sheetCount = workbook.size()
        int currentSheet = 1
        int itemIndex = 0
        workbook.each { sheet ->
            logger.info("读取Sheet(" + currentSheet + "/" + sheetCount + "):" + sheet.sheetName)
//            logger.info("一共有" + sheet.lastRowNum + "行数据")

            //处理每一行数据
            sheet.eachWithIndex { row, index ->
                XlsRow xlsRow = new XlsRow(row)
                boolean read_correct = true

                if (index == 0) {//检查标题行
                    logger.info("检查标题行......")
                    if (xlsRow.getCellValue(0) != '流水号') read_correct = false
                    if (xlsRow.getCellValue(1) != '代码') read_correct = false
                    if (xlsRow.getCellValue(2) != '车号') read_correct = false
                    if (xlsRow.getCellValue(3) != '长度') read_correct = false
                    if (xlsRow.getCellValue(4) != '自重') read_correct = false
                    if (xlsRow.getCellValue(5) != '电话') read_correct = false
                    if (xlsRow.getCellValue(6) != '公司代码') read_correct = false
                    if (xlsRow.getCellValue(7) != '公司') read_correct = false

                    if (read_correct == false) {
                        logger.info("Excel文件列名错误！")
                    } else {
                        logger.info("标题行列名正确,开始处理数据……")
                    }
                } else if (xlsRow.getCellValue(0)) {
                    itemIndex++
                    TruckInfo newTruckInfo = new TruckInfo(xlsRow.getCellValue(2))
                    newTruckInfo.truckWeight = xlsRow.getCellValue(4)
                    newTruckInfo.tellNbr = xlsRow.getCellValue(5)
                    newTruckInfo.setTruckCompCode(xlsRow.getCellValue(6))
                    truckInfoList.add(newTruckInfo)
                }
            }
        }
        logger.info("一共有" + itemIndex + "条有效数据")
    }
}
