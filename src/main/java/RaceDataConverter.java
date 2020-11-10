import dosStuff.SettingsHandler;
import dosStuff.SettingsReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Remus Courtenay - rcou199
 * @since 10/11/2020
 */
public class RaceDataConverter {

    private Map<ColumnType, Column> columns;

    public RaceDataConverter() {
        SettingsReader settingsReader = new SettingsReader();

        this.columns = setupColumns(settingsReader);

    }


    private Map<ColumnType, Column> setupColumns(SettingsReader settingsReader) {

        List<String> headerStrings = settingsReader.getHeaders();

        Map<ColumnType, Column> columnsMap = new HashMap<>(headerStrings.size());

        for (String headerString: headerStrings) {

            ColumnType columnType = ColumnType.valueOf(headerString); // This is wrong
            Column newColumn = new Column(headerString, columnType);

            columnsMap.put(columnType, newColumn);
        }

        return columnsMap;
    }
}
