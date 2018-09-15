package com.borges.igreja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.borges.igreja.service.impl.UsuarioService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsuarioService usuarioRepositoryImpl;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			authorizeRequests()
				//.antMatchers("/usuario/novoCadastro","/usuario/consultar").hasAnyRole("ADMIN")
				//.antMatchers("/financeiro").hasAnyRole("TESOURARIA")
				//.antMatchers("/ministerio/novo","/membros","/visitantes/novo","/templos","/escolaBiblica").hasAnyRole("CADASTROUSUARIO")
				//.antMatchers("/ministerio","/visitantes").hasAnyRole("ADMIN")
				//.antMatchers("/capacitacaoDestino").hasAnyRole("ADMIN")
				//.antMatchers("/capacitacaoDestino","/celulas").hasAnyRole("SECRETARIA")
				.anyRequest()
				.authenticated()
			.and()
			.formLogin()
				.loginPage("/entrar")
				.permitAll()
			.and()
			.logout()
				.logoutSuccessUrl("/entrar?logout")
				.permitAll();
		/*PÁGINA COM A MENSAGEM DE ACESSO NEGADO
		 *QUANDO O USUÁRIO NÃO TER UMA DETERMINADA PERMISSÃO DE ACESSO AO SISTEMA ELE VAI SER REDIRECIONADO
		 *PARA A URL ABAIXO */
		http.exceptionHandling().accessDeniedPage("/acessoNegado");
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			
        /*INFORMA A CRIPTOGRAFIA QUE DEVE SER USADA PARA A SENHA DO USÁRIO*/				
		auth.userDetailsService(usuarioRepositoryImpl).passwordEncoder(new BCryptPasswordEncoder());
    }
	/*
	 * CRIPTOGRAFANDO A SENHA PARA TESTE
	public static void main(String[] args) {
		
		System.out.println(new BCryptPasswordEncoder().encode("123456"));
	}
	*/
}
