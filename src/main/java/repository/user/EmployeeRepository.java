package repository.user;

import domain.user.Employee;
import repository.Repository;

import java.util.Set;

public interface EmployeeRepository extends Repository<Employee, String> {

    Set<Employee> getAll();

}
