package com.borges.igreja.model;

import java.io.Serializable;

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

import com.borges.igreja.enumerators.Opcao;
import com.borges.igreja.enumerators.Religiao;
import com.borges.igreja.enumerators.Sexo;

@Entity
@Table(name = "visitantes")
public class Visitantes extends Endereco implements Serializable {

	private static final long serialVersionUID = -482479883742093689L;

	@GenericGenerator(
            name = "visitantesSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "visitantesSequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "visitantesSequenceGenerator")
	private Long idVisitante;
	
	@NotBlank(message = "Campo Nome não pode estar em branco")
	private String nome;
	
	@NotBlank(message = "Campo Data Nascimento não pode estar em branco")
	private String dtNasc;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Campo Sexo não pode estar em branco")
	private Sexo sexo;
	
	@ManyToOne
	@NotNull(message = "Campo Templo não pode estar em branco")
	private Templo templo;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Campo Religião não pode estar em branco")
	private Religiao religiao;
	
	@ManyToOne
	@NotNull(message = "Campo Quem Convidou não pode estar em branco")
	private Membros convidou;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Campo Visitado não pode estar em branco")
	private Opcao visitado;
	
	@Enumerated(EnumType.STRING)
	private Opcao parente;
	
	private String parentesco;
	
	@ManyToOne
	private Membros quem ;
	
	public Long getIdVisitante() {
		return idVisitante;
	}
	public void setIdVisitante(Long idVisitante) {
		this.idVisitante = idVisitante;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Templo getTemplo() {
		return templo;
	}

	public void setTemplo(Templo templo) {
		this.templo = templo;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public Religiao getReligiao() {
		return religiao;
	}
	public void setReligiao(Religiao religiao) {
		this.religiao = religiao;
	}
	
	public Membros getConvidou() {
		return convidou;
	}
	public void setConvidou(Membros convidou) {
		this.convidou = convidou;
	}
	public Opcao getVisitado() {
		return visitado;
	}
	public void setVisitado(Opcao visitado) {
		this.visitado = visitado;
	}
	public Opcao getParente() {
		return parente;
	}
	public void setParente(Opcao parente) {
		this.parente = parente;
	}
	public String getParentesco() {
		return parentesco;
	}
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	public Membros getQuem() {
		return quem;
	}
	public void setQuem(Membros quem) {
		this.quem = quem;
	}
	public String getDtNasc() {
		return dtNasc;
	}
	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}
	
}
