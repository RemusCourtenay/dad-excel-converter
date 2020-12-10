package dosStuff.fileCreators;

import dosStuff.FileIOThreadManager;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

/**
 * @author Remus Courtenay - rcou199
 * @since 13/11/2020
 */
public class CellFormatsFileCreator extends FileCreator {

    // Top level comment in file explaining how to edit it.
    private static final String CELL_FORMATS_FILE_COMMENT = "Lists the excel format codes used for each data types. Entries follow the format: (Name),(Format Code) with no spaces. See https://exceljet.net/custom-number-formats for a guide to creating number formats but note that spaces must be replaced with an underscore. To use an underscore within the code, add the escape character '\\ before the underscore.'";

    @Override
    public void createDefaultFile(String fileAddress) {

        Workbook cellFormatsWorkbook = new XSSFWorkbook();
        CreationHelper cellFormatsCreationHelper = cellFormatsWorkbook.getCreationHelper();

        Sheet cellFormatsSheet = cellFormatsWorkbook.createSheet("Cell Formats");
        Row saveDataRow = cellFormatsSheet.createRow(0);

        int i = 0;
        for (DefaultCellFormatTypes formatType: DefaultCellFormatTypes.values()) {
            Cell cell = saveDataRow.createCell(i);
            cell.setCellValue(formatType.getName());
            cell.setCellStyle(formatType.getCellStyle());

        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileAddress);
            cellFormatsWorkbook.write(fileOutputStream);
            fileOutputStream.close();

            cellFormatsWorkbook.close();
        } catch (Exception e) {
            //todo...
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
