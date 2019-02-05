package com.borges.igreja.service;

import com.borges.igreja.model.Imagens;

public interface ImagensService <T extends Imagens>{
	
	void salvar(T entidade);
	//void salvar(T entidade, String imagem);

}
