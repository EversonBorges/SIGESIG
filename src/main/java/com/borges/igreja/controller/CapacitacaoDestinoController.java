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
import com.borges.igreja.enumerators.Status;
import com.borges.igreja.model.AddAlunoCD;
import com.borges.igreja.model.AulaModulo;
import com.borges.igreja.model.CapacitacaoDestino;
import com.borges.igreja.model.Modulos;
import com.borges.igreja.service.impl.AddAlunoCDServiceImpl;
import com.borges.igreja.service.impl.AulaModuloServiceImpl;
import com.borges.igreja.service.impl.CapacitacaoDestinoServiceImpl;
import com.borges.igreja.service.impl.CriarModuloServiceImpl;
import com.borges.igreja.service.impl.MembrosServiceImpl;
import com.borges.igreja.service.impl.ModulosServiceImpl;
import com.borges.igreja.service.impl.TemploServiceImpl;
import com.borges.igreja.util.Message;

@Controller
@RequestMapping("/capacitacaoDestino")
public class CapacitacaoDestinoController {

	@Autowired
	private CapacitacaoDestinoServiceImpl capacitacaoDestinoService;

	@Autowired
	private TemploServiceImpl temploService;

	@Autowired
	private MembrosServiceImpl membrosService;

	@Autowired
	private AddAlunoCDServiceImpl addAlunoCDService;

	@Autowired
	private CriarModuloServiceImpl criarModuloServiceImpl;

	@Autowired
	private ModulosServiceImpl modulosServiceImpl;

	@Autowired
	private AulaModuloServiceImpl aulaModuloServiceImpl;

	@GetMapping
	public ModelAndView listarTodos() {
		ModelAndView modelAndView = new ModelAndView("CapacitacaoDestino/listarCD");
		modelAndView.addObject("capacitacaoDestino", capacitacaoDestinoService.listarTodos());
		return modelAndView;
	}

	/**RETORNA UMA VIEW PARA ADICIONAR UM NOVO CAPACITAÇÃO DESTINO
	 * @param capacitacaoDestino
	 * @return
	 */
	@GetMapping("/novo")
	public ModelAndView novo(CapacitacaoDestino capacitacaoDestino) {
		ModelAndView modelAndView = new ModelAndView("CapacitacaoDestino/cadastrarCD");

		if (capacitacaoDestino.getIdCD() == null) {
			modelAndView.addObject("title", "Cadastrar Turma");
			modelAndView.addObject("btn", "Cadastrar");
		} else {
			modelAndView.addObject("title", "Editar Turma");
			modelAndView.addObject("btn", "Editar");
		}

		modelAndView.addObject(capacitacaoDestino);
		modelAndView.addObject("templos", temploService.listarTodos());
		modelAndView.addObject("tipos", Status.values());

		return modelAndView;
		
	}

	/**SALVA UM NOVO CAPACITAÇÃO DESTINO
	 * @param capacitacaoDestino
	 * @param result
	 * @param attributes
	 * @return
	 */
	@PostMapping("/novo")
	public ModelAndView cadastrar(@Valid CapacitacaoDestino capacitacaoDestino, BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return novo(capacitacaoDestino);
		}

