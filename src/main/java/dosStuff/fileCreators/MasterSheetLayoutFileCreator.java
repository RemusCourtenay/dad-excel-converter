package dosStuff.fileCreators;

import dosStuff.FileIOThreadManager;

/**
 * Extension of abstract FileCreator class that specifically creates the master sheet layout file. Methods only change
 * file if the file does not already exist.
 *
 * @author Remus Courtenay - rcou199
 * @since 13/11/2020
 */
public class MasterSheetLayoutFileCreator extends FileCreator {

    // Top level comment in file explaining how to edit
//    private static final String MASTER_SHEET_LAYOUT_FILE_COMMENT =
//            "Defines the layout of the generated Master sheet. Add new columns or edit existing following the format: (Header Text),(Cell Type),(Column Format),(Column Conditional Formatting) with no spaces. Valid Cell types are: "
//                    + STRING_CELL + ", "
//                    + NUMERIC_CELL + ", "
//                    + BOOLEAN_CELL + ", "
//                    + FORMULA_CELL + " and "
//                    + BLANK_CELL + ". "
//                    + "Valid Cell Formatting and Conditional Cell Formatting values can be found in their respective files. "
//                    + "If changes are made to this file, you will need to restart the program for it to take effect.";

    // List of default layout values, gets used if the file does not already exist
//    private static final String[][] MASTER_SHEET_LAYOUT_DEFAULT_HEADERS = {
//            DefaultHeaderTypes.FIRST_NAME                   .getSaveData(),
//            DefaultHeaderTypes.LAST_NAME                    .getSaveData(),
//            DefaultHeaderTypes.ADDRESS_1                    .getSaveData(), // Not used
//            DefaultHeaderTypes.ADDRESS_2                    .getSaveData(), // Not used
//            DefaultHeaderTypes.ADDRESS_3                    .getSaveData(), // Not used
//            DefaultHeaderTypes.ADDRESS_4                    .getSaveData(), // City
//            DefaultHeaderTypes.POST_CODE                    .getSaveData(), // Not used
//            DefaultHeaderTypes.EMAIL_ADDRESS                .getSaveData(),
//            DefaultHeaderTypes.PHONE_NUMBER                 .getSaveData(), // Not used
//            DefaultHeaderTypes.PHONE_NUMBER_2               .getSaveData(), // Not used
//            DefaultHeaderTypes.GENDER                       .getSaveData(), // No 'Other' option available
//            DefaultHeaderTypes.SUPPORT_PERSON               .getSaveData(), // Support person
//            DefaultHeaderTypes.CELLPHONE_NUMBER             .getSaveData(), // Cellphone number
//            DefaultHeaderTypes.REGISTRATION_ID              .getSaveData(), // Registration ID
//            DefaultHeaderTypes.REGISTRATION_TIME            .getSaveData(), // Registration Time, maybe put check?
//            DefaultHeaderTypes.DISTANCE_UNIT                .getSaveData(), // KM or MILES?
//            DefaultHeaderTypes.DATE_OF_BIRTH                .getSaveData(), // Date of birth, maybe put check?
//            DefaultHeaderTypes.AGE                          .getSaveData(), // Not used
//            DefaultHeaderTypes.TEAM                         .getSaveData(), // Not used
//            DefaultHeaderTypes.REGISTRATION_LICENSE_NUMBER  .getSaveData(), // Not used
//            DefaultHeaderTypes.UCI_NUMBER                   .getSaveData(), // Not used
//            DefaultHeaderTypes.RELAY_TEAM                   .getSaveData(), // Not used
//            DefaultHeaderTypes.RACE_NUMBER                  .getSaveData(), // Race number
//            DefaultHeaderTypes.TAG_NUMBER                   .getSaveData(),
//            DefaultHeaderTypes.EVENT                        .getSaveData(), // Name of sub-event, maybe put check?
//            DefaultHeaderTypes.DIVISION                     .getSaveData(), // Not used
//            DefaultHeaderTypes.WAVE                         .getSaveData(), // Not used
//            DefaultHeaderTypes.SEED                         .getSaveData(), // Not used
//            DefaultHeaderTypes.ESTIMATED_TIME               .getSaveData(), // Not used
//            DefaultHeaderTypes.MERCHANDISE                  .getSaveData(), // Not used
//            DefaultHeaderTypes.QUANTITY                     .getSaveData(), // Not used
//            DefaultHeaderTypes.SIZE                         .getSaveData(), // Not used
//            DefaultHeaderTypes.COMMENT                      .getSaveData(), // Not used
//            DefaultHeaderTypes.ATHLETE_2_FIRST_NAME         .getSaveData(), // Not used
//            DefaultHeaderTypes.ATHLETE_2_LAST_NAME          .getSaveData(), // Not used
//            DefaultHeaderTypes.ATHLETE_3_FIRST_NAME         .getSaveData(), // Not used
//            DefaultHeaderTypes.ATHLETE_3_LAST_NAME          .getSaveData()  // Not used
//    };

    @Override
    public void createDefaultFile(String fileAddress) {
        // writeToFileWithComment(MASTER_SHEET_LAYOUT_FILE_COMMENT, MASTER_SHEET_LAYOUT_DEFAULT_HEADERS, fileAddress);
    }
}


