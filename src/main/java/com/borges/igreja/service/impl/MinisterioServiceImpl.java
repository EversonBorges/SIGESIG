package com.borges.igreja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.igreja.model.Ministerio;
import com.borges.igreja.repository.MinisterioRepository;
import com.borges.igreja.service.ServiceAbstract;

@Service
public class MinisterioServiceImpl implements ServiceAbstract<Ministerio> {

	@Autowired
	MinisterioRepository mtr;
	
	@Override
	public List<Ministerio> listarTodos() {
		return this.mtr.findAll();
	}

	@Override
	public Ministerio listarId(Long id) {
		return this.mtr.findOne(id);
	}

	@Override
	public Ministerio cadastrar(Ministerio ministerio) {
		return this.mtr.save(ministerio);
	}

	@Override
	public Ministerio atualizar(Ministerio ministerio) {
		return this.mtr.save(ministerio);
	}

	@Override
	public void remover(Long id) {
		this.mtr.delete(id);

	}

}
