package com.borges.igreja.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.borges.igreja.model.CapacitacaoDestino;
import com.borges.igreja.model.Modulos;
import com.borges.igreja.service.impl.CapacitacaoDestinoServiceImpl;
import com.borges.igreja.service.impl.CriarModuloServiceImpl;
import com.borges.igreja.service.impl.ModulosServiceImpl;
import com.borges.igreja.util.Message;

@Controller
@RequestMapping("/modulos")
public class ModulosController {
	/*
	@Autowired
	private CapacitacaoDestinoServiceImpl capacitacaoDestinoService;
	
	
	@Autowired
	private CriarModuloServiceImpl criarModuloServiceImpl;
	
	@Autowired
	private ModulosServiceImpl modulosServiceImpl;
	
	@GetMapping("/modulo/{id}")
	public ModelAndView modulo(@PathVariable Long id,Modulos modulos) {
		CapacitacaoDestino capacitacaoDestino = capacitacaoDestinoService.listarId(id);
		ModelAndView modelAndView = new ModelAndView("capacitacaoDestino/AddModuloCD");
		modelAndView.addObject(modulos);
		modelAndView.addObject("modulos",criarModuloServiceImpl.listarTodos());
		modelAndView.addObject("capacitacaoDestino",capacitacaoDestino);
		modelAndView.addObject("criarModulos", modulosServiceImpl.listModulos(capacitacaoDestino));
		
		return modelAndView;
	}
	
	@PostMapping("/modulo/{id}")
	public ModelAndView moduloPost(@PathVariable Long id,@Valid Modulos modulos, BindingResult result,
			RedirectAttributes attributes) {
		
		CapacitacaoDestino capacitacaoDestino=capacitacaoDestinoService.listarId(id);
		modulos.setDestino(capacitacaoDestino);
		
		if (result.hasErrors()) {
			return modulo(id, modulos);
		}
		modulosServiceImpl.cadastrar(modulos);
		attributes.addFlashAttribute("message",Message.getMsgSucessoCadastrar());
		return new ModelAndView("redirect:/capacitacaoDestino/modulo/{id}");
	}
*/
}
