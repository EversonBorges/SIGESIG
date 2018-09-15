package com.borges.igreja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.borges.igreja.model.AddAlunoCD;
import com.borges.igreja.model.CapacitacaoDestino;
import com.borges.igreja.model.Modulos;

public interface AddAlunoCDRepository extends JpaRepository<AddAlunoCD, Long> {
	
	List<AddAlunoCD> findByModulos(Modulos modulos);

}
