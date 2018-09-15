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

import com.borges.igreja.enumerators.AulaEnum;
import com.borges.igreja.model.AddAlunoCD;
import com.borges.igreja.model.AulaModulo;
import com.borges.igreja.model.Modulos;
import com.borges.igreja.service.impl.AulaModuloServiceImpl;
import com.borges.igreja.service.impl.MembrosServiceImpl;
import com.borges.igreja.service.impl.ModulosServiceImpl;
import com.borges.igreja.util.Message;

@Controller
@RequestMapping("/aulaModulo")
public class AulaModuloController {
	
	/*
	
	@Autowired
	private AulaModuloServiceImpl aulaModuloServiceImpl;
	
	@Autowired
	private ModulosServiceImpl modulosServiceImpl;
	
	@Autowired
	private MembrosServiceImpl membrosServiceImpl;
	
	/**RETORNA UMA VIEW PELO ID DO MODULO
	 * @param id
	 * @param aulaModulo
	 * @return
	 */
/*
	@GetMapping("/modulo/{id}")
	public ModelAndView aulaMod(@PathVariable Long id,AulaModulo aulaModulo) {
		Modulos modulos = modulosServiceImpl.listarId(id);
		ModelAndView modelAndView = new ModelAndView("capacitacaoDestino/AddAulaMod");
		modelAndView.addObject("aulaModulos",aulaModuloServiceImpl.listModulo(modulos));
		modelAndView.addObject(aulaModulo);
		modelAndView.addObject("descricao", AulaEnum.values());
		modelAndView.addObject("professor", membrosServiceImpl.listarTodos());
		modelAndView.addObject("modulos", modulos);
		
		return modelAndView;
		
	}
	
	@PostMapping("/modulo/{id}")
	public ModelAndView aulaModPost(@PathVariable Long id, @Valid AulaModulo aulaModulo, 
			BindingResult result, RedirectAttributes attributes) {
		
		Modulos modulos = modulosServiceImpl.listarId(id);
		aulaModulo.setModuloAula(modulos);
		
		if(result.hasErrors()) {
			return aulaMod(id, aulaModulo);
		}
		
		aulaModuloServiceImpl.cadastrar(aulaModulo);
		attributes.addFlashAttribute("message",Message.getMsgSucessoCadastrar());
		return new ModelAndView("redirect:/aulaModulo/{id}");
	}
	
	@DeleteMapping("/modulo/{id}")
	public String remover(@PathVariable Long id, RedirectAttributes attributes) {
		
		try {
			aulaModuloServiceImpl.remover(id);
			attributes.addFlashAttribute("message",Message.getMsgDeleteSucesso());
			return "redirect:/aulaModulo/{id}/{idMod}";
			
		} catch (Exception e) {
			attributes.addFlashAttribute("messageErro",Message.getMsgDeleteError());
			return "redirect:/aulaModulo/{id}/{idMod}";
		}	
	}
	*/
}
