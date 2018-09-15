package com.borges.igreja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.borges.igreja.model.Visitantes;

public interface VisitanteRepository extends JpaRepository<Visitantes, Long> {

}
