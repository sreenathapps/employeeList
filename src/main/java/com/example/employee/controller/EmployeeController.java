package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeJpaService;

/**
 * EmployeeController
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeJpaService employeeJpaService;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeJpaService.getEmployees();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeJpaService.addEmployee(employee);
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") int employeeId) {
        return employeeJpaService.getEmployeeById(employeeId);
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updatEmployee(@PathVariable int employeeId, @RequestBody Employee employee) {
        return employeeJpaService.updatEmployee(employeeId, employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        employeeJpaService.deleteEmployee(employeeId);
        throw new ResponseStatusException(HttpStatus.OK);
    }

}