package dosStuff.fileCreators;

import dosStuff.fileCreators.defaultValues.DefaultSpecificLayoutValues;
import helpers.WorkbookHelper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.nio.file.Path;

public class SpecificLayoutSaveFileCreator <saveFileType extends DefaultSpecificLayoutValues> extends SaveDataFileCreator {

    private final Class<saveFileType> saveFileValuesClass;

    public SpecificLayoutSaveFileCreator(Class<saveFileType> saveFileValuesClass){
        this.saveFileValuesClass = saveFileValuesClass;
    };

    @Override
    public void createDefaultFile(Path filePath) {
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

        WorkbookHelper.resizeColumnsToFit(saveDataSheet);
        WorkbookHelper.writeWorkbookToFile(filePath, saveDataWorkbook);
    }
}
