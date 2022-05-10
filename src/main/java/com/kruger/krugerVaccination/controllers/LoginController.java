package com.kruger.krugerVaccination.controllers;

import com.kruger.krugerVaccination.dao.EmployeesDao;
import com.kruger.krugerVaccination.models.Employee;
import com.kruger.krugerVaccination.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class LoginController {

    @Autowired
    private EmployeesDao employeesDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/v1/login", method = RequestMethod.POST)
    public String login(@RequestBody Employee employee) {

        Employee employeeLogged = employeesDao.veriflyCredentials(employee);

        if (employeeLogged != null) {
            String tokenJWT =  jwtUtil.create(String.valueOf(employeeLogged.getId_employees()), String.valueOf(employeeLogged.getId_employees()));
            return tokenJWT;
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NO_CONTENT, "Employee Not Found");
        }
    }
}
