import dosStuff.FileIOThreadManager;

import java.util.List;

public class ColumnFormatsBuilder {

    public static void setupFormatsFromFile(FileIOThreadManager fileManager) {
        List<String[]> fileData = fileManager.readFile();
        new ColumnFormats(fileData);
    }


}
