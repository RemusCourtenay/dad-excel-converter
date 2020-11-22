package dosStuff;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static dosStuff.BatchFileHandler.appendToFileWithoutQuotes;

/**
 * @author Remus Courtenay - rcou199
 * @since 16/11/2020
 */
public class FileIOThreadManager {

    // Character(s) that specify the boundary between data values in the saved data
    private static final String DATA_FILE_DELIMITER = ",";

    private static final int NUM_COMMENT_LINES = 1;

    private final String fileAddress;
    private final ExecutorService commandExecutor;


    public FileIOThreadManager(String fileAddress) {
        this.fileAddress = fileAddress;
        this.commandExecutor = Executors.newSingleThreadExecutor();
    }

    public synchronized void writeToFileWithComment(String comment, String[][] dataLines) {

        // Checking if file already exists
        if(!BatchFileHandler.fileExists(fileAddress)) {

            commandExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    appendToFileWithoutQuotes(comment, fileAddress);
                }
            });

            // Echoing each set of values to a new line in the file
            for (String[] dataLine: dataLines) {

                commandExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        appendToFileWithoutQuotes(makeSaveDataLine(dataLine), fileAddress);
                    }
                });
            }
        }
    }

    public synchronized List<String> readFromFile() throws FileNotFoundException {
        if (BatchFileHandler.fileExists(fileAddress)) {

            File file = new File(fileAddress);
            List<String> dataLines = new ArrayList<>();
            BufferedReader dataReader = new BufferedReader(new FileReader(file));

            commandExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    String data;
                    while (true) {
                        try {
                            if ((data = dataReader.readLine()) == null) break;
                        } catch (IOException e) {
                            throw new RuntimeException("IOException occurred when trying to read line from file: " + fileAddress);
                        }
                        System.out.println(data);
                        dataLines.add(data);
                    }
                }
            });
            commandExecutor.shutdown();
            try {
                System.out.println("attempting executor shutdown");
                if(!commandExecutor.awaitTermination(60,TimeUnit.SECONDS)) {
                    commandExecutor.shutdownNow();
                    System.out.println("executor forced shutdown");
                } else {
                    System.out.println("executor has shutdown");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
            return dataLines;
        } else {
            throw new RuntimeException("File: " + fileAddress + " hasn't been initialised");
        }
    }

    /**
     * Private helper method that generates a String in the correct save data format from an array of values.
     * @param saveData : The data that is being saved as a line in a text file.
     * @return : The data formatted as a single string in the correct format
     */
    private String makeSaveDataLine(String[] saveData) {

        StringBuilder dataLineBuilder = new StringBuilder();

        // Adding each data chunk and separating with delimiter
        for (String dataChunk: saveData) {
            // Checking for illegal characters
            if (dataChunk.contains(DATA_FILE_DELIMITER)) {
                throw new RuntimeException(dataChunk + " in " + Arrays.toString(saveData) + " contains illegal character: " + DATA_FILE_DELIMITER);
            } else if (dataChunk.contains(" ") || dataChunk.contains("\t") || dataChunk.contains("\n")){
                throw new RuntimeException(dataChunk + " in " + Arrays.toString(saveData) + " contains illegal whitespace character, please replace with underscore");
            } else {
                dataLineBuilder.append(dataChunk).append(DATA_FILE_DELIMITER);
            }
        }

        // Removing unnecessary final delimiter
        int lastIndexOfDelimiter = dataLineBuilder.lastIndexOf(DATA_FILE_DELIMITER);
        dataLineBuilder.delete(lastIndexOfDelimiter, lastIndexOfDelimiter+DATA_FILE_DELIMITER.length());

        // Adding quote marks to ensure DOS command doesn't incorrectly split input string
        dataLineBuilder.insert(0, "\"");
        dataLineBuilder.append("\"");
        return dataLineBuilder.toString();
    }
}
