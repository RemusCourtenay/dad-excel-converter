package fakeEnums;

import dosStuff.FileIOThreadManager;
import fakeEnums.ColumnConditionalFormats;
import fakeEnums.FakeEnumBuilder;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Condition;

public class ColumnConditionalFormatsBuilder extends FakeEnumBuilder { // TODO... Comments

    private static final int NUM_OF_SAVE_DATA_ROWS = 1;

    @Override
    public void setupEnumFromFile(FileIOThreadManager fileManager) {
        Sheet saveDataSheet = getSaveDataSheetFromFile(fileManager);
        Row[] saveDataRows = getSaveDataRowsFromSheet(saveDataSheet, NUM_OF_SAVE_DATA_ROWS);

        Row saveDataNameRow = saveDataRows[0];
        Iterator<Cell> nameCellIterator = saveDataNameRow.cellIterator();
        Iterator<ConditionalFormatting> formattingIterator = getConditionalFormattingIteratorFromSheet(saveDataSheet);

        List<FakeEnumValue> enumValues = new ArrayList<>(saveDataNameRow.getPhysicalNumberOfCells());

        ConditionalFormatting conditionalFormatting;
        Cell nameCell;

        ColumnConditionalFormat conditionalFormat;

        while(allIteratorsHaveNext(nameCellIterator, formattingIterator)) {
            nameCell = nameCellIterator.next();
            conditionalFormatting = formattingIterator.next();

            if (nameCell.getAddress() != getSpecificCellAddress(conditionalFormatting)) {
                throw new RuntimeException(); // TODO...
            }

            conditionalFormat = new ColumnConditionalFormat(
                    nameCell.getStringCellValue(),
                    conditionalFormatting
            );

            enumValues.add(conditionalFormat);
        }

        new ColumnConditionalFormats(enumValues);
    }

    private Iterator<ConditionalFormatting> getConditionalFormattingIteratorFromSheet(Sheet saveDataSheet) {
        SheetConditionalFormatting saveDataConditionalFormatting = saveDataSheet.getSheetConditionalFormatting();
        int numOfConditionalFormattings = saveDataConditionalFormatting.getNumConditionalFormattings();

        List<ConditionalFormatting> conditionalFormattingList = new ArrayList<>(numOfConditionalFormattings);

        for (int i = 0; i < numOfConditionalFormattings; i++) {
            conditionalFormattingList.add(saveDataConditionalFormatting.getConditionalFormattingAt(i));
        }

        return conditionalFormattingList.iterator();
    }

    private CellAddress getSpecificCellAddress(ConditionalFormatting formatting) {

        CellRangeAddress[] cellRangeAddresses = formatting.getFormattingRanges();

        if (cellRangeAddresses.length != 1) {
            throw new RuntimeException(); // TODO...
        }

        CellRangeAddress cellAddresses = cellRangeAddresses[0];

        if (cellAddresses.getNumberOfCells() != 1) {
            throw new RuntimeException(); // TODO...
        }

        return cellAddresses.iterator().next();
    }

}
