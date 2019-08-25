package service.demography;

import domain.demography.Race;
import service.Service;

import java.util.Set;

public interface RaceService extends Service<Race, String> {

    Set<Race> getAll();
    Race readByName(String genderDesc);

}
