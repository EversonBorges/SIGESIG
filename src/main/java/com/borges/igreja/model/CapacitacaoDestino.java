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

import com.borges.igreja.enumerators.Status;

@Entity
@Table(name="capacitacaoDestino")
public class CapacitacaoDestino {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCD;
	
	@NotNull(message = "Campo Templo não pode estar em branco")
	@ManyToOne
	private Templo templo;
	
	@NotBlank(message = "Campo Data Inicio não pode estar em branco")
	private String dtInicio;
	
	private String dtTermino;
	
	@NotNull(message = "Campo Status não pode estar em branco")
		@Enumerated(EnumType.STRING)
		private Status tipo;
	
	@NotBlank(message = "Campo Descrição não pode estar em branco")
	private String descCD;

		public Long getIdCD() {
			return idCD;
		}

		public void setIdCD(Long idCD) {
			this.idCD = idCD;
		}
		public Templo getTemplo() {
			return templo;
		}

		public void setTemplo(Templo templo) {
			this.templo = templo;
		}

		public String getDtInicio() {
			return dtInicio;
		}

		public void setDtInicio(String dtInicio) {
			this.dtInicio = dtInicio;
		}

		public String getDtTermino() {
			return dtTermino;
		}

		public void setDtTermino(String dtTermino) {
			this.dtTermino = dtTermino;
		}

		public Status getTipo() {
			return tipo;
		}

		public void setTipo(Status tipo) {
			this.tipo = tipo;
		}

		public String getDescCD() {
			return descCD;
		}

		public void setDescCD(String descCD) {
			this.descCD = descCD;
		}
		
}
