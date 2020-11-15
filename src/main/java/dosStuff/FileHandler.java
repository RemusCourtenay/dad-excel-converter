package dosStuff;

/**
 * Abstract class that represents all classes that interact with the program files. Stores file locations/names and
 * methods used by all file handling classes.
 * @author Remus Courtenay - rcou199
 * @since 9/11/2020
 */
public abstract class FileHandler {

    // Character(s) that specify the boundary between data values in the saved data
    protected static final String DATA_FILE_DELIMITER = ",";

    // File/folder names
    protected static final String MAIN_FOLDER_NAME = "data";
    protected static final String SETTINGS_FILE_NAME = "settings.txt";
    protected static final String HEADERS_FILE_NAME = "headers.txt";
    protected static final String MASTER_SHEET_LAYOUT_FILE_NAME = "master-layout.txt";
    protected static final String CELL_FORMATS_FILE_NAME = "cell-formats.txt";
    protected static final String CONDITIONAL_CELL_FORMATS_FILE_NAME = "conditional-cell-formats.txt";

    // Batch files location
    protected static final String BAT_FILES_LOCATION = "src\\main\\resources\\batFiles\\";
    // Batch file names
    protected static final String CHECK_EXISTS_BAT = "checkExists.bat";
    protected static final String QUOTE_MARK_STRIPPER_BAT = "quoteMarkStripper.bat";


    // Standard command for running DOS by giving string inputs
    protected static final String[] NEW_COMMAND_SHELL = {"cmd", "/c"};


    /* -------------------------------- Helper Methods -------------------------------- */

    /**
     * Helper method that error checks the running of the batch files by ensuring their return value was zero.
     * @param returnValue : The return value of the DOS command/ Batch file.
     * @param errorMessage : Explanation of what was occurring when the error occurred.
     */
    protected void checkReturnValue(int returnValue, String errorMessage) {
        // Zero is the return value passed when the command/batch files finish with no errors
        if (returnValue != 0) {
            throw new RuntimeException("Batch file returned non-zero return value for: " + errorMessage);
        }
    }
}
