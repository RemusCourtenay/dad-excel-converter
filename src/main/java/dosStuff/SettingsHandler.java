package dosStuff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Interface to allow for stubs and testing methods to be created. Also stores all static fields relating to the
 * settings folder.
 * @author Remus Courtenay - rcou199
 * @since 9/11/2020
 */
public abstract class SettingsHandler {

    protected static final String MAIN_FOLDER_NAME = "data";

    protected static final String SETTINGS_FILE_NAME = "settings.txt";
    protected static final String SETTINGS_FILE_TEXT = "This is a settings file";

    protected static final String HEADERS_FILE_NAME = "headers.txt";
    protected static final String[] DEFAULT_HEADERS = {"Registration_ID", "Race_Number", "Last_Name", "First_Name", "Gender", "Age", "Finish_Result", "Event", "Rank_Overall", "Rank_Gender", "Division_Name"};


    protected static final String[] NEW_COMMAND_SHELL = {"cmd", "/c"};
    protected static final String BAT_FILES_LOCATION = "src\\main\\resources\\batFiles\\";
}
