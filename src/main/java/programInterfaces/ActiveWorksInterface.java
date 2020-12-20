package programInterfaces;

import dosStuff.DOSCommandHandler;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Implementation of ProgramInterface that specifically handles data coming from and going to the ActiveWorks program.
 * ACTIVE Works stores the data of all the competitors and the event and is used to show the results of the event.
 *
 * @author Remus Courtenay - rcou199
 * @since 13/11/2020
 */
public class ActiveWorksInterface extends ProgramInterface {

    private static final String WORKBOOK_OUT_NAME = "active-works-generated.xlsx";
    private static final Path WORKBOOK_PATH = Paths.get(PROGRAM_INTERFACE_FOLDER_NAME + WORKBOOK_OUT_NAME);

    public ActiveWorksInterface(Workbook saveDataWorkbook) {
        super(saveDataWorkbook);
    }

    @Override
    protected Workbook loadSaveDataWorkbook(Workbook saveDataWorkbook) throws IOException, InvalidFormatException {
        File generatedFile = WORKBOOK_PATH.toFile();
        Workbook generatedWorkbook;

        if (generatedFile.exists() && isCorrectFormat(generatedWorkbook = new XSSFWorkbook(generatedFile), saveDataWorkbook)) {
            return generatedWorkbook;
        } else {
            return makeNewWorkbookFromSaveData(generatedFile, saveDataWorkbook);
        }
    }
}
