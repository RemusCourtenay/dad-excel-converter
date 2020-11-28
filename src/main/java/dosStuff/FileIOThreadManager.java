package dosStuff;

import dosStuff.fileCreators.FileCreator;
import dosStuff.fileReaders.DataFileReader;

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
    private final ExecutorService commandExecutor;
    private final DataFileReader dataFileReader;
    private final FileCreator fileCreator;


    public FileIOThreadManager(String fileAddress, DataFileReader dataFileReader, FileCreator fileCreator) {
        this.fileAddress = fileAddress;
        this.commandExecutor = Executors.newSingleThreadExecutor();
        this.dataFileReader = dataFileReader;
        this.fileCreator = fileCreator;
    }

    public synchronized void setupFile() {
        if (!BatchFileHandler.fileExists(fileAddress)) {
            commandExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    fileCreator.createDefaultFile(fileAddress);
                }
            });
        }
    }


    public synchronized List<String[]> readFile() {

        if (BatchFileHandler.fileExists(fileAddress)) {
            List<String[]> dataArrays = new ArrayList<>();

            commandExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    dataArrays.addAll(dataFileReader.readFromFile(fileAddress));
                }
            });
            commandExecutor.shutdown();

            try {
                if (!commandExecutor.awaitTermination(30, TimeUnit.SECONDS)) {
                    commandExecutor.shutdownNow();
                    throw new RuntimeException("Executor timed out trying to read file: " + fileAddress);
                }
            } catch (InterruptedException exception) {
                exception.printStackTrace();
                throw new RuntimeException("Executor was interrupted while trying to read file: " + fileAddress);
            }
            return dataArrays;
        } else {
            throw new RuntimeException("Attempting to read file: " + fileAddress + " before it has been created");
        }


    }



}


