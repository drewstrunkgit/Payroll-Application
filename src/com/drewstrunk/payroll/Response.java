package com.drewstrunk.payroll;

import java.util.Map;

public class Response {
    Map<String, Employee> employees;

    public Map<String, Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Map<String, Employee> employees) {
        this.employees = employees;
    }
}
