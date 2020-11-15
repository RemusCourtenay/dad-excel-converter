package dosStuff.fileCreators;

import dosStuff.FileHandler;
import org.apache.poi.ss.usermodel.CellType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Abstract class that contains methods shared by all classes that create files. Abstract method runSetup allows for the
 * initialisation of all FileCreator extensions via the FileCreatorType enum.
 * @author Remus Courtenay - rcou199
 * @since 11/11/2020
 */
public abstract class FileCreator extends FileHandler {

    // Kinda cursed ngl

    protected final static String STRING                    = CellType.STRING.name();
    protected final static String NUMERIC                   = CellType.NUMERIC.name();
    protected final static String BOOLEAN                   = CellType.BOOLEAN.name();
    protected final static String FORMULA                   = CellType.FORMULA.name();
    protected final static String BLANK                     = CellType.BLANK.name();

    protected final static String TEXT                      = DefaultFormatTypes.TEXT.name();
    protected final static String ADDRESS                   = DefaultFormatTypes.ADDRESS.name();
    protected final static String POST_CODE                 = DefaultFormatTypes.POST_CODE.name();
    protected final static String EMAIL                     = DefaultFormatTypes.EMAIL.name();
    protected final static String PHONE_NUMBER              = DefaultFormatTypes.PHONE_NUMBER.name();
    protected final static String GENDER                    = DefaultFormatTypes.GENDER.name();
    protected final static String ID_NUMBER                 = DefaultFormatTypes.ID_NUMBER.name();
    protected final static String TAG_NUMBER                = DefaultFormatTypes.TAG_NUMBER.name();
    protected final static String TIME                      = DefaultFormatTypes.TIME.name();
    protected final static String DISTANCE                  = DefaultFormatTypes.DISTANCE.name();
    protected final static String DATE                      = DefaultFormatTypes.DATE.name();
    protected final static String EVENT                     = DefaultFormatTypes.EVENT.name();

    protected final static String NONE                      = DefaultConditionalCellFormatTypes.NONE.name();
    protected final static String PROPER                    = DefaultConditionalCellFormatTypes.PROPER.name();
    protected final static String UPPERCASE                 = DefaultConditionalCellFormatTypes.UPPERCASE.name();
    protected final static String DISTANCE_UNIT             = DefaultConditionalCellFormatTypes.DISTANCE_UNIT.name();
    protected final static String VALID_POSTCODE            = DefaultConditionalCellFormatTypes.VALID_POSTCODE.name();
    protected final static String VALID_EMAIL               = DefaultConditionalCellFormatTypes.VALID_EMAIL.name();
    protected final static String VALID_PHONE               = DefaultConditionalCellFormatTypes.VALID_PHONE.name();
    protected final static String VALID_REGISTRATION_ID     = DefaultConditionalCellFormatTypes.VALID_REGISTRATION_ID.name();
    protected final static String VALID_RACE_NUMBER         = DefaultConditionalCellFormatTypes.VALID_RACE_NUMBER.name();
    protected final static String VALID_TAG_NUMBER          = DefaultConditionalCellFormatTypes.VALID_TAG_NUMBER.name();



    /**
     * Abstract method for running all methods that are needed during the setup process.
     */
    public abstract void runSetup();

    /* -------------------------------- Helper Methods -------------------------------- */

    protected void createFileWithCommentLine(String fileName, String comment, String[][] dataLines) {

        // Making address relative to source root
        String fileAddress = makeMainFileAddress(fileName);

        // Checking if file already exists
        if(!fileExists(fileAddress)) {

            // Echoing comment to top line of file
            checkReturnValue(appendToFileWithoutQuotes(comment, fileAddress), "append header comment to " + fileAddress + " without quote marks");

            // Echoing each set of values to a new line in the file
            for (String[] dataLine: dataLines) {
                checkReturnValue(appendToFileWithoutQuotes(makeSaveDataLine(dataLine), fileAddress), "append default values to " + fileAddress + " without quote marks");
            }
        }

    }

    /**
     * Private helper method that calls the Quote Mark Stripper batch file with given inputs.
     * @param textToAppend : The text to be passed to the Quote Mark Stripper batch file and then sent to the file.
     * @param fileLocation : The location of the file to append the stripped text to.
     * @return : The return value of the batch file.
     */
    protected int appendToFileWithoutQuotes(String textToAppend, String fileLocation) {
        String errorMessage = "IOException occurred when attempting to append:" + textToAppend + " to " + fileLocation;

        List<String> commandList = makeCommandList(BAT_FILES_LOCATION + QUOTE_MARK_STRIPPER_BAT, textToAppend, fileLocation);
        return runProcess(errorMessage, commandList);
    }

    /**
     * Private helper method for building lists of strings.
     * @param commands : Strings to place in the list, order is preserved.
     * @return : The set of inputted Strings as a list.
     */
    protected List<String> makeCommandList(String... commands) {
        return new ArrayList<>(Arrays.asList(commands));
    }

    /**
     * Helper method that calls a DOS script to check if a file already exists.
     * @param address : A set of strings in order that correlate to a file path relative to the program's source root
     *                that leads to where the possibly existing file should be.
     * @return : True if the file exists, otherwise false.
     */
    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    protected boolean fileExists(String... address) {
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
     * Private helper method that makes a file address relative to the main data file.
     * @param fileName : The name of the file within the data file.
     * @return : The relative path from the program's source root to the inputted file.
     */

    protected String makeMainFileAddress(String fileName) {
        return MAIN_FOLDER_NAME + "\\" + fileName;
    }

    /**
     * Private helper method that generates a String in the correct save data format from an array of values.
     * @param saveData : The data that is being saved as a line in a text file.
     * @return : The data formatted as a single string in the correct format
     */
    protected String makeSaveDataLine(String[] saveData) {
        StringBuilder dataLineBuilder = new StringBuilder();

        // Adding each data chunk and separating with delimiter
        for (String dataChunk: saveData) {
            // Checking for illegal characters
            if (dataChunk.contains(DATA_FILE_DELIMITER)) {
                throw new RuntimeException(dataChunk + " in " + Arrays.toString(saveData) + " contains illegal character: " + DATA_FILE_DELIMITER);
            } else if (dataChunk.contains(" ") || dataChunk.contains("\t") || dataChunk.contains("\n")){
                throw new RuntimeException(dataChunk + " in " + Arrays.toString(saveData) + " contains illegal whitespace character, please replace with underscore");
            } else {
                dataLineBuilder.append(dataChunk).append(DATA_FILE_DELIMITER);
            }
        }

        // Removing unnecessary final delimiter
        int lastIndexOfDelimiter = dataLineBuilder.lastIndexOf(DATA_FILE_DELIMITER);
        dataLineBuilder.delete(lastIndexOfDelimiter, lastIndexOfDelimiter+DATA_FILE_DELIMITER.length());

        // Adding quote marks to ensure DOS command doesn't incorrectly split input string
        dataLineBuilder.insert(0, "\"");
        dataLineBuilder.append("\"");
        return dataLineBuilder.toString();
    }

    /**
     * Helper method for creating DOS commands that throw IOExceptions. Forces the main thread to wait for the process
     * to complete before continuing.
     * @param ioExceptionErrorMessage : Error message to throw if an IOException occurs.
     * @param commandLists : The lists of commands to be fed into the process builder.
     * @return : The process' exit value.
     */

    @SafeVarargs // Don't know why I need this but IDE says so
    protected final int runProcess(String ioExceptionErrorMessage, List<String>... commandLists) {
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
