package fakeEnums;

import org.apache.poi.ss.usermodel.*;

/**
 * @author Remus Courtenay - rcou199
 * @since 10/11/2020
 */
public class Column extends FakeEnumValue {

    private ColumnFormat columnFormat;
    private ColumnConditionalFormat columnConditionalFormat;

    public Column(String name, ColumnFormat columnFormat, ColumnConditionalFormat columnConditionalFormat) {
        super(name);
        this.columnFormat = columnFormat;
        this.columnConditionalFormat = columnConditionalFormat;
    }

    @Override
    public String toString() {
        return "Column - " + getName() + " : " + columnFormat.getName() + " " + columnConditionalFormat.getName();
    }

    public void applyFormat(Cell cell, CellStyle cellStyle, SheetConditionalFormatting sheetConditionalFormatting) {
        columnFormat.applyCellStyle(cellStyle, cell);
        columnConditionalFormat.applyConditionalFormatting(sheetConditionalFormatting, cell.getAddress());
    }
}
