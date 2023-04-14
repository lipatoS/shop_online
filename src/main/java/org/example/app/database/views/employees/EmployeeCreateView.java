package org.example.app.database.views.employees;

import org.example.app.entities.Employee;

import java.util.Scanner;

public class EmployeeCreateView {
    public Employee getData() {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();

        String lastName = "Enter last name: ";
        System.out.print(lastName);
        employee.setLastName(scanner.nextLine().trim());

        String firstName = "Enter first name: ";
        System.out.print(firstName);
        employee.setFirstName(scanner.nextLine().trim());

        String birthDate = "Enter birth date: ";
        System.out.print(birthDate);
        employee.setBirthDate(scanner.nextLine().trim());

        String positionId = "Enter position id: ";
        System.out.print(positionId);
        employee.setPositionId(scanner.nextInt());
        scanner.nextLine();

        String phone = "Enter phone: ";
        System.out.print(phone);
        employee.setPhone(scanner.nextLine().trim());

        String salary = "Enter salary: ";
        System.out.print(salary);
        employee.setSalary(scanner.nextDouble());

        return employee;
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
