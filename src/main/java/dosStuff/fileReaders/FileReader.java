package dosStuff.fileReaders;

import dosStuff.FileIOThreadManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Remus Courtenay - rcou199
 * @since 19/11/2020
 */
public abstract class FileReader {

    protected final FileIOThreadManager fileIOThreadManager;

    public FileReader(FileIOThreadManager fileIOThreadManager) {
        this.fileIOThreadManager = fileIOThreadManager;
    }

    public List<String[]> readFile() {

        List<String> dataStrings;
        List<String[]> dataArrays;

        try {
            dataStrings = fileIOThreadManager.readFromFile();
            dataArrays = new ArrayList<>(dataStrings.size());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("IOException occurred when attempting to read from file");
        }

        for (String dataLine: dataStrings) {
            dataArrays.add(convertLineToArray(dataLine));
        }
        return dataArrays;
    }


    private String[] convertLineToArray(String dataLine) {

        StringBuilder stringBuilder = new StringBuilder(dataLine);

        // TODO.. implement
        List<Integer> underscores = new ArrayList<>();

        int i;
        while (dataLine.contains("_")) {
            i = dataLine.indexOf("_", 1);
            if (dataLine.charAt(i-1) != '\\') {
                underscores.add(i);
            }
            dataLine = stringBuilder.substring(i+1);

        }

        return stringBuilder.toString().split(",");
    }

}
