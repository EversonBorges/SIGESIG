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
@Table(name="capacitacaoDestino")
public class CapacitacaoDestino {

	@GenericGenerator(
            name = "capacitacaoDestinoSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "capacitacaoDestinoSequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "capacitacaoDestinoSequenceGenerator")
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
