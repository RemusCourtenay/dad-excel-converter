import org.apache.poi.ss.format.CellFormat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

public class ColumnFormat implements FakeEnumValue {

    private final String name;
    private final CellStyle cellStyle;

    public ColumnFormat(String name, CellStyle cellStyle) { // TODO... Comment
        this.name = name;
        this.cellStyle = cellStyle;
    }

    public CellStyle getStyle() {
        return this.cellStyle;
    }

    public String getName() {
        return this.name;
    }

}
