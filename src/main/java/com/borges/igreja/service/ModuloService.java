package com.borges.igreja.service;

import java.util.List;

import com.borges.igreja.model.CapacitacaoDestino;
import com.borges.igreja.model.Modulos;

public interface ModuloService {

	List<Modulos> listModulos(CapacitacaoDestino capacitacaoDestino);
}
