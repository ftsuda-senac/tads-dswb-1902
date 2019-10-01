/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring.sessao.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

/**
 *
 * @author ftsuda
 */
@Service
public class CategoriaServiceMockImpl implements CategoriaService {

    private Map<Integer, Categoria> mapItens;

    private int sequenciaId = 0;

    public CategoriaServiceMockImpl() {
        mapItens = new ConcurrentHashMap<>();
        mapItens.put(++sequenciaId, new Categoria(sequenciaId, "Categoria 1"));
        mapItens.put(++sequenciaId, new Categoria(sequenciaId, "Categoria 2"));
        mapItens.put(++sequenciaId, new Categoria(sequenciaId, "Categoria 3"));
        mapItens.put(++sequenciaId, new Categoria(sequenciaId, "Categoria 4"));
        mapItens.put(++sequenciaId, new Categoria(sequenciaId, "Categoria 5"));
    }

    @Override
    public List<Categoria> findAll() {
        return new ArrayList<>(mapItens.values());
    }

    @Override
    public Categoria findById(Integer id) {
        return mapItens.get(id);
    }

}
