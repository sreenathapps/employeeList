// Write your code here
package com.example.employee;

import java.util.ArrayList;

/**
 * EmployeeRepository
 */
public interface EmployeeRepository {
    ArrayList<Employee> getEmployees();

    Employee getEmployeeById(int employeeId);

    Employee updateEmployee(int employeeId, Employee employee);

    Employee addEmployee(Employee employee);

    void deleteEmployee(int employeeId);

}