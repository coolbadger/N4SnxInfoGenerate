package fileLoader

import main.Logger
import main.UiGlobal
import org.apache.poi.hssf.usermodel.HSSFWorkbook

/**
 * Created by Badger on 16/1/8.
 */
class XlsLoader {
    private File file
    public HSSFWorkbook workbook
    public Logger logger

    public XlsLoader(String filePath) {
        loadFile(filePath)
    }

    public void loadFile(String filePath) {
        file = new File(filePath)
        workbook = new HSSFWorkbook(new FileInputStream(file))
        logger = UiGlobal.logger
    }

}
