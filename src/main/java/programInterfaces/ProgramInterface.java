package programInterfaces;

import fakeEnums.Column;
import fakeEnums.Columns;
import helpers.WorkbookHelper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Interface that represents all classes that interface this converter program with some other program.
 *
 * @author Remus Courtenay - rcou199
 * @since 13/11/2020
 */
public abstract class ProgramInterface { // TODO... Comment

    protected static final String PROGRAM_INTERFACE_FOLDER_NAME = "generated-files\\";
    protected static final File PROGRAM_INTERFACE_FOLDER = new File(PROGRAM_INTERFACE_FOLDER_NAME);

    protected static final int NUM_SAVE_DATA_ROWS = 2;

    static {
        try {
            PROGRAM_INTERFACE_FOLDER.mkdir();
        } catch (SecurityException exception) {
            exception.printStackTrace();
            throw new RuntimeException(); // TODO...
        }
    }

    private final Workbook generatedWorkbook;

    private final List<ConvertedColumn> interfaceLayout;

    public ProgramInterface(File saveDataFile) {
        try {
            interfaceLayout = loadSaveData(saveDataFile);
            generatedWorkbook = loadGeneratedWorkbook(interfaceLayout);
        } catch (IOException | InvalidFormatException exception) {
            exception.printStackTrace();
            throw new RuntimeException(); // TODO...
        }
    }

    protected List<ConvertedColumn> loadSaveData(File saveDataFile) {

        Row[] saveDataRows = WorkbookHelper.getSaveDataRowsFromSheet(
                WorkbookHelper.getSaveDataSheetFromFile(saveDataFile),
                NUM_SAVE_DATA_ROWS
        );

        Row saveDataColumnNameRow = saveDataRows[0];
        Row saveDataConvertedNameRow = saveDataRows[1];

        Iterator<Cell> saveDataColumnNameCellIterator = saveDataColumnNameRow.cellIterator();
        Iterator<Cell> saveDataConvertedNameCellIterator = saveDataConvertedNameRow.cellIterator();

        List<ConvertedColumn> workbookLayout = new ArrayList<>(WorkbookHelper.getNumberOfColumns(saveDataRows));

        Cell saveDataColumnNameCell;
        Cell saveDataConvertedNameCell;

        Column saveDataColumn;
        String convertedName;

        while(WorkbookHelper.allIteratorsHaveNext(saveDataColumnNameCellIterator, saveDataConvertedNameCellIterator)) {
            saveDataColumnNameCell = saveDataColumnNameCellIterator.next();
            saveDataConvertedNameCell = saveDataConvertedNameCellIterator.next();

            saveDataColumn = Columns.valueOf(saveDataColumnNameCell.getStringCellValue());
            convertedName = saveDataConvertedNameCell.getStringCellValue();

            workbookLayout.add(new ConvertedColumn(convertedName, saveDataColumn));
        }

        return workbookLayout;
    }

    protected Workbook loadGeneratedWorkbook(List<ConvertedColumn> layout) throws IOException, InvalidFormatException {
        Path workbookPath = getWorkbookPath();
        File generatedFile = workbookPath.toFile();
        Workbook generatedWorkbook;

        if (generatedFile.exists() && isCorrectFormat(generatedWorkbook = new XSSFWorkbook(generatedFile), layout)) {
            return generatedWorkbook;
        } else {
            return makeNewWorkbookFromSaveData(layout, workbookPath);
        }
    }

    protected Workbook makeNewWorkbookFromSaveData (List<ConvertedColumn> layout, Path workbookPath) throws IOException, InvalidFormatException {
        WorkbookHelper.makeEmptyPath(workbookPath);
        Workbook generatedWorkbook = new XSSFWorkbook();
        Sheet generatedSheet = generatedWorkbook.createSheet();
        SheetConditionalFormatting generatedSheetConditionalFormatting = generatedSheet.getSheetConditionalFormatting();
        Row generatedRow = generatedSheet.createRow(0);

        Cell generatedCell;
        CellStyle generatedCellStyle;
        ConditionalFormatting generatedConditionalFormatting;
        ConvertedColumn saveDataColumn;

        for (int i = 0; i < layout.size(); i++) {
            generatedCell = generatedRow.createCell(i);
            generatedCellStyle = generatedWorkbook.createCellStyle();

            saveDataColumn = layout.get(i);
            generatedCell.setCellValue(saveDataColumn.name());
        }
        WorkbookHelper.resizeColumnsToFit(generatedSheet);
        WorkbookHelper.writeWorkbookToFile(workbookPath, generatedWorkbook);

        return generatedWorkbook;
    }

    protected abstract Path getWorkbookPath();



    protected boolean isCorrectFormat(Workbook generatedWorkbook, List<ConvertedColumn> layout) {
        return false; // TODO...
    }

}
