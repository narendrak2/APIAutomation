package Airlines;

import Airlines.Pojos.Airline;
import Airlines.Pojos.AirlinePoiji;
import Airlines.Pojos.airlinepoiji1;
import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Poijitest {

    public static void main(String[] args) throws IOException {


        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings().addListDelimiter(";").build();
        List<airlinepoiji1> data = Poiji.fromExcel(new File("/Users/narendra/eclipse-workspace/APIAutomation/src/main/resources/Aldar123.xlsx"), airlinepoiji1.class, options);
        System.out.println("index value " + data.get(0));
        FileInputStream fs = new FileInputStream("/Users/narendra/eclipse-workspace/APIAutomation/src/main/resources/Aldar123.xlsx");
//Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);
        //HSSFSheet sheet=wb.getSheet("STUDENT_DATA");
        System.out.println("File Path: " + new File("/Users/narendra/eclipse-workspace/APIAutomation/src/main/resources/Aldar123.xlsx").getAbsolutePath());

        //get all rows in the sheet
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

        //iterate over all the row to print the data present in each cell.
        for (int i = 0; i <= rowCount; i++) {

            //get cell count in a row
            int cellcount = sheet.getRow(i).getLastCellNum();

            //iterate over each cell to print its value
            System.out.println("Row" + i + " data is :");

            for (int j = 0; j < cellcount; j++) {
                System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() + ",");
            }
            System.out.println();
        }
    }
}