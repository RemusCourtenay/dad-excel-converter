package dosStuff;

import java.util.List;

/**
 * DOS interface that handles the creation of a data folder for storing program settings and data.
 * If a folder already exists, these commands shouldn't override it.
 *
 * @author Remus Courtenay - rcou199
 * @since 9/11/2020
 */
public class SettingsCreator extends FileCreator {

    private static final String SETTINGS_FILE_TEXT = "This is a settings file";

    /**
     * Basic main method that ensures all methods are run in the correct order.
     */
    @Override
    public void runSetup() {
        setupSettingsFile();
    }



    /**
     * Handles the creation, exceptions and running of a DOS command that attempts to create a default settings file
     * inside the main data folder. Should preferentially be run after the data folder has been initialised.
     */
    private void setupSettingsFile() {
        String fileAddress = makeMainFileAddress(SETTINGS_FILE_NAME);
        if(!fileExists(fileAddress)) {
            String errorMessage = "IOException occurred when attempting to create default settings file: " + SETTINGS_FILE_NAME;

            // DOS command echoes the settings text into a new file placed at the file address
            List<String> makeSettingsFileCommand = makeCommandList("echo" + SETTINGS_FILE_TEXT, ">", fileAddress);
            runProcess(errorMessage, makeSettingsFileCommand);
        }
    }










}


