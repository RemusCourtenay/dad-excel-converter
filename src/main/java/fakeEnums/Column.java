package fakeEnums;

import fakeEnums.ColumnConditionalFormat;
import fakeEnums.ColumnFormat;
import org.apache.poi.ss.usermodel.CellType;

/**
 * @author Remus Courtenay - rcou199
 * @since 10/11/2020
 */
public class Column extends FakeEnumValue {

    private CellType cellType;
    private ColumnFormat columnFormat;
    private ColumnConditionalFormat columnConditionalFormat;

    public Column(String name, CellType cellType, ColumnFormat columnFormat, ColumnConditionalFormat columnConditionalFormat) {

        super(name);
        this.cellType = cellType;
        this.columnFormat = columnFormat;
        this.columnConditionalFormat = columnConditionalFormat;

    }

}
