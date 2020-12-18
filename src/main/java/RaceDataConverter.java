import dosStuff.fileReaders.SettingsFileReader;

/**
 * @author Remus Courtenay - rcou199
 * @since 10/11/2020
 */
public class RaceDataConverter {

//    private Map<String, fakeEnums.Column> columns;

    public RaceDataConverter() {
        SettingsFileReader settingsFileReader = new SettingsFileReader();

//        this.columns = setupColumns(settingsReader);

    }


//    private Map<String, fakeEnums.Column> setupColumns(SettingsReader settingsReader) {
//
//        List<String> headerStrings = settingsReader.getHeaders();
//
//        Map<String, fakeEnums.Column> columnsMap = new HashMap<>(headerStrings.size());
//
//        for (String headerString: headerStrings) {
//
//            String columnType = ColumnType.valueOf(headerString); // This is wrong, need to save header name and column type (I.E int, String, Date etc..)
//            fakeEnums.Column newColumn = new fakeEnums.Column(headerString, columnType);
//
//            columnsMap.put(columnType, newColumn);
//        }
//
//        return columnsMap;
//    }
}
