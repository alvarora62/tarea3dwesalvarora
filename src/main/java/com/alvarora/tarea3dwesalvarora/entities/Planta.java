package com.alvarora.tarea3dwesalvarora.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "plantas")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Planta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String codigo;

    @Column
    private String nombreComun;

    @Column
    private String nombreCientifico;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Ejemplar> ejemplares = new LinkedList<Ejemplar>();

    @Override
    public String toString() {
        return "Id: " + id + " | codigo: " + codigo + " | nombre comun: " + nombreComun;
    }
}
