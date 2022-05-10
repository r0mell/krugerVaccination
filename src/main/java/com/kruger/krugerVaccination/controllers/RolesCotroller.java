package com.kruger.krugerVaccination.controllers;

import com.kruger.krugerVaccination.dao.EmployeesDao;
import com.kruger.krugerVaccination.dao.RolesDao;
import com.kruger.krugerVaccination.models.Employee;
import com.kruger.krugerVaccination.models.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RolesCotroller {

    @Autowired
    private RolesDao rolesDao;

    @RequestMapping(value = "api/v1/roles")
    public List<Rol> getRoles() {
        return rolesDao.getRoles();
    }

    @RequestMapping(value = "api/v1/roles", method = RequestMethod.POST)
    public void createRoles(@RequestBody Rol rol) {

         rolesDao.postRoles(rol);
    }

}
