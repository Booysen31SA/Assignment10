package repository.employee.impl;

import domain.Employee;
import repository.employee.EmployeeRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EmployeeRepositoryImpl implements EmployeeRepository{



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

    public Employee read(Integer integer) {
        Employee employee = find(integer);
        return employee;
    }

    public Employee update(Employee employee) {

        Employee toDelete = read(employee.getEmpNumber());

        if(toDelete != null) {
            employees.remove(toDelete);
            return create(employee);
        }
        return null;
    }

    public void delete(Integer integer) {

        Employee toDelete = read(integer);
        if (toDelete != null){
            employees.remove(toDelete);
        }

    }

   public Employee find(int id) {
        return employees.stream().filter(employee -> employee.getEmpNumber() == id).findAny().orElse(null);
    }



}