package com.borges.igreja.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "ministerio")
public class Ministerio {
	
	@GenericGenerator(
            name = "ministerioSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "ministerioSequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "ministerioSequenceGenerator")
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
