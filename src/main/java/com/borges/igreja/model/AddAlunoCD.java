package com.borges.igreja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.NotBlank;

@Entity(name="AddAlunoCD")
@Table(name="addalunocd")
public class AddAlunoCD {

	@GenericGenerator(
            name = "addalunocdSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "addalunocdSequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "addalunocdSequenceGenerator")
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
