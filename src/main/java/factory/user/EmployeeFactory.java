package factory.user;

import domain.user.Employee;
import util.IdGenerator;

public class EmployeeFactory {

    public static Employee getEmployee(String fName, String lName ){

        return new Employee.Builder()
                .empNumber(IdGenerator.generateId())
                .empFirstName(fName)
                .empLastName(lName)
                .build();
    }

}
