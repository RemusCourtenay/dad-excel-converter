package dosStuff.fileCreators;

import static dosStuff.fileCreators.FileCreator.*;

/**
 * @author Remus Courtenay - rcou199
 * @since 16/11/2020
 */
public enum DefaultHeaderTypes {
        FIRST_NAME(                     "First_Name",           STRING_CELL,    TEXT_FORMAT,            PROPER_CONDITIONAL),
        LAST_NAME(                      "Last_Name",            STRING_CELL,    TEXT_FORMAT,            PROPER_CONDITIONAL),
        ADDRESS_1(                      "Address1",             STRING_CELL,    ADDRESS_FORMAT,         NONE_CONDITIONAL), // Not used
        ADDRESS_2(                      "Address2",             STRING_CELL,    ADDRESS_FORMAT,         NONE_CONDITIONAL), // Not used
        ADDRESS_3(                      "Address3",             STRING_CELL,    ADDRESS_FORMAT,         NONE_CONDITIONAL), // Not used
        ADDRESS_4(                      "Address4",             STRING_CELL,    ADDRESS_FORMAT,         PROPER_CONDITIONAL), // City
        CITY(                           "City",                 STRING_CELL,    NONE_FORMAT,            NONE_CONDITIONAL), // For headers.txt
        POST_CODE(                      "Post_Code",            NUMERIC_CELL,   POST_CODE_FORMAT,       VALID_POSTCODE_CONDITIONAL), // Not used
        EMAIL_ADDRESS(                  "Email",                STRING_CELL,    EMAIL_FORMAT,           VALID_EMAIL_CONDITIONAL),
        PHONE_NUMBER(                   "PhoneNo",              NUMERIC_CELL,   PHONE_NUMBER_FORMAT,    NONE_CONDITIONAL), // Not used
        PHONE_NUMBER_2(                 "PhoneNo2",             NUMERIC_CELL,   PHONE_NUMBER_FORMAT,    NONE_CONDITIONAL), // Not used
        GENDER(                         "Gender",               STRING_CELL,    GENDER_FORMAT,          UPPERCASE_CONDITIONAL),
        SUPPORT_PERSON(                 "Info1",                STRING_CELL,    TEXT_FORMAT,            PROPER_CONDITIONAL), // Support person
        CELLPHONE_NUMBER(               "Info2",                NUMERIC_CELL,   PHONE_NUMBER_FORMAT,    VALID_PHONE_CONDITIONAL), // Cellphone number
        REGISTRATION_ID(                "Info3",                NUMERIC_CELL,   ID_NUMBER_FORMAT,       VALID_REGISTRATION_ID_CONDITIONAL), // Registration ID
        HEADERS_REGISTRATION_ID(        "Registration_ID",      NUMERIC_CELL,   NONE_FORMAT,            NONE_CONDITIONAL), // For headers.txt
        REGISTRATION_TIME(              "Info4",                NUMERIC_CELL,   TIME_FORMAT,            NONE_CONDITIONAL), // Registration Time, maybe put check?
        DISTANCE_UNIT(                  "Info5",                STRING_CELL,    DISTANCE_FORMAT,        DISTANCE_UNIT_CONDITIONAL), // KM or MILES?
        DATE_OF_BIRTH(                  "DOB",                  NUMERIC_CELL,   DATE_FORMAT,            NONE_CONDITIONAL), // Date of birth, maybe put check?
        AGE(                            "Age",                  NUMERIC_CELL,   NONE_FORMAT,            NONE_CONDITIONAL), // Not used
        TEAM(                           "Team",                 STRING_CELL,    TEXT_FORMAT,            NONE_CONDITIONAL), // Not used
        REGISTRATION_LICENSE_NUMBER(    "Reg/Licence_No",       NUMERIC_CELL,   NONE_FORMAT,            NONE_CONDITIONAL), // Not used
        UCI_NUMBER(                     "UCI_No",               NUMERIC_CELL,   NONE_FORMAT,            NONE_CONDITIONAL), // Not used
        RELAY_TEAM(                     "Relay_Team",           STRING_CELL,    TEXT_FORMAT,            NONE_CONDITIONAL), // Not used
        RACE_NUMBER(                    "Race_No",              NUMERIC_CELL,   ID_NUMBER_FORMAT,       VALID_RACE_NUMBER_CONDITIONAL), // Race number
        HEADERS_RACE_NUMBER(            "Race_Number",          NUMERIC_CELL,   NONE_FORMAT,            NONE_CONDITIONAL), // For headers.txt
        TAG_NUMBER(                     "Tag_No",               STRING_CELL,    TAG_NUMBER_FORMAT,      VALID_TAG_NUMBER_CONDITIONAL),
        EVENT(                          "Event",                STRING_CELL,    EVENT_FORMAT,           NONE_CONDITIONAL), // Name of sub-event, maybe put check?
        DIVISION(                       "Division",             STRING_CELL,    TEXT_FORMAT,            NONE_CONDITIONAL), // Not used
        WAVE(                           "Wave",                 STRING_CELL,    TEXT_FORMAT,            NONE_CONDITIONAL), // Not used
        SEED(                           "Seed",                 STRING_CELL,    TEXT_FORMAT,            NONE_CONDITIONAL), // Not used
        ESTIMATED_TIME(                 "EstTime",              STRING_CELL,    TEXT_FORMAT,            NONE_CONDITIONAL), // Not used
        FINISH_RESULT(                  "Finish_Result",        STRING_CELL,    NONE_FORMAT,            NONE_CONDITIONAL), // For headers.txt, String or numeric?
        RANK_OVERALL(                   "Rank_Overall",         NUMERIC_CELL,   NONE_FORMAT,            NONE_CONDITIONAL), // For headers.txt
        RANK_GENDER(                    "Rank_Gender",          NUMERIC_CELL,   NONE_FORMAT,            NONE_CONDITIONAL), // For headers.txt
        DIVISION_NAME(                  "Division_Name",        STRING_CELL,    NONE_FORMAT,            NONE_CONDITIONAL), // For headers.txt
        MERCHANDISE(                    "Merchandise",          STRING_CELL,    TEXT_FORMAT,            NONE_CONDITIONAL), // Not used
        QUANTITY(                       "Qty",                  STRING_CELL,    TEXT_FORMAT,            NONE_CONDITIONAL), // Not used
        SIZE(                           "Size",                 STRING_CELL,    TEXT_FORMAT,            NONE_CONDITIONAL), // Not used
        COMMENT(                        "Comment",              STRING_CELL,    TEXT_FORMAT,            NONE_CONDITIONAL), // Not used
        ATHLETE_2_FIRST_NAME(           "Athlete2_First_Name",  STRING_CELL,    TEXT_FORMAT,            PROPER_CONDITIONAL), // Not used
        ATHLETE_2_LAST_NAME(            "Athlete2_Last_Name",   STRING_CELL,    TEXT_FORMAT,            PROPER_CONDITIONAL), // Not used
        ATHLETE_3_FIRST_NAME(           "Athlete3_First_Name",  STRING_CELL,    TEXT_FORMAT,            PROPER_CONDITIONAL), // Not used
        ATHLETE_3_LAST_NAME(            "Athlete3_Last_Name",   STRING_CELL,    TEXT_FORMAT,            PROPER_CONDITIONAL); // Not used

        private final String title;
        private final String cellType;
        private final String cellFormat;
        private final String conditionalCellFormat;

        DefaultHeaderTypes(String title, String cellType, String cellFormat, String conditionalCellFormat) {

                this.title = title;
                this.cellType = cellType;
                this.cellFormat = cellFormat;
                this.conditionalCellFormat = conditionalCellFormat;

        }

        public String[] getSaveData() {
                return new String[] {title, cellType, cellFormat, conditionalCellFormat};
        }
}
