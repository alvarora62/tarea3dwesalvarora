package com.alvarora.tarea3dwesalvarora.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "ejemplares")
public class Ejemplar implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @ManyToOne(optional = false)
    @JoinColumn(name = "codigoplanta", referencedColumnName = "codigo")
    private Planta planta;

    public Ejemplar() {
    }

    public Ejemplar(Long id, String nombre, Planta planta) {
        this.id = id;
        this.nombre = nombre;
        this.planta = planta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Planta: " + planta.getNombreComun();
    }

    //    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "idejemplar")
//    private List<Mensaje> mensajes = new LinkedList<Mensaje>();

}
