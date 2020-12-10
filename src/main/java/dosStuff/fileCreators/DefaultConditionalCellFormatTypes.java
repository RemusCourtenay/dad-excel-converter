package dosStuff.fileCreators;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * Enum representation of each default conditional cell format.
 * @author Remus Courtenay - rcou199
 * @since 13/11/2020
 */
public enum DefaultConditionalCellFormatTypes { // TODO... Comments
    NONE(                   "none",         "=FALSE"),
    PROPER(                 "proper",       "=NOT(EXACT([CELL],PROPER([CELL])))"),
    UPPERCASE(              "uppercase",    "=NOT(EXACT([CELL],UPPER([CELL])))"),
    DISTANCE_UNIT(          "distanceUnit", "=NOT(OR(EXACT([CELL],\"KM\"),EXACT([CELL],\"MI\")))"),
    VALID_POSTCODE(         "postcode",     "=NOT(LEN([CELL])=4)"),
    VALID_EMAIL(            "email",        "=NOT(ISNUMBER(MATCH(\"*@*.*\",[CELL],0)))"),
    VALID_PHONE(            "phone",        "=NOT(LEN([CELL])>6)"),
    VALID_REGISTRATION_ID(  "id",           "=NOT(AND(LEN([CELL])=9,ISNUMBER([CELL])))"),
    VALID_RACE_NUMBER(      "raceNum",      "=NOT(AND(LEN([CELL])>2,LEN([CELL])<5,ISNUMBER([CELL])))"),
    VALID_TAG_NUMBER(       "tagNum",       "=NOT(LEN([CELL])=12)");

    private static final String specificCellStandIn = "[CELL]";

    private final String name;
    private final String format;

    DefaultConditionalCellFormatTypes(String name, String format) {
        this.name = name;
        this.format = format;
    }

    /* -------------------------------- Getter methods -------------------------------- */

    public String[] getSaveData() {
        return new String[] {this.name, this.format};
    }

    public String getName() {
        return name;
    }

    public void setupSaveDataCell(Cell saveDataCell, SheetConditionalFormatting sheetConditionalFormatting) {
        StringBuilder addSpecificCellToFormat = new StringBuilder();
        String cellAddress = saveDataCell.getAddress().formatAsString();

        int index;
        while((index = addSpecificCellToFormat.indexOf(specificCellStandIn)) != -1) {
            addSpecificCellToFormat.replace(index, index + specificCellStandIn.length(), cellAddress);
        }

        ConditionalFormattingRule conditionalFormattingRule = sheetConditionalFormatting.createConditionalFormattingRule(this.format);

        PatternFormatting patternFormatting = conditionalFormattingRule.createPatternFormatting();
        patternFormatting.setFillPattern(PatternFormatting.SOLID_FOREGROUND);
        patternFormatting.setFillBackgroundColor(IndexedColors.RED.index);


        sheetConditionalFormatting.addConditionalFormatting(getSingleCellRangeAddressArray(saveDataCell), conditionalFormattingRule);
    }

    private CellRangeAddress[] getSingleCellRangeAddressArray(Cell cell) {
        int row = cell.getRowIndex();
        int col = cell.getColumnIndex();
        CellRangeAddress saveDataCellRange = new CellRangeAddress(row, row, col, col);

        return new CellRangeAddress[]{saveDataCellRange};
    }

}
