package dosStuff.fileReaders;

import dosStuff.FileIOThreadManager;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Remus Courtenay - rcou199
 * @since 13/11/2020
 */
public class ConditionalFormatTypesDataFileReader extends DataFileReader {

    public Map<String, ConditionalFormatting> readFromTheFile(String fileAddress) {
        Workbook cellConditionalFormatsSaveDataWorkbook;
        Map<String, ConditionalFormatting> conditionalFormats = new HashMap<>();

        try {
            cellConditionalFormatsSaveDataWorkbook = new XSSFWorkbook(new File(fileAddress));
        } catch(IOException | InvalidFormatException exception) {
            //TODO...
            exception.printStackTrace();
            throw new RuntimeException();
        }

        Sheet saveDataSheet = cellConditionalFormatsSaveDataWorkbook.getSheetAt(0);
        SheetConditionalFormatting saveDataConditionalFormatting = saveDataSheet.getSheetConditionalFormatting();
        Row saveDataRow = saveDataSheet.getRow(0);

        for (int i = 0; i<saveDataConditionalFormatting.getNumConditionalFormattings(); i++) {
            conditionalFormats.put(saveDataRow.getCell(i).getStringCellValue(), saveDataConditionalFormatting.getConditionalFormattingAt(i));
        }

        return conditionalFormats;
    }




}
