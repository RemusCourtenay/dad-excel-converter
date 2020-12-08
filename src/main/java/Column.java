import org.apache.poi.ss.usermodel.CellType;

/**
 * @author Remus Courtenay - rcou199
 * @since 10/11/2020
 */
public class Column {

    private String headerText;
    private CellType cellType;
    private ColumnFormats columnFormats;
    private ColumnConditionalFormats columnConditionalFormats;

    public Column(String headerText, CellType cellType, ColumnFormats columnFormats, ColumnConditionalFormats columnConditionalFormats) {

        this.headerText = headerText;
        this.cellType = cellType;
        this.columnFormats = columnFormats;
        this.columnConditionalFormats = columnConditionalFormats;


    }


}
