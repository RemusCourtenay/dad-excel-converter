package dosStuff;

/**
 * Abstract class that represents all classes that interact with the program files. Stores file locations/names and
 * methods used by all file handling classes.
 * @author Remus Courtenay - rcou199
 * @since 9/11/2020
 */
public abstract class FileHandler {

    // File/folder names
    static final String MAIN_FOLDER_NAME = "data";
    static final String SETTINGS_FILE_NAME = "settings.txt";
    static final String HEADERS_FILE_NAME = "headers.txt";

    // Batch file names
    static final String CHECK_EXISTS_BAT = "checkExists.bat";
    static final String QUOTE_MARK_STRIPPER_BAT = "quoteMarkStripper.bat";
    // Batch files location
    static final String BAT_FILES_LOCATION = "src\\main\\resources\\batFiles\\";

    // Standard command for running DOS by giving string inputs
    static final String[] NEW_COMMAND_SHELL = {"cmd", "/c"};


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
