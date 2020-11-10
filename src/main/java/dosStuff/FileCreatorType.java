package dosStuff;

/**
 * @author Remus Courtenay - rcou199
 * @since 11/11/2020
 */
public enum FileCreatorType {
    MAIN_FILE_CREATOR(MainFileCreator.class),
    HEADER_CREATOR(HeaderCreator.class),
    SETTINGS_CREATOR(SettingsCreator.class);

    private final Class<? extends FileCreator> fileCreatorClass;

    FileCreatorType(Class<? extends FileCreator> fileCreatorClass) {
        this.fileCreatorClass = fileCreatorClass;
    }

    public Class<? extends FileCreator> getFileCreatorClass() {
        return fileCreatorClass;
    }
}
