package fakeEnums;

import dosStuff.FileIOThreadManager;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public abstract class FakeEnumBuilder { // TODO... comment

    public abstract void setupEnumFromFile(FileIOThreadManager fileManager);

    protected Sheet getSaveDataSheetFromFile(FileIOThreadManager fileManager) {
        return convertFileToWorkbook(fileManager.getFile()).getSheetAt(0); // TODO.. check sheet
    }

    protected Row[] getSaveDataRowsFromSheet(Sheet saveDataSheet, int numOfSaveDataRows) {
        Row[] saveDataRows = new Row[numOfSaveDataRows];
        for (int i = 0; i < numOfSaveDataRows; i++) {
            saveDataRows[i] = saveDataSheet.getRow(i); // TODO.. check rows
        }
        return saveDataRows;
    }

    protected final boolean allIteratorsHaveNext(Iterator<?>... cellIterators) {
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


    private Workbook convertFileToWorkbook(File file) {
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
