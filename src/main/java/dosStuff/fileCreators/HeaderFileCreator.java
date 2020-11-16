package dosStuff.fileCreators;

import org.apache.poi.ss.usermodel.CellType;

/**
 * Extension of abstract FileCreator class that specifically creates the headers text file. Methods only change header
 * file if the file does not already exist.
 *
 * @author Remus Courtenay - rcou199
 * @since 11/11/2020
 */
public class HeaderFileCreator extends FileCreator {

    // Top level comment in header file explaining how to edit it.
    private static final String HEADERS_FILE_COMMENT =
            "Add new headers on a new line with the format: (name),(column type) with no spaces. Valid column types are: " // Don't use <> characters
                    + STRING_CELL + ", "
                    + NUMERIC_CELL + ", "
                    + BOOLEAN_CELL + ", "
                    + FORMULA_CELL + " and "
                    + BLANK_CELL + "."
                    + " If you make a change to this file, you will need to restart the program for it to take effect."
            ;

    // List of default headers, only gets applied to header file if it doesn't already exist.
    private static final String[][] DEFAULT_HEADERS = {
            DefaultHeaderTypes.REGISTRATION_ID.getSaveData(),
            DefaultHeaderTypes.RACE_NUMBER.getSaveData(),
            DefaultHeaderTypes.LAST_NAME.getSaveData(),
            DefaultHeaderTypes.FIRST_NAME.getSaveData(),
            DefaultHeaderTypes.GENDER.getSaveData(),
            DefaultHeaderTypes.AGE.getSaveData(),
            DefaultHeaderTypes.FINISH_RESULT.getSaveData(), // String?
            DefaultHeaderTypes.EVENT.getSaveData(),
            DefaultHeaderTypes.RANK_OVERALL.getSaveData(),
            DefaultHeaderTypes.RANK_GENDER.getSaveData(),
            DefaultHeaderTypes.DIVISION.getSaveData(),
            DefaultHeaderTypes.CITY.getSaveData()
    };

    /**
     * Implementation of abstract runSetup method to allow for this class to be initialised via the FileCreatorType enum.
     * Handles the creation, exceptions and running of a DOS command that attempts to create a default headers file
     * inside the main data folder. Should preferentially be run after the data folder has been initialised.
     */
    @Override
    public void runSetup() {
        // Using helper method to make file with comment
        makeFileWithCommentLine(HEADERS_FILE_NAME, HEADERS_FILE_COMMENT, DEFAULT_HEADERS);
    }
}
