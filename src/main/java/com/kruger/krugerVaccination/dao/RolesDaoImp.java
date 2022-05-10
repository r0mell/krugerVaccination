package com.kruger.krugerVaccination.dao;

import com.kruger.krugerVaccination.models.Rol;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class RolesDaoImp implements RolesDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Rol> getRoles() {
        String query = "FROM Rol";

        List<Rol> listaRoles = entityManager.createQuery(query).getResultList();

        return listaRoles;

    }

    @Override
    public void postRoles(Rol rol) {
        entityManager.merge(rol);
    }
}
