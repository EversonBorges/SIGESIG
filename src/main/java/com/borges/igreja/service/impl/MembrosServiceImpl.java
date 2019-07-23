package com.borges.igreja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.igreja.model.Membros;
import com.borges.igreja.repository.MembrosRepository;
import com.borges.igreja.service.ImagensService;
import com.borges.igreja.service.MembrosService;
import com.borges.igreja.service.ServiceAbstract;
@Service
public class MembrosServiceImpl implements MembrosService, ServiceAbstract<Membros>,ImagensService<Membros> {

	@Autowired
	MembrosRepository mr;
	
	@Override
	public List<Membros> listarTodos() {
		
		return this.mr.findAll();
	}

	@Override
	public Membros listarId(Long id) {

		return this.mr.findOne(id);
	}

	@Override
	public Membros cadastrar(Membros membros) {

		return this.mr.save(membros);
	}

	@Override
	public Membros atualizar(Membros membros) {

		return this.mr.save(membros);
	}

	@Override
	public void remover(Long id) {
		
		this.mr.delete(id);
	}
	@Override
	public List<Membros> listMembros(Long templo, Long turma) {
		return this.mr.findAllMembros(templo, turma);
	}

	@Override
	public List<Membros> listMembrosLid() {
		return this.mr.findAllMembrosLid();
	}

	@Override
	public List<Membros> listMembrosSup() {
		return this.mr.findAllMembrosSup();
	}

	@Override
	public List<Membros> listMembrosLidMat() {
		return this.mr.findAllMembrosLidMat();
	}

	@Override
	public void salvar(Membros membros) {
		this.mr.save(membros);
		
	}

	@Override
	public void salvar(Membros membros, String imagem) {
		membros.setImg(imagem);
		this.mr.save(membros);
		
	}

	@Override
	public String buscaCpf(String cpf) {
		return this.mr.BuscaCpf(cpf);
	}

	@Override
	public List<Membros> listTemplo(Long templo) {
		return this.mr.findAllMembrosTemplo(templo);
	}

}
