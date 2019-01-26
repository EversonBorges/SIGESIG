package com.borges.igreja.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.borges.igreja.enumerators.AulaEnum;

@Entity
@Table(name="aulaModulo")
public class AulaModulo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idAulaModulo;
	
	@NotNull(message = "Campo Descrição não pode estar em branco")
	@Enumerated(EnumType.STRING)
	private AulaEnum descAula;
	
	@NotBlank(message = "Campo Data não pode estar em branco")
	private String dataAula;
	
	@ManyToOne
	private Membros professorAula;
	
	@ManyToOne
	private Modulos moduloAula;

	public Long getIdAulaModulo() {
		return idAulaModulo;
	}

	public void setIdAulaModulo(Long idAulaModulo) {
		this.idAulaModulo = idAulaModulo;
	}

	public AulaEnum getDescAula() {
		return descAula;
	}

	public void setDescAula(AulaEnum descAula) {
		this.descAula = descAula;
	}

	public String getDataAula() {
		return dataAula;
	}

	public void setDataAula(String dataAula) {
		this.dataAula = dataAula;
	}

	public Membros getProfessorAula() {
		return professorAula;
	}

	public void setProfessorAula(Membros professorAula) {
		this.professorAula = professorAula;
	}

	public Modulos getModuloAula() {
		return moduloAula;
	}

	public void setModuloAula(Modulos moduloAula) {
		this.moduloAula = moduloAula;
	}
	
}
