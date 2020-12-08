import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFPatternFormatting;

public class ColumnConditionalFormat implements FakeEnumValue {

    private final String patternFormatting;
    private final String borderFormatting;
    private final String fontFormatting;
    private final String colorScaleFormatting;
    private final String dataBarFormatting;

    private static final String DEFAULT_PATTERN_FORMATTING = null;
    private static final String DEFAULT_BORDER_FORMATTING = null;
    private static final String DEFAULT_FONT_FORMATTING = null;
    private static final String DEFAULT_COLOR_SCALE_FORMATTING = null;
    private static final String DEFAULT_DATA_BAR_FORMATTING = null;

    public ColumnConditionalFormat(String patternFormat) {
        this(patternFormat, DEFAULT_BORDER_FORMATTING);
    }

    public ColumnConditionalFormat(String patternFormat, String borderFormat) {
        this(patternFormat, borderFormat, DEFAULT_FONT_FORMATTING);
    }

    public ColumnConditionalFormat(String patternFormat, String borderFormat, String fontFormat) {
        this(patternFormat, borderFormat, fontFormat, DEFAULT_COLOR_SCALE_FORMATTING);
    }

    public ColumnConditionalFormat(String patternFormat, String borderFormat, String fontFormat, String colorScaleFormat) {
        this(patternFormat, borderFormat, fontFormat, colorScaleFormat, DEFAULT_DATA_BAR_FORMATTING);
    }

    public ColumnConditionalFormat(String patternFormat, String borderFormat, String fontFormat, String colorScaleFormat, String dataBarFormat) {
        this.patternFormatting = patternFormat;
        this.borderFormatting = borderFormat;
        this.fontFormatting = fontFormat;
        this.colorScaleFormatting = colorScaleFormat;
        this.dataBarFormatting = dataBarFormat;
    }

}
