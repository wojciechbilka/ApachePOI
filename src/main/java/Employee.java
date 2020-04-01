import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Employee {

    private String name;
    private String surname;
    private LocalDate birthDate;

    @Override
    public String toString() {
        return "Employee: " +
                "name= " + name + '\'' +
                ", surname= " + surname + '\'' +
                ", birthDate= " + birthDate;
    }
}
