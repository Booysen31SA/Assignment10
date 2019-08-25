package service.demography;

import domain.demography.Gender;
import service.Service;

import java.util.Set;

public interface GenderService extends Service<Gender, String> {

    Set<Gender> getAll();
    Gender readByName(String desc);
}
