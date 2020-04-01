import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Example {
    private static final String FILE_PATH = "src/main/resources/DataFile.xlsx";

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", "Cena", LocalDate.of(1993, 2, 21)),
                new Employee("Alec", "White", LocalDate.of(1978, 3, 12)),
                new Employee("Pablo", "Coelo", LocalDate.of(1911, 2, 11))
        );
        List<Employee> readList;
        ApachePOIWriter.creatingFile(employees, FILE_PATH);
        readList = ApachePOIReader.readFile(FILE_PATH, "Employees");
        System.out.println(readList);
    }
}
