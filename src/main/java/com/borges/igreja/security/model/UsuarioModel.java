package com.borges.igreja.security.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.borges.igreja.model.Templo;

public class UsuarioModel implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long	  codigo;
	
	@NotEmpty(message ="O Nome é de preenchimento obrigatório.")
	private String	  nome;
	
	@NotEmpty(message ="O Login é de preenchimento obrigatório.")
	private String   login;
	
	@NotEmpty(message ="A Senha é de preenchimento obrigatório.")
	private String   senha;
	
	private boolean ativo;
	
	@NotNull(message ="O Templo é de preenchimento obrigatório.")
	private Templo templo;
	
	@NotEmpty(message ="Não existe nenhum grupo selecionado.")
	private  List<Long> grupos; 
	
	public UsuarioModel(){
		
		System.out.println("Passei " + LocalDate.now());
	}
	
	public UsuarioModel(Long codigo, String nome, String login,Templo templo, String senha, boolean ativo, List<Long> grupos) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.login = login;
		this.templo = templo;
		this.senha = senha;
		this.ativo = ativo;
		this.grupos = grupos;
	}	
	
	public Long getCodigo() {		
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<Long> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Long> grupos) {
		this.grupos = grupos;
	}
	
	public Templo getTemplo() {
		return templo;
	}

	public void setTemplo(Templo templo) {
		this.templo = templo;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return nome;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
