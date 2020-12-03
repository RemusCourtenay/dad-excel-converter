package dosStuff;

import dosStuff.fileCreators.*;
import dosStuff.fileReaders.*;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
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
    protected static final String HEADERS_FILE_NAME = "headers.txt";
    protected static final String MASTER_SHEET_LAYOUT_FILE_NAME = "master-layout.txt";
    protected static final String CELL_FORMATS_FILE_NAME = "cell-formats.txt";
    protected static final String CONDITIONAL_CELL_FORMATS_FILE_NAME = "conditional-cell-formats.txt";

    public FileHandler() {
        runFileSetup();
    }

    public File getFile(DataFileType dataFileType) {
        return null; // TODO...
    }



    private void runFileSetup() {

        makeMainDataFolder();
        ExecutorService setupExecutor = Executors.newCachedThreadPool();

        setupExecutor.submit(new Runnable() {
            @Override
            public void run() {
                FileIOThreadManager settingsFileIOManager = new FileIOThreadManager(MAIN_DATA_FOLDER + SETTINGS_FILE_NAME, new SettingsFileReader(), new SettingsFileCreator());
                settingsFileIOManager.setupFile();
                printData(settingsFileIOManager.readFile());
            }
        });

        setupExecutor.submit(new Runnable() {
            @Override
            public void run() {
                FileIOThreadManager headerFileIOManager = new FileIOThreadManager(MAIN_DATA_FOLDER + HEADERS_FILE_NAME, new HeadersFileReader(), new HeadersFileCreator());
                headerFileIOManager.setupFile();
                printData(headerFileIOManager.readFile());
            }
        });

        setupExecutor.submit(new Runnable() {
            @Override
            public void run() {
                FileIOThreadManager masterSheetLayoutFileIOManager = new FileIOThreadManager(MAIN_DATA_FOLDER + MASTER_SHEET_LAYOUT_FILE_NAME, new MasterLayoutDataFileReader(), new MasterSheetLayoutFileCreator());
                masterSheetLayoutFileIOManager.setupFile();
                printData(masterSheetLayoutFileIOManager.readFile());
            }
        });

        setupExecutor.submit(new Runnable() {
            @Override
            public void run() {
                FileIOThreadManager cellFormatsFileIOManager = new FileIOThreadManager(MAIN_DATA_FOLDER + CELL_FORMATS_FILE_NAME, new CellFormatsReader(), new CellFormatsFileCreator());
                cellFormatsFileIOManager.setupFile();
                printData(cellFormatsFileIOManager.readFile());
            }
        });

        setupExecutor.submit(new Runnable() {
            @Override
            public void run() {
                FileIOThreadManager conditionalCellFormatsFileIOManager = new FileIOThreadManager(MAIN_DATA_FOLDER + CONDITIONAL_CELL_FORMATS_FILE_NAME, new ConditionalFormatTypesDataFileReader(), new ConditionalCellFormatsFileCreator());
                conditionalCellFormatsFileIOManager.setupFile();
                printData(conditionalCellFormatsFileIOManager.readFile());
            }
        });


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
