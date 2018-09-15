package com.borges.igreja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.igreja.model.Templo;
import com.borges.igreja.repository.TemploRepository;
import com.borges.igreja.service.ServiceAbstract;
@Service
public class TemploServiceImpl implements ServiceAbstract<Templo> {
	
	@Autowired
	TemploRepository tr;

	@Override
	public List<Templo> listarTodos() {
		return this.tr.findAll();
	}

	@Override
	public Templo listarId(Long id) {
	return this.tr.findOne(id);
	}

	@Override
	public Templo cadastrar(Templo templo) {
	return this.tr.save(templo);
	}

	@Override
	public Templo atualizar(Templo templo) {
		return this.tr.save(templo);
	}

	@Override
	public void remover(Long id) {
		this.tr.delete(id);

	}

}
