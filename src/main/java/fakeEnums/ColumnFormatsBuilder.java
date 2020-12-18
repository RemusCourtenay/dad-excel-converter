package fakeEnums;

import dosStuff.FileIOThreadManager;
import fakeEnums.ColumnFormat;
import fakeEnums.ColumnFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ColumnFormatsBuilder extends FakeEnumBuilder { // TODO... Comment

    private static final int NUM_OF_SAVE_DATA_ROWS = 2;

    @Override
    public void setupEnumFromFile(FileIOThreadManager fileManager) {
        Row[] saveDataRows = getSaveDataRowsFromSheet(getSaveDataSheetFromFile(fileManager), NUM_OF_SAVE_DATA_ROWS);

        Row saveDataNameRow = saveDataRows[0];
        Row saveDataFormatRow = saveDataRows[1];

        Iterator<Cell> nameCellIterator = saveDataNameRow.cellIterator();
        Iterator<Cell> formatCellIterator = saveDataFormatRow.cellIterator();

        List<FakeEnumValue> enumValues = new ArrayList<>(saveDataNameRow.getPhysicalNumberOfCells());

        Cell nameCell;
        Cell formatCell;

        ColumnFormat columnFormat;

        while(allIteratorsHaveNext(nameCellIterator, formatCellIterator)) {
            nameCell = nameCellIterator.next();
            formatCell = formatCellIterator.next();

            columnFormat = new ColumnFormat(
                    nameCell.getStringCellValue(),
                    formatCell.getCellStyle()
            );

            enumValues.add(columnFormat);
        }

        new ColumnFormats(enumValues);

    }


}
