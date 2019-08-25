package factory.demography;

import domain.demography.Race;
import util.IdGenerator;

public class RaceFactory {

    public static Race buildRace(String desc){

        return new Race.Builder()
                .raceID(IdGenerator.generateId())
                .desc(desc)
                .build();

    }



}
