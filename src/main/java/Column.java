import org.apache.poi.ss.usermodel.CellType;

/**
 * @author Remus Courtenay - rcou199
 * @since 10/11/2020
 */
public class Column {

    private String headerText;
    private CellType cellType;

    public Column(String[] args) {

        this.headerText = args[0];
        this.cellType = CellType.valueOf(args[1]);

    }


}
