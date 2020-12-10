import dosStuff.FileIOThreadManager;

import java.util.List;

public class ColumnConditionalFormatsBuilder {

    public static void setupConditionalFormatsFromFile(FileIOThreadManager fileManager) {
        List<String[]> fileData = fileManager.readFile();
        new ColumnConditionalFormats(fileData);
    }

}
