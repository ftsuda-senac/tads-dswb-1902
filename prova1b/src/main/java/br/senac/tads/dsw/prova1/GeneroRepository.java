package br.senac.tads.dsw.prova1;

import java.util.List;

public interface GeneroRepository {

    List<Genero> findAll();

    Genero findById(Integer id);

    Genero save(Genero genero);
    
}
