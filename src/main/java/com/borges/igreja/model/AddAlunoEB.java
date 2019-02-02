package com.borges.igreja.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="addalunoeb")
public class AddAlunoEB {
	
	 @GenericGenerator(
	            name = "addalunoebSequenceGenerator",
	            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	            parameters = {
	                    @Parameter(name = "sequence_name", value = "addalunoebSequence"),
	                    @Parameter(name = "initial_value", value = "1"),
	                    @Parameter(name = "increment_size", value = "1")
	            }
	    )
	    @Id
	    @GeneratedValue(generator = "addalunoebSequenceGenerator")
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
