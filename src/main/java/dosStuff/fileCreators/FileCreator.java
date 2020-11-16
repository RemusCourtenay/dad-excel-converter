package dosStuff.fileCreators;

import org.apache.poi.ss.usermodel.CellType;

/**
 * Abstract class that contains methods shared by all classes that create files. Abstract method runSetup allows for the
 * initialisation of all FileCreator extensions via the FileCreatorType enum.
 * @author Remus Courtenay - rcou199
 * @since 11/11/2020
 */
public interface FileCreator {

    // Kinda cursed ngl

    String STRING_CELL                       = CellType.STRING.name();
    String NUMERIC_CELL                      = CellType.NUMERIC.name();
    String BOOLEAN_CELL                      = CellType.BOOLEAN.name();
    String FORMULA_CELL                      = CellType.FORMULA.name();
    String BLANK_CELL                        = CellType.BLANK.name();

    String NONE_FORMAT                       = DefaultCellFormatTypes.NONE.getName();
    String TEXT_FORMAT                       = DefaultCellFormatTypes.TEXT.getName();
    String ADDRESS_FORMAT                    = DefaultCellFormatTypes.ADDRESS.getName();
    String POST_CODE_FORMAT                  = DefaultCellFormatTypes.POST_CODE.getName();
    String EMAIL_FORMAT                      = DefaultCellFormatTypes.EMAIL.getName();
    String PHONE_NUMBER_FORMAT               = DefaultCellFormatTypes.PHONE_NUMBER.getName();
    String GENDER_FORMAT                     = DefaultCellFormatTypes.GENDER.getName();
    String ID_NUMBER_FORMAT                  = DefaultCellFormatTypes.ID_NUMBER.getName();
    String TAG_NUMBER_FORMAT                 = DefaultCellFormatTypes.TAG_NUMBER.getName();
    String TIME_FORMAT                       = DefaultCellFormatTypes.TIME.getName();
    String DISTANCE_FORMAT                   = DefaultCellFormatTypes.DISTANCE.getName();
    String DATE_FORMAT                       = DefaultCellFormatTypes.DATE.getName();
    String EVENT_FORMAT                      = DefaultCellFormatTypes.EVENT.getName();

    String NONE_CONDITIONAL                  = DefaultConditionalCellFormatTypes.NONE.getName();
    String PROPER_CONDITIONAL                = DefaultConditionalCellFormatTypes.PROPER.getName();
    String UPPERCASE_CONDITIONAL             = DefaultConditionalCellFormatTypes.UPPERCASE.getName();
    String DISTANCE_UNIT_CONDITIONAL         = DefaultConditionalCellFormatTypes.DISTANCE_UNIT.getName();
    String VALID_POSTCODE_CONDITIONAL        = DefaultConditionalCellFormatTypes.VALID_POSTCODE.getName();
    String VALID_EMAIL_CONDITIONAL           = DefaultConditionalCellFormatTypes.VALID_EMAIL.getName();
    String VALID_PHONE_CONDITIONAL           = DefaultConditionalCellFormatTypes.VALID_PHONE.getName();
    String VALID_REGISTRATION_ID_CONDITIONAL = DefaultConditionalCellFormatTypes.VALID_REGISTRATION_ID.getName();
    String VALID_RACE_NUMBER_CONDITIONAL     = DefaultConditionalCellFormatTypes.VALID_RACE_NUMBER.getName();
    String VALID_TAG_NUMBER_CONDITIONAL      = DefaultConditionalCellFormatTypes.VALID_TAG_NUMBER.getName();

}
