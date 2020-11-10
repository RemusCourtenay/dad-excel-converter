package dosStuff;

import org.apache.poi.ss.usermodel.CellType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Interface to allow for stubs and testing methods to be created. Also stores all static fields relating to the
 * settings folder.
 * @author Remus Courtenay - rcou199
 * @since 9/11/2020
 */
public abstract class FileHandler {

    static final String MAIN_FOLDER_NAME = "data";
    static final String SETTINGS_FILE_NAME = "settings.txt";
    static final String HEADERS_FILE_NAME = "headers.txt";

    static final String[] NEW_COMMAND_SHELL = {"cmd", "/c"};
    static final String BAT_FILES_LOCATION = "src\\main\\resources\\batFiles\\";

    static final String CHECK_EXISTS_BAT = "checkExists.bat";
    static final String QUOTE_MARK_STRIPPER_BAT = "quoteMarkStripper.bat";

    protected void checkReturnValue(int returnValue, String errorMessage) {
        if (returnValue != 0) {
            System.out.println("Batch file returned non-zero return value for: " + errorMessage);
        }
    }
}
