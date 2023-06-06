package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class EmployeeForm {
    private int id;
    private String name;
    private String address;
    private String number;
    private double salary;
    private MultipartFile image;

    public EmployeeForm() {
    }

    public EmployeeForm(int id, String name, String address, String number, double salary, MultipartFile image) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.number = number;
        this.salary = salary;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
