package dosStuff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Remus Courtenay - rcou199
 * @since 16/11/2020
 */
public class DOSCommandHandler {

    // Standard command for running DOS by giving string inputs
    protected static final String[] NEW_COMMAND_SHELL = {"cmd", "/c"};

    /**
     * Helper method for creating DOS commands that throw IOExceptions. Forces the main thread to wait for the process
     * to complete before continuing.
     * @param ioExceptionErrorMessage : Error message to throw if an IOException occurs.
     * @param commandLists : The lists of commands to be fed into the process builder.
     * @return : The process' exit value.
     */

    @SafeVarargs // Don't know why I need this but IDE says so
    protected static int runProcess(String ioExceptionErrorMessage, List<String>... commandLists) {
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

    /**
     * Private helper method for building lists of strings.
     * @param commands : Strings to place in the list, order is preserved.
     * @return : The set of inputted Strings as a list.
     */
    protected static List<String> makeCommandList(String... commands) {
        return new ArrayList<>(Arrays.asList(commands));
    }

}
