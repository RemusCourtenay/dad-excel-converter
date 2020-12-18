package fakeEnums;

import dosStuff.FileIOThreadManager;
import fakeEnums.ColumnConditionalFormats;
import fakeEnums.FakeEnumBuilder;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.ArrayList;
import java.util.List;

public class ColumnConditionalFormatsBuilder extends FakeEnumBuilder { // TODO... Comments

    @Override
    public void setupEnumFromFile(FileIOThreadManager fileManager) {
        Workbook saveDataWorkbook = convertFileToWorkbook(fileManager.getFile());

        Sheet saveDataSheet = saveDataWorkbook.getSheetAt(0); // TODO... check sheet num
        SheetConditionalFormatting saveDataConditionalFormatting = saveDataSheet.getSheetConditionalFormatting();
        int numOfConditionalFormattings = saveDataConditionalFormatting.getNumConditionalFormattings();

        List<FakeEnumValue> enumValues = new ArrayList<>(numOfConditionalFormattings);

        ConditionalFormatting conditionalFormatting;
        CellAddress cellAddress;
        Cell cell;

        for (int i = 0; i < numOfConditionalFormattings; i++) {
            conditionalFormatting = saveDataConditionalFormatting.getConditionalFormattingAt(i);

            cellAddress = getSpecificCellAddress(conditionalFormatting);
            cell = saveDataSheet.getRow(cellAddress.getRow()).getCell(cellAddress.getColumn());

            enumValues.add(new ColumnConditionalFormat(cell.getStringCellValue(), conditionalFormatting));
        }

        new ColumnConditionalFormats(enumValues);
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
