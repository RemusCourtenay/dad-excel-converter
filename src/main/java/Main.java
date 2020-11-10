import dosStuff.SettingsSetup;

import java.io.IOException;
import java.util.Map;

/**
 * @author Remus Courtenay - rcou199
 * @since 4/11/2020
 */
public class Main {

    public static void main(String[] args) throws IOException {

        new SettingsSetup().runSetup();

        new RaceDataConverter();
    }


}
