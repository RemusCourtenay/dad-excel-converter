package fakeEnums;

import dosStuff.FileIOThreadManager;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public abstract class FakeEnumBuilder{ // TODO... comment

    public abstract void setupEnumFromFile(File saveDataFile);

}
