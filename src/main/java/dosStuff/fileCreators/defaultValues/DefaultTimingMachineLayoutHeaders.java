package dosStuff.fileCreators.defaultValues;

import org.apache.poi.ss.usermodel.Cell;

public enum DefaultTimingMachineLayoutHeaders implements DefaultSpecificLayoutValues {
    REGISTRATION_ID(DefaultHeaderTypes.REGISTRATION_ID, "Registration ID"),
    BIB_NUMBER(DefaultHeaderTypes.TAG_NUMBER, "Bib Number");

    private final DefaultHeaderTypes headerType;
    private final String headerName;

    DefaultTimingMachineLayoutHeaders(DefaultHeaderTypes headerType, String headerName) {
        this.headerType = headerType;
        this.headerName = headerName;
    }

    @Override
    public void setupSaveDataNameCell(Cell nameCell) {
        headerType.setupSaveDataNameCell(nameCell);
    }

    @Override
    public void setupSaveDataConvertedNameCell(Cell saveDataCell) {
        saveDataCell.setCellValue(headerName);
    }
}
