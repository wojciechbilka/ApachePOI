import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ApachePOIReaderForLoop {

    public static List<Employee> readFile(String path, String sheetName) {
        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook(path);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        List<Employee> list = new ArrayList<>();
        XSSFSheet sheet = workbook.getSheet(sheetName);

        for(int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            list.add(new Employee(row.getCell(0).toString(),
                    row.getCell(1).toString(),
                    LocalDate.parse(row.getCell(2).toString())));
        }
        return list;
    }
}

