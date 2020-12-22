package fakeEnums;

import dosStuff.FileIOThreadManager;
import fakeEnums.ColumnConditionalFormats;
import fakeEnums.FakeEnumBuilder;
import helpers.WorkbookHelper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Condition;

public class ColumnConditionalFormatsBuilder extends FakeEnumBuilder { // TODO... Comments

    private static final int NUM_OF_SAVE_DATA_ROWS = 2;

    @Override
    public void setupEnumFromFile(File saveDataFile) { // TODO... Move into abstract class
        Sheet saveDataSheet = WorkbookHelper.getSaveDataSheetFromFile(saveDataFile);
        Row[] saveDataRows = WorkbookHelper.getSaveDataRowsFromSheet(saveDataSheet, NUM_OF_SAVE_DATA_ROWS);

        Row saveDataNameRow = saveDataRows[0];
        Row saveDataFormatRow = saveDataRows[1];
        Iterator<Cell> nameCellIterator = saveDataNameRow.cellIterator();
        Iterator<Cell> formatCellIterator = saveDataFormatRow.cellIterator();
        Iterator<ConditionalFormatting> formattingIterator = getConditionalFormattingIteratorFromSheet(saveDataSheet);

        List<FakeEnumValue> enumValues = new ArrayList<>(saveDataNameRow.getPhysicalNumberOfCells());

        ConditionalFormatting conditionalFormatting;
        Cell nameCell;
        Cell formatCell;

        ColumnConditionalFormat conditionalFormat;

        while(WorkbookHelper.allIteratorsHaveNext(nameCellIterator, formatCellIterator, formattingIterator)) {
            nameCell = nameCellIterator.next();
            formatCell = formatCellIterator.next();
            conditionalFormatting = formattingIterator.next();

            if (!formatCell.getAddress().equals(getSpecificCellAddress(conditionalFormatting))) {
                throw new RuntimeException(formatCell.getAddress().formatAsString() + " does not equal " + getSpecificCellAddress(conditionalFormatting).formatAsString()); // TODO...
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
