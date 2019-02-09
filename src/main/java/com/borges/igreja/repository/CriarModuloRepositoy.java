package com.borges.igreja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.borges.igreja.model.CriarModulo;

public interface CriarModuloRepositoy extends JpaRepository<CriarModulo, Long> {
	//@Query(value="SELECT * FROM criar_modulo WHERE descricao_mod =:descricaoMod",nativeQuery = true)
	//CriarModulo findByDescricaoMod(@Param("descricaoMod") String descricaoMod);

}
