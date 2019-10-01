/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring.sessao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.senac.tads.dsw.exemplosspring.sessao.item.ItemService;

/**
 *
 * @author ftsuda
 */
@Controller
@RequestMapping("/sem-layout")
public class SemLayoutController {
    
    @Autowired
    private ItemService itemService;

    @GetMapping("/tela1")
    public ModelAndView mostrarTela1() {
        return new ModelAndView("layout/sem-layout1");
    }

    @GetMapping("/tela2")
    public ModelAndView mostrarTela2() {
        return new ModelAndView("layout/sem-layout2");
    }

    @GetMapping("/tela3")
    public ModelAndView mostrarTela3() {
        return new ModelAndView("layout/sem-layout3").addObject("itens", itemService.findAll());
    }
}
