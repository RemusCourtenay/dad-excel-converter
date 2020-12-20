package programInterfaces;

import org.apache.poi.ss.usermodel.Workbook;

/**
 * Interface that represents all classes that interface this converter program with some other program.
 *
 * @author Remus Courtenay - rcou199
 * @since 13/11/2020
 */
public abstract class ProgramInterface { // TODO... Comment

    private final Workbook generatedWorkbook;

    public ProgramInterface(Workbook saveDataWorkbook) {
        generatedWorkbook = loadSaveDataWorkbook(saveDataWorkbook);
    }

    protected abstract Workbook loadSaveDataWorkbook(Workbook saveDataWorkbook);

}
