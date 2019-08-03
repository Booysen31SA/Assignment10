package repository.user;

import domain.user.EmployeeGender;
import repository.Repository;

import java.util.Set;

public interface EmployeeGenderRepository extends Repository<EmployeeGender, Integer> {

    Set<EmployeeGender> getAll();

}
