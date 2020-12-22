package dosStuff.fileCreators;

import dosStuff.fileCreators.defaultValues.DefaultCellFormatTypes;
import helpers.WorkbookHelper;
import org.apache.poi.ss.usermodel.*;

import java.nio.file.Path;

/**
 * @author Remus Courtenay - rcou199
 * @since 13/11/2020
 */
public class CellFormatsFileCreator extends SaveDataFileCreator {

    // Top level comment in file explaining how to edit it.
    private static final String CELL_FORMATS_FILE_COMMENT = "Lists the excel format codes used for each data types. Entries follow the format: (Name),(Format Code) with no spaces. See https://exceljet.net/custom-number-formats for a guide to creating number formats but note that spaces must be replaced with an underscore. To use an underscore within the code, add the escape character '\\ before the underscore.'";

    @Override
    public void createDefaultFile(Path filePath) { //TODO.. comments

        Row saveDataNameRow = saveDataSheet.createRow(0);
        Row saveDataValueRow = saveDataSheet.createRow(1);

        DefaultCellFormatTypes formatType;
        Cell nameCell;
        Cell valueCell;

        for (int i = 0; i<DefaultCellFormatTypes.values().length; i++) {
            formatType = DefaultCellFormatTypes.values()[i];
            nameCell = saveDataNameRow.createCell(i);
            valueCell = saveDataValueRow.createCell(i);

            formatType.setupSaveDataNameCell(nameCell);
            formatType.setupSaveDataValueCell(valueCell, saveDataWorkbook.createCellStyle());

        }
        WorkbookHelper.resizeColumnsToFit(saveDataSheet);
        WorkbookHelper.writeWorkbookToFile(filePath, saveDataWorkbook);
    }
}
