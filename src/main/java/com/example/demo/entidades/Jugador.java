package com.example.demo.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "jugadores")
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String posicion;
    private int numero;

    @ManyToOne
    @JoinColumn(name = "id_club")
    private Club club;

    // Getters y setters
}
