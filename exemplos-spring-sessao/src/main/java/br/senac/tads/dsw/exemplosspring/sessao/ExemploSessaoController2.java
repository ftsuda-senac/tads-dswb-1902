/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring.sessao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.senac.tads.dsw.exemplosspring.sessao.item.Item;
import br.senac.tads.dsw.exemplosspring.sessao.item.ItemService;

/**
 * 
 * @author ftsuda
 */
@Controller
@Scope("session")
@RequestMapping("/exemplo-sessao2")
public class ExemploSessaoController2 implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ItemService itemService;
	
	private List<ItemSelecionado> itensSelecionados = new ArrayList<>();

	@GetMapping
	public ModelAndView mostrarTela() {
		return new ModelAndView("exemplo-sessao2")
				.addObject("itens", itemService.findAll());
	}

	@PostMapping
	public ModelAndView adicionarItem(@ModelAttribute("itemId") Integer itemId,
			RedirectAttributes redirAttr) {
		Item item = itemService.findById(itemId);
		itensSelecionados.add(new ItemSelecionado(item));
		redirAttr.addFlashAttribute("msg", "Item ID " + item.getId() + " adicionado com sucesso");
		return new ModelAndView("redirect:/exemplo-sessao2");
	}

	@GetMapping("/limpar")
	public ModelAndView limparSessao(RedirectAttributes redirAttr) {
		itensSelecionados.clear();
		redirAttr.addFlashAttribute("msg", "Itens removidos");
		return new ModelAndView("redirect:/exemplo-sessao2");
	}

	public List<ItemSelecionado> getItensSelecionados() {
		return itensSelecionados;
	}

	public void setItensSelecionados(List<ItemSelecionado> itensSelecionados) {
		this.itensSelecionados = itensSelecionados;
	}

	@ModelAttribute("titulo")
	public String getTitulo() {
		return "Exemplo Sessao 2 - Uso do @Controller com @Scope(\"session\")";
	}

}
