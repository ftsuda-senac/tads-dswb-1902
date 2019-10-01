package br.senac.tads.dsw.exemplosspring1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExemploController {

	@GetMapping("/ex1")
	public String exemplo1() {
		return "exemplo1";
	}

	@GetMapping("/ex2")
	public String exemplo2(Model model) {
		model.addAttribute("mensagem", "Mensagem gerada no ExemploController");
		model.addAttribute("dataAcesso", LocalDateTime.now());
		return "exemplo2";
	}

	@GetMapping("/ex2b")
	public ModelAndView exemplo2b() {
		ModelAndView resposta = new ModelAndView("exemplo2");
		resposta.addObject("mensagem", 
				"Mensagem gerada no ExemploController usando ModelAndView");
		resposta.addObject("dataAcesso", LocalDateTime.now());
		return resposta;
	}

	@GetMapping("/ex3")
	public ModelAndView exemplo3() {
		ModelAndView resposta = new ModelAndView("exemplo3");
		List<String> mensagens = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			mensagens.add("Mensagem " + i);
		}
		resposta.addObject("listaMsg", mensagens);
		return resposta;
	}

	@GetMapping("/ex4")
	public ModelAndView exemplo4(
			@RequestParam("nome") String nome,
			@RequestParam(value = "genero", required = false, defaultValue = "0") int genero, 
			@RequestParam(value = "dtNasc", required = false) String dtNascimento) {
		ModelAndView resposta = new ModelAndView("exemplo4");
		resposta.addObject("nomeParam", nome);
		resposta.addObject("generoParam", genero);
		resposta.addObject("dtNascParam", dtNascimento);
		return resposta;
	}
	
	@GetMapping("/ex5/{apelido}")
	public ModelAndView exemplo5(
			@PathVariable("apelido") String apelido,
			@RequestParam(value = "genero", required = false, defaultValue = "0") int genero, 
			@RequestParam(value = "dtNasc", required = false) String dtNascimento) {
		ModelAndView resposta = new ModelAndView("exemplo5");
		resposta.addObject("apelidoParam", apelido);
		resposta.addObject("generoParam", genero);
		resposta.addObject("dtNascParam", dtNascimento);
		return resposta;
	}

	@GetMapping("/ex6/{apelido}/{numeroSorte}")
	public ModelAndView exemplo6(
			@PathVariable("apelido") String apelido,
			@PathVariable("numeroSorte") int numeroSorte) {
		ModelAndView resposta = new ModelAndView("exemplo6");
		resposta.addObject("apelidoParam", apelido);
		resposta.addObject("numeroSorteParam", numeroSorte);
		return resposta;
	}

	@GetMapping("/ex7")
	public ModelAndView exemplo7(@RequestHeader("user-agent") String userAgent) {
		ModelAndView resposta = new ModelAndView("exemplo7");
		boolean mobile = userAgent.toLowerCase().contains("mobile");
		resposta.addObject("ua", userAgent);
		resposta.addObject("mobile", mobile);
		return resposta;
	}
	
	@GetMapping("/ex8")
	public ModelAndView exemplo8(@RequestHeader Map<String, String> headers) {
		ModelAndView resposta = new ModelAndView("exemplo8");
		resposta.addObject("headers", headers);
		return resposta;
	}
	
}
