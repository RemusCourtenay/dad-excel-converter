package dosStuff.fileCreators;

import dosStuff.FileIOThreadManager;

/**
 * Extension of abstract FileCreator class that specifically creates the settings file. Methods only creates settings
 * file if the file does not already exist.
 *
 * @author Remus Courtenay - rcou199
 * @since 9/11/2020
 */
public class SettingsFileCreator extends FileCreator {

    private static final String SETTINGS_FILE_COMMENT = "This is a comment";

    // Placeholder text to add to file
    private static final String[][] SETTINGS_FILE_TEXT = {{"This_is_a_settings_file"}};

    @Override
    public void createDefaultFile(String fileAddress) {
        writeToFileWithComment(SETTINGS_FILE_COMMENT, SETTINGS_FILE_TEXT, fileAddress);
    }
}

