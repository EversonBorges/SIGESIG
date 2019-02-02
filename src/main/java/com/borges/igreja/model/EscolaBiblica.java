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

import com.borges.igreja.enumerators.Status;
import com.borges.igreja.enumerators.Turmas;

@Entity
@Table(name = "escolaBiblica")
public class EscolaBiblica {
	
	@GenericGenerator(
            name = "escolaBiblicaSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "escolaBiblicaSequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "escolaBiblicaSequenceGenerator")
	private Long idEB;
	
	@NotNull(message = "Campo Turma não pode estar em branco")
	private Turmas turma;
	
	@NotNull(message = "Campo Professor não pode estar em branco")
	@ManyToOne
	private Membros professor;
	
	@NotBlank(message = "Campo Data Inicio não pode estar em branco")
	private String dtInicio;
	
	//@NotNull(message = "Campo Status não pode estar em branco")
	@Enumerated(EnumType.STRING)
	private Status tipo;
	
	@NotNull(message = "Campo Templo não pode estar em branco")
	@ManyToOne
	private Templo templo;

	public Long getIdEB() {
		return idEB;
	}

	public void setIdEB(Long idEB) {
		this.idEB = idEB;
	}

	public Turmas getTurma() {
		return turma;
	}

	public void setTurma(Turmas turma) {
		this.turma = turma;
	}

	public Membros getProfessor() {
		return professor;
	}

	public void setProfessor(Membros professor) {
		this.professor = professor;
	}

	public String getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(String dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Status getTipo() {
		return tipo;
	}

	public void setTipo(Status tipo) {
		this.tipo = tipo;
	}
	
	public Templo getTemplo() {
		return templo;
	}

	public void setTemplo(Templo templo) {
		this.templo = templo;
	}

}
