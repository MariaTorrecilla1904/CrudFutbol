package com.example.demo.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "asociaciones")
public class Asociacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String pais;

    // Getters y setters
}
