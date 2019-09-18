/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplolocal;

import java.io.Serializable;

/**
 *
 * @author fernando.tsuda
 */
public class Categoria implements Serializable {

    private Integer id ;

    private String nome;

    public Categoria() {

    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Categoria(Integer id, String nome) {
        this(nome);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
