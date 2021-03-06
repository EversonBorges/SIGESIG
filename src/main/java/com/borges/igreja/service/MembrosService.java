package com.borges.igreja.service;

import java.util.List;

import com.borges.igreja.model.Membros;

public interface MembrosService extends ImagensService<Membros> {
	
	List<Membros> listMembros(Long  templo, Long turma);
	
	List<Membros> listMembrosLid();
	
	List<Membros> listMembrosSup();
	
	List<Membros> listMembrosLidMat();
	
	String buscaCpf(String cpf);
	
	List<Membros> listTemplo(Long templo);
	
}
