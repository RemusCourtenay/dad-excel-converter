package dosStuff;

import java.util.List;

import static dosStuff.DOSCommandHandler.makeCommandList;
import static dosStuff.DOSCommandHandler.runProcess;

/**
 * @author Remus Courtenay - rcou199
 * @since 16/11/2020
 */
public class BatchFileHandler {

    // Batch files location
    protected static final String BAT_FILES_LOCATION = "src\\main\\resources\\batFiles\\";
    // Batch file names
    protected static final String CHECK_EXISTS_BAT = "checkExists.bat";
    protected static final String QUOTE_MARK_STRIPPER_BAT = "quoteMarkStripper.bat";

    /**
     * Private helper method that calls the Quote Mark Stripper batch file with given inputs.
     * @param textToAppend : The text to be passed to the Quote Mark Stripper batch file and then sent to the file.
     * @param fileLocation : The location of the file to append the stripped text to.
     * @return : The return value of the batch file.
     */
    protected static int appendToFileWithoutQuotes(String textToAppend, String fileLocation) {
        String errorMessage = "IOException occurred when attempting to append:" + textToAppend + " to " + fileLocation;

        List<String> commandList = makeCommandList(BAT_FILES_LOCATION + QUOTE_MARK_STRIPPER_BAT, textToAppend, fileLocation);
        return runProcess(errorMessage, commandList);
    }

    protected static String readFileLine(String fileAddress, int i) {
        return null;
    }


    /**
     * Helper method that calls a DOS script to check if a file already exists.
     * @param address : A set of strings in order that correlate to a file path relative to the program's source root
     *                that leads to where the possibly existing file should be.
     * @return : True if the file exists, otherwise false.
     */
    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    protected static boolean fileExists(String... address) {
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
     * Helper method that error checks the running of the batch files by ensuring their return value was zero.
     * @param returnValue : The return value of the DOS command/ Batch file.
     * @param errorMessage : Explanation of what was occurring when the error occurred.
     */
    protected static void checkReturnValue(int returnValue, String errorMessage) {
        // Zero is the return value passed when the command/batch files finish with no errors
        if (returnValue != 0) {
            throw new RuntimeException("Batch file returned non-zero return value for: " + errorMessage);
        }
    }

}
