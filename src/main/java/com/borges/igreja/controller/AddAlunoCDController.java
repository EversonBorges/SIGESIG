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

import com.borges.igreja.model.AddAlunoCD;
import com.borges.igreja.model.Modulos;
import com.borges.igreja.service.impl.AddAlunoCDServiceImpl;
import com.borges.igreja.service.impl.MembrosServiceImpl;
import com.borges.igreja.service.impl.ModulosServiceImpl;
import com.borges.igreja.util.Message;

@Controller
@RequestMapping("/addAlunoCD")
public class AddAlunoCDController {
	
	/*
	@Autowired
	private AddAlunoCDServiceImpl addAlunoCDService;
	
	@Autowired
	private ModulosServiceImpl modulosServiceImpl;
	
	@Autowired
	private MembrosServiceImpl membrosService;

	@GetMapping("/aluno/{id}")
	public ModelAndView aluno(@PathVariable Long id,AddAlunoCD addAlunoCD) {
		Modulos modulos = modulosServiceImpl.listarId(id);
		ModelAndView modelAndView = new ModelAndView("capacitacaoDestino/AddAlunoCD");
		modelAndView.addObject("addAlunosCD",addAlunoCDService.listAluno(modulos));
		modelAndView.addObject(addAlunoCD);
		modelAndView.addObject("alunos",membrosService.listarTodos());
		modelAndView.addObject("modulos",modulos);
		
		return modelAndView;
	}
	
	@PostMapping("/aluno/{id}")
	public ModelAndView alunoPost(@PathVariable Long id,@Valid AddAlunoCD addAlunoCD,BindingResult result,
			RedirectAttributes attributes) {
		
		Modulos modulos=modulosServiceImpl.listarId(id);
		addAlunoCD.setModulos(modulos);
		
		if (result.hasErrors()) {
			return aluno(id, addAlunoCD);
		}
		//addAlunoCD.setConclusao("Não");
		//addAlunoCD.getAlunos().setMatLider(true);
		addAlunoCDService.cadastrar(addAlunoCD);
		attributes.addFlashAttribute("message",Message.getMsgSucessoCadastrar());
		return new ModelAndView("redirect:/addAlunoCD/aluno/{id}");
	}
	/*
	@GetMapping("/{id}")
	public String editAluno(@PathVariable Long id,AddAlunoCD addAlunoCD) {
		
	addAlunoCD = addAlunoELService.listarId(id);
	
		if (addAlunoCD.getConclusao().equals("Não")) {
			
			addAlunoCD.setConclusao("Sim");
			addAlunoCD.getAlunos().setConcluido(true);
			addAlunoELService.cadastrar(addAlunoCD);
			return "redirect:/capacitacaoDestino";
			
		}
			addAlunoCD.setConclusao("Não");
			addAlunoCD.getAlunos().setConcluido(false);
			addAlunoELService.cadastrar(addAlunoCD);
			return "redirect:/capacitacaoDestino";		
	}
*/
	
}
