import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ConditionalFormatting;
import org.apache.poi.xssf.usermodel.XSSFConditionalFormatting;
import org.apache.poi.xssf.usermodel.XSSFConditionalFormattingRule;

import java.util.*;

public class ColumnConditionalFormats extends FakeEnum {

    private static Map<String, FakeEnumValue> enumValues;

    public ColumnConditionalFormats(List<String> formatNames, List<ConditionalFormatting> conditionalFormats) {
        if (enumValues == null) {
            enumValues = convertDataToMap(formatNames, conditionalFormats);
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

    private static Map<String, FakeEnumValue> convertDataToMap(List<String> formatNames, List<ConditionalFormatting> conditionalFormats) {
        Map<String, FakeEnumValue> enumValues = new HashMap<>();

        Iterator<String> nameIterator = formatNames.iterator();
        Iterator<ConditionalFormatting> formatIterator = conditionalFormats.iterator();

        String name;
        while(nameIterator.hasNext() && formatIterator.hasNext()) {
            name = nameIterator.next();
            enumValues.put(name, new ColumnConditionalFormat(name, formatIterator.next()));
        }
        return enumValues;
    }

}
