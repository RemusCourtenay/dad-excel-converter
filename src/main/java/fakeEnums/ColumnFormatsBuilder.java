package fakeEnums;

import dosStuff.FileIOThreadManager;
import fakeEnums.ColumnFormat;
import fakeEnums.ColumnFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ColumnFormatsBuilder extends FakeEnumBuilder { // TODO... Comment

    @Override
    public void setupEnumFromFile(FileIOThreadManager fileManager) {
        Workbook saveFileWorkbook = convertFileToWorkbook(fileManager.getFile());

        Sheet saveFileSheet = saveFileWorkbook.getSheetAt(0); // TODO... check sheet num
        Row saveFileTopRow = saveFileSheet.getRow(0); // TODO... check row num
        Iterator<Cell> cellIterator = saveFileTopRow.cellIterator();

        List<FakeEnumValue> enumValues = new ArrayList<>(saveFileTopRow.getPhysicalNumberOfCells());

        Cell cell;

        while(cellIterator.hasNext()) {
            cell = cellIterator.next();
            enumValues.add(new ColumnFormat(cell.getStringCellValue(), cell.getCellStyle()));
        }

        new ColumnFormats(enumValues);

    }


}
