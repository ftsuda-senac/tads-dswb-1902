/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring.sessao.item;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author ftsuda
 */
public class Item implements Serializable {

    private Integer id;

    @NotBlank(message = "Nome obrigatório")
    private String nome;

    private String corHex;

    @Min(value = 1, message = "Valor mínimo é 1")
    @Max(value = 9999, message = "Valor máximo é 9999")
    private int valor;

    @PastOrPresent(message = "Data e hora devem estar no passado")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dataHora;

    private Set<Categoria> categorias = new LinkedHashSet<>();

    private transient Set<Integer> categoriasIds;

    public Item() {

    }

    public Item(Integer id, String nome, String corHex, int valor, LocalDateTime dataHora, Categoria... categorias) {
        this.id = id;
        this.nome = nome;
        this.corHex = corHex;
        this.valor = valor;
        this.dataHora = dataHora;
        Set<Integer> catIds = new LinkedHashSet<>();
        if (categorias != null && categorias.length > 0) {
            for (Categoria cat : categorias) {
                this.categorias.add(cat);
                catIds.add(cat.getId());
            }
        }
        categoriasIds = catIds;
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

    public String getCorHex() {
        return corHex;
    }

    public void setCorHex(String corHex) {
        this.corHex = corHex;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
        Set<Integer> catIds = new LinkedHashSet<>();
        if (categorias != null && categorias.size() > 0) {
            for (Categoria cat : categorias) {
                catIds.add(cat.getId());
            }
        }
        this.categoriasIds = catIds;
    }

    public Set<Integer> getCategoriasIds() {
        return categoriasIds;
    }

    public void setCategoriasIds(Set<Integer> categoriasIds) {
        this.categoriasIds = categoriasIds;
    }

}
