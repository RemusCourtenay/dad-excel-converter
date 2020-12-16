package dosStuff.fileCreators;

import dosStuff.FileIOThreadManager;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

/**
 * Extension of abstract FileCreator class that specifically creates the headers text file. Methods only change header
 * file if the file does not already exist.
 *
 * @author Remus Courtenay - rcou199
 * @since 11/11/2020
 */
public class HeadersFileCreator extends FileCreator {

    // Top level comment in header file explaining how to edit it.
//    private static final String HEADERS_FILE_COMMENT =
//            "Add new headers on a new line with the format: (name),(column type) with no spaces. Valid column types are: " // Don't use <> characters
//                    + STRING_CELL + ", "
//                    + NUMERIC_CELL + ", "
//                    + BOOLEAN_CELL + ", "
//                    + FORMULA_CELL + " and "
//                    + BLANK_CELL + "."
//                    + " If you make a change to this file, you will need to restart the program for it to take effect."
//            ;

    public HeadersFileCreator() {} // TODO... add title to superclass constructor

    @Override
    public void createDefaultFile(String fileAddress) {
        SheetConditionalFormatting sheetConditionalFormatting = saveDataSheet.getSheetConditionalFormatting();
        Row saveDataNameRow = saveDataSheet.createRow(0);
        Row saveDataFormatNameRow = saveDataSheet.createRow(1);
        Row saveDataConditionalFormatNameRow = saveDataSheet.createRow(2);
        Row saveDataValueRow = saveDataSheet.createRow(3);

        Cell nameCell;
        Cell formatNameCell;
        Cell conditionalFormatNameCell;
        Cell valueCell;
        DefaultHeaderTypes headerType;

        for (int i = 0; i<DefaultHeaderTypes.values().length; i++) {
            nameCell = saveDataNameRow.createCell(i);
            formatNameCell = saveDataFormatNameRow.createCell(i);
            conditionalFormatNameCell = saveDataConditionalFormatNameRow.createCell(i);
            valueCell = saveDataValueRow.createCell(i);
            headerType = DefaultHeaderTypes.values()[i];

            headerType.setupSaveDataNameCell(nameCell);
            headerType.setupSaveDataValueCells(
                    formatNameCell,
                    conditionalFormatNameCell,
                    valueCell,
                    saveDataWorkbook.createCellStyle(),
                    sheetConditionalFormatting);
        }

        super.resizeColumnsToFit();
        super.writeWorkbookToFile(fileAddress);
    }
}
