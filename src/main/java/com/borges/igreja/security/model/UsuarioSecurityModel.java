package com.borges.igreja.security.model;


import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.borges.igreja.model.Templo;

	public class UsuarioSecurityModel implements UserDetails {
			
		private static final long serialVersionUID = 1L;
			
			private String nome;
			private String login;
			private String senha;
			private boolean ativo;
			private Templo templo;
			private Collection<GrantedAuthority> permissoes = new ArrayList<>();
			
			public UsuarioSecurityModel(String nome, String login, 
					String senha, Templo templo, boolean ativo,Collection<GrantedAuthority> authorities) {
				this.nome = nome;
				this.login = login;
				this.senha = senha;
				this.templo  = templo;
				this.ativo = ativo;
				this.permissoes= authorities;
			}

			public String getNome() {
				return nome;
			}
			
			public String getLogin() {
				return login;
			}

			public Collection<GrantedAuthority> getPermissoes() {
				return permissoes;
			}
			
			public Templo getTemplo() {
				return templo;
			}

			@Override
			public Collection<GrantedAuthority> getAuthorities() {
				return permissoes;
			}

			@Override
			public String getPassword() {
				return senha;
			}

			@Override
			public String getUsername() {
				return login;
			}

			@Override
			public boolean isAccountNonExpired() {
				return true;
			}

			@Override
			public boolean isAccountNonLocked() {
				return true;
			}

			@Override
			public boolean isCredentialsNonExpired() {
				return true;
			}

			@Override
			public boolean isEnabled() {
				return ativo;
			}		
	}

