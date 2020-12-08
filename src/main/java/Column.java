import org.apache.poi.ss.usermodel.CellType;

/**
 * @author Remus Courtenay - rcou199
 * @since 10/11/2020
 */
public class Column {

    private String headerText;
    private CellType cellType;
    private ColumnFormat columnFormat;
    private ColumnConditionalFormat columnConditionalFormat;

    public Column(String headerText, CellType cellType, ColumnFormat columnFormat, ColumnConditionalFormat columnConditionalFormat) {

        this.headerText = headerText;
        this.cellType = cellType;
        this.columnFormat = columnFormat;
        this.columnConditionalFormat = columnConditionalFormat;


    }


}
