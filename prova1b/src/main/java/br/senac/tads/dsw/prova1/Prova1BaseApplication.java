package br.senac.tads.dsw.prova1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Prova1BaseApplication {

    @Autowired
    private GeneroRepository generoRepository;

    public static void main(String[] args) {
        SpringApplication.run(Prova1BaseApplication.class, args);
    }

    // Quando a aplicação for inicializada, verifica se tabela generos tem registros
    // Se não tiver, carrega 5 Generos.
    @EventListener
    public void handleContextRefreshedEvent(ContextRefreshedEvent event) {
        List<Genero> generos = generoRepository.findAll();
        if (generos == null  || generos.isEmpty()) {
            // Generos ainda não carregados
            generoRepository.save(new Genero("Rock"));
            generoRepository.save(new Genero("Samba"));
            generoRepository.save(new Genero("Funk"));
            generoRepository.save(new Genero("Forró"));
            generoRepository.save(new Genero("Sertanejo"));
        }
    }

}
