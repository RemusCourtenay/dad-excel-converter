import org.apache.poi.ss.format.CellFormat;
import org.apache.poi.ss.usermodel.Cell;

public class ColumnFormat implements FakeEnumValue {

    private final CellFormat cellFormat;

    public ColumnFormat(String cellFormatData) {
        this.cellFormat = CellFormat.getInstance(cellFormatData);
    }

    public CellFormat getFormat() {
        return this.cellFormat;
    }

}
