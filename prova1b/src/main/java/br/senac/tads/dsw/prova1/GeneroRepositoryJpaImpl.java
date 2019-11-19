package br.senac.tads.dsw.prova1;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class GeneroRepositoryJpaImpl implements GeneroRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Genero> findAll() {
        Query jpqlQuery = em.createQuery("SELECT g FROM Genero g");
        return jpqlQuery.getResultList();
    }

    @Override
    public Genero findById(Integer id) {
        Query jpqlQuery = em.createQuery("SELECT g FROM Genero g WHERE g.id = :idGenero")
                .setParameter("idGenero", id);
        Genero genero = (Genero) jpqlQuery.getSingleResult();
        return genero;
    }

    @Override
    @Transactional
    public Genero save(Genero genero) {
        if (genero.getId() == null) {
            em.persist(genero);
        } else {
            genero = em.merge(genero);
        }
        return genero;
    }
}
