package fakeEnums;

import java.util.Collection;
import java.util.Map;

public class ColumnConditionalFormats extends FakeEnum {

    private static Map<String, FakeEnumValue> enumValues;

    public ColumnConditionalFormats(Collection<FakeEnumValue> enumValueCollection) {
        if (enumValues == null) {
            enumValues = convertDataToMap(enumValueCollection);
        } else {
            throw new RuntimeException("ColumnConditionalFormat fake enum has already been instantiated.");
        }
    }

    public static ColumnConditionalFormat valueOf(String enumValue) throws NullPointerException, IllegalArgumentException {
        return ((ColumnConditionalFormat) valueOf(enumValues, enumValue));
    }
}
