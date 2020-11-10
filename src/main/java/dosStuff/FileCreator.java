package dosStuff;

import org.apache.poi.ss.usermodel.CellType;

/**
 * @author Remus Courtenay - rcou199
 * @since 11/11/2020
 */
public interface FileCreator extends SettingsHandler {

    static final String SETTINGS_FILE_TEXT = "This is a settings file";

    static final String HEADERS_FILE_COMMENT =
            "Add new headers on a new line with the format: (name),(column type) with no spaces. Valid column types are: " // Don't use <> characters
            + CellType.STRING.toString() + ", "
            + CellType.NUMERIC.toString() + ", "
            + CellType.BOOLEAN.toString() + ", "
            + CellType.FORMULA.toString() + " and "
            + CellType.BLANK.toString() + ".";

    static final String[][] DEFAULT_HEADERS = {
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




}
