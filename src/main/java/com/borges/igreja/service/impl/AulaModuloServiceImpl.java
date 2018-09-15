package com.borges.igreja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.igreja.model.AulaModulo;
import com.borges.igreja.model.Modulos;
import com.borges.igreja.repository.AulaRepository;
import com.borges.igreja.service.AulaModuloService;

@Service
public class AulaModuloServiceImpl implements AulaModuloService {

	@Autowired
	private AulaRepository ar;
	
	@Override
	public List<AulaModulo> listarTodos() {
		return this.ar.findAll();
	}

	@Override
	public AulaModulo listarId(Long id) {
		return this.ar.findOne(id);
	}

	@Override
	public AulaModulo cadastrar(AulaModulo aulaModulo) {
		return this.ar.save(aulaModulo);
	}

	@Override
	public AulaModulo atualizar(AulaModulo aulaModulo) {
		return this.ar.save(aulaModulo);
	}

	@Override
	public void remover(Long id) {
		this.ar.delete(id);
	}

	@Override
	public List<AulaModulo> listModulo(Modulos modulos) {
		return this.ar.findByModuloAula(modulos);
	}

}
