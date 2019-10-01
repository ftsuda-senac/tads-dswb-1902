/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring1;

import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ftsuda
 */
@Controller
@RequestMapping("/links")
public class ExemploLinksController {

    @GetMapping
    public ModelAndView abrirView() {
        return new ModelAndView("links/exemplo-links");
    }

    @GetMapping("/dinamico")
    public ModelAndView exemploDinamicos() {
        return new ModelAndView("links/exemplo-links-dinamicos").addObject("itens", Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @GetMapping("/dinamico/{item}")
    public ModelAndView exemploDinamico(@PathVariable("item") int item) {
        return new ModelAndView("links/exemplo-links-dinamicos-item").addObject("item", item);
    }
}
