package dosStuff.fileCreators.defaultValues;

import org.apache.poi.ss.usermodel.Cell;

public enum DefaultSportscoreLayoutHeaders implements DefaultSaveFileValues {

    FIRST_NAME(DefaultHeaderTypes.FIRST_NAME),
    LAST_NAME(DefaultHeaderTypes.LAST_NAME),
    CITY(DefaultHeaderTypes.CITY),
    EMAIL_ADDRESS(DefaultHeaderTypes.EMAIL_ADDRESS),
    GENDER(DefaultHeaderTypes.GENDER),
    EMERGENCY_CONTACT(DefaultHeaderTypes.SUPPORT_PERSON), // TODO... Fix this
    EMERGENCY_CONTACT_PHONE(DefaultHeaderTypes.CELLPHONE_NUMBER),
    REGISTRATION_ID(DefaultHeaderTypes.REGISTRATION_ID),
    REGISTRATION_TIME(DefaultHeaderTypes.REGISTRATION_TIME),
    WAVE(DefaultHeaderTypes.WAVE),
    DATE_OF_BIRTH(DefaultHeaderTypes.DATE_OF_BIRTH),
    BIB_NUMBER(DefaultHeaderTypes.RACE_NUMBER),
    CHIP_NUMBER(DefaultHeaderTypes.TAG_NUMBER),
    REGISTRATION_CATEGORY(DefaultHeaderTypes.DIVISION_NAME),
    NAME_ON_BIB(DefaultHeaderTypes.FIRST_NAME);



    private final DefaultHeaderTypes headerType;

    DefaultSportscoreLayoutHeaders(DefaultHeaderTypes headerType) {
        this.headerType = headerType;
    }

    @Override
    public void setupSaveDataNameCell(Cell nameCell) {
        this.headerType.setupSaveDataNameCell(nameCell);
    }
}
