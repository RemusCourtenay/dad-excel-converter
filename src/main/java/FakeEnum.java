import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
}
