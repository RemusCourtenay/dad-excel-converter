package dosStuff.fileReaders;

import dosStuff.FileIOThreadManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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

        StringBuilder dataBuilder = new StringBuilder();
        char[] dataArray = dataLine.toCharArray();

        for (int i = 0; i<dataLine.length() - 1; i++) { // -1 as final character can't be escape char
            if (dataArray[i] == '\\') {
                if (dataArray[i+1] == '\\') { // Escaped slash
                    dataBuilder.append('\\');
                    i++;
                } else if (dataArray[i+1] == '_') { // Escaped underscore
                    dataBuilder.append('_');
                    i++;
                } else {
                    dataBuilder.append('\\'); // Non-escape slash
                }
            } else if (dataArray[i] == '_') { // Non-escaped underscore converts to space
                dataBuilder.append(' ');
            } else {
                dataBuilder.append(dataArray[i]);
            }
        }

        return dataBuilder.toString().split(",");
    }

}
