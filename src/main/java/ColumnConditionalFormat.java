import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFPatternFormatting;

public class ColumnConditionalFormat implements FakeEnumValue {

    private final ConditionalFormatting conditionalFormat;
    private final String name;

    protected ColumnConditionalFormat(String name, ConditionalFormatting conditionalFormat) { // TODO... Comment
        this.name = name;
        this.conditionalFormat = conditionalFormat;
    }

    public String getName() {
        return name;
    }

    public ConditionalFormatting getConditionalFormat() {
        return conditionalFormat;
    }
}
