package com.borges.igreja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.igreja.model.EscolaBiblica;
import com.borges.igreja.repository.EscolaBiblicaRepository;
import com.borges.igreja.service.ServiceAbstract;

@Service
public class EscolaBiblicaServiceImpl implements ServiceAbstract<EscolaBiblica> {

	@Autowired
	private EscolaBiblicaRepository ebr;
	
	@Override
	public List<EscolaBiblica> listarTodos() {
		
		return this.ebr.findAll();
	}

	@Override
	public EscolaBiblica listarId(Long id) {
		
		return this.ebr.findOne(id);
	}

	@Override
	public EscolaBiblica cadastrar(EscolaBiblica escolaBiblica) {
		
		return this.ebr.save(escolaBiblica);
	}

	@Override
	public EscolaBiblica atualizar(EscolaBiblica escolaBiblica) {
		
		return this.ebr.save(escolaBiblica);
	}

	@Override
	public void remover(Long id) {
		
		this.ebr.delete(id);

	}

}
