package fakeEnums;

import java.util.Collection;
import java.util.Map;

public class ColumnConditionalFormats extends FakeEnum { // TODO... Comments

    private static Map<String, FakeEnumValue> enumValues;

    public ColumnConditionalFormats(Collection<FakeEnumValue> enumValueCollection) {
        storeData(enumValueCollection);
    }

    public static ColumnConditionalFormat valueOf(String enumValue) throws NullPointerException, IllegalArgumentException {
        return ((ColumnConditionalFormat) valueOf(enumValues, enumValue));
    }

    public static void printAll() {
        printAll(enumValues);
    }

    @Override
    protected boolean isInitialised() {
        return enumValues != null;
    }

    @Override
    protected void initialiseAs(Map<String, FakeEnumValue> enumValuesMap) {
        enumValues = enumValuesMap;
    }
}
