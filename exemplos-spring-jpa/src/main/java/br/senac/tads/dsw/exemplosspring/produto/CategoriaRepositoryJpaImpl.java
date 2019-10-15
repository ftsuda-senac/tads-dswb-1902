package br.senac.tads.dsw.exemplosspring.produto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class CategoriaRepositoryJpaImpl implements CategoriaRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Categoria> findAll() {
		Query query = em.createQuery("SELECT c FROM Categoria c");
		return query.getResultList();
	}

	@Override
	public Categoria findById(Integer id) {
		Query query = em.createQuery("SELECT c FROM Categoria c WHERE c.id = :idCat")
				.setParameter("idCat", id);
		return (Categoria) query.getSingleResult();
	}

	@Override
	@Transactional
	public Categoria save(Categoria cat) {
		if (cat.getId() == null) {
			// Assumindo que categoria nao existe - cria novo
			em.persist(cat);
		} else {
			// Assumindo que categoria está sendo atualizada
			cat = em.merge(cat);
		}
		return cat;
	}

}
