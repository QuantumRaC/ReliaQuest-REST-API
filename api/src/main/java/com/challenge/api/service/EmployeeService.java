package com.challenge.api.service;

import java.time.Instant;
import java.util.*;

import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeImplementation;
import org.springframework.stereotype.Service;

/**
 * Service layer containing business logic for Employee operations;
 * Also provides mock data handling for this challenge.
 */
@Service
public class EmployeeService {
    /**
     * Simulates data storage of all Employees temporarily,
     * Stocks mock Employee objects keyed by UUID for this challenge.
     * In production can be replaced by a DB
     */
    private final Map<UUID, Employee> employeeRepo = new HashMap<>();

    public EmployeeService() {
        // mock employee data
        EmployeeImplementation e1 = new EmployeeImplementation();
        e1.setUuid(UUID.randomUUID());
        e1.setFirstName("Peter");
        e1.setLastName("Parker");
        e1.setFullName("Peter Parker");
        e1.setAge(40);
        e1.setSalary(10000);
        e1.setJobTitle("Spider Man");
        e1.setEmail("peter@spiderman.com");
        e1.setContractHireDate(Instant.now());
        employeeRepo.put(e1.getUuid(), e1);
    }

    public List<Employee> getAllEmployees(){
        List<Employee> allEmployees = new ArrayList<Employee>(employeeRepo.values());
        return allEmployees;
    }

    public Employee getEmployeeByUuid(UUID uuid) {
        // returns null if the uuid doesn't correspond to any existing employee
        return employeeRepo.get(uuid);
    }

    public Employee createEmployee(EmployeeImplementation employee) {
        employee.setUuid(UUID.randomUUID());
        employee.setContractHireDate(Instant.now()); // assuming creating the employee is upon hiring
        employeeRepo.put(employee.getUuid(), employee);
        return employee;
    }
}

