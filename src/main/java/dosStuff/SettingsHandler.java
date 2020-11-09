package dosStuff;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DOS interface that handles the creation of a data folder for storing program settings and data.
 * If a folder already exists, these commands shouldn't override it.
 *
 * @author Remus Courtenay - rcou199
 * @since 9/11/2020
 */
public class SettingsHandler extends SettingsInterface {

    /**
     * Basic main method that ensures all methods are run in the correct order.
     */
    @Override
    public void runSetup() {
        setupDataFolder();
        setupSettingsFile();
    }

    /**
     * Handles the creation, exceptions and running of a DOS command that attempts to create an empty folder to store
     * the program data in. If a folder of that name already exists this command won't overwrite it.
     */
    private void setupDataFolder() {
        String errorMessage = "IOException occurred when attempting to initialise program data folder: " + MAIN_FOLDER_NAME;
        Process setupDataFolderProcess = makeProcess(MAKE_DATA_FOLDER_COMMAND, errorMessage);
    }

    /**
     * Handles the creation, exceptions and running of a DOS command that attempts to create a default settings file
     * inside the main data folder. Should preferentially be run after the data folder has been initialised.
     */
    private void setupSettingsFile(){
        String errorMessage = "IOException occurred when attempting to create default settings file:" + SETTINGS_FILE_NAME;
        Process setupSettingsFileProcess = makeProcess(MAKE_SETTINGS_FILE_COMMAND, errorMessage);
    }

    /**
     * Helper method for creating DOS commands that throw IOExceptions.
     *
     * @param commandArray : Array of commands to be added to the process.
     * @param ioExceptionErrorMessage : Error message to throw if an IOException occurs
     *
     * @return : A Process object that represents the running process
     */

    private Process makeProcess(String[] commandArray, String ioExceptionErrorMessage) {
        // Converting inputted commands into a list to feed into the process builder
        List<String> commandList = new ArrayList<>();
        commandList.addAll(Arrays.asList(NEW_COMMAND_SHELL));
        commandList.addAll(Arrays.asList(commandArray));

        // Initialising process builder and inputting list of commands
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command(commandList);

        // Attempting to start the process
        try {
            return processBuilder.start();
        } catch(IOException exception) { // Catching exception and throwing runtime with inputted error message
            exception.printStackTrace();
            throw new RuntimeException(ioExceptionErrorMessage);
        }

    }

}


