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

import com.borges.igreja.enumerators.Status;
import com.borges.igreja.enumerators.Turmas;
import com.borges.igreja.model.AddAlunoEB;
import com.borges.igreja.model.EscolaBiblica;
import com.borges.igreja.service.impl.AddAlunoEBServiceImpl;
import com.borges.igreja.service.impl.EscolaBiblicaServiceImpl;
import com.borges.igreja.service.impl.MembrosServiceImpl;
import com.borges.igreja.service.impl.TemploServiceImpl;
import com.borges.igreja.util.Message;

@Controller
@RequestMapping("/escolaBiblica")
public class EscolaBiblicaController {
	
	@Autowired
	private EscolaBiblicaServiceImpl escolaBiblicaService;
	
	@Autowired
	private MembrosServiceImpl membrosService;
	
	@Autowired
	private TemploServiceImpl temploService;
	
	@Autowired
	private AddAlunoEBServiceImpl addAlunoService;
	
	
	/**LISTAR TODAS ESCOLAS 
	 * @return
	 */
	@GetMapping
	public ModelAndView listarTodos() {
		ModelAndView modelAndView = new ModelAndView("escolaBiblica/listarEB");
		modelAndView.addObject("escolasBiblicas", escolaBiblicaService.listarTodos());
		
		return modelAndView;
	}
	
	/** MONTA VIEW PARA ADICIONAR NOVA ESCOLA
	 * @param escolaBiblica
	 * @return
	 */
	@GetMapping("/novo")
	public ModelAndView novo(EscolaBiblica escolaBiblica) {
		ModelAndView modelAndView = new ModelAndView("escolaBiblica/cadastrarEB");
		
		if (escolaBiblica.getIdEB()== null) {
			modelAndView.addObject("title", "Cadastrar Escola");
			modelAndView.addObject("btn", "Cadastrar");
		} else {
			modelAndView.addObject("title", "Editar Escola");
			modelAndView.addObject("btn", "Editar");
		}
		
		modelAndView.addObject(escolaBiblica);
		modelAndView.addObject("tipos", Status.values());
		modelAndView.addObject("membros", membrosService.listarTodos());
		modelAndView.addObject("templos", temploService.listarTodos());
		modelAndView.addObject("turmas", Turmas.values());
		
		
		return modelAndView;
	}
	
	/**ADICIONA NOVA ESCOLA
	 * @param escolaBiblica
	 * @param result
	 * @param attributes
	 * @return
	 */
	@PostMapping("/novo")
	public ModelAndView cadastrar(@Valid EscolaBiblica escolaBiblica,BindingResult result, RedirectAttributes attributes){
		if (result.hasErrors()) {
			return novo(escolaBiblica);
			
		}
		
		if(escolaBiblica.getIdEB() != null){
			escolaBiblicaService.cadastrar(escolaBiblica);
			attributes.addFlashAttribute("message", Message.getMsgEditado());
			return new ModelAndView("redirect:/escolaBiblica");
		}
		escolaBiblicaService.cadastrar(escolaBiblica);
		attributes.addFlashAttribute("message", Message.getMsgSucessoCadastrar());
		return new ModelAndView("redirect:/escolaBiblica/novo");
	}
	
	/**RETORNA ESCOLA POR ID
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return novo(escolaBiblicaService.listarId(id));
	}
	
	/**DELETA ESCOLA PELO ID
	 * @param id
	 * @param attributes
	 * @return
	 */
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Long id,RedirectAttributes attributes){
		
		//OBESERVAÇÃO: ALTERAR PARA EXECPTION SPRINGBOOT
		try {
			escolaBiblicaService.remover(id);
			attributes.addFlashAttribute("message", Message.getMsgDeleteSucesso());
			return "redirect:/escolaBiblica";
			
		} catch (Exception e) {
			attributes.addFlashAttribute("messageErro", Message.getMsgDeleteError());
			return "redirect:/escolaBiblica";
		}
	}
	
	/**MONTA A VIEW PARA ADICIONAR ALUNO A ESCOLA PELO ID
	 * @param id
	 * @param alunoEB
	 * @param templo
	 * @param turma
	 * @return
	 */
	@GetMapping("/add/{id}")
	public  ModelAndView addAluno(@PathVariable Long id, AddAlunoEB alunoEB, Long templo, Long turma) {
		EscolaBiblica escolaBiblica = escolaBiblicaService.listarId(id);
		ModelAndView modelAndView = new ModelAndView("escolaBiblica/AddAlunoEB");
		//Iterable<AddAlunoEB> addAlunoEB = addAlunoService.listAluno(escolaBiblica);
		modelAndView.addObject("addAlunosEB", addAlunoService.listAluno(escolaBiblica));
		 templo = escolaBiblica.getTemplo().getIdTemplo();
		turma = (long) escolaBiblica.getTurma().ordinal();
		modelAndView.addObject(alunoEB);
		modelAndView.addObject("alunos", membrosService.listMembros(templo,turma));
		modelAndView.addObject("escolasBiblicas", escolaBiblica);
		modelAndView.addObject("idEscola", escolaBiblica.getIdEB());

		return modelAndView;	
	}
	
	/**ADICIONA ALUNO A ESCOLA PELO ID
	 * @param id
	 * @param addAlunoEB
	 * @return
	 */
	@PostMapping("/adicionarAluno/{id}")
	public ModelAndView addAlunoPost(@PathVariable Long id,@Valid AddAlunoEB addAlunoEB,BindingResult result,RedirectAttributes attributes) {
		
		EscolaBiblica escolaBiblica = escolaBiblicaService.listarId(id);
		addAlunoEB.setEscolaBiblica(escolaBiblica);
		
		if (result.hasErrors()) {
			return addAluno(id, addAlunoEB,null,null);
		}
		addAlunoEB.getAlunos().setMatriculado(true);
		
		
		addAlunoService.cadastrar(addAlunoEB);
		attributes.addFlashAttribute("message", Message.getMsgSucessoAdicionar());
		return new ModelAndView("redirect:/escolaBiblica/add/{id}");
		
	}
	
	
}
