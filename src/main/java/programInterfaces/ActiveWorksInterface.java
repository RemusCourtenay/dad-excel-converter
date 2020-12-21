package programInterfaces;

import dosStuff.DOSCommandHandler;
import fakeEnums.Column;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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

    public ActiveWorksInterface(File saveDataFile) {
        super(saveDataFile);
    }

    @Override
    protected Path getWorkbookPath() {
        return WORKBOOK_PATH;
    }
}
