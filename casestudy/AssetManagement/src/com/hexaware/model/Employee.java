package com.hexaware.model;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private String email;
    private String password;

    public Employee(int employeeId, String name, String department, String email, String password) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.email = email;
        this.password = password;
    }

    public Employee() {}

    // Getters and Setters

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

