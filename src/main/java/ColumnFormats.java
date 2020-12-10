import org.apache.poi.ss.format.CellFormat;
import org.apache.poi.ss.usermodel.Cell;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Remus Courtenay - rcou199
 * @since 11/11/2020
 */
public class ColumnFormats extends FakeEnum {

    private static Map<String, FakeEnumValue> enumValues;

    public ColumnFormats(Iterator<Cell> cellIterator) {
        if (enumValues == null) {
            enumValues = convertDataToMap(cellIterator);
        } else {
            throw new RuntimeException("ColumnFormat fake enum has already been instantiated");
        }
    }

    public static ColumnFormat valueOf(String enumValue) throws NullPointerException, IllegalArgumentException {
        return ((ColumnFormat) valueOf(enumValues, enumValue));
    }

    public static void printAll() {
        System.out.println("Column Formats:");
        for (String valueName: enumValues.keySet()) {
            System.out.println(valueName);
        }
    }

    private Map<String, FakeEnumValue> convertDataToMap(Iterator<Cell> cellIterator) {

        Map<String, FakeEnumValue> enumValues = new HashMap<>();

        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            String styleName = cell.getStringCellValue();
            enumValues.put(styleName, new ColumnFormat(styleName, cell.getCellStyle()));
        }

        return enumValues;
    }
}