		if (capacitacaoDestino.getIdCD() != null) {
			capacitacaoDestinoService.cadastrar(capacitacaoDestino);
			attributes.addFlashAttribute("message", Message.getMsgEditado());
			return new ModelAndView("redirect:/capacitacaoDestino");

		} else {
			capacitacaoDestinoService.cadastrar(capacitacaoDestino);
			attributes.addFlashAttribute("message", Message.getMsgSucessoCadastrar());
			return new ModelAndView("redirect:/capacitacaoDestino/novo");
		}

	}

	/**RETORNA UM CAPACITAÇÃO DESTINO POR ID PARA EDIÇÃO
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		return novo(capacitacaoDestinoService.listarId(id));
	}

	/**DELETA UM CAPACITAÇÃO DESTINO
	 * @param id
	 * @param attributes
	 * @return
	 */
	@DeleteMapping("/{id}")
	public String remover(@PathVariable Long id, RedirectAttributes attributes) {

		try {
			capacitacaoDestinoService.remover(id);
			attributes.addFlashAttribute("message", Message.getMsgDeleteSucesso());
			return "redirect:/capacitacaoDestino";

		} catch (Exception e) {
			attributes.addFlashAttribute("messageErro", Message.getMsgDeleteError());
			return "redirect:/capacitacaoDestino";
		}
	}

	/**MONTA UMA VIEW PARA ADICIONAR UM MODULO À TURMA DE CAPACITAÇÃO DESTINO, REFENTE AO ID DA TURMA
	 * @param id
	 * @param modulos
	 * @return
	 */
	@GetMapping("/modulo/{id}")
	public ModelAndView modulo(@PathVariable Long id, Modulos modulos) {
		CapacitacaoDestino capacitacaoDestino = capacitacaoDestinoService.listarId(id);
		ModelAndView modelAndView = new ModelAndView("capacitacaoDestino/AddModuloCD");
		modelAndView.addObject(modulos);
		modelAndView.addObject("modulos", criarModuloServiceImpl.listarTodos());
		modelAndView.addObject("capacitacaoDestino", capacitacaoDestino);
		modelAndView.addObject("criarModulos", modulosServiceImpl.listModulos(capacitacaoDestino));

		return modelAndView; 
	}

	/**SALVA UM MODULO COM O ID DA TURMA CAPACITAÇÃO DESTINO
	 * @param id
	 * @param modulos
	 * @param result
	 * @param attributes
	 * @return
	 */
	@PostMapping("/modulo/{id}")
	public ModelAndView moduloPost(@PathVariable Long id, @Valid Modulos modulos, BindingResult result,
			RedirectAttributes attributes) {

		CapacitacaoDestino capacitacaoDestino = capacitacaoDestinoService.listarId(id);
		modulos.setDestino(capacitacaoDestino);

		if (result.hasErrors()) {
			return modulo(id, modulos);
		}
		modulosServiceImpl.cadastrar(modulos);
		attributes.addFlashAttribute("message", Message.getMsgSucessoCadastrar());
		return new ModelAndView("redirect:/capacitacaoDestino/modulo/{id}");
	}

	/**DELETA UM AULA REFERENTE AO ID DO MODULO
	 * @param id
	 * @param attributes
	 * @return
	 */
	@DeleteMapping("/modulo/{id}/{idMod}")
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
	
	/**MONTA UMA VIEW PARA ADICIONAR UM ALUNO AO MODULO, REFENTE AO ID DO MODULO
	 * @param id
	 * @param addAlunoCD
	 * @return
	 */
	@GetMapping("modulo/aluno/{id}")
	public ModelAndView aluno(@PathVariable Long id, AddAlunoCD addAlunoCD) {
		Modulos modulos = modulosServiceImpl.listarId(id);
		ModelAndView modelAndView = new ModelAndView("capacitacaoDestino/AddAlunoCD");
		modelAndView.addObject("addAlunosCD", addAlunoCDService.listAluno(modulos));
		modelAndView.addObject(addAlunoCD);
		modelAndView.addObject("alunos", membrosService.listarTodos());
		modelAndView.addObject("modulos", modulos);

		return modelAndView;
	}

	/**SALVA UM ALUNO REFERENTE AO ID DO MODULO
	 * @param id
	 * @param addAlunoCD
	 * @param result
	 * @param attributes
	 * @return
	 */
	@PostMapping("modulo/aluno/{id}")
	public ModelAndView alunoPost(@PathVariable Long id, @Valid AddAlunoCD addAlunoCD, BindingResult result,
			RedirectAttributes attributes) {

		Modulos modulos = modulosServiceImpl.listarId(id);
		addAlunoCD.setModulos(modulos);

		if (result.hasErrors()) {
			return aluno(id, addAlunoCD);
		}
		// addAlunoCD.setConclusao("Não");
		// addAlunoCD.getAlunos().setMatLider(true);
		addAlunoCDService.cadastrar(addAlunoCD);
		attributes.addFlashAttribute("message", Message.getMsgSucessoCadastrar());
		return new ModelAndView("redirect:/capacitacaoDestino/modulo/aluno/{id}");
	}
	
	 /**MONTA UMA VIEW PARA ADICIONAR UMA AULA AO MODULO, REFENTE AO ID DO MODULO
	 * 
	 * @param id
	 * @param aulaModulo
	 * @return
	 */
	@GetMapping("modulo/aula/{id}")
	public ModelAndView aulaMod(@PathVariable Long id, AulaModulo aulaModulo) {
		Modulos modulos = modulosServiceImpl.listarId(id);
		ModelAndView modelAndView = new ModelAndView("capacitacaoDestino/AddAulaMod");
		modelAndView.addObject("aulaModulos", aulaModuloServiceImpl.listModulo(modulos));
		modelAndView.addObject(aulaModulo);
		modelAndView.addObject("descricao", AulaEnum.values());
		modelAndView.addObject("professor", membrosService.listarTodos());
		modelAndView.addObject("modulos", modulos);

		return modelAndView;

	}

	/**SALVA UMA AULA REFERENTE AO ID DO MODULO
	 * @param id
	 * @param aulaModulo
	 * @param result
	 * @param attributes
	 * @return
	 */
	@PostMapping("modulo/aula/{id}")
	public ModelAndView aulaModPost(@PathVariable Long id, @Valid AulaModulo aulaModulo, BindingResult result,
			RedirectAttributes attributes) {

		Modulos modulos = modulosServiceImpl.listarId(id);
		aulaModulo.setModuloAula(modulos);

		if (result.hasErrors()) {
			return aulaMod(id, aulaModulo);
		}

		aulaModuloServiceImpl.cadastrar(aulaModulo);
		attributes.addFlashAttribute("message", Message.getMsgSucessoCadastrar());
		return new ModelAndView("redirect:/capacitacaoDestino/modulo/aula/{id}");
	}

	/**DELETA UM AULA REFERENTE AO ID DO MODULO
	 * @param id
	 * @param attributes
	 * @return
	 */
	@DeleteMapping("modulo/aula/{id}")
	public String removerAula(@PathVariable Long id, RedirectAttributes attributes) {

		try {
			aulaModuloServiceImpl.remover(id);
			attributes.addFlashAttribute("message", Message.getMsgDeleteSucesso());
			return "redirect:/capacitacaoDestino/modulo/aula/{id}";

		} catch (Exception e) {
			attributes.addFlashAttribute("messageErro", Message.getMsgDeleteError());
			return "redirect:/capacitacaoDestino/modulo/aula/{id}";
		}
	}
}
