package programInterfaces;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;

/**
 * Implementation of ProgramInterface that specifically handles data coming from and going to the SportsCore program.
 * SportsCore assigns a time and ranking to event participants as they cross the finish line. It does so by linking
 * the participants to their result via a chip number.
 *
 * @author Remus Courtenay - rcou199
 * @since 13/11/2020
 */
public class SportsCoreInterface extends ProgramInterface {
    public SportsCoreInterface(Workbook saveDataWorkbook) {
        super(saveDataWorkbook);
    }

    @Override
    protected Workbook loadSaveDataWorkbook(Workbook saveDataWorkbook) throws IOException, InvalidFormatException {
        return null;
    }
}
