package fakeEnums;

import dosStuff.FileIOThreadManager;
import fakeEnums.ColumnConditionalFormat;
import fakeEnums.ColumnConditionalFormats;
import fakeEnums.ColumnFormat;
import fakeEnums.ColumnFormats;
import org.apache.poi.ss.usermodel.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ColumnBuilder extends FakeEnumBuilder {

    private static final int NUM_OF_SAVE_DATA_ROWS = 3;

    @Override
    public void setupEnumFromFile(FileIOThreadManager fileManager) { // TODO... Comments
        Sheet saveDataSheet = getSaveDataSheetFromFile(fileManager);

        Row[] saveDataRows = getSaveDataRowsFromSheet(saveDataSheet, NUM_OF_SAVE_DATA_ROWS);

        Row saveDataNameRow = saveDataRows[0];
        Row saveDataFormatRow = saveDataRows[1];
        Row saveDataConditionalFormatRow = saveDataRows[2];

        Iterator<Cell> nameCellIterator = saveDataNameRow.cellIterator();
        Iterator<Cell> formatCellIterator = saveDataFormatRow.cellIterator();
        Iterator<Cell> conditionalFormatCellIterator = saveDataConditionalFormatRow.cellIterator();

        List<FakeEnumValue> enumValues = new ArrayList<>(saveDataNameRow.getPhysicalNumberOfCells());

        String name;
        String columnFormatName;
        String columnConditionalFormatName;

        Column column;

        while (allIteratorsHaveNext(nameCellIterator, formatCellIterator, conditionalFormatCellIterator)) {

            name = nameCellIterator.next().getStringCellValue();
            columnFormatName = formatCellIterator.next().getStringCellValue();
            columnConditionalFormatName = conditionalFormatCellIterator.next().getStringCellValue();

            column = new Column(
                    name,
                    ColumnFormats.valueOf(columnFormatName),
                    ColumnConditionalFormats.valueOf(columnConditionalFormatName)
            );

            enumValues.add(column);
        }

        new Columns(enumValues);
    }
}
