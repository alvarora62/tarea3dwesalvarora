package com.alvarora.tarea3dwesalvarora.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "mensajes")
public class Mensaje implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime fechaHora;

    @Column
    private String mensaje;

    @Column
    private Persona persona;

    @Column
    private Ejemplar ejemplar;

    public Mensaje() {
    }

    public Mensaje(Ejemplar ejemplar, String mensaje, Persona persona, Long id, LocalDateTime fechaHora) {
        this.ejemplar = ejemplar;
        this.mensaje = mensaje;
        this.persona = persona;
        this.id = id;
        this.fechaHora = fechaHora;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + " | Fecha y Hora: " + this.fechaHora + " | Mensaje: " + this.mensaje + " | Persona: " + this.persona.getId() + " | Ejemplar: " + this.ejemplar.getId();
    }
}
