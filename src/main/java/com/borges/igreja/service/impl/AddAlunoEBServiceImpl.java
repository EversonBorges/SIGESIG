package com.borges.igreja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.igreja.model.AddAlunoEB;
import com.borges.igreja.model.EscolaBiblica;
import com.borges.igreja.repository.AddAlunoEBRepository;
import com.borges.igreja.service.AddAlunoEBService;
import com.borges.igreja.service.ServiceAbstract;

@Service
public class AddAlunoEBServiceImpl implements AddAlunoEBService, ServiceAbstract<AddAlunoEB> {

	@Autowired
	private AddAlunoEBRepository aebr;
	

	@Override
	public List<AddAlunoEB> listarTodos() {
		return this.aebr.findAll();
	}

	@Override
	public AddAlunoEB listarId(Long id) {
		return this.aebr.findOne(id);
	}

	@Override
	public AddAlunoEB cadastrar(AddAlunoEB addAlunoEB) {
		return this.aebr.save(addAlunoEB);
	}

	@Override
	public AddAlunoEB atualizar(AddAlunoEB addAlunoEB) {
		return this.aebr.save(addAlunoEB);
	}

	@Override
	public void remover(Long id) {
		this.aebr.delete(id);

	}

	@Override
	public List<AddAlunoEB> listAluno(EscolaBiblica escolaBiblica) {
		return this.aebr.findByEscolaBiblica(escolaBiblica);
	}
	
	

}
