package programInterfaces;

import fakeEnums.Column;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Implementation of ProgramInterface that specifically handles data coming from and going to the SportsCore program.
 * SportsCore assigns a time and ranking to event participants as they cross the finish line. It does so by linking
 * the participants to their result via a chip number.
 *
 * @author Remus Courtenay - rcou199
 * @since 13/11/2020
 */
public class SportsCoreInterface extends ProgramInterface {

    private static final String WORKBOOK_OUT_NAME = "sports-core-generated.xlsx";
    private static final Path WORKBOOK_PATH = Paths.get(PROGRAM_INTERFACE_FOLDER_NAME + WORKBOOK_OUT_NAME);


    public SportsCoreInterface(File saveDataFile) {
        super(saveDataFile);
    }

    @Override
    protected Path getWorkbookPath() {
        return WORKBOOK_PATH;
    }
}
