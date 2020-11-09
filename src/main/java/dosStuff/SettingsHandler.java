package dosStuff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Remus Courtenay - rcou199
 * @since 9/11/2020
 */
public class SettingsHandler extends SettingsInterface {

    @Override
    public void runSetup() throws IOException {
        setupDataFolder();
        setupSettingsFile();
    }

    private void setupDataFolder() throws IOException {

        makeProcess(MAKE_DATA_FOLDER_COMMAND);

    }

    private void setupSettingsFile() throws IOException {

        makeProcess(MAKE_SETTINGS_FILE_COMMAND);

    }

    private void makeProcess(String[] commandArray) throws IOException {

        ProcessBuilder processBuilder = new ProcessBuilder();

        List<String> commandList = new ArrayList<>();
        commandList.addAll(Arrays.asList(NEW_COMMAND_SHELL));
        commandList.addAll(Arrays.asList(commandArray));
        processBuilder.command(commandList);
        processBuilder.start();
    }

}


