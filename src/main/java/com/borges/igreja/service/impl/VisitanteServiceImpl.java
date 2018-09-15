package com.borges.igreja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.igreja.model.Visitantes;
import com.borges.igreja.repository.VisitanteRepository;
import com.borges.igreja.service.ServiceAbstract;

@Service
public class VisitanteServiceImpl implements ServiceAbstract<Visitantes> {
	
	@Autowired
	private VisitanteRepository vr;

	@Override
	public List<Visitantes> listarTodos() {
		return this.vr.findAll();
	}

	@Override
	public Visitantes listarId(Long id) {
		return this.vr.findOne(id);
	}

	@Override
	public Visitantes cadastrar(Visitantes visitantes) {
		return this.vr.save(visitantes);
	}

	@Override
	public Visitantes atualizar(Visitantes visitantes) {
		return this.vr.save(visitantes);
	}

	@Override
	public void remover(Long id) {
		this.vr.delete(id);
		
	}

}
