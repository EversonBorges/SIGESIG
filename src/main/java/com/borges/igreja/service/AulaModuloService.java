package com.borges.igreja.service;

import java.util.List;

import com.borges.igreja.model.AulaModulo;
import com.borges.igreja.model.Modulos;

public interface AulaModuloService extends ServiceAbstract<AulaModulo> {
	
	List<AulaModulo> listModulo(Modulos modulos);

}
