package fakeEnums;

import org.apache.poi.ss.usermodel.ConditionalFormattingRule;

class ColumnConditionalFormat extends FakeEnumValue {

    private final ConditionalFormattingRule formattingRule;

    protected ColumnConditionalFormat(String name, ConditionalFormattingRule formattingRule) {
        super(name);
        this.formattingRule = formattingRule;
    }

    public ConditionalFormattingRule getFormattingRule() {
        return this.formattingRule;
    }
}
