package br.senac.tads.dsw.exemplosspring.produto;

import java.util.List;

public interface ProdutoRepository {

	List<Produto> findAll(int offset, int quantidade);

	List<Produto> findByCategoria(List<Integer> idsCat, int offset, int quantidade);

	Produto findById(Long id);

	Produto save(Produto p);

	void deleteById(Long id);

}