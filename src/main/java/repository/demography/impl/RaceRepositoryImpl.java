package repository.demography.impl;

import domain.demography.Race;
import repository.demography.RaceRepository;

import java.util.HashSet;
import java.util.Set;

public class RaceRepositoryImpl implements RaceRepository {

    private static RaceRepositoryImpl raceRepository = null;
    private Set<Race> races;

    public RaceRepositoryImpl(){

        races = new HashSet<Race>();

    }

    public static RaceRepositoryImpl getRaceRepository() {

        if(raceRepository == null){
            return new RaceRepositoryImpl();
        }

        return raceRepository;
    }

    @Override
    public Set<Race> getAll() {
        return races;
    }

    @Override
    public Race create(Race race) {
        races.add(race);
        return race;
    }

    @Override
    public Race read(String id) {

        return races.stream().filter(race -> race.getRaceID() == id).findAny().orElse(null);
    }

    @Override
    public Race update(Race race) {

        Race raceToDelete = read(race.getRaceID());

        if(raceToDelete != null) {
            races.remove(raceToDelete);
            return create(race);
        }
        return null;
    }

    @Override
    public void delete(String id) {
        Race raceToDelete = read(id);

        if(raceToDelete != null) {
            races.remove(raceToDelete);
        }
    }

    //method which will search the set/db for the corresponding gender
    public Race readByName(String raceDesc){
        //do the logic to get the gender
        return races.stream().filter(race -> race.getDesc().equals(raceDesc)).findAny().orElse(null);
    }

}
