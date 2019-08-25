package factory.demography;

import domain.demography.Race;
import factory.demography.RaceFactory;
import org.junit.Assert;
import org.junit.Test;

public class RaceFactoryTest {

    @Test
    public void buildRace() {

        Race race = RaceFactory.buildRace("African");
        Assert.assertNotNull(race);


    }
}