package dosStuff.fileCreators;

import dosStuff.fileCreators.FileCreator;

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

    @Override
    public void runSetup() {

    }
}
