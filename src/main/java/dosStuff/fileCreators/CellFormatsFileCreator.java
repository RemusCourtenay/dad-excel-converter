package dosStuff.fileCreators;

/**
 * @author Remus Courtenay - rcou199
 * @since 13/11/2020
 */
public class CellFormatsFileCreator extends FileCreator {

    // Top level comment in file explaining how to edit it.
    private static final String CELL_FORMATS_FILE_COMMENT = "Lists the excel format codes used for each data types. Entries follow the format: (Name),(Format Code) with no spaces. See https://exceljet.net/custom-number-formats for a guide to creating number formats but note that spaces must be replaced with an underscore. To use an underscore within the code, add the escape character '\\ before the underscore.'";

    // Default cell formats used if the file does not already exist
    private static final String[][] DEFAULT_FORMAT_TYPES = {
            DefaultCellFormatTypes.NONE         .getSaveData(),
            DefaultCellFormatTypes.TEXT         .getSaveData(),
            DefaultCellFormatTypes.ADDRESS      .getSaveData(),
            DefaultCellFormatTypes.POST_CODE    .getSaveData(),
            DefaultCellFormatTypes.EMAIL        .getSaveData(),
            DefaultCellFormatTypes.PHONE_NUMBER .getSaveData(),
            DefaultCellFormatTypes.GENDER       .getSaveData(),
            DefaultCellFormatTypes.ID_NUMBER    .getSaveData(),
            DefaultCellFormatTypes.TAG_NUMBER   .getSaveData(),
            DefaultCellFormatTypes.TIME         .getSaveData(),
            DefaultCellFormatTypes.DISTANCE     .getSaveData(),
            DefaultCellFormatTypes.DATE         .getSaveData(),
            DefaultCellFormatTypes.EVENT        .getSaveData()
    };

    /**
     * Implementation of abstract runSetup method to allow for this class to be initialised via the FileCreatorType enum.
     * Handles the creation, exceptions and running of a DOS command that attempts to create a data format types file
     * inside the main data folder. Should preferentially be run after the data folder has been initialised.
     */
    @Override
    public void runSetup() {
        // Using helper method to create file
        makeFileWithCommentLine(CELL_FORMATS_FILE_NAME, CELL_FORMATS_FILE_COMMENT, DEFAULT_FORMAT_TYPES);
    }
}
