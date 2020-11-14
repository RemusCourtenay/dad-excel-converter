package dosStuff.fileCreators;

import dosStuff.fileCreators.FileCreator;

/**
 * @author Remus Courtenay - rcou199
 * @since 13/11/2020
 */
public class FormatTypesFileCreator extends FileCreator {

    private static final String DATA_TYPES_FILE_COMMENT = "todo"; // TODO...

    private static final String[][] DEFAULT_FORMAT_TYPES = {
            {"NAME", "=NOT(EXACT([cell],PROPER([cell]))"}
    };

    @Override
    public void runSetup() {

    }
}
