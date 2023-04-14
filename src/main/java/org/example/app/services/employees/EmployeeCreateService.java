package org.example.app.services.employees;

import org.example.app.entities.Employee;
import org.example.app.exceptions.EmployeeCreateException;
import org.example.app.repositories.employees.EmployeeCreateRepository;
import org.example.app.utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class EmployeeCreateService {

    EmployeeCreateRepository repository;

    public EmployeeCreateService(EmployeeCreateRepository repository) {
        this.repository = repository;
    }

    public String createEmployee(Employee employee) {

        // Map для сбора ошибок
        Map<String, String> errors = new HashMap<>();

        if (employee.getLastName().isEmpty())
            errors.put("last name", Constants.INPUT_REQ_MSG);
        if (employee.getFirstName().isEmpty())
            errors.put("first name", Constants.INPUT_REQ_MSG);
        if (employee.getBirthDate().isEmpty())
            errors.put("birth date", Constants.INPUT_REQ_MSG);
        if (employee.getPositionId() < 0)
            errors.put("position id", Constants.INPUT_REQ_MSG);
        if (employee.getPhone().isEmpty())
            errors.put("phone", Constants.INPUT_REQ_MSG);
        if (employee.getSalary() <= 0)
            errors.put("salary", Constants.INPUT_REQ_MSG);
        if (errors.size() > 0) {
            try {
                throw new EmployeeCreateException("Check inputs", errors);
            } catch (EmployeeCreateException e) {
                return e.getErrors(errors);
            }
        }

        return repository.createEmployee(employee);
    }
}
