package dosStuff.fileCreators;

import dosStuff.BatchFileHandler;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Iterator;

import static dosStuff.BatchFileHandler.appendToFileWithoutQuotes;

/**
 * Abstract class that contains methods shared by all classes that create files. Abstract method runSetup allows for the
 * initialisation of all FileCreator extensions via the FileCreatorType enum.
 * @author Remus Courtenay - rcou199
 * @since 11/11/2020
 */
public abstract class FileCreator {

    protected final Workbook saveDataWorkbook;
    protected final CreationHelper saveDataCreationHelper;
    protected final Sheet saveDataSheet;

    public FileCreator() {

        this.saveDataWorkbook = new XSSFWorkbook();
        this.saveDataCreationHelper = saveDataWorkbook.getCreationHelper();
        this.saveDataSheet = saveDataWorkbook.createSheet();
    }

    public abstract void createDefaultFile(String fileAddress);

    protected void resizeColumnsToFit() {
        Row row = saveDataSheet.getRow(0);
        Iterator<Cell> it = row.cellIterator();

        while(it.hasNext()) {
            saveDataSheet.autoSizeColumn(it.next().getColumnIndex());
        }
    }

    protected void writeWorkbookToFile(String fileAddress) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileAddress);
            saveDataWorkbook.write(fileOutputStream);
            fileOutputStream.close();
            saveDataWorkbook.close();
        } catch (Exception e) {
            //todo...
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
