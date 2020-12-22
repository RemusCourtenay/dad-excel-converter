package dosStuff;

import dosStuff.fileCreators.SaveDataFileCreator;

import java.io.*;
import java.nio.file.*;


/**
 * @author Remus Courtenay - rcou199
 * @since 16/11/2020
 */
public class FileIOThreadManager { // TODO... comment

    private final Path filePath;
    private final SaveDataFileCreator saveDataFileCreator;


    public FileIOThreadManager(Path filePath, SaveDataFileCreator saveDataFileCreator) {
        this.filePath = filePath;
        this.saveDataFileCreator = saveDataFileCreator;
    }

    protected synchronized void setupFile() {
        if (!filePath.toFile().exists()) {
            saveDataFileCreator.createDefaultFile(filePath);
        }
    }


    public synchronized File getFile() {
        try {
            Path tempFilePath = Files.createTempFile(null, null);

            Files.copy(filePath, tempFilePath, StandardCopyOption.REPLACE_EXISTING);

            File tempFile = tempFilePath.toFile();
            tempFile.deleteOnExit();

            return tempFile;
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new RuntimeException(); // TODO...
        }
    }



}


