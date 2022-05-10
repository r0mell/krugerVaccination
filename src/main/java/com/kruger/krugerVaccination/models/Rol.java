package com.kruger.krugerVaccination.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@ToString
@EqualsAndHashCode
public class Rol {

    @Id
    @Getter
    @Setter
    @Column(name = "id_rol")
    private int idRol;


    @Getter
    @Setter
    @Column(name = "rol_name")
    private String rol_name;


}
