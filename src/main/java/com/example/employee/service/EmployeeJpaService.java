package com.example.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeJpaRepository;
import com.example.employee.repository.EmployeeRepository;

/**
 * EmployeeJpaService
 */
@Service
public class EmployeeJpaService implements EmployeeRepository {

    @Autowired
    EmployeeJpaRepository employeeJpaRepository;

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = employeeJpaRepository.findAll();
        return employees;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeId(0);
        employeeJpaRepository.save(employee);
        return employee;
    }

    @Override
    public Employee updatEmployee(int employeeId, Employee employee) {
        try {
            Employee newEmployee = employeeJpaRepository.findById(employeeId).get();
            if (employee.getEmployeeName() != null) {
                newEmployee.setEmployeeName(employee.getEmployeeName());
            }
            if (employee.getEmail() != null) {
                newEmployee.setEmail(employee.getEmail());
            }
            if (employee.getDepartment() != null) {
                newEmployee.setDepartment(employee.getDepartment());
            }
            employeeJpaRepository.save(newEmployee);
            return newEmployee;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        try {
            return employeeJpaRepository.findById(employeeId).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteEmployee(int employeeId) {
        try {
            employeeJpaRepository.deleteById(employeeId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}