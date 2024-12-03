package com.alvarora.tarea3dwesalvarora.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table
public class Ejemplar implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "planta_codigo", referencedColumnName = "codigo") // clave foránea
    private Planta planta;

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Planta: " + this.planta.getCodigo();
    }
    
    public Ejemplar() {
		super();
	}

	public Ejemplar(Long id, String nombre, Planta planta) {
		super();
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Planta getPlanta() {
		return planta;
	}

	public void setPlanta(Planta planta) {
		this.planta = planta;
	}
    
	
    
}
