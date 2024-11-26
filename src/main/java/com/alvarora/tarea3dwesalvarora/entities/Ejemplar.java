package com.alvarora.tarea3dwesalvarora.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "ejemplares")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Ejemplar implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idplanta")
    private Planta planta;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "idejemplar")
//    private List<Mensaje> mensajes = new LinkedList<Mensaje>();

}
