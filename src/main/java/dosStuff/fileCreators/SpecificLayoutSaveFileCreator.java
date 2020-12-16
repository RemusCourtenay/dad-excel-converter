package dosStuff.fileCreators;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;

public class SpecificLayoutSaveFileCreator <saveFileType extends DefaultSaveFileValues> extends FileCreator {

    private final Class<saveFileType> saveFileValuesClass;

    public SpecificLayoutSaveFileCreator(Class<saveFileType> saveFileValuesClass){
        this.saveFileValuesClass = saveFileValuesClass;
    };

    @Override
    public void createDefaultFile(String fileAddress) {
        Row saveDataNameRow = saveDataSheet.createRow(0);

        Cell nameCell;
        DefaultSaveFileValues saveFileValue;
        DefaultSaveFileValues[] defaultSaveFileValues;

        if ((defaultSaveFileValues = saveFileValuesClass.getEnumConstants()) == null) {
            throw new RuntimeException(); // TODO...
        }

        for (int i = 0; i<defaultSaveFileValues.length; i++) {
            nameCell = saveDataNameRow.createCell(i);
            saveFileValue = defaultSaveFileValues[i];

            saveFileValue.setupSaveDataNameCell(nameCell);
        }

        super.resizeColumnsToFit();
        super.writeWorkbookToFile(fileAddress);
    }
}
