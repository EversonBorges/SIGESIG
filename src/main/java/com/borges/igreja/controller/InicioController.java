package com.borges.igreja.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
public class InicioController {
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/")
    public String inicio() {

		return "inicio";
    }
	
	/*@RequestMapping(method = RequestMethod.GET, path = "/")
    public String inicio(ModelMap map) {
		
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName(); //get logged in username
		map.addAttribute("user", name);
		
		return "inicio";
    }*/
	
	@RequestMapping(method = RequestMethod.GET, path = "/entrar")
    public String entrar() {
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
