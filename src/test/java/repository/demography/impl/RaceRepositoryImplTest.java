package repository.demography.impl;

import domain.demography.Race;
import factory.demography.RaceFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.demography.RaceRepository;

import java.util.Set;

public class RaceRepositoryImplTest {

    private RaceRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = RaceRepositoryImpl.getRaceRepository();
    }


    @Test
    public void getAll() {

        Set<Race> employeeSet = repository.getAll();
        Assert.assertNotNull(employeeSet);

    }

    @Test
    public void create() {

        Race employee = RaceFactory.buildRace("fa");

        repository.create(employee);

        Race inRepo = repository.read(employee.getRaceId());

        Assert.assertNotNull(inRepo);

    }

    @Test
    public void read() {

        Race employee = RaceFactory.buildRace("fa");

        repository.create(employee);

        Race inRepo = repository.read(employee.getRaceId());

        Assert.assertNotNull(inRepo);
    }

    @Test
    public void update() {

        Race employee = RaceFactory.buildRace("Indian");
        repository.create(employee);

        Race updatedRace =  RaceFactory.buildRace("White");

        repository.update(updatedRace);

        Assert.assertNotEquals(employee.getDesc(), updatedRace.getDesc());

    }

    @Test
    public void delete() {

        Race employee = RaceFactory.buildRace("fa");

        repository.create(employee);

        Race inRepo = repository.read(employee.getRaceId());

        Assert.assertNotNull(inRepo);

        repository.delete(employee.getRaceId());

        Race deleted = repository.read(employee.getRaceId());

        Assert.assertNull(deleted);

    }
}