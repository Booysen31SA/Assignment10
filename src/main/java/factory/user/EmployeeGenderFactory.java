package factory.user;

import domain.user.EmployeeGender;

public class EmployeeGenderFactory {

    public static EmployeeGender buildEmployeeGender(String empId, String genderId){

        return new EmployeeGender().employeeGender(empId, genderId);
    }

}
