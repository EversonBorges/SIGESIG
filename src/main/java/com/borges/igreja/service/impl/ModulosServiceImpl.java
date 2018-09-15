package com.borges.igreja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.igreja.model.CapacitacaoDestino;
import com.borges.igreja.model.Modulos;
import com.borges.igreja.repository.ModulosRepository;
import com.borges.igreja.service.ModuloService;
import com.borges.igreja.service.ServiceAbstract;

@Service
public class ModulosServiceImpl implements ServiceAbstract<Modulos>,ModuloService {

	@Autowired
	private ModulosRepository mdr;
	
	@Override
	public List<Modulos> listarTodos() {
		return this.mdr.findAll();
	}

	@Override
	public Modulos listarId(Long id) {
		return this.mdr.findOne(id);
	}

	@Override
	public Modulos cadastrar(Modulos modulos) {
		return this.mdr.save(modulos);
	}

	@Override
	public Modulos atualizar(Modulos modulos) {
		return this.mdr.save(modulos);
	}

	@Override
	public void remover(Long id) {
		this.mdr.delete(id);
	}

	@Override
	public List<Modulos> listModulos(CapacitacaoDestino capacitacaoDestino) {
		return this.mdr.findByDestino(capacitacaoDestino);
	}

}
