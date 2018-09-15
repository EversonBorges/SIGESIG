package com.borges.igreja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.borges.igreja.model.Celulas;
import com.borges.igreja.model.ParticipanteCL;

public interface ParticipanteCLRepository extends JpaRepository<ParticipanteCL, Long> {
	Iterable<ParticipanteCL> findByCelulas(Celulas celulas);

	@Query(value="select count(*) from ParticipanteCL where celulas_id_celula = :celulas",nativeQuery=true)
	Long countPart(@Param("celulas") Long celulas);

}
