package com.alvarora.tarea3dwesalvarora.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "credenciales")
public class Credenciales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String usuario;

    @Column
    private String password;

    @ManyToOne
    @JoinColumn(name = "fk_persona_id")
    private Persona fk_persona;

    public Credenciales() {
    }

    public Credenciales(Persona fk_persona, Long id, String password, String usuario) {
        this.fk_persona = fk_persona;
        this.id = id;
        this.password = password;
        this.usuario = usuario;
    }

    public Persona getFk_persona() {
        return fk_persona;
    }

    public void setFk_persona(Persona fk_persona) {
        this.fk_persona = fk_persona;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Usuario: " + this.usuario + " | Password: " + this.password + " | ID: " + this.id;
    }
}
