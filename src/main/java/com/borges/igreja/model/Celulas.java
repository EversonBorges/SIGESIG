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

@Entity
@Table(name="celulas")
public class Celulas extends Endereco {
	
	@GenericGenerator(
            name = "celulasSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "celulasbSequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "celulasSequenceGenerator")
	private Long idCelula;
	
	@NotBlank(message = "Campo Nome não pode estar em branco")
	private String nome;
	
	@NotBlank(message = "Campo Data Abertura não pode estar em branco")
	private String dtAbertura;
	
	private String celularLider;
	
	@NotNull(message = "Campo Lider não pode estar em branco")
	@ManyToOne
	private Membros lider;
	
	@NotNull(message = "Campo Timóteo não pode estar em branco")
	@ManyToOne
	private Membros timoteo;
	
	@NotBlank(message = "Campo Anfitrião não pode estar em branco")
	private String anfitriao;
	
	@NotNull(message = "Campo Supervisor não pode estar em branco")
	@ManyToOne
	private Membros supervisor;
	
	@NotNull(message = "Campo Supervisor Área não pode estar em branco")
	@ManyToOne
	private Membros superArea;
	
	private Long qtdeParticipantes;
	
	@NotNull(message = "Campo Status não pode estar em branco")
	@Enumerated(EnumType.STRING)
	private Status tipo;

	public Long getIdCelula() {
		return idCelula;
	}

	public void setIdCelula(Long idCelula) {
		this.idCelula = idCelula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDtAbertura() {
		return dtAbertura;
	}

	public void setDtAbertura(String dtAbertura) {
		this.dtAbertura = dtAbertura;
	}

	public String getCelularLider() {
		return celularLider;
	}

	public void setCelularLider(String celularLider) {
		this.celularLider = celularLider;
	}

	public Membros getLider() {
		return lider;
	}

	public void setLider(Membros lider) {
		this.lider = lider;
	}

	public Membros getTimoteo() {
		return timoteo;
	}

	public void setTimoteo(Membros timoteo) {
		this.timoteo = timoteo;
	}

	public String getAnfitriao() {
		return anfitriao;
	}

	public void setAnfitriao(String anfitriao) {
		this.anfitriao = anfitriao;
	}

	public Membros getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Membros supervisor) {
		this.supervisor = supervisor;
	}

	public Membros getSuperArea() {
		return superArea;
	}

	public void setSuperArea(Membros superArea) {
		this.superArea = superArea;
	}

	public Long getQtdeParticipantes() {
		return qtdeParticipantes;
	}

	public void setQtdeParticipantes(Long qtdeParticipantes) {
		this.qtdeParticipantes = qtdeParticipantes;
	}

	public Status getTipo() {
		return tipo;
	}

	public void setTipo(Status tipo) {
		this.tipo = tipo;
	}
}
