package com.alvarora.tarea3dwesalvarora.repositories;

import com.alvarora.tarea3dwesalvarora.entities.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Long> {
}
