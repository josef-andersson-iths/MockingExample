package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryDummy implements EmployeeRepository {

    List<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> findAll() {
        return this.employees;
    }

    @Override
    public Employee save(Employee e) {
        return null;
    }

}
