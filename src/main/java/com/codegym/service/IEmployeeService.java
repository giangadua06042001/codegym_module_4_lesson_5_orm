package com.codegym.service;

import com.codegym.model.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> listEmployees();
    public Employee findById(int id);
    public  void remove(int id);
    public void updateEmployee(int id,Employee employee);
    public  void saveEmployee(Employee employee);



}
