/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring.sessao.item;

import java.util.List;

/**
 *
 * @author ftsuda
 */
public interface ItemService {

    List<Item> findAll();

    Item findById(Integer id);

    Item save(Item item);

    void deleteById(Integer id);

}
