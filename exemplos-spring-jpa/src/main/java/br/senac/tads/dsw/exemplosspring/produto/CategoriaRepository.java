package br.senac.tads.dsw.exemplosspring.produto;

import java.util.List;

public interface CategoriaRepository {

	List<Categoria> findAll();

	Categoria findById(Integer id);

	Categoria save(Categoria cat);

}