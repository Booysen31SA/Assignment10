package service.user;

import domain.user.Employee;
import domain.user.EmployeeGender;
import service.Service;

import java.util.Set;

public interface EmployeeService extends Service<Employee, String> {

    Set<Employee> getAll();
    Employee createEmployee(String firstName, String lastName, String race, String gender);

}
