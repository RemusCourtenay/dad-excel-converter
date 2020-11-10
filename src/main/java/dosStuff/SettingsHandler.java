package dosStuff;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
        setupHeadersFile();
    }

    /**
     * Handles the creation, exceptions and running of a DOS command that attempts to create an empty folder to store
     * the program data in. If a folder of that name already exists this command won't overwrite it.
     */
    private void setupDataFolder() {
        String errorMessage = "IOException occurred when attempting to initialise program data folder: " + MAIN_FOLDER_NAME;
        List<String> makeMainFolderCommand = makeCommandList("mkdir", MAIN_FOLDER_NAME);
        runProcess(errorMessage, makeMainFolderCommand);
    }

    /**
     * Handles the creation, exceptions and running of a DOS command that attempts to create a default settings file
     * inside the main data folder. Should preferentially be run after the data folder has been initialised.
     */
    private void setupSettingsFile() {
        String fileAddress = makeMainFileAddress(SETTINGS_FILE_NAME);
        if(!fileExists(fileAddress)) {
            String errorMessage = "IOException occurred when attempting to create default settings file: " + SETTINGS_FILE_NAME;
            List<String> makeSettingsFileCommand = makeCommandList("echo", SETTINGS_FILE_TEXT, ">", fileAddress);
            runProcess(errorMessage, makeSettingsFileCommand);
        }
    }

    private void setupHeadersFile() {
        String fileAddress = makeMainFileAddress(HEADERS_FILE_NAME);
        if (!fileExists(fileAddress)) {
            String errorMessage = "IOException occurred when attempting to create default headers file: " + HEADERS_FILE_NAME;

            List<String> commandList;
            for (String command : DEFAULT_HEADERS) {
                commandList = makeCommandList("echo", command, ">>", fileAddress);
                runProcess(errorMessage, commandList);
            }
        }
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    private boolean fileExists(String... address) {
        StringBuilder addressBuilder = new StringBuilder();

        for (String addressPart: address) {
            addressBuilder.append(addressPart).append("\\");
        }

        String fullAddress = addressBuilder.substring(0, addressBuilder.length()-1);


        List<String> commandList = makeCommandList(BAT_FILES_LOCATION + "checkExists.bat", fullAddress);

        return runProcess("TODO", commandList) == 0;
    }

    private List<String> makeCommandList(String... commands) {
        return new ArrayList<>(Arrays.asList(commands));
    }

    private String makeMainFileAddress(String fileName) {
        return MAIN_FOLDER_NAME + "\\" + fileName;
    }

    /**
     * Helper method for creating DOS commands that throw IOExceptions.
     *
     * @param ioExceptionErrorMessage : Error message to throw if an IOException occurs
     *
     * @return : A Process object that represents the running process
     */

    @SafeVarargs
    private int runProcess(String ioExceptionErrorMessage, List<String>... commandLists) {
        // Converting inputted commands into a list to feed into the process builder
        List<String> fullCommandList = new ArrayList<>(Arrays.asList(NEW_COMMAND_SHELL));
        for (List<String> commandList: commandLists) {
            fullCommandList.addAll(commandList);
        }

        // Initialising process builder and inputting list of commands
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command(fullCommandList);
        // Attempting to start the process
        try {
            Process process = processBuilder.start();
            return process.waitFor();
        } catch(IOException | InterruptedException exception) { // Catching exception and throwing runtime with inputted error message
            exception.printStackTrace();
            throw new RuntimeException(ioExceptionErrorMessage);
        }

    }

}


