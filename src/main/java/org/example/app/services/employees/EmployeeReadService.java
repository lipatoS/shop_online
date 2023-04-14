package org.example.app.services.employees;

import org.example.app.entities.Employee;
import org.example.app.entities.Position;
import org.example.app.repositories.employees.EmployeeReadRepository;
import org.example.app.utils.Constants;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class EmployeeReadService {
    EmployeeReadRepository repository;

    public EmployeeReadService(EmployeeReadRepository repository) {
        this.repository = repository;
    }

    public String readEmployees() {

        // Получаем данные в коллекцию.
        List<Employee> list = repository.readEmployees();

        // Если коллекция не null, формируем вывод.
        // Иначе уведомление об отсутствии данных.
        if (list != null) {
            // Если коллекция не пуста, формируем вывод.
            // Иначе уведомление об отсутствии данных.
            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder stringBuilder = new StringBuilder();
                list.forEach((prop) ->
                        stringBuilder.append(count.incrementAndGet())
                                .append(") id: ")
                                .append(prop.getId())
                                .append(", ")
                                .append("last name: ")
                                .append(prop.getLastName())
                                .append(", ")
                                .append("first name: ")
                                .append(prop.getFirstName())
                                .append(", ")
                                .append("birth date: ")
                                .append(prop.getBirthDate())
                                .append(", ")
                                .append("position id: ")
                                .append(prop.getPositionId())
                                .append(", ")
                                .append("phone: ")
                                .append(prop.getPhone())
                                .append(", ")
                                .append("salary: ")
                                .append(prop.getSalary())
                                .append("\n")

                );
                return stringBuilder.toString();
            } else return Constants.DATA_ABSENT_MSG;
        } else return Constants.DATA_ABSENT_MSG;
    }
}
