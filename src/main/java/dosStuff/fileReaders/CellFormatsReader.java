package dosStuff.fileReaders;

import dosStuff.FileIOThreadManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Remus Courtenay - rcou199
 * @since 19/11/2020
 */
public class CellFormatsReader implements FileReader {

    private final FileIOThreadManager fileIOThreadManager;


    public CellFormatsReader(FileIOThreadManager fileIOThreadManager) {
        this.fileIOThreadManager = fileIOThreadManager;
    }


    @Override
    public List<String[]> readFile() {

        List<String[]> data = new ArrayList<>();
        String[] dataLine;

        while ((dataLine = fileIOThreadManager.readLineFromFile()) != null) {
            data.add(dataLine);
        }

        return data;
    }
}
