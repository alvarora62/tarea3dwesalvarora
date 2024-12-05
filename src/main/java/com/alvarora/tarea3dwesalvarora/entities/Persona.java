package com.alvarora.tarea3dwesalvarora.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String email;

    @Override
    public String toString() {
        return "ID: " + this.id + " | Nombre: " + this.nombre + " | Email: " + this.email;
    }
    
    public Persona() {
		super();
	}

	public Persona(Long id, String nombre, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
	
    
}
