package helpers;

import dosStuff.FileIOThreadManager;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Iterator;

public class WorkbookHelper { // TODO... Comments

    public static Sheet getSaveDataSheetFromFile(File file) {
        return convertFileToWorkbook(file).getSheetAt(0); // TODO.. check sheet
    }

    public static Row[] getSaveDataRowsFromSheet(Sheet saveDataSheet, int numOfSaveDataRows) {
        Row[] saveDataRows = new Row[numOfSaveDataRows];
        for (int i = 0; i < numOfSaveDataRows; i++) {
            saveDataRows[i] = saveDataSheet.getRow(i); // TODO.. check rows
        }
        return saveDataRows;
    }

    public static int getNumberOfColumns(Row[] rows) {
        int numRows;
        if (rows == null || (numRows = rows.length) == 0) {
            throw new RuntimeException(); // TODO...
        }

        int numColumns = rows[0].getPhysicalNumberOfCells();
        for (int i = 1; i < numRows; i++) {
            if (rows[i].getPhysicalNumberOfCells() != numColumns) {
                throw new RuntimeException(); // TODO...
            }
        }
        return numColumns;
    }

    public static void resizeColumnsToFit(Sheet saveDataSheet) {
        Row row = saveDataSheet.getRow(0);
        Iterator<Cell> it = row.cellIterator();

        while(it.hasNext()) {
            saveDataSheet.autoSizeColumn(it.next().getColumnIndex());
        }
    }

    public static void makeEmptyPath(Path filePath) throws IOException {
        File file = filePath.toFile();
        if (file.exists()) {
            if (!file.delete()) {
                throw new IOException(); // TODO...
            }
        }
    }

    public static void writeWorkbookToFile(Path filePath, Workbook workbook) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath.toFile());
            workbook.write(fileOutputStream);
            fileOutputStream.close();
            workbook.close();
        } catch (Exception e) {
            //todo...
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static boolean allIteratorsHaveNext(Iterator<?>... cellIterators) {
        boolean iteratorHasFalse = false;
        boolean iteratorHasTrue = false;

        for (Iterator<?> cellIterator: cellIterators) {
            if (cellIterator.hasNext()) {
                iteratorHasTrue = true;
            } else {
                iteratorHasFalse = true;
            }
        }

        if (iteratorHasTrue && iteratorHasFalse) {
            throw new RuntimeException(); // TODO...
        } else return iteratorHasTrue;
    }



    /* Helper Methods */

    private static Workbook convertFileToWorkbook(File file) {
        Workbook saveFileWorkbook;

        try {
            saveFileWorkbook = new XSSFWorkbook(file);
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException(); //TODO...
        }

        return saveFileWorkbook;
    }



}
