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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.borges.igreja.model.CriarModulo;
import com.borges.igreja.service.impl.CriarModuloServiceImpl;
import com.borges.igreja.service.impl.GravarImagem;
import com.borges.igreja.util.Message;

@Controller
@RequestMapping("/criarModulo")
public class CriarModuloController {
	
	@Autowired
	private CriarModuloServiceImpl serviceImpl;
	
	@Autowired
	private GravarImagem gravarImagem;
	
	/**LISTA TODOS OS MINISTERIOS
	 * @return
	 */
	@GetMapping
	public ModelAndView listarTodos(){
		ModelAndView modelAndView = new ModelAndView("criarModulo/listarMDC");
		modelAndView.addObject("modulos", serviceImpl.listarTodos());
		return modelAndView;
	}
	
	/** MONTA A VIEW PARA CRIAR UM NOVO MODULO
	 * @param ministerio
	 * @return
	 */
	@GetMapping("/novo")
	public ModelAndView novo(CriarModulo criarModulo){
		ModelAndView modelAndView = new ModelAndView("criarModulo/cadastrarMDC");
		if (criarModulo.getIdCriarModulo() == null) {
			modelAndView.addObject("title", "Cadastrar Modulo");
			modelAndView.addObject("btn", "Cadastrar");
		}else {
			modelAndView.addObject("title", "Editar Modulo");
			modelAndView.addObject("btn", "Editar");
			
		}
		
		modelAndView.addObject(criarModulo);
		return modelAndView;
	}
	
	/**SALVA UM MODULO
	 * @param ministerio
	 * @param result
	 * @param attributes
	 * @return
	 */
	@PostMapping("/novo")
	public ModelAndView cadastrar(@RequestParam("file") MultipartFile file,@Valid CriarModulo criarModulo,BindingResult result,RedirectAttributes attributes){
		if (result.hasErrors()) {
			return novo(criarModulo);	
		}
		
		if (criarModulo.getIdCriarModulo() != null) {
			gravarImagem.gravaImagemBase64Service(file, serviceImpl, criarModulo);
			attributes.addFlashAttribute("message",Message.getMsgEditado());
			return new ModelAndView("redirect:/criarModulo");
		}
		//serviceImpl.cadastrar(criarModulo);
		gravarImagem.gravaImagemBase64Service(file, serviceImpl, criarModulo);
		attributes.addFlashAttribute("message",Message.getMsgSucessoAdicionar());
		return new ModelAndView("redirect:/criarModulo/novo");
	}
	
	/**RETORNA MODULO PELO ID
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id){
		return novo(serviceImpl.listarId(id));		
	}
	
	/**EXCLUI UM MODULO
	 * @param id
	 * @param attributes
	 * @return
	 */
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Long id,RedirectAttributes attributes){
		try {
			serviceImpl.remover(id);
			attributes.addFlashAttribute("message",Message.getMsgDeleteSucesso());
			 return "redirect:/criarModulo";
			
		} catch (Exception e) {
			attributes.addFlashAttribute("messageErro",Message.getMsgDeleteError());
			return "redirect:/criarModulo";
		}
	}


}
