import dosStuff.SettingsFileReader;

/**
 * @author Remus Courtenay - rcou199
 * @since 10/11/2020
 */
public class RaceDataConverter {

//    private Map<String, Column> columns;

    public RaceDataConverter() {
        SettingsFileReader settingsFileReader = new SettingsFileReader();

//        this.columns = setupColumns(settingsReader);

    }


//    private Map<String, Column> setupColumns(SettingsReader settingsReader) {
//
//        List<String> headerStrings = settingsReader.getHeaders();
//
//        Map<String, Column> columnsMap = new HashMap<>(headerStrings.size());
//
//        for (String headerString: headerStrings) {
//
//            String columnType = ColumnType.valueOf(headerString); // This is wrong, need to save header name and column type (I.E int, String, Date etc..)
//            Column newColumn = new Column(headerString, columnType);
//
//            columnsMap.put(columnType, newColumn);
//        }
//
//        return columnsMap;
//    }
}
