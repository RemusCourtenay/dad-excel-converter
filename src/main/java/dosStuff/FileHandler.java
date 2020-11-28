package dosStuff;

import dosStuff.fileCreators.*;
import dosStuff.fileReaders.CellFormatsReader;
import dosStuff.fileReaders.ConditionalFormatTypesFileReader;
import dosStuff.fileReaders.FileReader;
import dosStuff.fileReaders.SettingsFileReader;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
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

    private void runFileSetup() {

        makeMainDataFolder();

        FileIOThreadManager settingsFileThreadManager = new FileIOThreadManager(MAIN_DATA_FOLDER + SETTINGS_FILE_NAME);
        FileIOThreadManager headersFileThreadManager = new FileIOThreadManager(MAIN_DATA_FOLDER + HEADERS_FILE_NAME);
        FileIOThreadManager masterSheetLayoutFileThreadManager = new FileIOThreadManager(MAIN_DATA_FOLDER + MASTER_SHEET_LAYOUT_FILE_NAME);
        FileIOThreadManager cellFormatsFileThreadManager = new FileIOThreadManager(MAIN_DATA_FOLDER + CELL_FORMATS_FILE_NAME);
        FileIOThreadManager conditionalCellFormatsThreadManager = new FileIOThreadManager(MAIN_DATA_FOLDER + CONDITIONAL_CELL_FORMATS_FILE_NAME);

        ExecutorService setupExecutor = Executors.newCachedThreadPool();

        setupExecutor.submit(makeAsTask(SettingsFileCreator.class, settingsFileThreadManager));
        setupExecutor.submit(makeAsTask(HeadersFileCreator.class, headersFileThreadManager));
        setupExecutor.submit(makeAsTask(MasterSheetLayoutFileCreator.class, masterSheetLayoutFileThreadManager));
        setupExecutor.submit(makeAsTask(CellFormatsFileCreator.class, cellFormatsFileThreadManager));
        setupExecutor.submit(makeAsTask(ConditionalCellFormatsFileCreator.class, conditionalCellFormatsThreadManager));

        setupExecutor.submit(makeAsTask(cellFormatsFileThreadManager, CellFormatsReader.class));
        setupExecutor.submit(makeAsTask(conditionalCellFormatsThreadManager, ConditionalFormatTypesFileReader.class));

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

    private Runnable makeAsTask(Class<? extends FileCreator> fileCreatorClass, FileIOThreadManager threadManager) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    fileCreatorClass.getConstructor(FileIOThreadManager.class).newInstance(threadManager);
                    System.out.println("Constructed " + fileCreatorClass.getName());
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                    throw new RuntimeException("File creator: " + fileCreatorClass.getName() + " threw exception during instantiation");
                }
            }
        };
    }

    private Runnable makeAsTask(FileIOThreadManager fileIOThreadManager, Class<? extends FileReader> fileReaderClass) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    printData(fileReaderClass.getConstructor(FileIOThreadManager.class).newInstance(fileIOThreadManager).readFile());
                    System.out.println("Constructed " + fileReaderClass.getName());
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                    throw new RuntimeException("File reader " + fileReaderClass.getName() + " threw exception during data reading");
                }
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
