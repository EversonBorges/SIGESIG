package com.borges.igreja.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.borges.igreja.enumerators.OperacaoSaida;

@Entity
@Table(name="saidas")
public class Saidas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSaida;
	
	@Enumerated(EnumType.STRING)
	private OperacaoSaida saida;
	
	private String dtSaida;
	
	private BigDecimal valor;

	public Long getIdSaida() {
		return idSaida;
	}

	public void setIdSaida(Long idSaida) {
		this.idSaida = idSaida;
	}

	public OperacaoSaida getSaida() {
		return saida;
	}

	public void setSaida(OperacaoSaida saida) {
		this.saida = saida;
	}

	public String getDtSaida() {
		return dtSaida;
	}

	public void setDtSaida(String dtSaida) {
		this.dtSaida = dtSaida;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
