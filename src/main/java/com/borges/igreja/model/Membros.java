package com.borges.igreja.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import com.borges.igreja.enumerators.Opcao;
import com.borges.igreja.enumerators.Sexo;
import com.borges.igreja.enumerators.Status;

@Entity
@Table(name = "membros")
public class Membros extends Imagens implements  Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -482479883742093689L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMembro;
	
	@NotBlank(message = "Campo Nome não pode estar em branco")
	public String nome;
	
	@NotBlank(message = "Campo CPF não pode estar em branco")
	@CPF(message = "CPF Inválido!")
	private String cpf;
	
	@NotBlank (message = "Campo RG não pode estar em branco")
	private String rg;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Campo Batizado não pode estar em branco")
	private Opcao batizado;
	
	@NotBlank(message = "Campo Data Nascimento não pode estar em branco")
	//@DateTimeFormat(pattern="dd/MM/yyyy")
	//@Temporal(TemporalType.DATE)
	private String dtNasc;
	
	@NotNull(message = "Campo Ministerio não pode estar em branco")
	@ManyToOne
	private Ministerio ministerio; 
	
	@NotNull(message = "Campo Status não pode estar em branco")
	@Enumerated(EnumType.STRING)
	private Status tipo;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Campo Sexo não pode estar em branco")
	private Sexo sexo;
	
	@ManyToOne
	@NotNull(message = "Campo Templo não pode estar em branco")
	private Templo templo;
	
	
	//@NotNull(message = "Campo Idade não pode estar em branco")
	private int idade;
	
	private int turma;
	
	private boolean matriculado;
	
	private boolean concluido;
	
	private boolean matLider;
	
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String uf;
	@NotBlank(message = "Campo Cep não pode estar em branco")
	private String cep;
	private String complemento;
	
	@NotBlank(message = "Campo Celular não pode estar em branco")
	private String celular;
	private String fixo;
	
	@Enumerated(EnumType.STRING)
	private Opcao whatsaap;
	
	@Email(message = "EMAIL Inválido!")
	private String email;
	
	public Opcao getBatizado() {
		return batizado;
	}

	public void setBatizado(Opcao batizado) {
		this.batizado = batizado;
	}

	public Long getIdMembro() {
		return idMembro;
	}
	public void setIdMembro(Long idMembro) {
		this.idMembro = idMembro;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}

	public Ministerio getMinisterio() {
		return ministerio;
	}

	public void setMinisterio(Ministerio ministerio) {
		this.ministerio = ministerio;
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public int getTurma() {
		return turma;
	}
	public void setTurma(int turma) {
		this.turma = turma;
	}
	public boolean isMatriculado() {
		return matriculado;
	}
	public void setMatriculado(boolean matriculado) {
		this.matriculado = matriculado;
	}
	public boolean isConcluido() {
		return concluido;
	}
	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}
	public boolean isMatLider() {
		return matLider;
	}
	public void setMatLider(boolean matLider) {
		this.matLider = matLider;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getFixo() {
		return fixo;
	}

	public void setFixo(String fixo) {
		this.fixo = fixo;
	}

	public Opcao getWhatsaap() {
		return whatsaap;
	}

	public void setWhatsaap(Opcao whatsaap) {
		this.whatsaap = whatsaap;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
