package com.borges.igreja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.borges.igreja.model.CapacitacaoDestino;
import com.borges.igreja.model.Modulos;

public interface ModulosRepository extends JpaRepository<Modulos, Long> {
	
	List<Modulos> findByDestino(CapacitacaoDestino capacitacaoDestino);

}
