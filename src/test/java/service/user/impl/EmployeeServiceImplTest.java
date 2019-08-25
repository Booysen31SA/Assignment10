package service.user.impl;

import domain.demography.Gender;
import domain.demography.Race;
import domain.user.Employee;
import domain.user.EmployeeGender;
import factory.demography.GenderFactory;
import factory.demography.RaceFactory;
import factory.user.EmployeeFactory;
import factory.user.EmployeeGenderFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.demography.GenderService;
import service.demography.RaceService;
import service.demography.impl.GenderServiceImpl;
import service.demography.impl.RaceServiceImpl;
import service.user.EmployeeService;

import java.util.Set;

public class EmployeeServiceImplTest {

    private EmployeeService service;
    private RaceService raceService;
    private GenderService genderService;

    @Before
    public void setUp() throws Exception {
        this.service = EmployeeServiceImpl.getService();
        raceService = RaceServiceImpl.getService();
        genderService = GenderServiceImpl.getService();
    }

    @Test
    public void getAll() {

        Set<Employee> employeeSet = service.getAll();
        Assert.assertNotNull(employeeSet);

    }

    @Test
    public void create() {

        Employee employee = EmployeeFactory.getEmployee("Riaz", "Khan");

        service.create(employee);

        Employee inRepo = service.read(employee.getEmpNumber());

        Assert.assertNotNull(inRepo);

    }

    @Test
    public void read() {

        Employee employee = EmployeeFactory.getEmployee("Riaz", "Khan");

        service.create(employee);

        Employee inRepo = service.read(employee.getEmpNumber());

        Assert.assertNotNull(inRepo);
    }

    @Test
    public void update() {

        Employee employee = EmployeeFactory.getEmployee("Riaz", "Khan");

        service.create(employee);
        Employee inRepo = service.read(employee.getEmpNumber());

        employee.setEmpFirstName("Not Riaz");

        service.update(employee);

        Assert.assertEquals(employee.getEmpNumber(), inRepo.getEmpNumber());

    }

    @Test
    public void delete() {

        Employee employee = EmployeeFactory.getEmployee("Riaz", "Khan");

        service.create(employee);

        Employee inRepo = service.read(employee.getEmpNumber());

        Assert.assertNotNull(inRepo);

        service.delete(employee.getEmpNumber());

        Employee deleted = service.read(employee.getEmpNumber());

        Assert.assertNull(deleted);

    }

    @Test
    public void createEmployee() {

        Race race = RaceFactory.buildRace("Indian");
        raceService.create(race);
        System.out.println(race);

        Gender gender = GenderFactory.buildGender("M");
        genderService.create(gender);
        System.out.println(gender);

        Employee employee = service.createEmployee("Riaz", "Khan", "M", "Indian");
        Assert.assertNotNull(employee);
    }



}