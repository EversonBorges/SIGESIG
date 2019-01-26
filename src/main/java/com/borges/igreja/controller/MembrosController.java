package com.borges.igreja.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

import com.borges.igreja.enumerators.Opcao;
import com.borges.igreja.enumerators.Sexo;
import com.borges.igreja.enumerators.Status;
import com.borges.igreja.model.Membros;
import com.borges.igreja.security.model.UsuarioSecurityModel;
import com.borges.igreja.service.impl.GravarImagem;
import com.borges.igreja.service.impl.MembrosServiceImpl;
import com.borges.igreja.service.impl.MinisterioServiceImpl;
import com.borges.igreja.service.impl.TemploServiceImpl;
import com.borges.igreja.util.Message;

/**
 * @author Borges
 *
 */
@Controller
@RequestMapping("/membros")
public class MembrosController {
	
	@Autowired
	private MembrosServiceImpl membrosService;
	
	@Autowired
	private TemploServiceImpl temploService;
	
	@Autowired
	private MinisterioServiceImpl ministerioService;
	
	@Autowired
	private GravarImagem gravarImagem;
	
	@GetMapping
	public ModelAndView listarTodos(@AuthenticationPrincipal UsuarioSecurityModel usuario) {
		ModelAndView modelAndView = new ModelAndView("membros/listarMB");
		Long id = usuario.getTemplo().getIdTemplo();
		
		System.out.println("Templo: " + id);
		
		modelAndView.addObject("membros", membrosService.listTemplo(id));
		
		return modelAndView;
	}
	
	@GetMapping("/buscaCpf")
	public ModelAndView buscaCpfView() {
		ModelAndView modelAndView = new ModelAndView("membros/buscaCpf");
		return modelAndView;
	}
	
	 @RequestMapping("/request")
     public String redirect() {
         return "redirect:/query?q=Thymeleaf+Is+Great!";
     }
	
	@GetMapping("/buscaCpf/{cpf}")
	public ModelAndView buscaCpf(Membros membros,@PathVariable("cpf") String cpf,RedirectAttributes attributes) {
		
		System.out.println("CPF Antes :"+cpf);
		
		
		
		System.out.println("CPF Modificado :"+cpf);
		
		String cpfs = membrosService.buscaCpf(cpf);
		
		System.out.println("CPF Apos :"+cpfs);
		
		if (cpfs != null) {
			attributes.addFlashAttribute("message", Message.getBuscaCpf());
			return new ModelAndView("redirect:/membros"); 
		} else {
			return new ModelAndView("redirect:/membros/novo");

		}
		
	}
	
	@GetMapping("/novo")
	public ModelAndView novo( Membros membros, @AuthenticationPrincipal UsuarioSecurityModel usuario) {
		ModelAndView modelAndView = new ModelAndView("membros/cadastrarMB");
		
		if (membros.getIdMembro() == null) {
			modelAndView.addObject("title", "Cadastrar Membro");
			modelAndView.addObject("btn", "Cadastrar");
		} else {
			modelAndView.addObject("title", "Editar Membro");
			modelAndView.addObject("btn", "Editar");
		}
		
		modelAndView.addObject(membros);
		Long id = usuario.getTemplo().getIdTemplo();
		
		modelAndView.addObject("templos", temploService.listarId(id));
		
		//modelAndView.addObject("templos", temploService.listarTodos());
		modelAndView.addObject("ministerios", ministerioService.listarTodos());
		modelAndView.addObject("tipos", Status.values());
		modelAndView.addObject("sexos", Sexo.values());
		modelAndView.addObject("whatsaaps", Opcao.values());
		modelAndView.addObject("batizados", Opcao.values());
		
		
		return modelAndView;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@RequestParam("file") MultipartFile file, @Valid Membros membros,BindingResult result, RedirectAttributes attributes,@AuthenticationPrincipal UsuarioSecurityModel usuario){
		
		if (result.hasErrors()) {
			return novo(membros,usuario);	
		}
		
		if (membros.getIdade() <=7 ) {
			membros.setTurma(3);
			
		}else if(membros.getIdade() >7 && membros.getIdade() <=15   ) {
			membros.setTurma(2);
		}
		else if(membros.getIdade() >15 && membros.getIdade() <=25   ) {
			membros.setTurma(1);
		}else {
			membros.setTurma(0);
		}
		
		if(membros.getIdMembro() != null){
			//membrosService.cadastrar(membros);
			gravarImagem.gravaImagemBase64Service(file, membrosService, membros);
			attributes.addFlashAttribute("message", Message.getMsgEditado());
			return new ModelAndView("redirect:/membros/novo");
		}
		
		//membrosService.cadastrar(membros);
		
		gravarImagem.gravaImagemBase64Service(file, membrosService, membros);
		attributes.addFlashAttribute("message", Message.getMsgSucessoCadastrar());
		return new ModelAndView("redirect:/membros/novo");
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id,@AuthenticationPrincipal UsuarioSecurityModel usuario) {
		return novo(membrosService.listarId(id), usuario);
	}
	
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Long id,RedirectAttributes attributes){
		
		try {
			membrosService.remover(id);
			attributes.addFlashAttribute("message",Message.getMsgDeleteSucesso());
			return "redirect:/membros";
			
		} catch (Exception e) {
			attributes.addFlashAttribute("messageErro",Message.getMsgDeleteError());
			return "redirect:/membros";
		}
	}
	
}
