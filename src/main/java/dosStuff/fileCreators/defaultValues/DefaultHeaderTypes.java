package dosStuff.fileCreators.defaultValues;

import org.apache.poi.ss.usermodel.*;

/**
 * Enum representation of each default header.
 * @author Remus Courtenay - rcou199
 * @since 16/11/2020
 */
public enum DefaultHeaderTypes implements DefaultSaveFileValues {
        FIRST_NAME(                     "First Name", "Remus",             DefaultCellFormatTypes.TEXT,            DefaultConditionalCellFormatTypes.PROPER),
        LAST_NAME(                      "Last Name", "Courtenay",               DefaultCellFormatTypes.TEXT,            DefaultConditionalCellFormatTypes.PROPER),
        ADDRESS_1(                      "Address1",               DefaultCellFormatTypes.ADDRESS,         DefaultConditionalCellFormatTypes.NONE), // Not used
        ADDRESS_2(                      "Address2",               DefaultCellFormatTypes.ADDRESS,         DefaultConditionalCellFormatTypes.NONE), // Not used
        ADDRESS_3(                      "Address3",               DefaultCellFormatTypes.ADDRESS,         DefaultConditionalCellFormatTypes.NONE), // Not used
        ADDRESS_4(                      "Address4", "Nelson",              DefaultCellFormatTypes.ADDRESS,         DefaultConditionalCellFormatTypes.PROPER), // City
        CITY(                           "City",                   DefaultCellFormatTypes.NONE,            DefaultConditionalCellFormatTypes.NONE), // For headers.txt
        POST_CODE(                      "Post Code", "7020",            DefaultCellFormatTypes.POST_CODE,       DefaultConditionalCellFormatTypes.VALID_POSTCODE), // Not used
        EMAIL_ADDRESS(                  "Email", "remuscourtenay@gmail.com",                  DefaultCellFormatTypes.EMAIL,           DefaultConditionalCellFormatTypes.VALID_EMAIL),
        PHONE_NUMBER(                   "PhoneNo",               DefaultCellFormatTypes.PHONE_NUMBER,    DefaultConditionalCellFormatTypes.NONE), // Not used
        PHONE_NUMBER_2(                 "PhoneNo2",              DefaultCellFormatTypes.PHONE_NUMBER,    DefaultConditionalCellFormatTypes.NONE), // Not used
        GENDER(                         "Gender", "MALE",                DefaultCellFormatTypes.GENDER,          DefaultConditionalCellFormatTypes.UPPERCASE),
        SUPPORT_PERSON(                 "Info1", "Ian Courtenay",                  DefaultCellFormatTypes.TEXT,            DefaultConditionalCellFormatTypes.PROPER), // Support person
        CELLPHONE_NUMBER(               "Info2", "0211893736",                DefaultCellFormatTypes.PHONE_NUMBER,    DefaultConditionalCellFormatTypes.VALID_PHONE), // Cellphone number
        REGISTRATION_ID(                "Info3", "898217506",                 DefaultCellFormatTypes.ID_NUMBER,       DefaultConditionalCellFormatTypes.VALID_REGISTRATION_ID), // Registration ID
        HEADERS_REGISTRATION_ID(        "Registration ID",       DefaultCellFormatTypes.NONE,            DefaultConditionalCellFormatTypes.NONE), // For headers.txt
        REGISTRATION_TIME(              "Info4", "26/06/2020  9:08:19 am",                 DefaultCellFormatTypes.TIME,            DefaultConditionalCellFormatTypes.NONE), // Registration Time, maybe put check?
        DISTANCE_UNIT(                  "Info5", "KM",                  DefaultCellFormatTypes.DISTANCE,        DefaultConditionalCellFormatTypes.DISTANCE_UNIT), // KM or MILES?
        DATE_OF_BIRTH(                  "DOB", "05/02/1999",                  DefaultCellFormatTypes.DATE,            DefaultConditionalCellFormatTypes.NONE), // Date of birth, maybe put check?
        AGE(                            "Age",                   DefaultCellFormatTypes.NONE,            DefaultConditionalCellFormatTypes.NONE), // Not used
        TEAM(                           "Team",                   DefaultCellFormatTypes.TEXT,            DefaultConditionalCellFormatTypes.NONE), // Not used
        REGISTRATION_LICENSE_NUMBER(    "Reg/Licence No",        DefaultCellFormatTypes.NONE,            DefaultConditionalCellFormatTypes.NONE), // Not used
        UCI_NUMBER(                     "UCI No",                DefaultCellFormatTypes.NONE,            DefaultConditionalCellFormatTypes.NONE), // Not used
        RELAY_TEAM(                     "Relay Team",             DefaultCellFormatTypes.TEXT,            DefaultConditionalCellFormatTypes.NONE), // Not used
        RACE_NUMBER(                    "Race No", "250",              DefaultCellFormatTypes.ID_NUMBER,       DefaultConditionalCellFormatTypes.VALID_RACE_NUMBER), // Race number
        HEADERS_RACE_NUMBER(            "Race Number",           DefaultCellFormatTypes.NONE,            DefaultConditionalCellFormatTypes.NONE), // For headers.txt
        TAG_NUMBER(                     "Tag No", "058001ea67df",                DefaultCellFormatTypes.TAG_NUMBER,      DefaultConditionalCellFormatTypes.VALID_TAG_NUMBER),
        EVENT(                          "Event", "2.5km Run",                  DefaultCellFormatTypes.EVENT,           DefaultConditionalCellFormatTypes.NONE), // Name of sub-event, maybe put check?
        DIVISION(                       "Division",               DefaultCellFormatTypes.TEXT,            DefaultConditionalCellFormatTypes.NONE), // Not used
        WAVE(                           "Wave",                   DefaultCellFormatTypes.TEXT,            DefaultConditionalCellFormatTypes.NONE), // Not used
        SEED(                           "Seed",                   DefaultCellFormatTypes.TEXT,            DefaultConditionalCellFormatTypes.NONE), // Not used
        ESTIMATED_TIME(                 "EstTime",                DefaultCellFormatTypes.TEXT,            DefaultConditionalCellFormatTypes.NONE), // Not used
        FINISH_RESULT(                  "Finish Result",          DefaultCellFormatTypes.NONE,            DefaultConditionalCellFormatTypes.NONE), // For headers.txt, String or numeric?
        RANK_OVERALL(                   "Rank Overall",          DefaultCellFormatTypes.NONE,            DefaultConditionalCellFormatTypes.NONE), // For headers.txt
        RANK_GENDER(                    "Rank Gender",           DefaultCellFormatTypes.NONE,            DefaultConditionalCellFormatTypes.NONE), // For headers.txt
        RANK_DIVISION(                  "Rank Division",        DefaultCellFormatTypes.NONE,              DefaultConditionalCellFormatTypes.NONE), // For Active Layout
        DIVISION_NAME(                  "Division Name",          DefaultCellFormatTypes.NONE,            DefaultConditionalCellFormatTypes.NONE), // For headers.txt
        MERCHANDISE(                    "Merchandise",            DefaultCellFormatTypes.TEXT,            DefaultConditionalCellFormatTypes.NONE), // Not used
        QUANTITY(                       "Qty",                    DefaultCellFormatTypes.TEXT,            DefaultConditionalCellFormatTypes.NONE), // Not used
        SIZE(                           "Size",                   DefaultCellFormatTypes.TEXT,            DefaultConditionalCellFormatTypes.NONE), // Not used
        COMMENT(                        "Comment",                DefaultCellFormatTypes.TEXT,            DefaultConditionalCellFormatTypes.NONE), // Not used
        ATHLETE_2_FIRST_NAME(           "Athlete2 First Name",    DefaultCellFormatTypes.TEXT,            DefaultConditionalCellFormatTypes.PROPER), // Not used
        ATHLETE_2_LAST_NAME(            "Athlete2 Last Name",     DefaultCellFormatTypes.TEXT,            DefaultConditionalCellFormatTypes.PROPER), // Not used
        ATHLETE_3_FIRST_NAME(           "Athlete3 First Name",    DefaultCellFormatTypes.TEXT,            DefaultConditionalCellFormatTypes.PROPER), // Not used
        ATHLETE_3_LAST_NAME(            "Athlete3 Last Name",     DefaultCellFormatTypes.TEXT,            DefaultConditionalCellFormatTypes.PROPER); // Not useString name;

