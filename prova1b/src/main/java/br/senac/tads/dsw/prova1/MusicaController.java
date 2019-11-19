package br.senac.tads.dsw.prova1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/musica")
public class MusicaController {

	@Autowired
	private MusicaRepository musicaRepo;

	@Autowired
	private GeneroRepository generoRepo;

	@GetMapping
	public ModelAndView listar() {
		List<Musica> musicas = musicaRepo.findAll();
		return new ModelAndView("lista")
				.addObject("musicas", musicas);
	}

	@GetMapping("/novo")
	public ModelAndView mostrarForm() {
		List<Genero> generos = generoRepo.findAll();
		return new ModelAndView("form")
				.addObject("musica", new Musica())
				.addObject("generos", generos);
	}

	@PostMapping("/salvar")
	public ModelAndView salvar(
			@ModelAttribute @Valid Musica musica,
			BindingResult bindingResult,
			RedirectAttributes redirAttr) {
		if (bindingResult.hasErrors()) {
			List<Genero> generos = generoRepo.findAll();
			return new ModelAndView("form")
					.addObject("musica", new Musica())
					.addObject("generos", generos)
					.addObject("msgErro", "Preencha todos os campos");
		}
		Genero genero = generoRepo.findById(musica.getIdGenero());
		genero.setMusicas(new HashSet<Musica>(Arrays.asList(musica)));
		musica.setGenero(genero);
		musicaRepo.save(musica);
		
		redirAttr.addFlashAttribute("msg", "Música salva com sucesso");
		return new ModelAndView("redirect:/musica");
	}
}
