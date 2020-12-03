

import dosStuff.DataFileType;
import dosStuff.FileHandler;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author Remus Courtenay - rcou199
 * @since 4/11/2020
 */
public class Main {

    public static void main(String[] args) {

        FileHandler fileHandler = new FileHandler();

        List<Column> masterSheetColumns = ColumnBuilder.fromDataFile(fileHandler.getFile(DataFileType.MASTER_SHEET_LAYOUT));
    }


}
