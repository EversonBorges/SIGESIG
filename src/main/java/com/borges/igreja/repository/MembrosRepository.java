package com.borges.igreja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.borges.igreja.model.Membros;


public interface MembrosRepository extends JpaRepository<Membros, Long>  {
	@Query(value="SELECT * FROM Membros WHERE templo_id_templo =:templo and turma=:turma and tipo='Ativo' and matriculado=false", nativeQuery=true)
	List<Membros> findAllMembros(@Param("templo") Long templo, @Param("turma") Long turma);
	
	@Query(value="SELECT * FROM Membros WHERE concluido=true", nativeQuery=true)
	List<Membros> findAllMembrosLid();
	
	@Query(value="SELECT * FROM Membros WHERE ministerio_id_ministerio=1", nativeQuery=true)
	List<Membros> findAllMembrosSup();
	
	@Query(value="SELECT * FROM Membros WHERE mat_Lider=false", nativeQuery=true)
	List<Membros> findAllMembrosLidMat();
	
	@Query(value="SELECT cpf FROM Membros WHERE cpf =:cpf", nativeQuery=true)
	String BuscaCpf(@Param("cpf") String cpf);
	
	@Query(value="SELECT * FROM Membros WHERE templo_id_templo =:templo", nativeQuery=true)
	List<Membros> findAllMembrosTemplo(@Param("templo") Long templo);

	
}
