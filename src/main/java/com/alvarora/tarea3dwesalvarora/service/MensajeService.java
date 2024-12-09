package com.alvarora.tarea3dwesalvarora.service;

import com.alvarora.tarea3dwesalvarora.entities.Mensaje;

import java.time.LocalDateTime;
import java.util.List;

public interface MensajeService {

	List<Mensaje> findAll();
    List<Mensaje> findByPersona(Long id);
    List<Mensaje> findByEjemplar(Long id);
    List<Mensaje> findBetweenDateTime(LocalDateTime firstLocalDateTime, LocalDateTime secondLocalDateTime);
    void save(Mensaje mensaje);
    void mensajeInicial(Long idPersona, Long idEjemplar);
}
