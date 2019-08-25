package factory.demography;

import domain.demography.Gender;
import factory.demography.GenderFactory;
import org.junit.Assert;
import org.junit.Test;

public class GenderFactoryTest {

    @Test
    public void getGender() {

        Gender gender = GenderFactory.buildGender("M");
        Assert.assertNotNull(gender);

    }
}