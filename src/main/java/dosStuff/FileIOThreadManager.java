package dosStuff;

import dosStuff.fileCreators.FileCreator;
import dosStuff.fileReaders.DataFileReader;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * @author Remus Courtenay - rcou199
 * @since 16/11/2020
 */
public class FileIOThreadManager {

    private static final int NUM_COMMENT_LINES = 1;

    private final String fileAddress;
    private final FileCreator fileCreator;


    public FileIOThreadManager(String fileAddress, FileCreator fileCreator) {
        this.fileAddress = fileAddress;
        this.fileCreator = fileCreator;
    }

    public synchronized void setupFile() {
        if (!BatchFileHandler.fileExists(fileAddress)) {
            fileCreator.createDefaultFile(fileAddress);
        }
    }


    public synchronized File getFile() {
        try {
            Path saveDataFilePath = Path.of(fileAddress);
            Path tempFilePath = Files.createTempFile(null, null);

            Files.copy(saveDataFilePath, tempFilePath, StandardCopyOption.REPLACE_EXISTING);

            File tempFile = tempFilePath.toFile();
            tempFile.deleteOnExit();

            return tempFile;
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new RuntimeException(); // TODO...
        }
    }



}


