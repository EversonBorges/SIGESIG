package com.borges.igreja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.igreja.model.CapacitacaoDestino;
import com.borges.igreja.repository.CapacitacaoDestinoRepository;
import com.borges.igreja.service.ServiceAbstract;

@Service
public class CapacitacaoDestinoServiceImpl implements ServiceAbstract<CapacitacaoDestino> {

	@Autowired
	private CapacitacaoDestinoRepository elr;
	
	@Override
	public List<CapacitacaoDestino> listarTodos() {
		return this.elr.findAll();
	}

	@Override
	public CapacitacaoDestino listarId(Long id) {
		return this.elr.findOne(id);
	}

	@Override
	public CapacitacaoDestino cadastrar(CapacitacaoDestino escolaLideres) {
		return this.elr.save(escolaLideres);
	}

	@Override
	public CapacitacaoDestino atualizar(CapacitacaoDestino escolaLideres) {
		return this.elr.save(escolaLideres);
	}

	@Override
	public void remover(Long id) {
		this.elr.delete(id);
	}

}
