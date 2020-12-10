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

    // Default cell formats used if the file does not already exist
    private static final String[][] DEFAULT_FORMAT_TYPES = {
            DefaultCellFormatTypes.NONE.getSaveData(),
            DefaultCellFormatTypes.TEXT.getSaveData(),
            DefaultCellFormatTypes.ADDRESS.getSaveData(),
            DefaultCellFormatTypes.POST_CODE.getSaveData(),
            DefaultCellFormatTypes.EMAIL.getSaveData(),
            DefaultCellFormatTypes.PHONE_NUMBER.getSaveData(),
            DefaultCellFormatTypes.GENDER.getSaveData(),
            DefaultCellFormatTypes.ID_NUMBER.getSaveData(),
            DefaultCellFormatTypes.TAG_NUMBER.getSaveData(),
            DefaultCellFormatTypes.TIME.getSaveData(),
            DefaultCellFormatTypes.DISTANCE.getSaveData(),
            DefaultCellFormatTypes.DATE.getSaveData(),
            DefaultCellFormatTypes.EVENT.getSaveData()
    };

    @Override
    public void createDefaultFile(String fileAddress) {

        Workbook cellFormatsWorkbook = new XSSFWorkbook();
        CreationHelper cellFormatsCreationHelper = cellFormatsWorkbook.getCreationHelper();

        Sheet cellFormatsSheet = cellFormatsWorkbook.createSheet("Cell Formats");
        Row saveDataRow = cellFormatsSheet.createRow(0);

        for (int i = 0; i < DEFAULT_FORMAT_TYPES.length; i++) {
            Cell cell = saveDataRow.createCell(i);
            cell.setCellValue(DEFAULT_FORMAT_TYPES[i][0]);

            CellStyle cellStyle = cellFormatsWorkbook.createCellStyle();
            cellStyle.setDataFormat(cellFormatsCreationHelper.createDataFormat().getFormat(DEFAULT_FORMAT_TYPES[i][1]));
            cell.setCellStyle(cellStyle);
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

        // writeToFileWithComment(CELL_FORMATS_FILE_COMMENT, DEFAULT_FORMAT_TYPES, fileAddress);
    }
}
