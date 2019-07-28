package com.borges.igreja.model;

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
import org.hibernate.validator.constraints.br.CNPJ;

import com.borges.igreja.enumerators.Status;

@Entity
@Table(name = "templo")
public class Templo extends Endereco {
	
	@GenericGenerator(
            name = "temploSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "temploSequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "temploSequenceGenerator")
	private Long idTemplo;
	
//	@NotBlank(message = "Campo Nome Fantasia não pode estar em branco")
	private String nomeFantasia;
	
//	@NotBlank(message = "Campo Razão Social não pode estar em branco")
	private String razaoSocial;
	
//	@NotBlank(message = "Campo CNPJ não pode estar em branco")
	@CNPJ(message = "CNPJ Inválido!")
	private String cnpj;
	
	//@NotBlank(message = "Campo Data Abertura não pode estar em branco")
	private String dtAbertura;
	
	@ManyToOne
	private Membros pastorTitular;
	
	@ManyToOne
	private Membros pastorAux;
	
	//@NotNull(message = "Campo Status não pode estar em branco")
	@Enumerated(EnumType.STRING)
	private Status tipo;
	
	public Long getIdTemplo() {
		return idTemplo;
	}
	public void setIdTemplo(Long idTemplo) {
		this.idTemplo = idTemplo;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getDtAbertura() {
		return dtAbertura;
	}

	public void setDtAbertura(String dtAbertura) {
		this.dtAbertura = dtAbertura;
	}

	public Membros getPastorTitular() {
		return pastorTitular;
	}

	public void setPastorTitular(Membros pastorTitular) {
		this.pastorTitular = pastorTitular;
	}

	public Membros getPastorAux() {
		return pastorAux;
	}

	public void setPastorAux(Membros pastorAux) {
		this.pastorAux = pastorAux;
	}

	public Status getTipo() {
		return tipo;
	}

	public void setTipo(Status tipo) {
		this.tipo = tipo;
	}
}