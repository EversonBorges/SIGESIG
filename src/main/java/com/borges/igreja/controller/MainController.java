package com.borges.igreja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.borges.igreja.model.Templo;
import com.borges.igreja.repository.UsuarioRepository;
import com.borges.igreja.security.model.UsuarioModel;
import com.borges.igreja.security.model.UsuarioSecurityModel;

@Controller
public class MainController {
	
	@Autowired
	private UsuarioRepository ur;

	/***
	 * ESSE MÉTODO CARREGA A PÁGINA(index.html) DE LOGIN DA NOSSA APLICAÇÃO
	 * @return
	 * public String suaAction(@AuthenticationPrincipal Usuario usuario) {
    ...    // usuario.getUsername(); 
}
	 */
	@RequestMapping(value="/", method= RequestMethod.GET)	
	public String index(@AuthenticationPrincipal UsuarioSecurityModel usuario ){	
		
		String user = usuario.getNome();
		
		System.out.println("Nome Usuário :"+ user);
		
		/*
		Model model
		
String user = SecurityContextHolder.getContext().getAuthentication().getName();

		
		String usuario = ur.findByNome(user);
	    String templo = ur.findByNome1(user);
	    
	    Long.parseLong( templo );
		
		model.addAttribute("User",usuario);
		
		model.addAttribute("templo", templo);*/
		
	    return "inicio";
	}
	
	/***
	 * CARREGA À PÁGINA INICIAL DA APLICAÇÃO APÓS EFETUARMOS O LOGIN 
	 * @return
	 */
	@RequestMapping(value="/entrar", method= RequestMethod.GET)
	public String home(){
		
		return "entrar";
	}
	
	/***
	 * MOSTRA UM PÁGINA COM A MENSAGEM DE ACESSO NEGADO QUANDO O 
	 * USUÁRIO NÃO TIVER PERMISSÃO DE ACESSAR UMA DETERMINADA FUNÇÃO DO SISTEMA
	 * @return
	 */
	@RequestMapping(value="/acessoNegado", method= RequestMethod.GET)
	public String acessoNegado(){
		
		return "acessoNegado";
	}
	
}
