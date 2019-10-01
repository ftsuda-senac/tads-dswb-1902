package br.senac.tads.dsw.exemplosspring.sessao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.senac.tads.dsw.exemplosspring.sessao.item.Item;
import br.senac.tads.dsw.exemplosspring.sessao.item.ItemService;

@Controller
@RequestMapping("/exemplo-sessao-errado")
public class ExemploSessaoControllerErrado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ItemService itemService;

	// NÃO COLOCAR ATRIBUTO DE INSTÂNCIA NOS CONTROLLERS POIS PODE CAUSAR
	// COMPORTAMENTO ERRADO DA APLICAÇÃO.
	// O OBJETO CONTROLLER PODE SER COMPARTILHADO ENTRE REQUISICOES DIFERENTES.
	private List<ItemSelecionado> itensSelecionados = new ArrayList<>();

	@GetMapping
	public ModelAndView mostrarTela() {
		return new ModelAndView("exemplo-sessao-errado").addObject("itens", itemService.findAll());
	}

	@PostMapping
	public ModelAndView adicionarItem(@ModelAttribute("itemId") Integer itemId, RedirectAttributes redirAttr) {
		Item item = itemService.findById(itemId);
		itensSelecionados.add(new ItemSelecionado(item));
		redirAttr.addFlashAttribute("msg", "Item ID " + item.getId() + " adicionado com sucesso");
		return new ModelAndView("redirect:/exemplo-sessao-errado");
	}

	@GetMapping("/limpar")
	public ModelAndView limparSessao(RedirectAttributes redirAttr) {
		itensSelecionados.clear();
		redirAttr.addFlashAttribute("msg", "Itens removidos");
		return new ModelAndView("redirect:/exemplo-sessao-errado");
	}

	@ModelAttribute("itensSelecionados")
	public List<ItemSelecionado> getItensSelecionados() {
		return itensSelecionados;
	}

	public void setItensSelecionados(List<ItemSelecionado> itensSelecionados) {
    	this.itensSelecionados = itensSelecionados;
	}

	@ModelAttribute("titulo")
	public String getTitulo() {
		return "Exemplo Sessao ERRADO";
	}
}
