package programInterfaces;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Interface that represents all classes that interface this converter program with some other program.
 *
 * @author Remus Courtenay - rcou199
 * @since 13/11/2020
 */
public abstract class ProgramInterface { // TODO... Comment

    protected static final String PROGRAM_INTERFACE_FOLDER_NAME = "generated-files\\";

    private final Workbook generatedWorkbook;

    public ProgramInterface(Workbook saveDataWorkbook) {
        try {
            generatedWorkbook = loadSaveDataWorkbook(saveDataWorkbook);
        } catch (IOException | InvalidFormatException exception) {
            exception.printStackTrace();
            throw new RuntimeException(); // TODO...
        }
    }

    protected abstract Workbook loadSaveDataWorkbook(Workbook saveDataWorkbook) throws IOException, InvalidFormatException;

    protected Workbook makeNewWorkbookFromSaveData(File generatedFile, Workbook saveDataWorkbook) throws IOException, InvalidFormatException {

        if (generatedFile.exists()) {
            if (!generatedFile.delete()) {
                throw new IOException(); // TODO...
            }
        }

        if (!generatedFile.createNewFile()) {
            throw new IOException();
        }

        FileOutputStream outputStream = new FileOutputStream(generatedFile);

        saveDataWorkbook.write(outputStream);
        saveDataWorkbook.close();
        outputStream.close();

        return new XSSFWorkbook(generatedFile);
    }

    protected boolean isCorrectFormat(Workbook generatedWorkbook, Workbook saveDataWorkbook) {
        return false; // TODO...
    }



}
