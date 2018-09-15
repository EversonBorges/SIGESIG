package com.borges.igreja.service;

import java.util.List;

public interface ServiceAbstract<T> {
	
	List<T> listarTodos();
	
	T listarId(Long id);
	
	T cadastrar(T entidades);
	
	T atualizar(T entidades);
	
	void remover(Long id);

}
