package com.alvarora.tarea3dwesalvarora.repositories;

import com.alvarora.tarea3dwesalvarora.entities.Ejemplar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EjemplarRepository extends JpaRepository<Ejemplar, Long> {

	@Query("SELECT e FROM Ejemplar e WHERE e.planta.codigo = ?1")
    List<Ejemplar> findByFkPlanta(String codigo);

}
