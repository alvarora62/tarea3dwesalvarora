package com.alvarora.tarea3dwesalvarora.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table
public class Mensaje implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime fechaHora;

    @Column
    private String mensaje;
    
    @ManyToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "ejemplar_id", referencedColumnName = "id")
    private Ejemplar ejemplar;

    @Override
    public String toString() {
        return "ID: " + this.id + " | Fecha y Hora: " + this.fechaHora + " | Mensaje: " + this.mensaje;
    }
    
    public Mensaje() {
		super();
	}

	public Mensaje(Long id, LocalDateTime fechaHora, String mensaje, Persona persona, Ejemplar ejemplar) {
		super();
		this.id = id;
		this.fechaHora = fechaHora;
		this.mensaje = mensaje;
		this.persona = persona;
		this.ejemplar = ejemplar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Ejemplar getEjemplar() {
		return ejemplar;
	}

	public void setEjemplar(Ejemplar ejemplar) {
		this.ejemplar = ejemplar;
	}
    
    
}
