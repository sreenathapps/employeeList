package com.example.employee.repository;

import java.util.List;

import com.example.employee.model.Employee;

/**
 * EmployeeRepository
 */
public interface EmployeeRepository {

    List<Employee> getEmployees();

    Employee addEmployee(Employee employee);

    Employee updatEmployee(int employeeId, Employee employee);

    Employee getEmployeeById(int employeeId);

    void deleteEmployee(int employeeId);
}