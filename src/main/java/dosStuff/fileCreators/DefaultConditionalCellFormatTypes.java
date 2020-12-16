package dosStuff.fileCreators;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * Enum representation of each default conditional cell format.
 * @author Remus Courtenay - rcou199
 * @since 13/11/2020
 */
public enum DefaultConditionalCellFormatTypes implements DefaultSaveFileValues{ // TODO... Comments
    NONE(                   "none"),
    TRUE(                   "true",         "=TRUE"),
    PROPER(                 "proper",       "=NOT(EXACT([CELL],PROPER([CELL])))",                       "Remus Courtenay"),
    UPPERCASE(              "uppercase",    "=NOT(EXACT([CELL],UPPER([CELL])))",                        "REMUS"),
    DISTANCE_UNIT(          "distanceUnit", "=NOT(OR(EXACT([CELL],\"KM\"),EXACT([CELL],\"MI\")))",      "KM"),
    VALID_POSTCODE(         "postcode",     "=NOT(LEN([CELL])=4)",                                      "7020"),
    VALID_EMAIL(            "email",        "=NOT(ISNUMBER(MATCH(\"*@*.*\",[CELL],0)))",                "remuscourtenay@gmail.com"),
    VALID_PHONE(            "phone",        "=NOT(LEN([CELL])>6)",                                      "0211097735"),
    VALID_REGISTRATION_ID(  "id",           "=NOT(AND(LEN([CELL])=9,ISNUMBER([CELL])))",                "898217506"),
    VALID_RACE_NUMBER(      "raceNum",      "=NOT(AND(LEN([CELL])>2,LEN([CELL])<5,ISNUMBER([CELL])))",  "250"),
    VALID_TAG_NUMBER(       "tagNum",       "=NOT(LEN([CELL])=12)",                                     "058001ea67df");

    private static final String specificCellStandIn = "[CELL]";

    private final String name;
    private final String exampleValue;
    private final String format;


    DefaultConditionalCellFormatTypes(String name, String format, String exampleValue) {
        this.name = name;
        this.format = format;
        this.exampleValue = exampleValue;
    }

    DefaultConditionalCellFormatTypes(String name, String format) {
        this(name, format, DEFAULT_EXAMPLE_VALUE);
    }

    DefaultConditionalCellFormatTypes(String name) {
        this(name, DEFAULT_CONDITIONAL_FORMAT);
    }




    public void setupSaveDataNameCell(Cell nameCell) {
        nameCell.setCellValue(this.name);
    }

    public void setupSaveDataValueCell(Cell valueCell, SheetConditionalFormatting sheetConditionalFormatting) {

        switch (this) {
            case NONE, TRUE, PROPER, UPPERCASE, DISTANCE_UNIT, VALID_EMAIL, VALID_TAG_NUMBER -> valueCell.setCellValue(this.exampleValue);
            case VALID_POSTCODE, VALID_PHONE, VALID_REGISTRATION_ID, VALID_RACE_NUMBER -> valueCell.setCellValue(Integer.parseInt(this.exampleValue));
            default -> throw new RuntimeException(); //TODO...
        }
        setupSaveDataCellConditionalFormatting(valueCell, sheetConditionalFormatting);

    }

    protected void setupSaveDataCellConditionalFormatting(Cell valueCell, SheetConditionalFormatting sheetConditionalFormatting) {
        if (this.format == null) {
            return;
        }
        StringBuilder addSpecificCellToFormat = new StringBuilder(this.format);
        String cellAddress = valueCell.getAddress().formatAsString();

        int index;
        while((index = addSpecificCellToFormat.indexOf(specificCellStandIn)) != -1) {
            addSpecificCellToFormat.replace(index, index + specificCellStandIn.length(), cellAddress);
        }

        ConditionalFormattingRule conditionalFormattingRule = sheetConditionalFormatting.createConditionalFormattingRule(addSpecificCellToFormat.toString());

        PatternFormatting patternFormatting = conditionalFormattingRule.createPatternFormatting();
        patternFormatting.setFillPattern(PatternFormatting.SOLID_FOREGROUND);
        patternFormatting.setFillBackgroundColor(IndexedColors.RED.index);


        sheetConditionalFormatting.addConditionalFormatting(getSingleCellRangeAddressArray(valueCell), conditionalFormattingRule);
    }

    private CellRangeAddress[] getSingleCellRangeAddressArray(Cell cell) {
        int row = cell.getRowIndex();
        int col = cell.getColumnIndex();
        CellRangeAddress saveDataCellRange = new CellRangeAddress(row, row, col, col);

        return new CellRangeAddress[]{saveDataCellRange};
    }
}
