package com.borges.igreja.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="chamadaCD")
public class ChamadaCD implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idChamada;
	
	@NotNull(message = "Campo Aluno não pode estar em branco")
	@ManyToOne
	private AddAlunoCD alunoCD;
	
	
	@NotNull(message = "Campo Aula não pode estar em branco")
	@ManyToOne
	private AulaModulo aulaModCD;
	
	@NotNull(message = "Campo Modulo não pode estar em branco")
	@ManyToOne
	private Modulos moduloCD;
	

	@NotNull(message = "Campo Aluno não pode estar em branco")
	private boolean presenca = false;


	public AddAlunoCD getAlunoCD() {
		return alunoCD;
	}

	public void setAlunoCD(AddAlunoCD alunoCD) {
		this.alunoCD = alunoCD;
	}


	public AulaModulo getAulaModCD() {
		return aulaModCD;
	}


	public void setAulaModCD(AulaModulo aulaModCD) {
		this.aulaModCD = aulaModCD;
	}


	public Modulos getModuloCD() {
		return moduloCD;
	}


	public void setModuloCD(Modulos moduloCD) {
		this.moduloCD = moduloCD;
	}


	public boolean isPresenca() {
		return presenca;
	}


	public void setPresenca(boolean presenca) {
		this.presenca = presenca;
	}


	public Long getIdChamada() {
		return idChamada;
	}


	public void setIdChamada(Long idChamada) {
		this.idChamada = idChamada;
	}
	
}
