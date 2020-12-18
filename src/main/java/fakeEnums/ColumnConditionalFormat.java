package fakeEnums;

import org.apache.poi.ss.usermodel.ConditionalFormatting;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;

class ColumnConditionalFormat extends FakeEnumValue {

    private final ConditionalFormatting formatting;

    protected ColumnConditionalFormat(String name, ConditionalFormatting formatting) {
        super(name);
        this.formatting = formatting;
    }

    public ConditionalFormatting getFormatting() {
        return this.formatting;
    }
}
