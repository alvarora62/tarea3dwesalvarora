package com.alvarora.tarea3dwesalvarora.service;

import java.time.LocalDateTime;
import java.util.List;

import com.alvarora.tarea3dwesalvarora.entities.Mensaje;

public interface MensajeService {

	List<Mensaje> findAll();
    List<Mensaje> findByPersona(Long id);
    List<Mensaje> findByEjemplar(Long id);
    List<Mensaje> findBetweenDateTime(LocalDateTime firstLocalDateTime, LocalDateTime secondLocalDateTime);
    void save(Mensaje mensaje);
    void mensajeInicial(Mensaje mensaje);
}
