package programInterfaces;

import fakeEnums.Column;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.IOException;
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
    public SportsCoreInterface(File saveDataFile) {
        super(saveDataFile);
    }

    @Override
    protected Workbook loadGeneratedWorkbook(List<Column> layout ) throws IOException, InvalidFormatException {
        return null;
    }
}
