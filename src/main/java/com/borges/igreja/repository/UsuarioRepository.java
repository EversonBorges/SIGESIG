package com.borges.igreja.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.borges.igreja.model.Templo;
import com.borges.igreja.security.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

	UsuarioEntity findByLogin(String login);
	
	@Query(value="SELECT ds_nome,templo_id_templo FROM tb_usuario WHERE ds_login =:nome", nativeQuery=true)
	String findByNome(@Param ("nome") String nome);
	
	@Query(value="SELECT templo_id_templo FROM tb_usuario WHERE ds_login =:nome", nativeQuery=true)
	String findByNome1(@Param ("nome") String nome);
	
}
