package com.borges.igreja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.igreja.model.ChamadaCD;
import com.borges.igreja.repository.ChamadaCDRepository;
import com.borges.igreja.service.ServiceAbstract;

@Service
public class ChamadaCDServiceImpl implements ServiceAbstract<ChamadaCD> {

	@Autowired
	private ChamadaCDRepository cr;
	@Override
	public List<ChamadaCD> listarTodos() {
		return this.cr.findAll();
	}

	@Override
	public ChamadaCD listarId(Long id) {
		return this.cr.findOne(id);
	}

	@Override
	public ChamadaCD cadastrar(ChamadaCD chamadaCD) {
		return this.cr.save(chamadaCD);
	}

	@Override
	public ChamadaCD atualizar(ChamadaCD chamadaCD) {
		return this.cr.save(chamadaCD);
	}

	@Override
	public void remover(Long id) {
		this.cr.delete(id);
	}

}
