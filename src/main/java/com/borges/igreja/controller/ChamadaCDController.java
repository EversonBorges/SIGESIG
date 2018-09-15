package com.borges.igreja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.borges.igreja.model.AulaModulo;
import com.borges.igreja.model.CapacitacaoDestino;
import com.borges.igreja.model.ChamadaCD;
import com.borges.igreja.model.Modulos;
import com.borges.igreja.service.impl.AddAlunoCDServiceImpl;
import com.borges.igreja.service.impl.AulaModuloServiceImpl;
import com.borges.igreja.service.impl.CapacitacaoDestinoServiceImpl;
import com.borges.igreja.service.impl.ChamadaCDServiceImpl;
import com.borges.igreja.service.impl.CriarModuloServiceImpl;
import com.borges.igreja.service.impl.ModulosServiceImpl;
import com.borges.igreja.util.Message;

/**
 * @author Borges
 *
 */
@Controller
@RequestMapping("/chamada")
public class ChamadaCDController {
	
	@Autowired
	private ChamadaCDServiceImpl chamadaCDService;
	
	@Autowired
	private CapacitacaoDestinoServiceImpl destinoService;
	
	@Autowired
	private AddAlunoCDServiceImpl addAlunoCDServiceImpl;
	
	@Autowired
	private AulaModuloServiceImpl aulaModuloService;
	
	@Autowired
	private ModulosServiceImpl moduloService;
	
	@GetMapping
	public ModelAndView listarTodos(){
		ModelAndView modelAndView = new ModelAndView("capacitacaoDestino/chamadaCD2");
		modelAndView.addObject("chamadas", chamadaCDService.listarTodos());
		
		return modelAndView;
	}
	
	@GetMapping("/novo")
	public ModelAndView novo(ChamadaCD chamadaCD){
		ModelAndView modelAndView = new ModelAndView("capacitacaoDestino/chamadaCD");
		
		if (chamadaCD.getModuloCD() == null) {
			modelAndView.addObject("title", "Cadastrar Chamada");
			modelAndView.addObject("btn", "Cadastrar");
		} else {
			modelAndView.addObject("title", "Editar Chamada");
			modelAndView.addObject("btn", "Editar");
		}
		
		modelAndView.addObject(chamadaCD);
		modelAndView.addObject("capacitacao", destinoService.listarTodos());
		//modelAndView.addObject("modulos", criarModuloService.listarTodos());
		
		
		return modelAndView;
	}
	
	@GetMapping("/mods/{id}")
	public ModelAndView modulo(@PathVariable Long id, Modulos modulos) {
		CapacitacaoDestino capacitacaoDestino = destinoService.listarId(id);
		ModelAndView modelAndView = new ModelAndView("capacitacaoDestino/chamadaCD");
		modelAndView.addObject(modulos);
		modelAndView.addObject("capacitacao", destinoService.listarId(id));
		modelAndView.addObject("criarModulos", moduloService.listModulos(capacitacaoDestino));

		return modelAndView; 
	}
	
	 @GetMapping("/aula/{id}/{idMod}")
	public ModelAndView aula(@PathVariable Long id,@PathVariable Long idMod, AulaModulo aulaModulo) {
		CapacitacaoDestino capacitacaoDestino = destinoService.listarId(id);
		Modulos modulos = moduloService.listarId(idMod);
		ModelAndView modelAndView = new ModelAndView("capacitacaoDestino/chamadaCD");
		modelAndView.addObject(aulaModulo);
		modelAndView.addObject("capacitacao", destinoService.listarId(id));
		modelAndView.addObject("criarModulos", moduloService.listModulos(capacitacaoDestino));
		modelAndView.addObject("aulas", aulaModuloService.listModulo(modulos));
		
		return modelAndView; 
	}
	 
	 @GetMapping("/presenca/{id}/{idMod}")
		public ModelAndView aula(@PathVariable Long id,@PathVariable Long idMod,ChamadaCD chamadaCD ) {
			CapacitacaoDestino capacitacaoDestino = destinoService.listarId(id);
			Modulos modulos = moduloService.listarId(idMod);
			ModelAndView modelAndView = new ModelAndView("capacitacaoDestino/chamadaCD");
			modelAndView.addObject(chamadaCD);
			modelAndView.addObject("capacitacao", destinoService.listarId(id));
			modelAndView.addObject("criarModulos", moduloService.listModulos(capacitacaoDestino));
			modelAndView.addObject("aulas", aulaModuloService.listModulo(modulos));
			modelAndView.addObject("alunos", addAlunoCDServiceImpl.listAluno(modulos));

			return modelAndView; 
		}
	 /*
	  *@DeleteMapping("/modulo/{id}/{idMod}")
	public ModelAndView removerModulo(@PathVariable Long id,@PathVariable Long idMod, RedirectAttributes attributes) {

		try {
			modulosServiceImpl.remover(id);
			attributes.addFlashAttribute("message", Message.getMsgDeleteSucesso());
			return new ModelAndView("redirect:/capacitacaoDestino/modulo/{idMod}");

		} catch (Exception e) {
			attributes.addFlashAttribute("messageErro", Message.getMsgDeleteError());
			return new ModelAndView("redirect:/capacitacaoDestino/modulo/{idMod}");
		}
	} 
	  */

}
