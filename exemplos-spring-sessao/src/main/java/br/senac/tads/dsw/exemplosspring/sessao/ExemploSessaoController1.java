/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring.sessao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.senac.tads.dsw.exemplosspring.sessao.item.Item;
import br.senac.tads.dsw.exemplosspring.sessao.item.ItemService;

/**
 * Para remover atributos ver
 * https://stackoverflow.com/questions/18209233/spring-mvc-how-to-remove-session-attribute
 * 
 * @author ftsuda
 */
@Controller
@RequestMapping("/exemplo-sessao1")
@SessionAttributes("itensSelecionados1")
public class ExemploSessaoController1 {

	@Autowired
	private ItemService itemService;

	@GetMapping
	public ModelAndView mostrarTela() {
		return new ModelAndView("exemplo-sessao1")
				.addObject("itens", itemService.findAll());
	}

	@PostMapping
	public ModelAndView adicionarItem(@ModelAttribute("itemId") Integer itemId,
			@ModelAttribute("itensSelecionados1") List<ItemSelecionado> itensSelecionados,
			RedirectAttributes redirAttr) {
		Item item = itemService.findById(itemId);
		itensSelecionados.add(new ItemSelecionado(item));
		redirAttr.addFlashAttribute("msg", "Item ID " + item.getId() + " adicionado com sucesso");
		return new ModelAndView("redirect:/exemplo-sessao1");
	}

	@GetMapping("/limpar")
	public ModelAndView limparSessao(
			@ModelAttribute("itensSelecionados1") List<ItemSelecionado> itensSelecionados,
			RedirectAttributes redirAttr) {
		itensSelecionados.clear();
		redirAttr.addFlashAttribute("msg", "Itens removidos");
		return new ModelAndView("redirect:/exemplo-sessao1");
	}

	@ModelAttribute("itensSelecionados1")
	public List<ItemSelecionado> getItensSelecionados() {
		return new ArrayList<>();
	}

	@ModelAttribute("titulo")
	public String getTitulo() {
		return "Exemplo Sessao 1 - Uso do @SessionAttributes";
	}

}
