package repository.user.impl;

import domain.user.Employee;
import repository.user.EmployeeRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static EmployeeRepositoryImpl employeeRepository = null;
    private Set<Employee> employees;

    private EmployeeRepositoryImpl(){

        employees = new HashSet<Employee>();

    }


    public static EmployeeRepositoryImpl getEmployeeRepository() {

        if(employeeRepository == null){
            return new EmployeeRepositoryImpl();
        }

        return employeeRepository;
    }

    public Set<Employee> getAll() {

        return employees;

    }

    public Employee create(Employee employee) {

        employees.add(employee);

        return employee;

    }

    public Employee read(String id) {

        return employees.stream().filter(employee -> employee.getEmpNumber() == id).findAny().orElse(null);

    }

    public Employee update(Employee employee) {

        Employee toUpdate = read(employee.getEmpNumber());

        if(employees.contains(employee)){
            employees.remove(toUpdate);
            employees.add(employee);
        }

        return null;

    }

    public void delete(String integer) {

        Employee toDelete = read(integer);
        if (toDelete != null){
            employees.remove(toDelete);
        }

    }



}
