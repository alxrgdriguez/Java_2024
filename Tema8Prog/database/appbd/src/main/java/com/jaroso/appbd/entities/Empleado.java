package com.jaroso.appbd.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Empleado {

    //Propiedades
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO-INCREMENT
    private Long id;

    private String nombre;

    private String apellidos;

    private Integer edad;

    private String email;



}
