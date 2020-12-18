package fakeEnums;

import java.util.Collection;
import java.util.Map;

public class Columns extends FakeEnum { // TODO... Comments

    private static Map<String, FakeEnumValue> enumValues;

    protected Columns(Collection<FakeEnumValue> enumValueCollection) {
        storeData(enumValueCollection);
    }

    public static Column valueOf(String enumValueName) {
        return (Column) valueOf(enumValues, enumValueName);
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
