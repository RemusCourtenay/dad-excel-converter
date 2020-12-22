

import dosStuff.DataFileType;
import dosStuff.FileHandler;
import fakeEnums.*;
import programInterfaces.ActiveWorksInterface;
import programInterfaces.SportsCoreInterface;

import java.util.List;

/**
 * @author Remus Courtenay - rcou199
 * @since 4/11/2020
 */
public class Main {

    public static void main(String[] args) { // TODO... Comment

        FileHandler fileHandler = new FileHandler();
        new ColumnFormatsBuilder().setupEnumFromFile(fileHandler.getFileManager(DataFileType.CELL_FORMATS).getFile());
        new ColumnConditionalFormatsBuilder().setupEnumFromFile(fileHandler.getFileManager(DataFileType.CONDITIONAL_CELL_FORMATS).getFile());
        new ColumnBuilder().setupEnumFromFile(fileHandler.getFileManager(DataFileType.HEADERS_SHEET_LAYOUT).getFile());

        ColumnFormats.printAll();
        ColumnConditionalFormats.printAll();
        Columns.printAll();

        new ActiveWorksInterface(fileHandler.getFileManager(DataFileType.ACTIVE_SHEET_LAYOUT).getFile());
        new SportsCoreInterface(fileHandler.getFileManager(DataFileType.SPORTSCORE_SHEET_LAYOUT).getFile());
    }
}
