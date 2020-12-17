package dosStuff.fileCreators;

import dosStuff.fileCreators.defaultValues.DefaultConditionalCellFormatTypes;
import org.apache.poi.ss.usermodel.*;

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
        SheetConditionalFormatting sheetConditionalFormatting = saveDataSheet.getSheetConditionalFormatting();
        Row saveDataNameRow = saveDataSheet.createRow(0);
        Row saveDataValueRow = saveDataSheet.createRow(1);

        Cell nameCell;
        Cell valueCell;
        DefaultConditionalCellFormatTypes formatType;

        for (int i = 0; i < DefaultConditionalCellFormatTypes.values().length; i++) {
            nameCell = saveDataNameRow.createCell(i);
            valueCell = saveDataValueRow.createCell(i);
            formatType = DefaultConditionalCellFormatTypes.values()[i];

            formatType.setupSaveDataNameCell(nameCell);
            formatType.setupSaveDataValueCell(valueCell, sheetConditionalFormatting);
        }

        super.resizeColumnsToFit();
        super.writeWorkbookToFile(fileAddress);
    }
}
