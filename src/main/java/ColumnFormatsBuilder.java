import dosStuff.FileIOThreadManager;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ColumnFormatsBuilder extends FakeEnumBuilder {

    public static void setupFormatsFromFile(FileIOThreadManager fileManager) {
        Workbook saveFileWorkbook = convertFileToWorkbook(fileManager.getFile());

        Sheet saveFileSheet = saveFileWorkbook.getSheetAt(0); // TODO... check sheet num
        Row saveFileTopRow = saveFileSheet.getRow(0);

        new ColumnFormats(saveFileTopRow.cellIterator());
    }


}
