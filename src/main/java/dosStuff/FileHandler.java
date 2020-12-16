package dosStuff;

import dosStuff.fileCreators.*;
import dosStuff.fileReaders.*;

import javax.xml.crypto.Data;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
    protected static final String HEADERS_FILE_NAME = "headers.xlsx";
    protected static final String MASTER_SHEET_LAYOUT_FILE_NAME = "master-layout.xlsx";
    protected static final String CELL_FORMATS_FILE_NAME = "cell-formats.xlsx";
    protected static final String CONDITIONAL_CELL_FORMATS_FILE_NAME = "conditional-cell-formats.xlsx";
    protected static final String ACTIVE_SHEET_LAYOUT_FILE_NAME = "active-sheet-layout.xlsx";
    protected static final String SPORTSCORE_SHEET_LAYOUT_FILE_NAME = "sportscore-sheet-layout.xlsx";

    private final Map<DataFileType, FileIOThreadManager> dataFiles;

    public FileHandler() {
        this.dataFiles = runFileSetup();
    }

    public FileIOThreadManager getFileManager(DataFileType dataFileType) {
        return dataFiles.get(dataFileType);
    }



    private Map<DataFileType, FileIOThreadManager> runFileSetup() {

        makeMainDataFolder();
        FileIOThreadManager settingsFileIOManager = new FileIOThreadManager(MAIN_DATA_FOLDER + SETTINGS_FILE_NAME, new SettingsFileCreator());
        // FileIOThreadManager masterSheetLayoutFileIOManager = new FileIOThreadManager(MAIN_DATA_FOLDER + MASTER_SHEET_LAYOUT_FILE_NAME, new MasterLayoutDataFileReader(), new MasterSheetLayoutFileCreator());
        FileIOThreadManager cellFormatsFileIOManager = new FileIOThreadManager(MAIN_DATA_FOLDER + CELL_FORMATS_FILE_NAME, new CellFormatsFileCreator());
        FileIOThreadManager conditionalCellFormatsFileIOManager = new FileIOThreadManager(MAIN_DATA_FOLDER + CONDITIONAL_CELL_FORMATS_FILE_NAME, new ConditionalCellFormatsFileCreator());
        FileIOThreadManager headerFileIOManager = new FileIOThreadManager(MAIN_DATA_FOLDER + HEADERS_FILE_NAME, new HeadersFileCreator());
        FileIOThreadManager activeSheetLayoutFileIOManager = new FileIOThreadManager(MAIN_DATA_FOLDER + ACTIVE_SHEET_LAYOUT_FILE_NAME, new SpecificLayoutSaveFileCreator<DefaultActiveLayoutHeaders>(DefaultActiveLayoutHeaders.class));
        FileIOThreadManager sportscoreSheetLayoutFileIOManager = new FileIOThreadManager(MAIN_DATA_FOLDER + SPORTSCORE_SHEET_LAYOUT_FILE_NAME, new SpecificLayoutSaveFileCreator<DefaultSportscoreLayoutHeaders>(DefaultSportscoreLayoutHeaders.class));

        Map<DataFileType, FileIOThreadManager> fileManagers = new HashMap<>(DataFileType.getNumOfFiles());

        fileManagers.put(DataFileType.SETTINGS, settingsFileIOManager);
//        fileManagers.put(DataFileType.MASTER_SHEET_LAYOUT, masterSheetLayoutFileIOManager);
        fileManagers.put(DataFileType.CELL_FORMATS, cellFormatsFileIOManager);
        fileManagers.put(DataFileType.CONDITIONAL_CELL_FORMATS, conditionalCellFormatsFileIOManager);
        fileManagers.put(DataFileType.HEADERS_SHEET_LAYOUT, headerFileIOManager);
        fileManagers.put(DataFileType.ACTIVE_SHEET_LAYOUT, activeSheetLayoutFileIOManager);
        fileManagers.put(DataFileType.SPORTSCORE_SHEET_LAYOUT, sportscoreSheetLayoutFileIOManager);

        ExecutorService setupExecutor = Executors.newCachedThreadPool();
        setupFiles(setupExecutor, fileManagers);
        setupExecutor.shutdown();

        try {
            if(!setupExecutor.awaitTermination(30, TimeUnit.SECONDS)) {
              setupExecutor.shutdownNow();
              throw new RuntimeException("File setup timed out");
            }
        } catch(InterruptedException exception) {
            exception.printStackTrace();
            throw new RuntimeException("File setup interrupted");
        }

        return fileManagers;
    }

    private void setupFiles(ExecutorService executorService, Map<DataFileType, FileIOThreadManager> fileManagers) {
        for (FileIOThreadManager fileManager: fileManagers.values()) {
            executorService.submit(fileSetupAsTask(fileManager));
        }

    }

    private Runnable fileSetupAsTask(FileIOThreadManager fileIOThreadManager) {
        return new Runnable() {
            @Override
            public void run() {
                fileIOThreadManager.setupFile();
            }
        };
    }

    private void printData(List<String[]> fileOutput) {
        for (String[] dataLine: fileOutput) {
            for (String data: dataLine) {
                System.out.print(data + " ");
            }
            System.out.println("");
        }
    }

    private void makeMainDataFolder() {
        DOSCommandHandler.runProcess(
                "Error Attempting to initialise main data folder: " + MAIN_DATA_FOLDER,
                DOSCommandHandler.makeCommandList("mkdir", MAIN_DATA_FOLDER)
        );
    }

}
