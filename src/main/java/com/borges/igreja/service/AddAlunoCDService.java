package com.borges.igreja.service;

import java.util.List;

import com.borges.igreja.model.AddAlunoCD;
import com.borges.igreja.model.CapacitacaoDestino;
import com.borges.igreja.model.Modulos;

public interface AddAlunoCDService {
	
	AddAlunoCD cadastrar(AddAlunoCD addAlunoCD);
	List<AddAlunoCD> listAluno(Modulos modulos);
	AddAlunoCD listarId(Long id);

}
