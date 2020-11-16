package dosStuff.fileCreators;

import dosStuff.fileCreators.FileCreator;

/**
 * Extension of abstract FileCreator class that specifically creates the settings file. Methods only creates settings
 * file if the file does not already exist.
 *
 * @author Remus Courtenay - rcou199
 * @since 9/11/2020
 */
public class SettingsFileCreator extends FileCreator {

    // Placeholder text to add to file
    private static final String SETTINGS_FILE_TEXT = "This is a settings file";

    /**
     * Implementation of abstract runSetup method to allow for this class to be initialised via the FileCreatorType enum.
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
            // DOS command echoes the settings text into a new file placed at the file address
            checkReturnValue(appendToFileWithoutQuotes(SETTINGS_FILE_TEXT, fileAddress), "append settings text to file: " + SETTINGS_FILE_NAME + " without quote marks");
        }
    }
}


