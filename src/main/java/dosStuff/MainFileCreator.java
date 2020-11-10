package dosStuff;

import java.util.List;

/**
 * @author Remus Courtenay - rcou199
 * @since 11/11/2020
 */
public class MainFileCreator extends FileCreator {

    @Override
    public void runSetup() {
        setupDataFolder();
    }

    /**
     * Handles the creation, exceptions and running of a DOS command that attempts to create an empty folder to store
     * the program data in. If a folder of that name already exists this command won't overwrite it.
     */
    private void setupDataFolder() {
        String errorMessage = "IOException occurred when attempting to initialise program data folder: " + MAIN_FOLDER_NAME;

        // DOS command makes a directory with the name of the main folder.
        List<String> makeMainFolderCommand = makeCommandList("mkdir", MAIN_FOLDER_NAME);
        runProcess(errorMessage, makeMainFolderCommand);
    }

}
