package com.borges.igreja.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="criar_modulo")
public class CriarModulo extends Imagens  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GenericGenerator(
            name = "criarModuloSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "criarModuloSequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "criarModuloSequenceGenerator")
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
