package com.kruger.krugerVaccination.dao;

import com.kruger.krugerVaccination.models.Employee;

import java.util.List;

public interface EmployeesDao {
    List<Employee> getEmployees();

    void deleteEmployee(int id);

    Employee createEmployee(Employee employee, String auxPasword);

    void updateEmployee(Employee employee, int id);

    Employee veriflyCredentials(Employee employee);
}
