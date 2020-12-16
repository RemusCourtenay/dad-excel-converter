package dosStuff.fileCreators;


import org.apache.poi.ss.usermodel.Cell;

public enum DefaultActiveLayoutHeaders implements DefaultSaveFileValues{

    REGISTRATION_ID(DefaultHeaderTypes.REGISTRATION_ID),
    RACE_NUMBER(DefaultHeaderTypes.RACE_NUMBER),
    LAST_NAME(DefaultHeaderTypes.LAST_NAME),
    FIRST_NAME(DefaultHeaderTypes.FIRST_NAME),
    GENDER(DefaultHeaderTypes.GENDER),
    AGE(DefaultHeaderTypes.AGE),
    FINISH_RESULT(DefaultHeaderTypes.FINISH_RESULT),
    EVENT(DefaultHeaderTypes.EVENT),
    RANK_OVERALL(DefaultHeaderTypes.RANK_OVERALL),
    RANK_GENDER(DefaultHeaderTypes.RANK_GENDER),
    DIVISION_NAME(DefaultHeaderTypes.DIVISION_NAME),
    RANK_DIVISION(DefaultHeaderTypes.RANK_DIVISION),
    DISTANCE_UNIT(DefaultHeaderTypes.DISTANCE_UNIT),
    CITY(DefaultHeaderTypes.CITY);



    private final DefaultHeaderTypes headerType;

    DefaultActiveLayoutHeaders(DefaultHeaderTypes headerType) {
        this.headerType = headerType;
    }


    @Override
    public void setupSaveDataNameCell(Cell nameCell) {
        this.headerType.setupSaveDataNameCell(nameCell);
    }
}
