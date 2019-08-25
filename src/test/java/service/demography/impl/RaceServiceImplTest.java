package service.demography.impl;

import domain.demography.Race;
import factory.demography.RaceFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.demography.RaceService;

import java.util.Set;

public class RaceServiceImplTest {

    private RaceService service;

    @Before
    public void setUp() throws Exception {
        this.service = RaceServiceImpl.getService();
    }

    @Test
    public void getAll() {

        Set<Race> employeeSet = service.getAll();
        Assert.assertNotNull(employeeSet);

    }

    @Test
    public void create() {

        Race employee = RaceFactory.buildRace("fa");

        service.create(employee);

        Race inRepo = service.read(employee.getRaceId());

        Assert.assertNotNull(inRepo);

    }

    @Test
    public void read() {

        Race employee = RaceFactory.buildRace("fa");

        service.create(employee);

        Race inRepo = service.read(employee.getRaceId());

        Assert.assertNotNull(inRepo);
    }

    @Test
    public void update() {

        Race employee = RaceFactory.buildRace("fa");

        service.create(employee);
        Race inRepo = service.read(employee.getRaceId());

        employee.setDesc("Not Riaz");

        service.update(employee);

        Assert.assertEquals(employee.getRaceId(), inRepo.getRaceId());

    }

    @Test
    public void delete() {

        Race employee = RaceFactory.buildRace("fa");

        service.create(employee);

        Race inRepo = service.read(employee.getRaceId());

        Assert.assertNotNull(inRepo);

        service.delete(employee.getRaceId());

        Race deleted = service.read(employee.getRaceId());

        Assert.assertNull(deleted);

    }

    @Test
    public void readByName() {

        Race employee = RaceFactory.buildRace("fa");

        service.create(employee);

        Race gender2 = service.readByName("fa");

        Assert.assertEquals(employee.getDesc(), gender2.getDesc());

    }
}