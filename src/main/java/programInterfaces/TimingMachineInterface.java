package programInterfaces;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TimingMachineInterface extends ProgramInterface {

    private static final String WORKBOOK_OUT_NAME = "timing-software-generated.xlsx";
    private static final Path WORKBOOK_PATH = Paths.get(PROGRAM_INTERFACE_FOLDER_NAME + WORKBOOK_OUT_NAME);

    public TimingMachineInterface(File saveDataFile) {
        super(saveDataFile);
    }

    @Override
    protected Path getWorkbookPath() {
        return WORKBOOK_PATH;
    }
}
