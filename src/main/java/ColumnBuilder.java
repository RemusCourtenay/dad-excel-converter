import dosStuff.FileIOThreadManager;
import org.apache.poi.ss.format.CellFormat;
import org.apache.poi.ss.usermodel.CellType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColumnBuilder {

    private static final int NUM_COLUMN_FIELDS = 4;


    protected static List<Column> fromDataFile(FileIOThreadManager fileManager) {
        List<String[]> fileData = fileManager.readFile();
        List<Column> columns = new ArrayList<>(fileData.size());

        String headerText;
        CellType cellType;
        ColumnFormat columnFormat;
        ColumnConditionalFormat columnConditionalFormat;

        for (String[] dataSet: fileData) {

            if (dataSet.length != NUM_COLUMN_FIELDS) {
                throw new RuntimeException("File data line: " + Arrays.toString(dataSet) + " does not have " + NUM_COLUMN_FIELDS + " values. Data may be corrupted or incorrectly setup.");
            }

            headerText = dataSet[0];

            try {
                cellType = CellType.valueOf(dataSet[1]);
            } catch (IllegalArgumentException exception) {
                exception.printStackTrace();
                throw new RuntimeException("Value: " + dataSet[1] + " is not a valid CellType");
            }

            try {
                columnFormat = ColumnFormats.valueOf(dataSet[2]);
            } catch (IllegalArgumentException exception) {
                exception.printStackTrace();
                throw new RuntimeException("Value: " + dataSet[2] + " is not a valid ColumnFormat");
            }

            try {
                columnConditionalFormat = ColumnConditionalFormats.valueOf(dataSet[3]);
            } catch (IllegalArgumentException exception) {
                exception.printStackTrace();
                throw new RuntimeException("Value: " + dataSet[3] + " in line: " + Arrays.toString(dataSet) + " is not a valid ColumnConditionalFormat");
            }

            columns.add(new Column(headerText, cellType, columnFormat, columnConditionalFormat));
        }
        return columns;
    }
}
