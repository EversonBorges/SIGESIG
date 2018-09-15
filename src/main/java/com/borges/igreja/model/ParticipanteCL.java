package com.borges.igreja.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.borges.igreja.enumerators.Religiao;

@Entity
@Table(name = "participanteCL")
public class ParticipanteCL extends Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idParticipante;
	
	@NotBlank(message = "Campo Nome não pode estar em branco")
	private String nome;
	
	@NotBlank(message = "Campo Data Nascimento não pode estar em branco")
	private String dtNasc;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Campo Religião não pode estar em branco")
	private Religiao religiao;
	
	@ManyToOne
	private Celulas celulas;

	public Long getIdParticipante() {
		return idParticipante;
	}

	public void setIdParticipante(Long idParticipante) {
		this.idParticipante = idParticipante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}
	
	public Religiao getReligiao() {
		return religiao;
	}

	public void setReligiao(Religiao religiao) {
		this.religiao = religiao;
	}

	public Celulas getCelulas() {
		return celulas;
	}

	public void setCelulas(Celulas celulas) {
		this.celulas = celulas;
	}
	
}
