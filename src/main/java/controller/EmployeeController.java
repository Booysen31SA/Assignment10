package controller;

import domain.user.Employee;
import service.user.EmployeeService;
import service.user.impl.EmployeeServiceImpl;

public class EmployeeController {

    private EmployeeService employeeService = EmployeeServiceImpl.getService();

    public Employee createEmployee(String fName, String lName, String gender, String race){

        return employeeService.createEmployee(fName, lName, gender, race);

    }
}
