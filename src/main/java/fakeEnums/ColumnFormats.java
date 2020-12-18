package fakeEnums;

import org.apache.poi.ss.usermodel.Cell;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Remus Courtenay - rcou199
 * @since 11/11/2020
 */
public class ColumnFormats extends FakeEnum { // TODO... Comments

    private static Map<String, FakeEnumValue> enumValues; // Has to live here not in abstract class as is static

    public ColumnFormats(Collection<FakeEnumValue> enumValuesCollection) {
        storeData(enumValuesCollection);
    }

    public static ColumnFormat valueOf(String enumValue) throws NullPointerException, IllegalArgumentException {
        return ((ColumnFormat) valueOf(enumValues, enumValue));
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
