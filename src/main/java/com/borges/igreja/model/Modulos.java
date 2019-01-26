package com.borges.igreja.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="modulos")
public class Modulos{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idModulo;
	
	@NotBlank(message = "Campo Data Inicio não pode estar em branco")
	private String dtInicio;
	
	@NotBlank(message = "Campo Data Termino não pode estar em branco")
	private String dtTermino;
	
	@ManyToOne
	private CapacitacaoDestino destino;
	
	@ManyToOne
	private CriarModulo modulo;
	
	@NotBlank(message = "Campo Descrição não pode estar em branco")
	private String descricao;

	public Long getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}

	public String getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(String dtInicio) {
		this.dtInicio = dtInicio;
	}

	public String getDtTermino() {
		return dtTermino;
	}

	public void setDtTermino(String dtTermino) {
		this.dtTermino = dtTermino;
	}

	public CapacitacaoDestino getDestino() {
		return destino;
	}

	public void setDestino(CapacitacaoDestino destino) {
		this.destino = destino;
	}

	public CriarModulo getModulo() {
		return modulo;
	}

	public void setModulo(CriarModulo modulo) {
		this.modulo = modulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result + ((dtInicio == null) ? 0 : dtInicio.hashCode());
		result = prime * result + ((dtTermino == null) ? 0 : dtTermino.hashCode());
		result = prime * result + ((idModulo == null) ? 0 : idModulo.hashCode());
		result = prime * result + ((modulo == null) ? 0 : modulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modulos other = (Modulos) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (dtInicio == null) {
			if (other.dtInicio != null)
				return false;
		} else if (!dtInicio.equals(other.dtInicio))
			return false;
		if (dtTermino == null) {
			if (other.dtTermino != null)
				return false;
		} else if (!dtTermino.equals(other.dtTermino))
			return false;
		if (idModulo == null) {
			if (other.idModulo != null)
				return false;
		} else if (!idModulo.equals(other.idModulo))
			return false;
		if (modulo == null) {
			if (other.modulo != null)
				return false;
		} else if (!modulo.equals(other.modulo))
			return false;
		return true;
	}
	
}
