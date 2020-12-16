package dosStuff.fileCreators;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.model.StylesTable;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Enum representation of each default cell format.
 * @author Remus Courtenay - rcou199
 * @since 13/11/2020
 */
public enum DefaultCellFormatTypes implements DefaultSaveFileValues{
    NONE(           "none"),
    TEXT(           "text", "Example text"),
    ADDRESS(        "address", "163 Queen Street"),
    POST_CODE(      "postcode", "7020"),
    EMAIL(          "email", "remuscourtenay@gmail.com"),
    PHONE_NUMBER(   "phone", "0211097735"),
    GENDER(         "gender", "Male"),
    ID_NUMBER(      "id", "898217506"),
    TAG_NUMBER(     "tag", "058001ea67df"),
    TIME(           "time", "05/02/1999", "dd-mm-yyyy h:ss"),
    DISTANCE(       "distance", "KM"),
    DATE(           "date",  "05/02/1999", "dd-mm-yyyy"),
    EVENT(          "event", "10km");


    private final String name;
    private final String exampleValue;
    private final CellStyle cellStyle;

    DefaultCellFormatTypes(String name, String exampleValue, String format) {

        this.name = name;
        this.exampleValue = exampleValue;
        StylesTable stylesTable = new StylesTable();
        this.cellStyle = stylesTable.createCellStyle();

        short index = 0;
        stylesTable.putNumberFormat(index, format);
        this.cellStyle.setDataFormat(index);

    }

    DefaultCellFormatTypes(String name, String exampleValue) {
        this(name, exampleValue, DEFAULT_FORMAT);
    }

    DefaultCellFormatTypes(String name) {
        this(name, DEFAULT_EXAMPLE_VALUE);
    }

    @Override
    public void setupSaveDataNameCell(Cell nameCell) {
        nameCell.setCellValue(this.name);
    }
    public void setupSaveDataValueCell(Cell valueCell, CellStyle blankStyle)  {
        setupSaveDataValueCell(valueCell, blankStyle, this.exampleValue);
    }

    protected void setupSaveDataValueCell(Cell valueCell, CellStyle blankStyle, String exampleValue) {
        setCellTypeWithCellValue(valueCell, exampleValue);

        blankStyle.cloneStyleFrom(this.cellStyle);
        valueCell.setCellStyle(blankStyle);
    }

    private void setCellTypeWithCellValue(Cell valueCell, String exampleValue) {
        try {
            switch (this) {
                case NONE, TEXT, ADDRESS, EMAIL, GENDER, TAG_NUMBER, DISTANCE, EVENT -> // Add as String
                        valueCell.setCellValue(exampleValue);
                case POST_CODE, PHONE_NUMBER, ID_NUMBER -> // Add as int
                        valueCell.setCellValue(Integer.parseInt(exampleValue));
                case DATE, TIME -> // Add as Date
                        valueCell.setCellValue(DEFAULT_DATE_FORMAT.parse(exampleValue));
                default -> throw new RuntimeException(); // TODO...
            }
        } catch (ParseException exception) {
            exception.printStackTrace();
            throw new RuntimeException(); // TODO...
        } catch (NumberFormatException exception) {
            valueCell.setCellValue("");
        }
    }
}
