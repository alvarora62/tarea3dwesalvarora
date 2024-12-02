package com.alvarora.tarea3dwesalvarora.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "credenciales")
public class Credenciales implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String usuario;

    @Column
    private String password;

    @OneToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    private Persona persona;

    public Credenciales() {
    }

    public Credenciales(Long id, String usuario, String password, Persona persona) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.persona = persona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
