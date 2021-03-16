package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeManagerTest {

    @DisplayName("Handles paying the correct number of employees")
    @Test
    void payEmployeesCount() {
        EmployeeRepositoryDummy erd = new EmployeeRepositoryDummy();

        assertEquals(0, new EmployeeManager(
                erd,
                new BankServiceDummy()).payEmployees());

        erd.employees = Arrays.asList(
                new Employee("1", 20000),
                new Employee("2", 30000));

        assertEquals(2, new EmployeeManager(
                erd,
                new BankServiceDummy()).payEmployees());
    }

    @DisplayName("Handles paying all employees")
    @Test
    void payEmployeesPaid() {
        EmployeeRepositoryDummy erd = new EmployeeRepositoryDummy();
        erd.employees = Arrays.asList(new Employee("1", 20000), new Employee("2", 30000));

        new EmployeeManager(
                erd,
                new BankServiceDummy()).payEmployees();

        assertTrue(erd.employees.stream().allMatch(Employee::isPaid));
    }

    @DisplayName("Mockito: Handles paying the correct amount of employees")
    @Test
    void payEmployeesMock() {
        EmployeeRepository er = Mockito.mock(EmployeeRepository.class);
        Mockito.when(er.findAll()).thenReturn(Arrays.asList(new Employee("1", 20000), new Employee("2", 30000)));

        BankService bs = Mockito.mock(BankService.class);

        assertEquals(2, new EmployeeManager(er, bs).payEmployees());
    }

}