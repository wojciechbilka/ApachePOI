import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApachePOIReaderIterator {

    public static List<Employee> readFile(String path, String sheetName) {
        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook(path);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        Iterator<Row> rowIterator;
        List<Employee> list = new ArrayList<>();
        XSSFSheet sheet = workbook.getSheet(sheetName);
        rowIterator = sheet.rowIterator();
        if (rowIterator.hasNext()) {
            rowIterator.next();
            rowIterator.forEachRemaining(row -> {
                list.add(new Employee(row.getCell(0).toString(),
                        row.getCell(1).toString(),
                        LocalDate.parse(row.getCell(2).toString())));
            });
        }
        return list;
    }
}
