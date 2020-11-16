package dosStuff;

import dosStuff.fileCreators.*;

/**
 * Abstract class that represents all classes that interact with the program files. Stores file locations/names and
 * methods used by all file handling classes.
 * @author Remus Courtenay - rcou199
 * @since 9/11/2020
 */
public class FileHandler {

    // File/folder names
    protected static final String MAIN_DATA_FOLDER = "data\\";
    protected static final String SETTINGS_FILE_NAME = "settings.txt";
    protected static final String HEADERS_FILE_NAME = "headers.txt";
    protected static final String MASTER_SHEET_LAYOUT_FILE_NAME = "master-layout.txt";
    protected static final String CELL_FORMATS_FILE_NAME = "cell-formats.txt";
    protected static final String CONDITIONAL_CELL_FORMATS_FILE_NAME = "conditional-cell-formats.txt";

    public FileHandler() {
        runFileSetup();
    }

    private void runFileSetup() {

        makeMainDataFolder();

        new SettingsFileCreator(new FileIOThreadManager(MAIN_DATA_FOLDER + SETTINGS_FILE_NAME));
        new HeadersFileCreator(new FileIOThreadManager(MAIN_DATA_FOLDER + HEADERS_FILE_NAME));
        new MasterSheetLayoutFileCreator(new FileIOThreadManager(MAIN_DATA_FOLDER + MASTER_SHEET_LAYOUT_FILE_NAME));
        new CellFormatsFileCreator(new FileIOThreadManager(MAIN_DATA_FOLDER + CELL_FORMATS_FILE_NAME));
        new ConditionalCellFormatsFileCreator(new FileIOThreadManager(MAIN_DATA_FOLDER + CONDITIONAL_CELL_FORMATS_FILE_NAME));

    }

    private void makeMainDataFolder() {
        DOSCommandHandler.runProcess(
                "Error Attempting to initialise main data folder: " + MAIN_DATA_FOLDER,
                DOSCommandHandler.makeCommandList("mkdir", MAIN_DATA_FOLDER)
        );
    }

}
