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

import com.borges.igreja.model.Ministerio;
import com.borges.igreja.service.impl.MinisterioServiceImpl;
import com.borges.igreja.util.Message;


@Controller
@RequestMapping("/ministerio")
public class MinisterioController {

	@Autowired
	private MinisterioServiceImpl ministerioService;
	
	/**LISTA TODOS OS MINISTERIOS
	 * @return
	 */
	@GetMapping
	public ModelAndView listarTodos(){
		ModelAndView modelAndView = new ModelAndView("ministerio/listarMT");
		modelAndView.addObject("ministerios", ministerioService.listarTodos());
		return modelAndView;
	}
	
	/** MONTA A VIEW PARA CADASTRAR UM NOVO MINISTERIO
	 * @param ministerio
	 * @return
	 */
	@GetMapping("/novo")
	public ModelAndView novo(Ministerio ministerio){
		ModelAndView modelAndView = new ModelAndView("ministerio/cadastrarMT");
		if (ministerio.getIdMinisterio() == null) {
			modelAndView.addObject("title", "Cadastrar Ministério");
			modelAndView.addObject("btn", "Cadastrar");
		}else {
			modelAndView.addObject("title", "Editar Ministério");
			modelAndView.addObject("btn", "Editar");
			
		}
		
		modelAndView.addObject(ministerio);
		return modelAndView;
	}
	
	/**SALVA UM MINISTERIO
	 * @param ministerio
	 * @param result
	 * @param attributes
	 * @return
	 */
	@PostMapping("/novo")
	public ModelAndView cadastrar(@Valid Ministerio ministerio,BindingResult result,RedirectAttributes attributes){
		if (result.hasErrors()) {
			return novo(ministerio);	
		}
		
		if (ministerio.getIdMinisterio() != null) {
			ministerioService.cadastrar(ministerio);
			attributes.addFlashAttribute("message",Message.getMsgEditado());
			return new ModelAndView("redirect:/ministerio");
		}
		ministerioService.cadastrar(ministerio);
		attributes.addFlashAttribute("message",Message.getMsgSucessoAdicionar());
		return new ModelAndView("redirect:/ministerio/novo");
	}
	
	/**RETORNA MINISTERIO PELO ID
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id){
		return novo(ministerioService.listarId(id));		
	}
	
	/**EXCLUI UM MINISTERIO
	 * @param id
	 * @param attributes
	 * @return
	 */
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Long id,RedirectAttributes attributes){
		try {
			ministerioService.remover(id);
			attributes.addFlashAttribute("message",Message.getMsgDeleteSucesso());
			 return "redirect:/ministerio";
			
		} catch (Exception e) {
			attributes.addFlashAttribute("messageErro",Message.getMsgDeleteError());
			return "redirect:/ministerio";
		}
	}

}
