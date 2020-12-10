package dosStuff.fileCreators;

import dosStuff.FileIOThreadManager;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

/**
 * Extension of abstract FileCreator class that specifically creates the condition cell formats file. Methods only
 * change file if the file does not already exist.
 *
 * @author Remus Courtenay - rcou199
 * @since 11/11/2020
 */
public class ConditionalCellFormatsFileCreator extends FileCreator {

    // Top level comment in file explaining how to edit it
    private static final String CONDITIONAL_CELL_FORMATS_FILE_COMMENT = "Lists the excel formula for each conditional cell format used in the sheets. Entries follow the format: (Name),(Excel Formula) with no spaces. Note that all commas in the formulae have been replaced with fullstops. If you need to use a fullstop in the formula then add an additional \\ before the fullstop.";

    @Override
    public void createDefaultFile(String fileAddress) { // TODO... add comments and pull out shared method
        Workbook cellConditionalFormatsWorkbook = new XSSFWorkbook();
        CreationHelper cellFormatsCreationHelper = cellConditionalFormatsWorkbook.getCreationHelper();

        Sheet cellFormatsSheet = cellConditionalFormatsWorkbook.createSheet("Conditional Cell Formats");
        SheetConditionalFormatting sheetConditionalFormatting = cellFormatsSheet.getSheetConditionalFormatting();

        ConditionalFormattingRule conditionalFormattingRule;

        PatternFormatting conditionalFormatPatternFill;
        Row saveDataRow = cellFormatsSheet.createRow(0);

        int i = 0;
        for (DefaultConditionalCellFormatTypes conditionalCellFormat: DefaultConditionalCellFormatTypes.values()) {
            Cell cell = saveDataRow.createCell(i);
            conditionalCellFormat.setupSaveDataCell(cell, sheetConditionalFormatting);
            i++;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileAddress);
            cellConditionalFormatsWorkbook.write(fileOutputStream);
            fileOutputStream.close();

            cellConditionalFormatsWorkbook.close();
        } catch (Exception e) {
            //todo...
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