        private final String name;
        private final String exampleValue;
        private final DefaultCellFormatTypes cellFormat;
        private final DefaultConditionalCellFormatTypes conditionalCellFormat;

        DefaultHeaderTypes(String name, String exampleValue, DefaultCellFormatTypes cellFormat, DefaultConditionalCellFormatTypes conditionalCellFormat) {
                this.name = name;
                this.exampleValue = exampleValue;
                this.cellFormat = cellFormat;
                this.conditionalCellFormat = conditionalCellFormat;
        }

        DefaultHeaderTypes(String name, DefaultCellFormatTypes cellFormat, DefaultConditionalCellFormatTypes conditionalCellFormat) {
                this(name, DEFAULT_EXAMPLE_VALUE, cellFormat, conditionalCellFormat);
        }

        DefaultHeaderTypes(DefaultCellFormatTypes cellFormat, DefaultConditionalCellFormatTypes conditionalCellFormat) {
                this(DEFAULT_NAME, cellFormat, conditionalCellFormat);
        }

        @Override
        public void setupSaveDataNameCell(Cell nameCell) {
                nameCell.setCellValue(this.name);
        }

        public void setupSaveDataValueCells(Cell formatNameCell, Cell conditionalFormatNameCell, Cell valueCell, CellStyle blankStyle, SheetConditionalFormatting sheetConditionalFormatting) {
                cellFormat.setupSaveDataNameCell(formatNameCell);
                cellFormat.setupSaveDataValueCell(valueCell, blankStyle, this.exampleValue);

                conditionalCellFormat.setupSaveDataNameCell(conditionalFormatNameCell);
                conditionalCellFormat.setupSaveDataCellConditionalFormatting(valueCell, sheetConditionalFormatting);
        }
}
