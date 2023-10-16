import org.junit.Test;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class EmployeeTest {
    @Test
    public void createEmployeeTest() {
        String name = "Maxim";
        String surname = "Bebronuh";
        double salary = 1000;

        Employee testEmp = null;

        try{
            testEmp = new Employee(name, surname, salary);
        }
        catch (FieldLengthLimitException ex){
            Logger.getLogger(EmployeeTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        assertEquals(name, testEmp.getName());
        assertEquals(surname, testEmp.getSurname());
        assertEquals(salary, testEmp.getSalary(), 0.00001);
    }

    @Test
    public void exceptionTestName(){
        String name = "hbjrnbjknrfkjdnjknjvknfjkfnbnfgbknfd";
        String surname = "Bebronuh";
        double salary = 1000;

        FieldLengthLimitException thrown = assertThrows(FieldLengthLimitException.class, () -> new Employee(name, surname, salary));

        assertTrue(thrown.getMessage().contains("Too much symbols in name!\n"));
    }

    @Test
    public void exceptionTestSurname(){
        String name = "Maxim";
        String surname = "dfbvjhbvjkdfvbjjdfvbfvbfbvnjfvbjnfb";
        double salary = 1000;

        FieldLengthLimitException thrown = assertThrows(FieldLengthLimitException.class, () -> new Employee(name, surname, salary));

        assertTrue(thrown.getMessage().contains("Too much symbols in surname!\n"));
    }

    @Test
    public void exceptionTestSalary(){
        String name = "Maxim";
        String surname = "Bebronuh";
        double salary = -1000;

        FieldLengthLimitException thrown = assertThrows(FieldLengthLimitException.class, () -> new Employee(name, surname, salary));

        assertTrue(thrown.getMessage().contains("Salary cannot be negative!\n"));
    }

    @Test
    public void exceptionTestSalary2(){
        String name = "Maxim";
        String surname = "Bebronuh";
        double salary = 3500;

        FieldLengthLimitException thrown = assertThrows(FieldLengthLimitException.class, () -> new Employee(name, surname, salary));

        assertTrue(thrown.getMessage().contains("Salary cannot be so big!\n"));
    }
}

