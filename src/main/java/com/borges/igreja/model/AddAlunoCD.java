package com.borges.igreja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity(name="AddAlunoCD")
@Table(name="addalunocd")
public class AddAlunoCD {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idAddAlunoCD")
	private Integer idAddAlunoCD;
	
	@NotNull(message = "Campo Aluno não pode estar em branco")
	@ManyToOne
	private Membros alunos;
	
	@ManyToOne
	private Modulos modulos;
	
	@NotBlank(message = "Campo Data Matricula não pode estar em branco")
	@Column(name="dtMatricula")
	private String dtMatricula;
	
	@Column(name="frequencia")
	private float frequencia;
	
	public Integer getIdAddAlunoCD() {
		return idAddAlunoCD;
	}

	public void setIdAddAlunoCD(Integer idAddAlunoCD) {
		this.idAddAlunoCD = idAddAlunoCD;
	}


	public Membros getAlunos() {
		return alunos;
	}


	public void setAlunos(Membros alunos) {
		this.alunos = alunos;
	}

	public Modulos getModulos() {
		return modulos;
	}


	public void setModulos(Modulos modulos) {
		this.modulos = modulos;
	}


	public String getDtMatricula() {
		return dtMatricula;
	}


	public void setDtMatricula(String dtMatricula) {
		this.dtMatricula = dtMatricula;
	}

	public float getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(float frequencia) {
		this.frequencia = frequencia;
	}
	
}
