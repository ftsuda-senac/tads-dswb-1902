package br.senac.tads.dsw.exemplosspring.produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

/**
 *
 * @author fernando.tsuda
 */
@Service
public class CategoriaRepositoryMockImpl implements CategoriaRepository {

	private Map<Integer, Categoria> mapItens;

	private int sequenciaId = 0;

	public CategoriaRepositoryMockImpl() {
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

	@Override
	public Categoria save(Categoria cat) {
		if (cat.getId() == null) {
			cat.setId(++sequenciaId);
		}
		mapItens.put(cat.getId(), cat);
		return cat;
	}

}
