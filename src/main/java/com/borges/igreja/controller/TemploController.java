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
import com.borges.igreja.enumerators.Status;
import com.borges.igreja.exceptions.MinhaException;
import com.borges.igreja.model.Templo;
import com.borges.igreja.service.MembrosService;
import com.borges.igreja.service.impl.TemploServiceImpl;
import com.borges.igreja.util.Message;

@Controller
@RequestMapping("/templos")
public class TemploController {

	@Autowired
	private TemploServiceImpl temploService;

	@Autowired
	private MembrosService membrosService;

	@GetMapping
	public ModelAndView listarTodos() {
		ModelAndView modelAndView = new ModelAndView("templos/listarTP");
		modelAndView.addObject("templos", temploService.listarTodos());

		return modelAndView;
	}

	@GetMapping("/novo")
	public ModelAndView novo(Templo templo) {
		ModelAndView modelAndView = new ModelAndView("templos/cadastrarTP");

		if (templo.getIdTemplo() == null) {
			modelAndView.addObject("title", "Cadastrar Templo");
			modelAndView.addObject("btn", "Cadastrar");
		} else {
			modelAndView.addObject("title", "Editar Templo");
			modelAndView.addObject("btn", "Editar");
		}

		modelAndView.addObject(templo);
		modelAndView.addObject("pastores", membrosService.listMembrosSup());
		modelAndView.addObject("tipos", Status.values());
		modelAndView.addObject("whatsaaps", Opcao.values());

		return modelAndView;
	}

	@PostMapping("/novo")
	public ModelAndView cadastrar(@Valid Templo templo, BindingResult result, RedirectAttributes attributes,Long id) {
		if (result.hasErrors()) {
			return novo(templo);

		}
		
		if(templo.getIdTemplo() != null){
			temploService.cadastrar(templo);
			attributes.addFlashAttribute("message", Message.getMsgEditado());
			return new ModelAndView("redirect:/templos");
		}
		
		temploService.cadastrar(templo);
		
		attributes.addFlashAttribute("message", Message.getMsgSucessoCadastrar());
		return new ModelAndView("redirect:/templos/novo");
	}

	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return novo(temploService.listarId(id));
	}

	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Long id, Templo templo, BindingResult result, RedirectAttributes attributes)
			throws MinhaException {

		try {
			temploService.remover(id);
			attributes.addFlashAttribute("message",Message.getMsgDeleteSucesso());
			return "redirect:/templos";

		} catch (Exception e) {
			attributes.addFlashAttribute("messageErro", Message.getMsgDeleteError());
			return "redirect:/templos";
		}

	}

}
