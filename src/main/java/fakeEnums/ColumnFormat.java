package fakeEnums;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

public class ColumnFormat extends FakeEnumValue {

    private final CellStyle cellStyle;

    protected ColumnFormat(String name, CellStyle cellStyle) {
        super(name);
        this.cellStyle = cellStyle;
    }

    public void applyCellStyle(CellStyle cellStyle, Cell cell) {
        cellStyle.cloneStyleFrom(this.cellStyle);
        cell.setCellStyle(cellStyle);
    }

    @Override
    public String toString() {
        return "Column Format - " + getName() + " : " + cellStyle.getDataFormatString();
    }
}
