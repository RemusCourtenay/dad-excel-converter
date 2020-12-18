package fakeEnums;

import org.apache.poi.ss.usermodel.Cell;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class FakeEnum {

    protected static FakeEnumValue valueOf(Map<String, FakeEnumValue> enumValues, String valueName) throws NullPointerException, IllegalArgumentException {
        FakeEnumValue valueData;
        if (valueName == null) {
            throw new NullPointerException("Fake Enum value cannot be null");
        } else if (enumValues == null) {
            throw new NullPointerException("Fake Enum values have not been instantiated");
        } else if ((valueData = enumValues.get(valueName)) == null) {
            throw new IllegalArgumentException("No such Fake Enum value: " + valueName);
        } else {
            return valueData;
        }
    }

    protected static Map<String, FakeEnumValue> convertDataToMap(Collection<FakeEnumValue> enumValueCollection) {
        Map<String, FakeEnumValue> fakeEnumValues = new HashMap<>(enumValueCollection.size());

        for (FakeEnumValue enumValue: enumValueCollection) {
            fakeEnumValues.put(enumValue.getName(), enumValue);
        }

        return fakeEnumValues;
    }
}
