package fakeEnums;

import org.apache.poi.ss.usermodel.ConditionalFormattingRule;

record ColumnConditionalFormat(
        String name,
        ConditionalFormattingRule conditionalFormattingRule
) {}
