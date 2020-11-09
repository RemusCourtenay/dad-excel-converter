package dosStuff;

import java.io.IOException;

/**
 * @author Remus Courtenay - rcou199
 * @since 9/11/2020
 */
public abstract class SettingsInterface {

    protected static final String MAIN_FOLDER_NAME = "data";
    protected static final String SETTINGS_FILE_NAME = "settings.txt";

    protected static final String SETTINGS_FILE_TEXT = "This is a settings file";

    protected static final String[] NEW_COMMAND_SHELL = {"cmd", "/c"};
    protected static final String[] MAKE_DATA_FOLDER_COMMAND = {"mkdir", MAIN_FOLDER_NAME};
    protected static final String[] MAKE_SETTINGS_FILE_COMMAND = {"echo", SETTINGS_FILE_TEXT, ">", MAIN_FOLDER_NAME + "/" + SETTINGS_FILE_NAME};


    public abstract void runSetup() throws IOException;

}
