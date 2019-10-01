/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring.sessao.item;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ftsuda
 */
@Service
public class ItemServiceMockImpl implements ItemService {

    @Autowired
    private CategoriaService categoriaService;

    private Map<Integer, Item> mapItens;

    private int sequenciaId = 0;

    public ItemServiceMockImpl() {

    }

    @PostConstruct
    public void init() {
        mapItens = new ConcurrentHashMap<>();
        mapItens.put(++sequenciaId, new Item(sequenciaId, "Item A", "#c0392b", 90, LocalDateTime.parse("2019-07-02T08:30:00"), categoriaService.findById(1), categoriaService.findById(3)));
        mapItens.put(++sequenciaId, new Item(sequenciaId, "Item B", "#2980b9", 125, LocalDateTime.parse("2019-02-10T06:58:00"), categoriaService.findById(2), categoriaService.findById(4)));
        mapItens.put(++sequenciaId, new Item(sequenciaId, "Item C", "#27ae60", 75, LocalDateTime.parse("2019-09-01T15:50:00")));
        mapItens.put(++sequenciaId, new Item(sequenciaId, "Item D", "#e67e22", 100, LocalDateTime.parse("2019-03-29T20:30:00"), categoriaService.findById(3)));
        mapItens.put(++sequenciaId, new Item(sequenciaId, "Item E", "#8e44ad", 85, LocalDateTime.parse("2019-08-24T12:45:00")));
        mapItens.put(++sequenciaId, new Item(sequenciaId, "Item F", "#7f8c8d", 140, LocalDateTime.parse("2019-06-29T11:20:00"), categoriaService.findById(2), categoriaService.findById(5)));
    }

    @Override
    public List<Item> findAll() {
        return new ArrayList<>(mapItens.values());
    }

    @Override
    public Item findById(Integer id) {
        return mapItens.get(id);
    }

    @Override
    public Item save(Item item) {
        if (item.getId() == null) {
            item.setId(++sequenciaId);
        }
        mapItens.put(item.getId(), item);
        return item;
    }

    @Override
    public void deleteById(Integer id) {
        mapItens.remove(id);
    }

}
