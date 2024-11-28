package com.alvarora.tarea3dwesalvarora.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "plantas")
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

    public Planta() {
    }

    public Planta(String codigo, String nombreComun, String nombreCientifico, Long id, List<Ejemplar> ejemplares) {
        this.codigo = codigo;
        this.nombreComun = nombreComun;
        this.nombreCientifico = nombreCientifico;
        this.id = id;
        this.ejemplares = ejemplares;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(List<Ejemplar> ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    @Override
    public String toString() {
        return "Id: " + id + " | codigo: " + codigo + " | nombre comun: " + nombreComun + " | nombre cientifico: " + nombreCientifico;
    }
}
