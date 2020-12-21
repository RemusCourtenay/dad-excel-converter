package programInterfaces;

import fakeEnums.Column;
import fakeEnums.Columns;
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

    static {
        try {
            PROGRAM_INTERFACE_FOLDER.mkdir();
        } catch (SecurityException exception) {
            exception.printStackTrace();
            throw new RuntimeException(); // TODO...
        }
    }

    private final Workbook generatedWorkbook;

    private final List<Column> interfaceLayout;

    public ProgramInterface(File saveDataFile) {
        try {
            interfaceLayout = loadSaveData(new XSSFWorkbook(saveDataFile));
            generatedWorkbook = loadGeneratedWorkbook(interfaceLayout);
        } catch (IOException | InvalidFormatException exception) {
            exception.printStackTrace();
            throw new RuntimeException(); // TODO...
        }
    }

    protected List<Column> loadSaveData(Workbook saveDataWorkbook) {
        Sheet saveDataSheet = saveDataWorkbook.getSheetAt(0);
        Row saveDataRow = saveDataSheet.getRow(0); // TODO...
        Iterator<Cell> saveDataCellIterator = saveDataRow.cellIterator();

        List<Column> workbookLayout = new ArrayList<>(saveDataRow.getPhysicalNumberOfCells());

        Cell saveDataCell;
        while(saveDataCellIterator.hasNext()) {
            saveDataCell = saveDataCellIterator.next();
            workbookLayout.add(Columns.valueOf(saveDataCell.getStringCellValue()));
        }

        return workbookLayout;
    }

    protected abstract Workbook loadGeneratedWorkbook(List<Column> layout) throws IOException, InvalidFormatException;

    protected Workbook makeNewWorkbookFromSaveData(File generatedFile, List<Column> layout, Path workbookPath) throws IOException, InvalidFormatException {
        createBlankFile(generatedFile);
        Workbook generatedWorkbook = new XSSFWorkbook();
        Sheet generatedSheet = generatedWorkbook.createSheet();
        SheetConditionalFormatting generatedSheetConditionalFormatting = generatedSheet.getSheetConditionalFormatting();
        Row generatedRow = generatedSheet.createRow(0);

        Cell generatedCell;
        CellStyle generatedCellStyle;
        ConditionalFormatting generatedConditionalFormatting;
        Column saveDataColumn;

        for (int i = 0; i < layout.size(); i++) {
            generatedCell = generatedRow.createCell(i);
            generatedCellStyle = generatedWorkbook.createCellStyle();

            saveDataColumn = layout.get(i);
            generatedCell.setCellValue(saveDataColumn.getName());
        }

        writeWorkbookToFile(generatedWorkbook, workbookPath);

        return generatedWorkbook;
    }

    protected void createBlankFile(File file) throws IOException {
        if (file.exists()) {
            if (!file.delete()) {
                throw new IOException(); // TODO...
            }
        }
    }

    protected boolean isCorrectFormat(Workbook generatedWorkbook, List<Column> layout) {
        return false; // TODO...
    }

    protected void writeWorkbookToFile(Workbook workbook, Path filePath) throws IOException{
        FileOutputStream outputStream = new FileOutputStream(filePath.toString());
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

}
