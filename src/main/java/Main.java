

import dosStuff.DataFileType;
import dosStuff.FileHandler;

import java.util.List;

/**
 * @author Remus Courtenay - rcou199
 * @since 4/11/2020
 */
public class Main {

    public static void main(String[] args) {

        FileHandler fileHandler = new FileHandler();
        ColumnFormatsBuilder.setupFormatsFromFile(fileHandler.getFileManager(DataFileType.CELL_FORMATS));
        ColumnFormats.printAll();
        ColumnConditionalFormatsBuilder.setupConditionalFormatsFromFile(fileHandler.getFileManager(DataFileType.CONDITIONAL_CELL_FORMATS));
        ColumnConditionalFormats.printAll();
//        List<Column> masterSheetColumns = ColumnBuilder.fromDataFile(fileHandler.getFileManager(DataFileType.MASTER_SHEET_LAYOUT));
//        System.out.println("Master Sheet Columns: ");
//        for (Column column: masterSheetColumns) {
//            System.out.println(column.getHeaderText());
//        }

    }


}
