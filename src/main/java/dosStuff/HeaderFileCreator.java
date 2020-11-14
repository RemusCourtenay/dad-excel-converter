package dosStuff;

import org.apache.poi.ss.usermodel.CellType;

/**
 * Extension of abstract FileCreator class that specifically creates the headers text file. Methods only change header
 * file if the file does not already exist.
 *
 * @author Remus Courtenay - rcou199
 * @since 11/11/2020
 */
public class HeaderFileCreator extends FileCreator {

    // Top level comment in header file explaining how to edit it.
    private static final String HEADERS_FILE_COMMENT =
            "Add new headers on a new line with the format: (name),(column type) with no spaces. Valid column types are: " // Don't use <> characters
                    + CellType.STRING.toString() + ", "
                    + CellType.NUMERIC.toString() + ", "
                    + CellType.BOOLEAN.toString() + ", "
                    + CellType.FORMULA.toString() + " and "
                    + CellType.BLANK.toString() + "."
                    + " If you make a change to this file, you will need to restart the program for it to take effect.";

    // List of default headers, only gets applied to header file if it doesn't already exist.
    private static final String[][] DEFAULT_HEADERS = {
            {"Registration_ID", CellType.NUMERIC.toString()},
            {"Race_Number", CellType.NUMERIC.toString()},
            {"Last_Name", CellType.STRING.toString()},
            {"First_Name", CellType.STRING.toString()},
            {"Gender", CellType.STRING.toString()},
            {"Age", CellType.NUMERIC.toString()},
            {"Finish_Result", CellType.NUMERIC.toString()}, // String?
            {"Event", CellType.STRING.toString()},
            {"Rank_Overall", CellType.NUMERIC.toString()},
            {"Rank_Gender", CellType.NUMERIC.toString()},
            {"Division_Name", CellType.STRING.toString()}
    };

    /**
     * Implementation of abstract runSetup method to allow for this class to be initialised via the FileCreatorType enum.
     */
    @Override
    public void runSetup() {
        setupHeadersFile();
    }

    /**
     * Handles the creation, exceptions and running of a DOS command that attempts to create a default headers file
     * inside the main data folder. Should preferentially be run after the data folder has been initialised.
     */
    private void setupHeadersFile() {
        String fileAddress = makeMainFileAddress(HEADERS_FILE_NAME);
        if (!fileExists(fileAddress)) {

            // Echoing the file comment to a new file
            checkReturnValue(appendToFileWithoutQuotes(HEADERS_FILE_COMMENT, fileAddress), "append header comment to " + HEADERS_FILE_NAME + " without quote marks");
            // Appending each header to the text file so that they appear on new lines
            for (String[] command : DEFAULT_HEADERS) {
                checkReturnValue(appendToFileWithoutQuotes(makeSaveDataLine(command), fileAddress), "append default headers to " + HEADERS_FILE_NAME + " without quote marks");
            }
        }
    }
}
