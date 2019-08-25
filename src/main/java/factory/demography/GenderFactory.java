package factory.demography;

import domain.demography.Gender;
import util.IdGenerator;

public class GenderFactory {

    public static Gender buildGender(String gender){

        return new Gender.Builder()
                .id(IdGenerator.generateId())
                .desc(gender)
                .build();

    }


}
