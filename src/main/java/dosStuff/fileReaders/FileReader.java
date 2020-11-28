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

        StringBuilder dataBuilder = new StringBuilder(dataLine);

        for (int i = 0; i< dataBuilder.capacity(); i++) {
            if (dataBuilder.charAt(i) == '_' && notEscaped(dataBuilder, i)) {
                dataBuilder.setCharAt(i, ' ');
            }
        }

        return dataBuilder.toString().split(",");
    }

    private boolean notEscaped(StringBuilder dataBuilder, int i) {
        if (i == 0) {
            return true;
        } else {
            if (dataBuilder.charAt(i-1) == '\\' && notEscaped(dataBuilder, i-1)) {
                return false;
            } else {
                return true;
            }
        }
    }

}
