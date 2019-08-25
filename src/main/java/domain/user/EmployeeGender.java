package domain.user;

public class EmployeeGender {

    private String genderId;
    private String empNumber;

    public EmployeeGender(){

    }

    public String getGenderId() {
        return genderId;
    }

    public void setGenderId(String genderId) {
        this.genderId = genderId;
    }

    public String getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    public EmployeeGender employeeGender(String empNumber, String genderId){


        this.empNumber = empNumber;
        this.genderId = genderId;
        return this;


    }

    @Override
    public String toString() {
        return "EmployeeGender{" +
                "empNumber='" + empNumber + '\'' +
                ", genderId='" + genderId + '\'' +
                '}';
    }

}
