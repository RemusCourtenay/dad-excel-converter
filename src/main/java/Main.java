import dosStuff.FileCreatorType;
import dosStuff.SettingsCreator;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Remus Courtenay - rcou199
 * @since 4/11/2020
 */
public class Main {

    public static void main(String[] args) throws IOException {

        runFileSetup();

        new RaceDataConverter();
    }

    private static void runFileSetup() {
        for (FileCreatorType creatorType: FileCreatorType.values()) {
            try {
                creatorType.getFileCreatorClass().getConstructor().newInstance().runSetup();
            } catch(NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException exception) {
                exception.printStackTrace();
                throw new RuntimeException("FileCreatorType Enum value: " + creatorType.toString() + " not setup correctly");
            }

        }
    }


}
