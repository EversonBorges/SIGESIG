package com.borges.igreja.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.NotBlank;

import com.borges.igreja.enumerators.Evento;

@Entity
@Table(name="financeiro")
public class Financeiro {
	
	@GenericGenerator(
            name = "financeiroSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "financeiroSequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "financeiroSequenceGenerator")
	private Long IdEvento;
	
	@NotNull(message="Campo Mês Referência não pode estar em branco")
	@Enumerated(EnumType.STRING)
	private Evento mesReferencia;
	
	@NotBlank(message="Campo Ano Referência não pode estar em branco")
	private String anoReferencia;
	
	@NotBlank(message="Campo Data Operação não pode estar em branco")
	private String dtOperacao;
	
	private BigDecimal entradas;
	
	private BigDecimal saidas;
	
	private BigDecimal saldo;

	public Long getIdEvento() {
		return IdEvento;
	}

	public void setIdEvento(Long idEvento) {
		IdEvento = idEvento;
	}

	public Evento getMesReferencia() {
		return mesReferencia;
	}

	public void setMesReferencia(Evento mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public String getAnoReferencia() {
		return anoReferencia;
	}

	public void setAnoReferencia(String anoReferencia) {
		this.anoReferencia = anoReferencia;
	}

	public String getDtOperacao() {
		return dtOperacao;
	}

	public void setDtOperacao(String dtOperacao) {
		this.dtOperacao = dtOperacao;
	}

	public BigDecimal getEntradas() {
		return entradas;
	}

	public void setEntradas(BigDecimal entradas) {
		this.entradas = entradas;
	}

	public BigDecimal getSaidas() {
		return saidas;
	}

	public void setSaidas(BigDecimal saidas) {
		this.saidas = saidas;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

}
