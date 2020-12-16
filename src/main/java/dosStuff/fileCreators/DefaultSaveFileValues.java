package dosStuff.fileCreators;

import org.apache.poi.ss.usermodel.Cell;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public interface DefaultSaveFileValues {

    String DEFAULT_NAME = "default-name";
    String DEFAULT_EXAMPLE_VALUE = "";

    String DEFAULT_FORMAT = "General";
    DateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    String DEFAULT_CONDITIONAL_FORMAT = null;
    public void setupSaveDataNameCell(Cell nameCell);
}
