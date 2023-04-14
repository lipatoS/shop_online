package org.example.app.services.employees;

import org.example.app.controllers.employees.EmployeeCreateController;
import org.example.app.controllers.employees.EmployeeReadController;
import org.example.app.exceptions.OptionException;
import org.example.app.repositories.employees.EmployeeCreateRepository;
import org.example.app.repositories.employees.EmployeeReadRepository;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.database.views.employees.EmployeeCreateView;
import org.example.app.database.views.employees.EmployeeReadView;

public class EmployeeService {
    public void createEmployee() {
        EmployeeCreateRepository repository = new EmployeeCreateRepository();
        EmployeeCreateService service = new EmployeeCreateService(repository);
        EmployeeCreateView view = new EmployeeCreateView();
        EmployeeCreateController controller = new EmployeeCreateController(service, view);
        controller.createEmployee();
    }

    public void readEmployees() {
        EmployeeReadRepository repository = new EmployeeReadRepository();
        EmployeeReadService service = new EmployeeReadService(repository);
        EmployeeReadView view = new EmployeeReadView();
        EmployeeReadController controller = new EmployeeReadController(service, view);
        controller.readEmployee();
    }

    public void getNoSuchOption(int choice) {
        int[] menuChoices = {0, 1, 2};
        if (!contains(menuChoices, choice)) {
            try {
                throw new OptionException(Constants.INCORRECT_VALUE_MSG);
            } catch (OptionException e) {
                System.out.println(e.getMessage());
                AppStarter.startApp();
            }
        }
    }

    public static boolean contains(final int[] options, final int value) {
        boolean result = false;
        for (int i : options) {
            if (i == value) {
                result = true;
                break;
            }
        }
        return result;
    }
}
