package dosStuff.fileReaders;

import dosStuff.FileIOThreadManager;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
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

        List<String> dataStrings;
        List<String[]> dataArrays;

        try {
            dataStrings = fileIOThreadManager.readFromFile();
            dataArrays = new ArrayList<>(dataStrings.size());
        } catch (IOException e) {
            throw new RuntimeException("IOException occurred when attempting to read from file");
        }

        for (String dataLine: dataStrings) {
            dataArrays.add(convertLineToArray(dataLine));
        }
        return dataArrays;
    }


    private String[] convertLineToArray(String dataLine) {

        StringBuilder stringBuilder = new StringBuilder(dataLine);

        List<Integer> underscores = new ArrayList<>();

        int i;
        while (dataLine.contains("_")) {
            i = dataLine.indexOf("_", 1);
            if (dataLine.charAt(i-1) != '\\') {
                underscores.add(i);
            }
            dataLine = stringBuilder.toString().substring(i+1);

        }

        return stringBuilder.toString().split(",");

    }
}
