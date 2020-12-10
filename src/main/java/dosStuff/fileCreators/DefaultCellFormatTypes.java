package dosStuff.fileCreators;

/**
 * Enum representation of each default cell format.
 * @author Remus Courtenay - rcou199
 * @since 13/11/2020
 */
public enum DefaultCellFormatTypes {
    NONE(           "none"),
    TEXT(           "text"),
    ADDRESS(        "address"),
    POST_CODE(      "postcode"),
    EMAIL(          "email"),
    PHONE_NUMBER(   "phone"),
    GENDER(         "gender"),
    ID_NUMBER(      "id"),
    TAG_NUMBER(     "tag"),
    TIME(           "time", "dd-mm-yyyy h:ss"),
    DISTANCE(       "distance"),
    DATE(           "date", "dd-mm-yyyy"),
    EVENT(          "event");

    private static final String GENERAL_FORMAT = "General";

    private final String name;
    private final String format;

    DefaultCellFormatTypes(String name, String format) {

        this.name = name;
        this.format = format;

    }

    DefaultCellFormatTypes(String name) {
        this.name = name;
        this.format = GENERAL_FORMAT;
    }

    /* -------------------------------- Getter methods -------------------------------- */

    public String[] getSaveData() {
        return new String[]{name, format};
    }

    public String getName() {
        return name;
    }

}
