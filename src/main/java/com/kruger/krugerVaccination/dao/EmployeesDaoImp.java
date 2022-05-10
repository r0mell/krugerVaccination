package com.kruger.krugerVaccination.dao;

import com.kruger.krugerVaccination.models.Employee;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class EmployeesDaoImp implements EmployeesDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Employee> getEmployees() {
        String query = "FROM Employee";

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void deleteEmployee(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }

    @Override
    public Employee createEmployee(Employee employee, String auxPasword) {

        Employee sendEmployee = new Employee();

        entityManager.merge(employee);

        sendEmployee.setEmail(employee.getEmail());
        sendEmployee.setPassword(auxPasword);

        return sendEmployee;
    }

    @Override
    public void updateEmployee(@NotNull Employee employee, int id) {

        System.out.println("datos del empleado" + employee);

        Employee employeeAux = entityManager.find(Employee.class, id);

        employeeAux.setCi(employee.getCi());
        employeeAux.setFirstname(employee.getFirstname());
        employeeAux.setLastname(employee.getLastname());
        employeeAux.setEmail(employee.getEmail());
        employeeAux.setPassword(employee.getPassword());

        entityManager.merge(employeeAux);


    }

    @Override
    public Employee veriflyCredentials(Employee employee) {

        String query = "FROM Employee WHERE email = :email";
        List<Employee> lista = entityManager.createQuery(query)
                .setParameter("email", employee.getEmail())
                .getResultList();

        if (lista.isEmpty()) {
            return null;
        }

        String passwordHash = lista.get(0).getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i);

        //System.out.println(lista.get(0));

        if (argon2.verify(passwordHash, employee.getPassword())) {

            return lista.get(0);
        }
        return null;
    }
}
