package fakeEnums;

import org.apache.poi.ss.usermodel.ConditionalFormatting;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;

public class ColumnConditionalFormat extends FakeEnumValue {

    private final ConditionalFormatting formatting;

    protected ColumnConditionalFormat(String name, ConditionalFormatting formatting) {
        super(name);
        this.formatting = formatting;
    }

    public void applyConditionalFormatting(SheetConditionalFormatting sheetConditionalFormatting, CellAddress cellAddress) {
        int numOfRules = formatting.getNumberOfRules();
        ConditionalFormattingRule[] formattingRules = new ConditionalFormattingRule[numOfRules];
        for (int i = 0; i < numOfRules; i++) {
            formattingRules[i] = formatting.getRule(i);
        }

        int cellRow = cellAddress.getRow();
        int cellCol = cellAddress.getColumn();

        CellRangeAddress[] cellRangeAddresses = new CellRangeAddress[]{new CellRangeAddress(cellRow, cellRow, cellCol, cellCol)}; // Cursed method of generating cellrangeaddress from cellAddress

        sheetConditionalFormatting.addConditionalFormatting(cellRangeAddresses, formattingRules);
    }

    @Override
    public String toString() {
        return "Conditional Format - " + getName() + " : " + formatting.getRule(0).getFormula1();
    }
}
