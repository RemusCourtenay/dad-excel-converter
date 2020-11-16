package dosStuff.fileCreators;

/**
 * Enum representation of each default conditional cell format.
 * @author Remus Courtenay - rcou199
 * @since 13/11/2020
 */
public enum DefaultConditionalCellFormatTypes {
    NONE("none",""),
    PROPER("proper","=NOT(EXACT([CELL].PROPER([CELL])))"),
    UPPERCASE("uppercase","=NOT(EXACT([CELL].UPPER([CELL])))"),
    DISTANCE_UNIT("distanceUnit","=NOT(OR(EXACT([CELL].\"KM\").EXACT([CELL].\"MI\")))"),
    VALID_POSTCODE("postcode","=LEN([CELL])=4"),
    VALID_EMAIL("email","=NOT(ISNUMBER(MATCH(\"*@*\\.*\".[CELL].0)))"),
    VALID_PHONE("phone","=NOT(LEN([CELL])>6)"),
    VALID_REGISTRATION_ID("id","=NOT(AND(LEN([CELL])=9.ISNUMBER([CELL])))"),
    VALID_RACE_NUMBER("raceNum","=NOT(AND(LEN([CELL])>2.LEN([CELL])<5.ISNUMBER([CELL])))"),
    VALID_TAG_NUMBER("tagNum","=NOT(LEN([CELL]=12)");

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
}
