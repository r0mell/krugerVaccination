package com.kruger.krugerVaccination.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "vaccines")
@ToString
@EqualsAndHashCode
public class Vaccines {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vaccines")
    private int id_vaccines;

    @Getter
    @Setter
    @Column(name = "ci")
    private String ci;

    @Getter
    @Setter
    @Column(name = "dateVaccination")
    private Date dateVaccination;

    @Getter
    @Setter
    @Column(name = "numberDoses")
    private Date numberDoses;



}
