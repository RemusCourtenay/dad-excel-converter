package dosStuff;

/**
 * @author Remus Courtenay - rcou199
 * @since 13/11/2020
 */
public class MasterSheetLayoutFileCreator extends FileCreator {

    private static final String MASTER_SHEET_LAYOUT_FILE_COMMENT = "Defines the layout of the generated Master sheet.";

    private static final String[][] MASTER_SHEET_LAYOUT_DEFAULT_HEADERS = {
            // <Header text>, <Cell Type>, <Cell Formatting>, <Conditional Cell Formatting>
            {"First_Name",              STRING,     TEXT,           PROPER},
            {"Last_Name",               STRING,     TEXT,           PROPER},
            {"Address1",                STRING,     ADDRESS,        NONE}, // Not used
            {"Address2",                STRING,     ADDRESS,        NONE}, // Not used
            {"Address3",                STRING,     ADDRESS,        NONE}, // Not used
            {"Address4",                STRING,     ADDRESS,        PROPER}, // City
            {"Post_Code",               NUMERIC,    POST_CODE,      VALID_POSTCODE}, // Not used
            {"Email",                   STRING,     EMAIL,          VALID_EMAIL},
            {"PhoneNo",                 NUMERIC,    PHONE_NUMBER,   NONE}, // Not used
            {"PhoneNo2",                NUMERIC,    PHONE_NUMBER,   NONE}, // Not used
            {"Gender",                  STRING,     GENDER,         UPPERCASE},
            {"Info1",                   STRING,     TEXT,           PROPER}, // Support person
            {"Info2",                   NUMERIC,    PHONE_NUMBER,   VALID_PHONE}, // Cellphone number
            {"Info3",                   NUMERIC,    ID_NUMBER,      VALID_REGISTRATION_ID}, // Registration ID
            {"Info4",                   NUMERIC,    TIME,           NONE}, // Registration Time, maybe put check?
            {"Info5",                   STRING,     DISTANCE,       DISTANCE_UNIT}, // KM or MILES?
            {"DOB",                     NUMERIC,    DATE,           NONE}, // Date of birth, maybe put check?
            {"Age",                     NUMERIC,    NONE,           NONE}, // Not used
            {"Team",                    STRING,     TEXT,           NONE}, // Not used
            {"Reg/Licence_No",          NUMERIC,    NONE,           NONE}, // Not used
            {"UCI No",                  NUMERIC,    NONE,           NONE}, // Not used
            {"Relay_Team",              STRING,     TEXT,           NONE}, // Not used
            {"Race No",                 NUMERIC,    ID_NUMBER,      VALID_RACE_NUMBER}, // Race number
            {"Tag No",                  STRING,     TAG_NUMBER,     VALID_TAG_NUMBER},
            {"Event",                   STRING,     EVENT,          NONE}, // Name of sub-event, maybe put check?
            {"Division",                STRING,     TEXT,           NONE}, // Not used
            {"Wave",                    STRING,     TEXT,           NONE}, // Not used
            {"Seed",                    STRING,     TEXT,           NONE}, // Not used
            {"EstTime",                 STRING,     TEXT,           NONE}, // Not used
            {"Merchandise",             STRING,     TEXT,           NONE}, // Not used
            {"Qty",                     STRING,     TEXT,           NONE}, // Not used
            {"Size",                    STRING,     TEXT,           NONE}, // Not used
            {"Comment",                 STRING,     TEXT,           NONE}, // Not used
            {"Athlete2_First_Name",     STRING,     TEXT,           PROPER}, // Not used
            {"Athlete2_Last_Name",      STRING,     TEXT,           PROPER}, // Not used
            {"Athlete3_First_Name",     STRING,     TEXT,           PROPER}, // Not used
            {"Athlete3_Last_Name",      STRING,     TEXT,           PROPER} // Not used
    };

    @Override
    public void runSetup() {

    }
}
