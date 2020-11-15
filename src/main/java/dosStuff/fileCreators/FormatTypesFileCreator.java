package dosStuff.fileCreators;

/**
 * @author Remus Courtenay - rcou199
 * @since 13/11/2020
 */
public class FormatTypesFileCreator extends FileCreator {

    private static final String DATA_TYPES_FILE_COMMENT = "todo"; // TODO...

    private static final String GENERAL_FORMAT = "General";

    private static final String[][] DEFAULT_FORMAT_TYPES = {
            {NONE,          GENERAL_FORMAT},
            {TEXT,          GENERAL_FORMAT},
            {ADDRESS,       GENERAL_FORMAT},
            {POST_CODE,     GENERAL_FORMAT},
            {EMAIL,         GENERAL_FORMAT},
            {PHONE_NUMBER,  GENERAL_FORMAT},
            {GENDER,        GENERAL_FORMAT},
            {ID_NUMBER,     GENERAL_FORMAT},
            {TAG_NUMBER,    GENERAL_FORMAT},
            {TIME,          "dd-mm-yyyy_h:ss"}, // Doesn't add zeros to hours<10
            {DISTANCE,      GENERAL_FORMAT},
            {DATE,          "dd-mm-yyyy"},
            {EVENT,         GENERAL_FORMAT}
    };

    /**
     * Implementation of abstract runSetup method to allow for this class to be initialised via the FileCreatorType enum.
     * Handles the creation, exceptions and running of a DOS command that attempts to create a data format types file
     * inside the main data folder. Should preferentially be run after the data folder has been initialised.
     */
    @Override
    public void runSetup() {
        // Using helper method to create file
        createFileWithCommentLine(DATA_TYPES_FILE_NAME, DATA_TYPES_FILE_COMMENT, DEFAULT_FORMAT_TYPES);
    }
}
