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
import com.borges.igreja.enumerators.Status;
import com.borges.igreja.model.Celulas;
import com.borges.igreja.model.ParticipanteCL;
import com.borges.igreja.service.MembrosService;
import com.borges.igreja.service.impl.CelulasServiceImpl;
import com.borges.igreja.service.impl.ParticipanteCLServiceImpl;
import com.borges.igreja.util.Message;

@Controller
@RequestMapping("/celulas")
public class CelulasController {
	
	@Autowired
	private CelulasServiceImpl celulasService;
	
	@Autowired
	private MembrosService membrosService;
	
	@Autowired
	private ParticipanteCLServiceImpl participanteCLService;
	
	/**LISTAR TODAS AS CELULAS
	 * @return
	 */
	@GetMapping
	public ModelAndView listarTodos(){
		ModelAndView modelAndView = new ModelAndView("celulas/listarCL");
		modelAndView.addObject("celulas", celulasService.listarTodos());
		
		return modelAndView;
	}

	/**MONTA VIEW PARA ADICIONAR NOVA CELULA
	 * @param celulas
	 * @return
	 */
	@GetMapping("/novo")
	public ModelAndView novo(Celulas celulas){
		ModelAndView modelAndView = new ModelAndView("celulas/cadastrarCL");
		
		if (celulas.getIdCelula() == null) {
			modelAndView.addObject("title", "Cadastrar Célula");
			modelAndView.addObject("btn", "Cadastrar");
		} else {
			modelAndView.addObject("title", "Editar Célula");
			modelAndView.addObject("btn", "Editar");
		}
		
		modelAndView.addObject(celulas);
		modelAndView.addObject("lideres",membrosService.listMembrosLid());
		modelAndView.addObject("timoteos",membrosService.listMembrosLid());
		modelAndView.addObject("supervisores", membrosService.listMembrosSup());
		modelAndView.addObject("superAreas", membrosService.listMembrosSup());
		modelAndView.addObject("whatsaaps", Opcao.values());
		modelAndView.addObject("tipos", Status.values());
		
		
		return modelAndView;
		
	}
	
	/**SALVA UMA NOVA CELULA
	 * @param celulas
	 * @param result
	 * @param attributes
	 * @return
	 */
	@PostMapping("/novo")
	public ModelAndView cadastrar(@Valid Celulas celulas,BindingResult result,RedirectAttributes attributes){
		if (result.hasErrors()) {
			return novo(celulas);
			
		}
		
		if (celulas.getIdCelula() != null) {
			celulasService.cadastrar(celulas);
			attributes.addFlashAttribute("message",Message.getMsgEditado());
			return new ModelAndView("redirect:/celulas");
			
			
			
		} else {
			
			celulasService.cadastrar(celulas);
			attributes.addFlashAttribute("message",Message.getMsgSucessoCadastrar());
			return new ModelAndView("redirect:/celulas/novo");

		}
		
	}
	
	/**RETORNA CELULA POR ID
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id){
		return novo(celulasService.listarId(id));
	}
	
	/**REMOVE UMA CELULA POR ID
	 * @param id
	 * @param attributes
	 * @return
	 */
	@DeleteMapping("/{id}")
	private String remover(@PathVariable Long id,RedirectAttributes attributes){
		try {
			celulasService.remover(id);
			attributes.addFlashAttribute("message", Message.getMsgDeleteSucesso());
			return "redirect:/celulas";
		} catch (Exception e) {
			attributes.addFlashAttribute("messageErro", Message.getMsgDeleteError());
			return "redirect:/celulas";
		}
	}
	
	@GetMapping("/add/{id}")
	public ModelAndView addPart(@PathVariable Long id, ParticipanteCL participanteCL) {
		Celulas celulas = celulasService.listarId(id);
		ModelAndView modelAndView = new ModelAndView("celulas/AddParticipante");
		
		modelAndView.addObject("celulas",celulas);
		modelAndView.addObject("whatsaaps",Opcao.values());
		modelAndView.addObject("religioes",Religiao.values());
		modelAndView.addObject("participantes",participanteCLService.listPart(celulas));
		
		return modelAndView;
	}
	
	@PostMapping("add/{id}")
	public ModelAndView addPartPost(@PathVariable Long id, @Valid ParticipanteCL participanteCL,BindingResult result, RedirectAttributes attributes) {
		
		Celulas celulas = celulasService.listarId(id);
		participanteCL.setCelulas(celulas);
		
		if (result.hasErrors()) {
			return addPart(id, participanteCL);
		}
		
		if (participanteCL.getIdParticipante() != null) {
			participanteCLService.cadastrar(participanteCL);
			attributes.addFlashAttribute("message",Message.getMsgEditado());
			return new ModelAndView( "redirect:/celulas/add/{id}");
			
		} 
		 
		participanteCLService.cadastrar(participanteCL);
		celulas.setQtdeParticipantes(participanteCLService.qtdPartc(id));
		celulasService.cadastrar(celulas);
		attributes.addFlashAttribute("message",Message.getMsgSucessoAdicionar());
		return new ModelAndView( "redirect:/celulas/add/{id}");
		
	}
}
