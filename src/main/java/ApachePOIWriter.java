import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ApachePOIWriter {

    public static void creatingFile(List<Employee> employeeList, String filePath) {
        int rowIndex = 0;
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Employees");
        Row row = sheet.createRow(rowIndex);

        row.createCell(0).setCellValue("Name:");
        row.createCell(1).setCellValue("Surname:");
        row.createCell(2).setCellValue("Date if birth:");

        for (Employee e : employeeList) {
            rowIndex++;
            row = sheet.createRow(rowIndex);
            row.createCell(0).setCellValue(e.getName());
            row.createCell(1).setCellValue(e.getSurname());
            row.createCell(2).setCellValue(e.getBirthDate().toString());
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            workbook.write(fileOutputStream);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
