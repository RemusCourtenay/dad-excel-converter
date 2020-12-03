package dosStuff.fileReaders;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Remus Courtenay - rcou199
 * @since 19/11/2020
 */
public abstract class DataFileReader {

    public DataFileReader() {
    }

    public List<String[]> readFromFile(String fileAddress)  {

        File file = new File(fileAddress);
        List<String> dataLines = new ArrayList<>();
        BufferedReader dataReader;

        try {
            dataReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
            throw new RuntimeException("File: " + fileAddress + " not found");
        }

        String data;
        while (true) {
            try {
                if ((data = dataReader.readLine()) == null) {
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException("IOException occurred when trying to read line from file: " + fileAddress);
            }
            dataLines.add(data);
        }

        return convertToArrays(dataLines);
    }

    private List<String[]> convertToArrays(List<String> dataLines) {
        List<String[]> dataArrays = new ArrayList<>(dataLines.size());

        for (String dataLine: dataLines) {
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
