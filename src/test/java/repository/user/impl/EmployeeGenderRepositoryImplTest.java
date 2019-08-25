package repository.user.impl;

import domain.user.EmployeeGender;
import factory.user.EmployeeGenderFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.user.EmployeeGenderRepository;

import java.util.Set;

public class EmployeeGenderRepositoryImplTest {

    private EmployeeGenderRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = EmployeeGenderRepositoryImpl.getEmployeeGenderRepository();
    }


    @Test
    public void getAll() {

        Set<EmployeeGender> employeeSet = repository.getAll();
        Assert.assertNotNull(employeeSet);

    }

    @Test
    public void create() {

        EmployeeGender employee = EmployeeGenderFactory.buildEmployeeGender("A", "B");

        repository.create(employee);

        EmployeeGender inRepo = repository.read(employee.getEmpNumber());

        Assert.assertNotNull(inRepo);

    }

    @Test
    public void read() {

        EmployeeGender employee = EmployeeGenderFactory.buildEmployeeGender("FASDFASD", "AFSDFAS");

        repository.create(employee);

        EmployeeGender inRepo = repository.read(employee.getEmpNumber());

        Assert.assertNotNull(inRepo);
    }

    @Test
    public void update() {

        EmployeeGender employee = EmployeeGenderFactory.buildEmployeeGender("AFSDFAS", "ASDFASD");
        repository.create(employee);

        EmployeeGender updatedEmpGender = EmployeeGenderFactory.buildEmployeeGender("AFSDFAS", "ASDFAS");

        repository.update(updatedEmpGender);

        Assert.assertNotEquals(employee.getGenderId(), updatedEmpGender.getEmpNumber());

    }

    @Test
    public void delete() {

        EmployeeGender employee = EmployeeGenderFactory.buildEmployeeGender("ASDFAS", "ASDFASD");

        repository.create(employee);

        EmployeeGender inRepo = repository.read(employee.getEmpNumber());

        Assert.assertNotNull(inRepo);

        repository.delete(employee.getEmpNumber());

        EmployeeGender deleted = repository.read(employee.getEmpNumber());

        Assert.assertNull(deleted);

    }
}