package com.borges.igreja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.igreja.model.Celulas;
import com.borges.igreja.repository.CelulasRepository;
import com.borges.igreja.service.ServiceAbstract;

@Service
public class CelulasServiceImpl implements ServiceAbstract<Celulas> {
	
	@Autowired
	private CelulasRepository cr;

	@Override
	public List<Celulas> listarTodos() {
		return this.cr.findAll();
	}

	@Override
	public Celulas listarId(Long id) {
		return this.cr.findOne(id);
	}

	@Override
	public Celulas cadastrar(Celulas celulas) {
		return this.cr.save(celulas);
	}

	@Override
	public Celulas atualizar(Celulas celulas) {
		return this.cr.save(celulas);
	}

	@Override
	public void remover(Long id) {
		this.cr.delete(id);
	}

}
