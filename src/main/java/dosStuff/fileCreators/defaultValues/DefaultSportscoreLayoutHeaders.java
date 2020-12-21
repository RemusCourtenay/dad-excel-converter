package dosStuff.fileCreators.defaultValues;

import org.apache.poi.ss.usermodel.Cell;

public enum DefaultSportscoreLayoutHeaders implements DefaultSpecificLayoutValues {

    FIRST_NAME(DefaultHeaderTypes.FIRST_NAME, "First Name"),
    LAST_NAME(DefaultHeaderTypes.LAST_NAME, "Last Name"),
    CITY(DefaultHeaderTypes.CITY, "City"),
    EMAIL_ADDRESS(DefaultHeaderTypes.EMAIL_ADDRESS, "Email Address"),
    GENDER(DefaultHeaderTypes.GENDER, "Gender"),
    EMERGENCY_CONTACT(DefaultHeaderTypes.SUPPORT_PERSON, "Emergency Contact Name"), // TODO... Fix this
    EMERGENCY_CONTACT_PHONE(DefaultHeaderTypes.CELLPHONE_NUMBER, "Emergency Contact Phone"),
    REGISTRATION_ID(DefaultHeaderTypes.REGISTRATION_ID, "Registration ID"),
    REGISTRATION_TIME(DefaultHeaderTypes.REGISTRATION_TIME, "Registration Time"),
    WAVE(DefaultHeaderTypes.WAVE, "Wave"),
    DATE_OF_BIRTH(DefaultHeaderTypes.DATE_OF_BIRTH, "Date Of Birth"),
    BIB_NUMBER(DefaultHeaderTypes.RACE_NUMBER, "Bib Number"),
    CHIP_NUMBER(DefaultHeaderTypes.TAG_NUMBER, "Chip Number"),
    REGISTRATION_CATEGORY(DefaultHeaderTypes.DIVISION_NAME, "Registration Category"),
    NAME_ON_BIB(DefaultHeaderTypes.FIRST_NAME, "Name On Bib Number");



    private final DefaultHeaderTypes headerType;
    private final String headerName;

    DefaultSportscoreLayoutHeaders(DefaultHeaderTypes headerType, String headerName) {
        this.headerType = headerType;
        this.headerName = headerName;
    }

    @Override
    public void setupSaveDataNameCell(Cell nameCell) {
        this.headerType.setupSaveDataNameCell(nameCell);
    }


    @Override
    public void setupSaveDataConvertedNameCell(Cell saveDataCell) {
        saveDataCell.setCellValue(headerName);
    }
}
