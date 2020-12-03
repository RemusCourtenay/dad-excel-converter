package dosStuff.fileCreators;

import dosStuff.BatchFileHandler;
import org.apache.poi.ss.usermodel.CellType;

import java.util.Arrays;

import static dosStuff.BatchFileHandler.appendToFileWithoutQuotes;

/**
 * Abstract class that contains methods shared by all classes that create files. Abstract method runSetup allows for the
 * initialisation of all FileCreator extensions via the FileCreatorType enum.
 * @author Remus Courtenay - rcou199
 * @since 11/11/2020
 */
public abstract class FileCreator {


    // Character(s) that specify the boundary between data values in the saved data
    private static final String DATA_FILE_DELIMITER = ",";

    // Kinda cursed ngl
    protected final static String STRING_CELL                       = CellType.STRING.name();
    protected final static String NUMERIC_CELL                      = CellType.NUMERIC.name();
    protected final static String BOOLEAN_CELL                      = CellType.BOOLEAN.name();
    protected final static String FORMULA_CELL                      = CellType.FORMULA.name();
    protected final static String BLANK_CELL                        = CellType.BLANK.name();

    protected final static String NONE_FORMAT                       = DefaultCellFormatTypes.NONE.getName();
    protected final static String TEXT_FORMAT                       = DefaultCellFormatTypes.TEXT.getName();
    protected final static String ADDRESS_FORMAT                    = DefaultCellFormatTypes.ADDRESS.getName();
    protected final static String POST_CODE_FORMAT                  = DefaultCellFormatTypes.POST_CODE.getName();
    protected final static String EMAIL_FORMAT                      = DefaultCellFormatTypes.EMAIL.getName();
    protected final static String PHONE_NUMBER_FORMAT               = DefaultCellFormatTypes.PHONE_NUMBER.getName();
    protected final static String GENDER_FORMAT                     = DefaultCellFormatTypes.GENDER.getName();
    protected final static String ID_NUMBER_FORMAT                  = DefaultCellFormatTypes.ID_NUMBER.getName();
    protected final static String TAG_NUMBER_FORMAT                 = DefaultCellFormatTypes.TAG_NUMBER.getName();
    protected final static String TIME_FORMAT                       = DefaultCellFormatTypes.TIME.getName();
    protected final static String DISTANCE_FORMAT                   = DefaultCellFormatTypes.DISTANCE.getName();
    protected final static String DATE_FORMAT                       = DefaultCellFormatTypes.DATE.getName();
    protected final static String EVENT_FORMAT                      = DefaultCellFormatTypes.EVENT.getName();

    protected final static String NONE_CONDITIONAL                  = DefaultConditionalCellFormatTypes.NONE.getName();
    protected final static String PROPER_CONDITIONAL                = DefaultConditionalCellFormatTypes.PROPER.getName();
    protected final static String UPPERCASE_CONDITIONAL             = DefaultConditionalCellFormatTypes.UPPERCASE.getName();
    protected final static String DISTANCE_UNIT_CONDITIONAL         = DefaultConditionalCellFormatTypes.DISTANCE_UNIT.getName();
    protected final static String VALID_POSTCODE_CONDITIONAL        = DefaultConditionalCellFormatTypes.VALID_POSTCODE.getName();
    protected final static String VALID_EMAIL_CONDITIONAL           = DefaultConditionalCellFormatTypes.VALID_EMAIL.getName();
    protected final static String VALID_PHONE_CONDITIONAL           = DefaultConditionalCellFormatTypes.VALID_PHONE.getName();
    protected final static String VALID_REGISTRATION_ID_CONDITIONAL = DefaultConditionalCellFormatTypes.VALID_REGISTRATION_ID.getName();
    protected final static String VALID_RACE_NUMBER_CONDITIONAL     = DefaultConditionalCellFormatTypes.VALID_RACE_NUMBER.getName();
    protected final static String VALID_TAG_NUMBER_CONDITIONAL      = DefaultConditionalCellFormatTypes.VALID_TAG_NUMBER.getName();


    public FileCreator() {
    }

    public abstract void createDefaultFile(String fileAddress);

    public void writeToFileWithComment(String comment, String[][] dataLines, String fileAddress) {

            BatchFileHandler.appendToFileWithoutQuotes(comment, fileAddress);

            // Echoing each set of values to a new line in the file
            for (String[] dataLine: dataLines) {
                        appendToFileWithoutQuotes(makeSaveDataLine(dataLine), fileAddress);
        }
    }

    /**
     * Private helper method that generates a String in the correct save data format from an array of values.
     * @param saveData : The data that is being saved as a line in a text file.
     * @return : The data formatted as a single string in the correct format
     */
    private String makeSaveDataLine(String[] saveData) {

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
}
