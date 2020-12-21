package dosStuff.fileCreators;

import dosStuff.fileCreators.defaultValues.DefaultSaveFileValues;
import dosStuff.fileCreators.defaultValues.DefaultSpecificLayoutValues;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class SpecificLayoutSaveFileCreator <saveFileType extends DefaultSpecificLayoutValues> extends FileCreator {

    private final Class<saveFileType> saveFileValuesClass;

    public SpecificLayoutSaveFileCreator(Class<saveFileType> saveFileValuesClass){
        this.saveFileValuesClass = saveFileValuesClass;
    };

    @Override
    public void createDefaultFile(String fileAddress) {
        Row saveDataNameRow = saveDataSheet.createRow(0);
        Row saveDataConvertedNameRow = saveDataSheet.createRow(1);

        Cell nameCell;
        Cell convertedNameCell;
        DefaultSpecificLayoutValues saveFileValue;
        DefaultSpecificLayoutValues[] defaultSaveFileValues;

        if ((defaultSaveFileValues = saveFileValuesClass.getEnumConstants()) == null) {
            throw new RuntimeException(); // TODO...
        }

        for (int i = 0; i<defaultSaveFileValues.length; i++) {
            nameCell = saveDataNameRow.createCell(i);
            convertedNameCell = saveDataConvertedNameRow.createCell(i);
            saveFileValue = defaultSaveFileValues[i];

            saveFileValue.setupSaveDataNameCell(nameCell);
            saveFileValue.setupSaveDataConvertedNameCell(convertedNameCell);

        }

        super.resizeColumnsToFit();
        super.writeWorkbookToFile(fileAddress);
    }
}
