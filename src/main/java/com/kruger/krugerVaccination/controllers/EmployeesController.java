package com.kruger.krugerVaccination.controllers;

import com.kruger.krugerVaccination.dao.EmployeesDao;
import com.kruger.krugerVaccination.models.Employee;
import com.kruger.krugerVaccination.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class EmployeesController {

    @Autowired
    private EmployeesDao employeesDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/v1/employees", method = RequestMethod.GET)
    public List<Employee> getEmployees(@RequestHeader(value = "Authorization") String token) {


        if (!validateToken(token) && !token.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Invalid Token");
        }

        return employeesDao.getEmployees();
    }

    private boolean validateToken(String tokenBearer) {
        String token;

        if (tokenBearer.startsWith("Bearer ")) {
            token = tokenBearer.substring(7, tokenBearer.length());
        } else {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Invalid Token Bearer");
        }

        String employeeId = jwtUtil.getKey(token);

        System.out.println(employeeId);

        return employeeId != null;
    }


    @RequestMapping(value = "api/v1/employees/{id}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable int id) {
        employeesDao.deleteEmployee(id);
    }

    @RequestMapping(value = "api/v1/employees", method = RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee employee) {

        String auxPassword = employee.getPassword();
        //implement encrypt password with Argon2
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i);
        String passwordHash = argon2.hash(1, 1024, 1, employee.getPassword());

        employee.setPassword(passwordHash);

        Employee credentialEmployee =  employeesDao.createEmployee(employee, auxPassword);

        return credentialEmployee;
    }

    @RequestMapping(value = "api/v1/employees/{id}", method = RequestMethod.PUT)
    public void updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
        employeesDao.updateEmployee(employee, id);
    }


}
