package dosStuff.fileCreators;

/**
 * Extension of abstract FileCreator class that specifically creates the condition cell formats file. Methods only
 * change file if the file does not already exist.
 *
 * @author Remus Courtenay - rcou199
 * @since 11/11/2020
 */
public class ConditionalCellFormatsFileCreator extends FileCreator {

    // Top level comment in file explaining how to edit it
    private static final String CONDITIONAL_CELL_FORMATS_FILE_COMMENT = "Lists the excel formula for each conditional cell format used in the sheets. Entries follow the format: (Name),(Excel Formula) with no spaces. Note that all commas in the formulae have been replaced with fullstops. If you need to use a fullstop in the formula then add an additional \\ before the fullstop.";

    // Default values to use if file does not already exist
    private static final String[][] DEFAULT_CONDITION_CELL_FORMATS = {
            DefaultConditionalCellFormatTypes.NONE.getSaveData(),
            DefaultConditionalCellFormatTypes.PROPER.getSaveData(),
            DefaultConditionalCellFormatTypes.UPPERCASE.getSaveData(),
            DefaultConditionalCellFormatTypes.DISTANCE_UNIT.getSaveData(),
            DefaultConditionalCellFormatTypes.VALID_POSTCODE.getSaveData(),
            DefaultConditionalCellFormatTypes.VALID_EMAIL.getSaveData(),
            DefaultConditionalCellFormatTypes.VALID_PHONE.getSaveData(),
            DefaultConditionalCellFormatTypes.VALID_REGISTRATION_ID.getSaveData(),
            DefaultConditionalCellFormatTypes.VALID_RACE_NUMBER.getSaveData(),
            DefaultConditionalCellFormatTypes.VALID_TAG_NUMBER.getSaveData()
    };

    /**
     * Implementation of abstract runSetup method to allow for this class to be initialised via the FileCreatorType enum.
     * Handles the creation, exceptions and running of a DOS command that attempts to create a conditional cell formats
     * file inside the main data folder. Should preferentially be run after the data folder has been initialised.
     */
    @Override
    public void runSetup() {
        // Using helper method to create file with comment header line
        createFileWithCommentLine(CONDITIONAL_CELL_FORMATS_FILE_NAME, CONDITIONAL_CELL_FORMATS_FILE_COMMENT, DEFAULT_CONDITION_CELL_FORMATS);
    }
}
