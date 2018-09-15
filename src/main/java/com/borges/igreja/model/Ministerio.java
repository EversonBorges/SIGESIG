package com.borges.igreja.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "ministerio")
public class Ministerio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMinisterio;
	
	@NotBlank(message = "Campo Descrição não pode estar em branco")
	private String tipoMinisterio;

	public Long getIdMinisterio() {
		return idMinisterio;
	}

	public void setIdMinisterio(Long idMinisterio) {
		this.idMinisterio = idMinisterio;
	}

	public String getTipoMinisterio() {
		return tipoMinisterio;
	}

	public void setTipoMinisterio(String tipoMinisterio) {
		this.tipoMinisterio = tipoMinisterio;
	}

	

	
}
