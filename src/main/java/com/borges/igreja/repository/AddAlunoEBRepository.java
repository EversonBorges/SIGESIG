package com.borges.igreja.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.borges.igreja.model.AddAlunoEB;
import com.borges.igreja.model.EscolaBiblica;


public interface AddAlunoEBRepository extends JpaRepository<AddAlunoEB, Long> {
	//@Query(value="SELECT * FROM Addalunoeb a,Membros m WHERE a.alunos_id_membro = m.id_membro AND m.tipo = 'Inativo'",nativeQuery=true)
	//@Query(value="SELECT * FROM Addalunoeb a join a.alunos m  where m.tipo='Inativo'",nativeQuery=true)
	List<AddAlunoEB> findByEscolaBiblica(EscolaBiblica escolaBiblica);
}
