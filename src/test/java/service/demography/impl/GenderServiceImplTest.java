package service.demography.impl;

import domain.demography.Gender;
import factory.demography.GenderFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.demography.GenderService;

import java.util.Set;

public class GenderServiceImplTest {

    private GenderService service;

    @Before
    public void setUp() throws Exception {
        this.service = GenderServiceImpl.getService();
    }

    @Test
    public void getAll() {

        Set<Gender> employeeSet = service.getAll();
        Assert.assertNotNull(employeeSet);

    }

    @Test
    public void create() {

        Gender employee = GenderFactory.buildGender("M");

        service.create(employee);

        Gender inRepo = service.read(employee.getGenderId());

        Assert.assertNotNull(inRepo);

    }

    @Test
    public void read() {

        Gender employee = GenderFactory.buildGender("M");

        service.create(employee);

        Gender inRepo = service.read(employee.getGenderId());

        Assert.assertNotNull(inRepo);
    }

    @Test
    public void update() {

        Gender employee = GenderFactory.buildGender("M");

        service.create(employee);
        Gender inRepo = service.read(employee.getGenderId());

        employee.setDesc("Not Riaz");

        service.update(employee);

        Assert.assertEquals(employee.getGenderId(), inRepo.getGenderId());

    }

    @Test
    public void delete() {

        Gender employee = GenderFactory.buildGender("M");

        service.create(employee);

        Gender inRepo = service.read(employee.getGenderId());

        Assert.assertNotNull(inRepo);

        service.delete(employee.getGenderId());

        Gender deleted = service.read(employee.getGenderId());

        Assert.assertNull(deleted);

    }

    @Test
    public void readByName() {

        Gender employee = GenderFactory.buildGender("M");

        service.create(employee);

        Gender gender2 = service.readByName("M");

        Assert.assertEquals(employee.getDesc(), gender2.getDesc());


    }
}