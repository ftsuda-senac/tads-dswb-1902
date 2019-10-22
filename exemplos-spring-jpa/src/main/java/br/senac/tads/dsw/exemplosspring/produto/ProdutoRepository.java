package br.senac.tads.dsw.exemplosspring.produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findByCategorias_IdIn(List<Integer> idsCat);
}