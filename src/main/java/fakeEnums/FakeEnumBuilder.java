package fakeEnums;

import dosStuff.FileIOThreadManager;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public abstract class FakeEnumBuilder { // TODO... comment

    public abstract void setupEnumFromFile(FileIOThreadManager fileManager);

    protected Workbook convertFileToWorkbook(File file) {
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
