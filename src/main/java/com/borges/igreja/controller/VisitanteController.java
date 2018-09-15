package com.borges.igreja.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.borges.igreja.enumerators.Opcao;
import com.borges.igreja.enumerators.Religiao;
import com.borges.igreja.enumerators.Sexo;
import com.borges.igreja.model.Visitantes;
import com.borges.igreja.service.impl.MembrosServiceImpl;
import com.borges.igreja.service.impl.TemploServiceImpl;
import com.borges.igreja.service.impl.VisitanteServiceImpl;
import com.borges.igreja.util.Message;

@Controller
@RequestMapping("/visitantes")
public class VisitanteController {
	
	@Autowired
	private VisitanteServiceImpl visitanteService;
	
	@Autowired
	private MembrosServiceImpl membrosService;
	
	@Autowired
	private TemploServiceImpl temploService;
	
	@GetMapping
	public ModelAndView listarTodos() {
		ModelAndView modelAndView = new ModelAndView("visitantes/listarVT");
		modelAndView.addObject("visitantes", visitanteService.listarTodos());
		return modelAndView;
		
	}
	
	@GetMapping("/novo")
	private ModelAndView novo(Visitantes visitantes) {
		ModelAndView modelAndView = new ModelAndView("visitantes/cadastrarVT");
		
		if(visitantes.getIdVisitante() == null) {
			modelAndView.addObject("title", "Cadastrar Visitante");
			modelAndView.addObject("btn", "Cadastrar");
		}else {
			modelAndView.addObject("title", "Editar Visitante");
			modelAndView.addObject("btn", "Editar");
		}
		modelAndView.addObject(visitantes);
		modelAndView.addObject("templos", temploService.listarTodos());
		modelAndView.addObject("membros", membrosService.listarTodos());
		modelAndView.addObject("sexos", Sexo.values());
		modelAndView.addObject("opcao", Opcao.values());
		modelAndView.addObject("religioes", Religiao.values());
		
		return modelAndView;
	}
	
	@PostMapping("/novo")
	private ModelAndView cadastrar(@Valid Visitantes visitantes,BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(visitantes);	
		}
		
		if(visitantes.getIdVisitante() != null){
			visitanteService.cadastrar(visitantes);
			attributes.addFlashAttribute("message",Message.getMsgEditado());
			return new ModelAndView("redirect:/visitantes");
		}
		visitanteService.cadastrar(visitantes);
		attributes.addFlashAttribute("message",Message.getMsgSucessoCadastrar());
		return new ModelAndView("redirect:/visitantes/novo");
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return novo(visitanteService.listarId(id));
	}
	
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Long id,RedirectAttributes attributes) {
		
		try {
			visitanteService.remover(id);
			attributes.addFlashAttribute("message",Message.getMsgDeleteSucesso());
			return "redirect:/visitantes";
			
		} catch (Exception e) {
			attributes.addFlashAttribute("message",Message.getMsgDeleteError());
			return "redirect:/visitantes";
		}
	}

}
