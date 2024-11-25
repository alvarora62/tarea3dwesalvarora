package com.alvarora.tarea3dwesalvarora.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "plantas")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Planta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public String toString() {
        return "Id: " + id + " |";
    }
}
