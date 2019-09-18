/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplolocal;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author fernando.tsuda
 */
public class Produto implements Serializable {

    private Long id;

    private String nome;

    private String descricao;

    private BigDecimal precoCompra;

    private BigDecimal precoVenda;

    private int quantidade;

    private boolean disponivel;

    private String imagem;

    private List<Categoria> categorias;

    public Produto() {

    }
    
    public Produto(long id, String nome, String descricao, BigDecimal precoCompra, BigDecimal precoVenda, String imagem) {
        this(nome, descricao, precoCompra, precoVenda, imagem);
        this.id = id;
    }

    public Produto(String nome, String descricao, BigDecimal precoCompra, BigDecimal precoVenda, String imagem) {
        this.nome = nome;
        this.descricao = descricao;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.imagem = imagem;
    }

    public Produto(String nome, String descricao, BigDecimal preco, String imagem) {
        this(nome, descricao, preco, preco, imagem);
    }

    public Produto(long id, String nome, String descricao, BigDecimal preco, String imagem) {
        this(nome, descricao, preco, preco, imagem);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(BigDecimal precoCompra) {
        this.precoCompra = precoCompra;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

}
