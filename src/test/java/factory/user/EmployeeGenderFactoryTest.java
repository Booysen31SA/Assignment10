package factory.user;

import domain.user.EmployeeGender;
import factory.user.EmployeeGenderFactory;
import org.junit.Assert;
import org.junit.Test;

public class EmployeeGenderFactoryTest {

    @Test
    public void buildEmployeeGender() {

        EmployeeGender employeeGender = EmployeeGenderFactory.buildEmployeeGender("A", "B");
        Assert.assertNotNull(employeeGender);

    }

}