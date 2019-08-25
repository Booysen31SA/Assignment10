package controller;

import domain.demography.Gender;
import domain.demography.Race;
import domain.user.Employee;
import factory.demography.GenderFactory;
import factory.demography.RaceFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.demography.GenderService;
import service.demography.RaceService;
import service.demography.impl.GenderServiceImpl;
import service.demography.impl.RaceServiceImpl;

import static org.junit.Assert.*;

public class EmployeeControllerTest {

    private EmployeeController controller;
    private RaceService raceService;
    private GenderService genderService;

    @Before
    public void setUp(){
        controller = new EmployeeController();
        raceService = RaceServiceImpl.getService();
        genderService = GenderServiceImpl.getService();
    }

    @Test
    public void createEmployee() {

        Race race = RaceFactory.buildRace("Indian");
        raceService.create(race);

        Gender gender = GenderFactory.buildGender("M");
        genderService.create(gender);

        Employee employee = controller.createEmployee("Riaz", "Khan", "M", "Indian");
        Assert.assertNotNull(employee);
    }
}