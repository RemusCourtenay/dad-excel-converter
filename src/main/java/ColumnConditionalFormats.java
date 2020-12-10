import org.apache.poi.ss.usermodel.ConditionalFormatting;
import org.apache.poi.xssf.usermodel.XSSFConditionalFormatting;
import org.apache.poi.xssf.usermodel.XSSFConditionalFormattingRule;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColumnConditionalFormats extends FakeEnum {

    private static Map<String, FakeEnumValue> enumValues;

    public ColumnConditionalFormats(List<String[]> columnConditionalFormatsData) {
        if (enumValues == null) {
            enumValues = convertDataToMap(columnConditionalFormatsData);
        } else {
            throw new RuntimeException("ColumnConditionalFormat fake enum has already been instantiated.");
        }
    }


    public static ColumnConditionalFormat valueOf(String enumValue) throws NullPointerException, IllegalArgumentException {
        return ((ColumnConditionalFormat) valueOf(enumValues, enumValue));
    }

    public static void printAll() {
        System.out.println("Column Conditional Formats:");
        for (String valueName: enumValues.keySet()) {
            System.out.println(valueName);
        }
    }

    private static Map<String, FakeEnumValue> convertDataToMap(List<String[]> columnConditionalFormatsData) {
        Map<String, FakeEnumValue> enumValues = new HashMap<>(columnConditionalFormatsData.size());

        for (String[] columnConditionalFormatData: columnConditionalFormatsData) {
            enumValues.put(columnConditionalFormatData[0], makeColumnConditionalFormat(columnConditionalFormatData));
        }

        return enumValues;
    }

    private static FakeEnumValue makeColumnConditionalFormat(String[] columnConditionalFormatData) {
        return switch (columnConditionalFormatData.length) {
            case 1 -> new ColumnConditionalFormat();
            case 2 -> new ColumnConditionalFormat(columnConditionalFormatData[1]);
            case 3 -> new ColumnConditionalFormat(columnConditionalFormatData[1], columnConditionalFormatData[2]);
            case 4 -> new ColumnConditionalFormat(columnConditionalFormatData[1], columnConditionalFormatData[2], columnConditionalFormatData[3]);
            case 5 -> new ColumnConditionalFormat(columnConditionalFormatData[1], columnConditionalFormatData[2], columnConditionalFormatData[3], columnConditionalFormatData[4]);
            default -> throw new RuntimeException("Column Conditional Format: " + Arrays.toString(columnConditionalFormatData) + " does not have a valid (1-5) number of data pieces. This may have been setup incorrectly or been corrupted");
        };
    }

}
