package com.alvarora.tarea3dwesalvarora.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
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

    @Override
    public String toString() {
        return "Id: " + this.id + " | codigo: " + this.codigo + " | nombre comun: " + this.nombreComun + " | nombre cientifico: " + this.nombreCientifico;
    }
    
    public Planta() {
		super();
	}

	public Planta(Long id, String codigo, String nombreComun, String nombreCientifico) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombreComun = nombreComun;
		this.nombreCientifico = nombreCientifico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombreComun() {
		return nombreComun;
	}

	public void setNombreComun(String nombreComun) {
		this.nombreComun = nombreComun;
	}

	public String getNombreCientifico() {
		return nombreCientifico;
	}

	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}
    
	
    
}
