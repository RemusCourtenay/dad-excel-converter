package dosStuff.fileCreators.defaultValues;


import org.apache.poi.ss.usermodel.Cell;

public enum DefaultActiveLayoutHeaders implements DefaultSpecificLayoutValues{

    REGISTRATION_ID(DefaultHeaderTypes.REGISTRATION_ID, "Registration ID"),
    RACE_NUMBER(DefaultHeaderTypes.RACE_NUMBER, "Race Number"),
    LAST_NAME(DefaultHeaderTypes.LAST_NAME, "Last Name"),
    FIRST_NAME(DefaultHeaderTypes.FIRST_NAME, " First Name"),
    GENDER(DefaultHeaderTypes.GENDER, "Gender"),
    AGE(DefaultHeaderTypes.AGE, "Age"),
    FINISH_RESULT(DefaultHeaderTypes.FINISH_RESULT, "Finish Result"),
    EVENT(DefaultHeaderTypes.EVENT, "Event"),
    RANK_OVERALL(DefaultHeaderTypes.RANK_OVERALL, "Rank Overall"),
    RANK_GENDER(DefaultHeaderTypes.RANK_GENDER, "Rank Gender"),
    DIVISION_NAME(DefaultHeaderTypes.DIVISION_NAME, "Division Name"),
    RANK_DIVISION(DefaultHeaderTypes.RANK_DIVISION, "Rank Division"),
    DISTANCE_UNIT(DefaultHeaderTypes.DISTANCE_UNIT, "Distance Unit");



    private final DefaultHeaderTypes headerType;
    private final String headerName;

    DefaultActiveLayoutHeaders(DefaultHeaderTypes headerType, String headerName) {
        this.headerType = headerType;
        this.headerName = headerName;
    }


    @Override
    public void setupSaveDataNameCell(Cell nameCell) {
        this.headerType.setupSaveDataNameCell(nameCell);
    }

    @Override
    public void setupSaveDataConvertedNameCell(Cell activeNameCell) {
        activeNameCell.setCellValue(headerName);
    }
}
