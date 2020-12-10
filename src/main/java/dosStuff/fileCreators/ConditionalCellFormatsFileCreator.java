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

    private static final String specificCellStandIn = DefaultConditionalCellFormatTypes.getSpecificCellStandIn();

    // Top level comment in file explaining how to edit it
    private static final String CONDITIONAL_CELL_FORMATS_FILE_COMMENT = "Lists the excel formula for each conditional cell format used in the sheets. Entries follow the format: (Name),(Excel Formula) with no spaces. Note that all commas in the formulae have been replaced with fullstops. If you need to use a fullstop in the formula then add an additional \\ before the fullstop.";

    // Default values to use if file does not already exist
    private static final String[][] DEFAULT_CONDITION_CELL_FORMATS = {
            DefaultConditionalCellFormatTypes.NONE.getSaveData(),
            DefaultConditionalCellFormatTypes.PROPER.getSaveData(),
            DefaultConditionalCellFormatTypes.UPPERCASE.getSaveData(),
            DefaultConditionalCellFormatTypes.DISTANCE_UNIT.getSaveData(),
            DefaultConditionalCellFormatTypes.VALID_POSTCODE.getSaveData(),
            DefaultConditionalCellFormatTypes.VALID_EMAIL.getSaveData(),
            DefaultConditionalCellFormatTypes.VALID_PHONE.getSaveData(),
            DefaultConditionalCellFormatTypes.VALID_REGISTRATION_ID.getSaveData(),
            DefaultConditionalCellFormatTypes.VALID_RACE_NUMBER.getSaveData(),
            DefaultConditionalCellFormatTypes.VALID_TAG_NUMBER.getSaveData()
    };

    @Override
    public void createDefaultFile(String fileAddress) { // TODO... add comments and pull out shared method
        Workbook cellConditionalFormatsWorkbook = new XSSFWorkbook();
        CreationHelper cellFormatsCreationHelper = cellConditionalFormatsWorkbook.getCreationHelper();

        Sheet cellFormatsSheet = cellConditionalFormatsWorkbook.createSheet("Conditional Cell Formats");
        SheetConditionalFormatting sheetConditionalFormatting = cellFormatsSheet.getSheetConditionalFormatting();

        ConditionalFormattingRule conditionalFormattingRule;

        PatternFormatting conditionalFormatPatternFill;
        Row saveDataRow = cellFormatsSheet.createRow(0);

        for (int i = 0; i < DEFAULT_CONDITION_CELL_FORMATS.length; i++) {
            Cell cell = saveDataRow.createCell(i);
            cell.setCellValue(DEFAULT_CONDITION_CELL_FORMATS[i][0]);

            StringBuilder addSpecificCellToFormat = new StringBuilder(DEFAULT_CONDITION_CELL_FORMATS[i][1]);
            int index;
            while((index = addSpecificCellToFormat.indexOf(specificCellStandIn)) != -1) {
                addSpecificCellToFormat.replace(index, index + specificCellStandIn.length(), cell.getAddress().toString());
            }

            conditionalFormattingRule = sheetConditionalFormatting.createConditionalFormattingRule(addSpecificCellToFormat.toString());
            conditionalFormatPatternFill = conditionalFormattingRule.createPatternFormatting();
            conditionalFormatPatternFill.setFillBackgroundColor(IndexedColors.RED.index);
            conditionalFormatPatternFill.setFillPattern(PatternFormatting.SOLID_FOREGROUND);

            ConditionalFormattingRule[] conditionalFormattingRules = new ConditionalFormattingRule[]{conditionalFormattingRule};
            CellRangeAddress[] regions = new CellRangeAddress[]{new CellRangeAddress(cell.getRowIndex(), cell.getRowIndex(), cell.getColumnIndex(), cell.getColumnIndex())};

            sheetConditionalFormatting.addConditionalFormatting(regions, conditionalFormattingRules);
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
