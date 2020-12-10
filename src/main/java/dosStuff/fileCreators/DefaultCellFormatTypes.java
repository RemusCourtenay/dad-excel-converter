package dosStuff.fileCreators;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;

/**
 * Enum representation of each default cell format.
 * @author Remus Courtenay - rcou199
 * @since 13/11/2020
 */
public enum DefaultCellFormatTypes {
    NONE(           "none"),
    TEXT(           "text"),
    ADDRESS(        "address"),
    POST_CODE(      "postcode"),
    EMAIL(          "email"),
    PHONE_NUMBER(   "phone"),
    GENDER(         "gender"),
    ID_NUMBER(      "id"),
    TAG_NUMBER(     "tag"),
    TIME(           "time", "dd-mm-yyyy h:ss"),
    DISTANCE(       "distance"),
    DATE(           "date", "dd-mm-yyyy"),
    EVENT(          "event");

    private static final String GENERAL_FORMAT = "General";

    private final String name;
    private final CellStyle cellStyle;
    private final StylesTable stylesTable;

    DefaultCellFormatTypes(String name, String format) {

        this.name = name;
        this.stylesTable = new StylesTable();
        this.cellStyle = stylesTable.createCellStyle();

        short index = 0;
        stylesTable.putNumberFormat(index, format);
        this.cellStyle.setDataFormat(index);

    }

    DefaultCellFormatTypes(String name) {
        this(name, GENERAL_FORMAT);
    }

    /* -------------------------------- Getter methods -------------------------------- */

    public String getName() {
        return name;
    }

    public CellStyle getCellStyle() {
        return cellStyle;
    }
}
