package service.user;

import domain.user.EmployeeGender;
import service.Service;

import java.util.Set;

public interface EmployeeGenderService extends Service<EmployeeGender, String> {

    Set<EmployeeGender> getAll();
}
