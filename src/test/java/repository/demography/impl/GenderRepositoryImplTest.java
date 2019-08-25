package repository.demography.impl;

import domain.demography.Gender;
import factory.demography.GenderFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.demography.GenderRepository;

import java.util.Set;

public class GenderRepositoryImplTest {

    private GenderRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = GenderRepositoryImpl.getGenderRepository();
    }


    @Test
    public void getAll() {

        Set<Gender> employeeSet = repository.getAll();
        Assert.assertNotNull(employeeSet);

    }

    @Test
    public void create() {

        Gender employee = GenderFactory.buildGender("M");

        repository.create(employee);

        Gender inRepo = repository.read(employee.getGenderId());

        Assert.assertNotNull(inRepo);

    }

    @Test
    public void read() {

        Gender employee = GenderFactory.buildGender("M");

        repository.create(employee);

        Gender inRepo = repository.read(employee.getGenderId());

        Assert.assertNotNull(inRepo);
    }

    @Test
    public void update() {

        Gender employee = GenderFactory.buildGender("M");
        repository.create(employee);

        Gender updatedEmployee = GenderFactory.buildGender("F");

        repository.update(updatedEmployee);

        Assert.assertNotEquals(employee.getDesc(), updatedEmployee.getDesc());

    }

    @Test
    public void delete() {

        Gender employee = GenderFactory.buildGender("M");

        repository.create(employee);

        Gender inRepo = repository.read(employee.getGenderId());

        Assert.assertNotNull(inRepo);

        repository.delete(employee.getGenderId());

        Gender deleted = repository.read(employee.getGenderId());

        Assert.assertNull(deleted);

    }
}