package dosStuff.fileCreators;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Extension of abstract FileCreator class that specifically creates the settings file. Methods only creates settings
 * file if the file does not already exist.
 *
 * @author Remus Courtenay - rcou199
 * @since 9/11/2020
 */
public class SettingsFileCreator extends SaveDataFileCreator {

    private static final String SETTINGS_FILE_COMMENT = "This is a comment\n";

    // Placeholder text to add to file
    private static final String SETTINGS_FILE_TEXT = "This_is_a_settings_file";

    @Override
    public void createDefaultFile(Path filePath) { // TODO... Comment

        File settingsFile = filePath.toFile();
        try {
            if (settingsFile.createNewFile()) {
                FileWriter settingsFileWriter = new FileWriter(settingsFile);
                settingsFileWriter.write(SETTINGS_FILE_COMMENT);
                settingsFileWriter.write(SETTINGS_FILE_TEXT);
                settingsFileWriter.flush();
                settingsFileWriter.close();
            } else {
                throw new RuntimeException(); // TODO...
            }
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new RuntimeException(); // TODO...
        }
    }
}


