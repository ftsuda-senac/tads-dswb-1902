package br.senac.tads.dsw.exemplospringsecurity.service;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 *
 * @author fernando.tsuda
 */
@Service
public class UsuarioSistemaService {

	private static final Map<String, UsuarioSistema> USUARIOS_CADASTRADOS = new LinkedHashMap<>();

	static {
		USUARIOS_CADASTRADOS.put("denver",
				new UsuarioSistema("denver", "Ricardo Ramos", "abcd1234", 
						Arrays.asList(new Papel("ROLE_PEAO"))));
		USUARIOS_CADASTRADOS.put("tokio",
				new UsuarioSistema("tokio", "Silene Oliveira", "abcd1234", 
						Arrays.asList(new Papel("ROLE_PEAO"))));
		USUARIOS_CADASTRADOS.put("berlin", 
				new UsuarioSistema("berlin", "Andres de Fonollosa", "abcd1234",
						Arrays.asList(new Papel("ROLE_PEAO"), new Papel("ROLE_FODON"))));
		USUARIOS_CADASTRADOS.put("professor", 
				new UsuarioSistema("professor", "Sergio Marquina", "abcd1234",
						Arrays.asList(new Papel("ROLE_PEAO"), new Papel("ROLE_GOD"))));
	}
}
