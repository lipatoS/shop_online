package org.example.app.controllers.employees;

import org.example.app.entities.Employee;
import org.example.app.services.employees.EmployeeCreateService;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Constants;
import org.example.app.database.views.employees.EmployeeCreateView;

public class EmployeeCreateController {
    EmployeeCreateView view;
    Employee employee;
    EmployeeCreateService service;

    public EmployeeCreateController(EmployeeCreateService service, EmployeeCreateView view) {
        this.service = service;
        this.view = view;
    }

    public void createEmployee() {
        // Получаем входные данные.
        employee = view.getData();
        // Передаем данные на обработку и получаем сообщение.
        String str = service.createEmployee(employee);
        // Проверяем сообщение на внесение данных.
        // Если что-то не так, выводим сообщение об этом, и закрываем приложение.
        // Иначе выводим сообщение и перезапускаем приложение.
        if (str.equals(Constants.SMTH_WRONG_MSG)) {
            // Выводим уведомление.
            view.getOutput(str);
            // Закрываем приложение.
            System.exit(0);
        } else {
            // Выводим уведомление.
            view.getOutput(str);
            // Перезапускаем приложение.
            AppStarter.startApp();
        }
    }
}

