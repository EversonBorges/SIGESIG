package com.borges.igreja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.borges.igreja.model.AulaModulo;
import com.borges.igreja.model.Modulos;

public interface AulaRepository extends JpaRepository<AulaModulo, Long> {
	
	List<AulaModulo> findByModuloAula(Modulos modulos);

}
