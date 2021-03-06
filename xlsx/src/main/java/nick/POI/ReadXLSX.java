package nick.POI;

/**
 * Created by Nick Taylor on 1/8/2017.
 */

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ReadXLSX {

    public static ArrayList<XSSFCell> readXLSXFile() throws IOException {


        ArrayList<XSSFCell> data = new ArrayList<XSSFCell>();
        FileInputStream fis = new FileInputStream(new File("\\\\NicksWhiteBox\\d\\xlsx\\DatabaseInject.xlsx"));
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFWorkbook test = new XSSFWorkbook();
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row = null;
        XSSFCell cell;
        Iterator rows = sheet.rowIterator();

        XSSFCell name = wb.getSheetAt(0).getRow(0).getCell(0);
        XSSFCell name2 = wb.getSheetAt(0).getRow(1).getCell(0);
        XSSFCell cost = wb.getSheetAt(0).getRow(0).getCell(1);
        XSSFCell cost2 = wb.getSheetAt(0).getRow(1).getCell(1);
        XSSFCell name3 = wb.getSheetAt(0).getRow(2).getCell(0);
        XSSFCell cost3 = wb.getSheetAt(0).getRow(2).getCell(1);

        data.add(name);
        data.add(name2);
        data.add(cost);
        data.add(cost2);

        System.out.println(name + " " +  " " + cost + " ");
        System.out.println(name2 + " " +  " " + cost2 + " ");
        System.out.println(name3 + " makes " +  " " + cost3 + " an hour ");

        return data;
    }
}