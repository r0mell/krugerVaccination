package com.kruger.krugerVaccination.models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "employees")
@ToString
@EqualsAndHashCode
public class Employee {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employees")
    private int id_employees;

    @Getter
    @Setter
    @Column(name = "ci")
    private String ci;


    @Getter
    @Setter
    @Column(name = "firstname")
    private String firstname;

    @Getter
    @Setter
    @Column(name = "lastname")
    private String lastname;

    @Getter
    @Setter
    @Column(name = "email")
    private String email;

    @Getter
    @Setter
    @Column(name = "password")
    private String password;

    @Getter
    @Setter
    @Column(name = "cod_rol")
    private int cod_rol;


//extra information given by employee
   /*
     @Getter
    @Setter
    @Column(name = "isVaccinated")
    private boolean isVaccinated;


    @Getter
    @Setter
    @Column(name = "phone")
    private String phone;

    @Getter
    @Setter
    @Column(name = "address")
    private String address;

    @Getter
    @Setter
    @Column(name = "birthday")
    private Date birthday;*/



}
