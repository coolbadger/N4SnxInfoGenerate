package fileLoader

import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.ss.usermodel.Row

/**
 * Created by Badger on 16/1/14.
 */
class XlsRow {
    private Row xlsRow

    public XlsRow(Row row) {
        xlsRow = row
    }

    def getCellVal(HSSFCell cell) {
        if (cell == null) return ""
        else {
            def value
            switch (cell.getCellType()) {
                case HSSFCell.CELL_TYPE_BOOLEAN:
                    value = cell.getBooleanCellValue();
                    break
                case HSSFCell.CELL_TYPE_ERROR:
                    value = cell.getErrorCellValue()
                    break
                case HSSFCell.CELL_TYPE_NUMERIC:
                    value = "" + cell.getNumericCellValue()
                    for (int i = 0; i < value.length(); i++) {
                        if (".".equals(value.charAt(i))) {
                            //有小数点
                        } else {
                            //无小数点，转换为int后转换为String
                            value = "" + ((int) Double.parseDouble(value))
                        }
                    }
                    break
                case HSSFCell.CELL_TYPE_STRING:
                    value = cell.getStringCellValue()
                    break
                default:
                    value = ""
            }
            return value
        }

    }

    def stripe = {
        it.toString().reverse().stripIndent().reverse().stripIndent()
    }

    def getCellValue(int cellIndex) {
        return stripe.call(getCellVal(xlsRow.getCell(cellIndex)))
    }
}
