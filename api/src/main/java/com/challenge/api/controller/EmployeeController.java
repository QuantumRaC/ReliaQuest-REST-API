package com.challenge.api.controller;

import com.challenge.api.model.Employee;
import com.challenge.api.service.EmployeeService;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    // constructor injection
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * GET /api/v1/employee
     * Returns all employees
     */
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    /**
     * GET /api/v1/employee/{uuid}
     * Returns an employee by their UUID
     */
    @GetMapping("/{uuid}")
    public Employee getEmployeeByUuid(@PathVariable UUID uuid) {
        Employee foundEmployee = employeeService.getEmployeeByUuid(uuid);
        if(foundEmployee == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found.");
        }
        return employee;
    }

    /**
     * POST /api/v1/employee
     * Creates a new employee
     */
    @PostMapping
    public Employee createEmployee(@RequestBody Object requestBody) {
        Employee newEmployee = employeeService.createEmployee(requestBody);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEmployee);
    }
}
