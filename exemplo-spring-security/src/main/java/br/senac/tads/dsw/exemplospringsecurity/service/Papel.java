package br.senac.tads.dsw.exemplospringsecurity.service;

/**
 *
 * @author fernando.tsuda
 */
public class Papel {

    private String nome;

    public Papel() {
    }

    public Papel(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
