package com.alvarora.tarea3dwesalvarora.repositories;

import com.alvarora.tarea3dwesalvarora.entities.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

    @Query("SELECT m FROM Mensaje m WHERE m.persona.id = ?1")
    List<Mensaje> findByFKPersona(Long personaId);

    @Query("SELECT m FROM Mensaje m WHERE m.ejemplar.id = ?1")
    List<Mensaje> findByFKEjemplar(Long ejemplarId);

    @Query("SELECT m FROM Mensaje m WHERE m.fechaHora BETWEEN ?1 AND ?2")
    List<Mensaje> findBetweenDateTime(LocalDateTime firstLocalDateTime, LocalDateTime secondLocalDateTime);
}