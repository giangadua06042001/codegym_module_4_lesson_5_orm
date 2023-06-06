package com.codegym.service;

import com.codegym.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements IEmployeeService {
    private static List<Employee> employeeList;

    static {
        employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Nguyen Hai Son", "Ha Nam", "043534325", 50000, "url"));
        employeeList.add(new Employee(2, "Nguyen Hai Beo", "Ha Nam", "043534325", 50000, "url"));
        employeeList.add(new Employee(3, "Nguyen Hai Bien", "Ha Nam", "043534325", 50000, "url"));
        employeeList.add(new Employee(4, "Nguyen Hai Tu", "Ha Nam", "043534325", 50000, "url"));
    }

    @Override
    public List<Employee> listEmployees() {
        List<Employee> listEmployee = new ArrayList<>();
        for (Employee employee : employeeList) {
            listEmployee.add(employee);
        }
        return listEmployee;
    }

    @Override
    public Employee findById(int id) {
        Employee employee1 = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employee1 = employee;

            }
        }
        return employee1;
    }

    @Override
    public void remove(int id) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeList.remove(employee.getId());
            }

        }

    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        for (Employee employee1 : employeeList) {
            if(employee1.getId()==id){
                employeeList.add(employee1.getId(),employee1);
            }
        }
    }

    @Override
    public void saveEmployee(Employee employee) {
      employeeList.add(employee);
    }
}
