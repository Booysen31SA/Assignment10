package service.user.impl;

import domain.user.EmployeeGender;
import factory.user.EmployeeGenderFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.user.EmployeeGenderService;

import java.util.Set;

import static org.junit.Assert.*;

public class EmployeeGenderServiceImplTest {

    private EmployeeGenderService service;

    @Before
    public void setUp() throws Exception {
        this.service = EmployeeGenderServiceImpl.getService();
    }

    @Test
    public void getAll() {

        Set<EmployeeGender> employeeSet = service.getAll();
        Assert.assertNotNull(employeeSet);

    }

    @Test
    public void create() {

        EmployeeGender employee = EmployeeGenderFactory.buildEmployeeGender("FASDF", "AFSDF");

        service.create(employee);

        EmployeeGender inRepo = service.read(employee.getEmpNumber());

        Assert.assertNotNull(inRepo);

    }

    @Test
    public void read() {

        EmployeeGender employee = EmployeeGenderFactory.buildEmployeeGender("Asdfas", "ASdfas");

        service.create(employee);

        EmployeeGender inRepo = service.read(employee.getEmpNumber());

        Assert.assertNotNull(inRepo);
    }

    @Test
    public void update() {

        EmployeeGender employee = EmployeeGenderFactory.buildEmployeeGender("ASDf", "Asdfasdf");

        service.create(employee);
        EmployeeGender inRepo = service.read(employee.getEmpNumber());

        employee.setEmpNumber("asdf");

        service.update(employee);

        Assert.assertEquals(employee.getEmpNumber(), inRepo.getEmpNumber());

    }

    @Test
    public void delete() {

        EmployeeGender employee = EmployeeGenderFactory.buildEmployeeGender("ASdf", "ASdf");

        service.create(employee);

        EmployeeGender inRepo = service.read(employee.getEmpNumber());

        Assert.assertNotNull(inRepo);

        service.delete(employee.getEmpNumber());

        EmployeeGender deleted = service.read(employee.getEmpNumber());

        Assert.assertNull(deleted);

    }
}