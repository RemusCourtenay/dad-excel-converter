package fakeEnums;

import org.apache.poi.ss.usermodel.CellStyle;

record ColumnFormat(
        String name,
        CellStyle cellStyle
) {}
