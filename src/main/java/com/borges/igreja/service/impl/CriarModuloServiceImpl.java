package com.borges.igreja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.igreja.model.CriarModulo;
import com.borges.igreja.repository.CriarModuloRepositoy;
import com.borges.igreja.service.ImagensService;
import com.borges.igreja.service.ServiceAbstract;

@Service
public class CriarModuloServiceImpl implements ServiceAbstract<CriarModulo>,ImagensService<CriarModulo> {

	@Autowired
	private CriarModuloRepositoy cmr;
	
	@Override
	public List<CriarModulo> listarTodos() {
		return this.cmr.findAll();
	}

	@Override
	public CriarModulo listarId(Long id) {
		return this.cmr.findOne(id);
	}

	@Override
	public CriarModulo cadastrar(CriarModulo criarModulo) {
		return this.cmr.save(criarModulo);
	}

	@Override
	public CriarModulo atualizar(CriarModulo criarModulo) {
		return this.cmr.save(criarModulo);
	}

	@Override
	public void remover(Long id) {
		this.cmr.delete(id);
		
	}
	
//	@Override
//	public void salvar(CriarModulo criarModulo, String imagem) {
//		criarModulo.setImg(imagem);
//		this.cmr.save(criarModulo);
//		
//	}

	@Override
	public void salvar(CriarModulo criarModulo) {
		this.cmr.save(criarModulo);
		
	}

}
