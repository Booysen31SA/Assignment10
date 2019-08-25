package service.user.impl;

import domain.user.EmployeeGender;
import repository.user.EmployeeGenderRepository;
import repository.user.impl.EmployeeGenderRepositoryImpl;
import service.user.EmployeeGenderService;

import java.util.Set;

public class EmployeeGenderServiceImpl implements EmployeeGenderService {

    private static EmployeeGenderServiceImpl service = null;
    private EmployeeGenderRepository repository;

    public EmployeeGenderServiceImpl() {
        repository = EmployeeGenderRepositoryImpl.getEmployeeGenderRepository();
    }

    public static EmployeeGenderServiceImpl getService(){

        if(service == null){
            return new EmployeeGenderServiceImpl();
        }
        return service;
    }

    @Override
    public Set<EmployeeGender> getAll() {
        return repository.getAll();
    }

    @Override
    public EmployeeGender create(EmployeeGender employeeGender) {
        return repository.create(employeeGender);
    }

    @Override
    public EmployeeGender read(String id) {
        return repository.read(id);
    }

    @Override
    public EmployeeGender update(EmployeeGender employeeGender) {
        return repository.update(employeeGender);
    }

    @Override
    public void delete(String id) {

        repository.delete(id);

    }
}
