package com.alvarora.tarea3dwesalvarora.repositories;

import com.alvarora.tarea3dwesalvarora.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
