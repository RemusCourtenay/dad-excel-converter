import org.apache.poi.ss.format.CellFormat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Remus Courtenay - rcou199
 * @since 11/11/2020
 */
public class ColumnFormats extends FakeEnum {

    private static Map<String, FakeEnumValue> enumValues;

    public ColumnFormats(List<String[]> columnFormatsData) {
        if (enumValues == null) {
            enumValues = convertDataToMap(columnFormatsData);
        } else {
            throw new RuntimeException("ColumnFormat fake enum has already been instantiated");
        }
    }

    public static ColumnFormat valueOf(String enumValue) throws NullPointerException, IllegalArgumentException {
        return ((ColumnFormat) valueOf(enumValues, enumValue));
    }

    private Map<String, FakeEnumValue> convertDataToMap(List<String[]> columnFormatsData) {

        Map<String, FakeEnumValue> enumValues = new HashMap<>(columnFormatsData.size());

        for (String[] columnFormatData: columnFormatsData) {
            enumValues.put(columnFormatData[0], new ColumnFormat(columnFormatData[1]));
        }

        return enumValues;
    }
}
