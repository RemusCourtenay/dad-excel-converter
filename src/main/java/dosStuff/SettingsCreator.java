package dosStuff;

import java.io.IOException;
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
public class SettingsCreator implements FileCreator {

    /**
     * Basic main method that ensures all methods are run in the correct order.
     */
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

        // DOS command makes a directory with the name of the main folder.
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

            // DOS command echoes the settings text into a new file placed at the file address
            List<String> makeSettingsFileCommand = makeCommandList("echo" + SETTINGS_FILE_TEXT, ">", fileAddress);
            runProcess(errorMessage, makeSettingsFileCommand);
        }
    }

    /**
     * Handles the creation, exceptions and running of a DOS command that attempts to create a default headers file
     * inside the main data folder. Should preferentially be run after the data folder has been initialised.
     */
    private void setupHeadersFile() {
        String fileAddress = makeMainFileAddress(HEADERS_FILE_NAME);
        if (!fileExists(fileAddress)) {
            String errorMessage = "IOException occurred when attempting to create default headers file: " + HEADERS_FILE_NAME;
            List<String> commandList;

            // Echoing the file comment to a new file
            commandList = makeCommandList(BAT_FILES_LOCATION + QUOTE_MARK_STRIPPER_BAT, HEADERS_FILE_COMMENT, fileAddress);
            runProcess(errorMessage, commandList);

            // Appending each header to the text file so that they appear on new lines
            for (String[] command : DEFAULT_HEADERS) {
                commandList = makeCommandList("echo", command[0] + "," + command[1], ">>", fileAddress);
                runProcess(errorMessage, commandList);
            }
        }
    }

    /**
     * Helper method that calls a DOS script to check if a file already exists.
     * @param address : A set of strings in order that correlate to a file path relative to the program's source root
     *                that leads to where the possibly existing file should be.
     * @return : True if the file exists, otherwise false.
     */
    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    private boolean fileExists(String... address) {
        StringBuilder addressBuilder = new StringBuilder();

        // Building file path from inputs
        for (String addressPart: address) {
            addressBuilder.append(addressPart).append("\\");
        }
        // Removing final backslash
        String fullAddress = addressBuilder.substring(0, addressBuilder.length()-1);

        // Building command list that runs checkExists.bat with the inputted address as it's first input
        List<String> commandList = makeCommandList(BAT_FILES_LOCATION + CHECK_EXISTS_BAT, fullAddress);

        // Checking the exit value of the batch file
        return runProcess("TODO", commandList) == 0;
    }

    /**
     * Private helper method for building lists of strings.
     * @param commands : Strings to place in the list, order is preserved.
     * @return : The set of inputted Strings as a list.
     */
    private List<String> makeCommandList(String... commands) {
        return new ArrayList<>(Arrays.asList(commands));
    }

    /**
     * Private helper method that makes a file address relative to the main data file.
     * @param fileName : The name of the file within the data file.
     * @return : The relative path from the program's source root to the inputted file.
     */

    private String makeMainFileAddress(String fileName) {
        return MAIN_FOLDER_NAME + "\\" + fileName;
    }

    /**
     * Helper method for creating DOS commands that throw IOExceptions. Forces the main thread to wait for the process
     * to complete before continuing.
     * @param ioExceptionErrorMessage : Error message to throw if an IOException occurs.
     * @param commandLists : The lists of commands to be fed into the process builder.
     * @return : The process' exit value.
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
            return process.waitFor(); // Waiting for thread to complete and returning it's exit value
        } catch(IOException | InterruptedException exception) { // Catching exception and throwing runtime with inputted error message
            exception.printStackTrace();
            throw new RuntimeException(ioExceptionErrorMessage);
        }
    }
}


