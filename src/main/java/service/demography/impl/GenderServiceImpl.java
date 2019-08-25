package service.demography.impl;

import domain.demography.Gender;
import repository.demography.GenderRepository;
import repository.demography.impl.GenderRepositoryImpl;
import service.demography.GenderService;

import java.util.Set;

public class GenderServiceImpl implements GenderService {

    private static GenderServiceImpl service = null;
    private GenderRepository repository;

    public GenderServiceImpl() {
        repository = GenderRepositoryImpl.getGenderRepository();
    }

    public static GenderServiceImpl getService(){

        if(service == null){
            return new GenderServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Gender> getAll() {
        return repository.getAll();
    }

    @Override
    public Gender create(Gender gender) {
        return repository.create(gender);
    }

    @Override
    public Gender read(String id) {
        return repository.read(id);
    }

    @Override
    public Gender update(Gender gender) {
        return repository.update(gender);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }

    @Override
    //method which will search the set/db for the corresponding gender
    public Gender readByName(String genderDesc){
        //do the logic to get the gender
        return repository.getAll()
                .stream()
                .filter(gender -> gender.getDesc().equals(genderDesc))
                .findAny().orElse(null);
    }



}
