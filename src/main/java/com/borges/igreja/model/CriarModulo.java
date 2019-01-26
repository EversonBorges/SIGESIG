package com.borges.igreja.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="criarModulo")
public class CriarModulo extends Imagens  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idCriarModulo;
	
	@NotBlank(message = "Campo Descrição não pode estar em branco")
	private String descricaoMod;

	public Long getIdCriarModulo() {
		return idCriarModulo;
	}

	public void setIdCriarModulo(Long idCriarModulo) {
		this.idCriarModulo = idCriarModulo;
	}

	public String getDescricaoMod() {
		return descricaoMod;
	}

	public void setDescricaoMod(String descricaoMod) {
		this.descricaoMod = descricaoMod;
	}
}
