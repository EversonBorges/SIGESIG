package com.borges.igreja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.igreja.model.Celulas;
import com.borges.igreja.model.ParticipanteCL;
import com.borges.igreja.repository.ParticipanteCLRepository;
import com.borges.igreja.service.ParticipanteCLService;
import com.borges.igreja.service.ServiceAbstract;

@Service
public class ParticipanteCLServiceImpl implements ParticipanteCLService, ServiceAbstract<ParticipanteCL> {

	@Autowired
	private ParticipanteCLRepository pr;
	
	@Override
	public List<ParticipanteCL> listarTodos() {
		return this.pr.findAll();
	}

	@Override
	public ParticipanteCL listarId(Long id) {
		return this.pr.findOne(id);
	}

	@Override
	public ParticipanteCL cadastrar(ParticipanteCL participanteCL) {
		return this.pr.save(participanteCL);
	}

	@Override
	public ParticipanteCL atualizar(ParticipanteCL participanteCL) {
		return this.pr.save(participanteCL);
	}

	@Override
	public void remover(Long id) {
		this.pr.delete(id);
	}

	@Override
	public Iterable<ParticipanteCL> listPart(Celulas celulas) {
		return this.pr.findByCelulas(celulas);
	}

	@Override
	public Long qtdPartc(Long idPart) {
		return pr.countPart(idPart);
	}

}
