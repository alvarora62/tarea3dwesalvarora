package com.alvarora.tarea3dwesalvarora.repositories;

import com.alvarora.tarea3dwesalvarora.entities.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {
}
