import dosStuff.FileIOThreadManager;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ColumnConditionalFormatsBuilder extends FakeEnumBuilder { // TODO... Comments

    public static void setupConditionalFormatsFromFile(FileIOThreadManager fileManager) {
        Workbook saveDataWorkbook = convertFileToWorkbook(fileManager.getFile());

        Sheet saveDataSheet = saveDataWorkbook.getSheetAt(0); // TODO... check sheet num
        SheetConditionalFormatting saveDataConditionalFormatting = saveDataSheet.getSheetConditionalFormatting();
        Row saveDataTopRow = saveDataSheet.getRow(0); // TODO... check row num

        int numOfConditionalFormats = saveDataConditionalFormatting.getNumConditionalFormattings();


        List<ConditionalFormatting> saveDataConditionalFormats = new ArrayList<>(numOfConditionalFormats);
        List<String> saveDataConditionalFormatNames = new ArrayList<>(numOfConditionalFormats);

        for (int i = 0; i<numOfConditionalFormats; i++) {
            // Giving conditional formatting objects not conditional formatting rules objects, could be wrong
            saveDataConditionalFormats.add(saveDataConditionalFormatting.getConditionalFormattingAt(i));
            saveDataConditionalFormatNames.add(saveDataTopRow.getCell(i).getStringCellValue());
        }
        // Feature envy?
        new ColumnConditionalFormats(saveDataConditionalFormatNames, saveDataConditionalFormats);
    }

}
