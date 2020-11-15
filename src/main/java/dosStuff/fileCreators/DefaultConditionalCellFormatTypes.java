package dosStuff.fileCreators;

/**
 * @author Remus Courtenay - rcou199
 * @since 13/11/2020
 */
public enum DefaultConditionalCellFormatTypes {
    NONE(""),
    PROPER("=NOT(EXACT([CELL].PROPER([CELL])))"),
    UPPERCASE("=NOT(EXACT([CELL].UPPER([CELL])))"),
    DISTANCE_UNIT("=NOT(OR(EXACT([CELL].\"KM\").EXACT([CELL].\"MI\")))"),
    VALID_POSTCODE("=LEN([CELL])=4"),
    VALID_EMAIL("=NOT(ISNUMBER(MATCH(\"*@*\\.*\".[CELL].0)))"),
    VALID_PHONE("=NOT(LEN([CELL])>6)"),
    VALID_REGISTRATION_ID("=NOT(AND(LEN([CELL])=9.ISNUMBER([CELL])))"),
    VALID_RACE_NUMBER("=NOT(AND(LEN([CELL])>2.LEN([CELL])<5.ISNUMBER([CELL])))"),
    VALID_TAG_NUMBER("=NOT(LEN([CELL]=12)");

    private final String format;

    DefaultConditionalCellFormatTypes(String format) {
        this.format = format;
    }

    public String[] getSaveData() {
        return new String[] {this.name(), this.format};
    }
}
