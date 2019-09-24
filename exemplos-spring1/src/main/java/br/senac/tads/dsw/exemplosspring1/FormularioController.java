package br.senac.tads.dsw.exemplosspring1;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/formulario")
public class FormularioController {

	@GetMapping
	public ModelAndView abrirFormulario() {
		ModelAndView mv = new ModelAndView("formulario");
		
		DadosPessoais dados = new DadosPessoais();
//		dados.setId(123L);
//		dados.setNome("Fulano da Silva");
//		dados.setDescricao("Bla bla bla");
//		dados.setEmail("fulano@email.com");
//		dados.setSenha("abc1234");
//		dados.setNumeroSorte(1024);
//		dados.setPeso(BigDecimal.valueOf(80.5));
//		dados.setAltura(BigDecimal.valueOf(1.75));
//		dados.setDtNascimento(LocalDate.of(1982, Month.JANUARY, 15));
//		dados.setSexo(1);
//		dados.setInteresses(new String[] { "Tecnologia", "Viagens" });
		
		mv.addObject("dadosPessoais", dados);
		return mv;
	}

	@PostMapping("/salvar")
	public ModelAndView salvarDados(
			@ModelAttribute("dadosPessoais") DadosPessoais dadosPreenchidos) {
		ModelAndView mv = new ModelAndView("resultado-formulario");
		mv.addObject("dados", dadosPreenchidos);
		return mv;
	}
	
	@PostMapping("/salvar-prg")
	public ModelAndView salvarDadosPostRedirectGet(
			@ModelAttribute("dadosPessoais") DadosPessoais dadosPreenchidos,
			RedirectAttributes redirAttr) {
		ModelAndView mv = new ModelAndView("redirect:/formulario/resultado");
		redirAttr.addFlashAttribute("dados", dadosPreenchidos);
		return mv;
	}
	
	@PostMapping("/salvar-prg-validacao")
	public ModelAndView salvarDadosComValidacao(
			@ModelAttribute("dadosPessoais") @Valid DadosPessoais dadosPreenchidos,
			BindingResult bindingResult,
			RedirectAttributes redirAttr) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("formulario-final");
		}
		ModelAndView mv = new ModelAndView("redirect:/formulario/resultado");
		redirAttr.addFlashAttribute("dados", dadosPreenchidos);
		return mv;
	}

	@GetMapping("/resultado")
	public ModelAndView resultadoPostRedirectGet() {
		return new ModelAndView("resultado-formulario");
	}
	
	
	
	
}
