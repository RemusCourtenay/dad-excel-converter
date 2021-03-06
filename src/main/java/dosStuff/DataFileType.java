package dosStuff;

/**
 * Enum representing all different data files created by the system
 */

public enum DataFileType {
    HEADERS_SHEET_LAYOUT,
    CELL_FORMATS,
    CONDITIONAL_CELL_FORMATS,
    SETTINGS,
    ACTIVE_SHEET_LAYOUT,
    SPORTSCORE_SHEET_LAYOUT,
    TIMING_MACHINE_SHEET_LAYOUT;

    private static final int numOfFiles = 7;

    public static int getNumOfFiles() {
        return numOfFiles;
    }
}
