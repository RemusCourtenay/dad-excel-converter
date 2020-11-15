package dosStuff.fileCreators;

/**
 * Enum with values that represent all extensions of the FileCreator class. Used to initialise all the FileCreator
 * extensions without having to explicitly call them. This functionality can be done via the Reflections search method
 * but this is faster.
 * @author Remus Courtenay - rcou199
 * @since 11/11/2020
 */
public enum FileCreatorType {
    // All extensions of the abstract FileCreator class. Values MUST BE placed in the order they need to be initialised in
    MAIN_FILE_CREATOR(MainFileCreator.class), // Must go first
    SETTINGS_CREATOR(SettingsFileCreator.class),
    HEADER_CREATOR(HeaderFileCreator.class),
    MASTER_SHEET_LAYOUT_CREATOR(MasterSheetLayoutFileCreator.class),
    CELL_FORMATS_FILE_CREATOR(CellFormatsFileCreator.class),
    CONDITIONAL_CELL_FORMATS_FILE_CREATOR(ConditionalCellFormatsFileCreator.class);


    // Storing class objects to give to the automated constructor
    private final Class<? extends FileCreator> fileCreatorClass;

    FileCreatorType(Class<? extends FileCreator> fileCreatorClass) {
        this.fileCreatorClass = fileCreatorClass;
    }

    /**
     * Basic getter method.
     * @return : The class object that the enum value represents.
     */
    public Class<? extends FileCreator> getFileCreatorClass() {
        return fileCreatorClass;
    }
}
