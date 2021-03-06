package com.borges.igreja.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.NotBlank;

import com.borges.igreja.enumerators.OperacaoEntrada;

@Entity
@Table(name="entradas")
public class Entradas {
	
	@GenericGenerator(
            name = "entradaSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "entradaSequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "entradaSequenceGenerator")
	private Long idEntrada;
	
	@NotNull(message="Campo Tipo Entrada não pode estar em branco")
	@Enumerated(EnumType.STRING)
	private OperacaoEntrada entrada;
	
	@NotBlank(message="Campo Valor não pode estar em branco")
	private BigDecimal valorEntrada;
	
	@NotBlank(message="Campo Data Entrada não pode estar em branco")
	private String dtEntrada;
	
	@ManyToOne
	private Membros dizimista;

	public Long getIdEntrada() {
		return idEntrada;
	}

	public void setIdEntrada(Long idEntrada) {
		this.idEntrada = idEntrada;
	}

	public OperacaoEntrada getEntrada() {
		return entrada;
	}

	public void setEntrada(OperacaoEntrada entrada) {
		this.entrada = entrada;
	}

	public BigDecimal getValorEntrada() {
		return valorEntrada;
	}

	public void setValorEntrada(BigDecimal valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

	public String getDtEntrada() {
		return dtEntrada;
	}

	public void setDtEntrada(String dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public Membros getDizimista() {
		return dizimista;
	}

	public void setDizimista(Membros dizimista) {
		this.dizimista = dizimista;
	}

}
