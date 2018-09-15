package com.borges.igreja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.igreja.model.AddAlunoCD;
import com.borges.igreja.model.CapacitacaoDestino;
import com.borges.igreja.model.Modulos;
import com.borges.igreja.repository.AddAlunoCDRepository;
import com.borges.igreja.service.AddAlunoCDService;

@Service
public class AddAlunoCDServiceImpl implements AddAlunoCDService{
	
	@Autowired
	private AddAlunoCDRepository aelr;

	@Override
	public List<AddAlunoCD> listAluno(Modulos modulos) {
		return this.aelr.findByModulos(modulos);
	}

	@Override
	public AddAlunoCD cadastrar(AddAlunoCD addAlunoCD) {
		return this.aelr.save(addAlunoCD);
	}

	@Override
	public AddAlunoCD listarId(Long id) {
		return this.aelr.findOne(id);
	}

	
}
