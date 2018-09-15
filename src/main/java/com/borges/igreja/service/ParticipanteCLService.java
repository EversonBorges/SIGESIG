package com.borges.igreja.service;

import com.borges.igreja.model.Celulas;
import com.borges.igreja.model.ParticipanteCL;

public interface ParticipanteCLService {
	
	Iterable<ParticipanteCL> listPart(Celulas celulas);
	
	Long qtdPartc(Long idPart);

}
