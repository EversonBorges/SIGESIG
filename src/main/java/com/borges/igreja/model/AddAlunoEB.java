package com.borges.igreja.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="addalunoeb")
public class AddAlunoEB {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAddAluno;
	
	@NotNull(message = "Campo Aluno não pode estar em branco")
	@ManyToOne
	private Membros alunos;
	
	@ManyToOne
	private EscolaBiblica escolaBiblica;
	
	@NotBlank(message = "Campo Data Matricula não pode estar em branco")
	private String dtInicioEB;

	public Long getIdAddAluno() {
		return idAddAluno;
	}

	public void setIdAddAluno(Long idAddAluno) {
		this.idAddAluno = idAddAluno;
	}

	public Membros getAlunos() {
		return alunos;
	}

	public void setAlunos(Membros alunos) {
		this.alunos = alunos;
	}

	public EscolaBiblica getEscolaBiblica() {
		return escolaBiblica;
	}

	public void setEscolaBiblica(EscolaBiblica escolaBiblica) {
		this.escolaBiblica = escolaBiblica;
	}

	public String getDtInicioEB() {
		return dtInicioEB;
	}

	public void setDtInicioEB(String dtInicioEB) {
		this.dtInicioEB = dtInicioEB;
	}
}
