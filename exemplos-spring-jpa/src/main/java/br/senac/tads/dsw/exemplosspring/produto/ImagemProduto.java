package br.senac.tads.dsw.exemplosspring.produto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author fernando.tsuda
 */
public class ImagemProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank
	@Size(max = 500)
	private String nomeArquivo;

	@Size(max = 1000)
	private String legenda;

	private Produto produto;

	public ImagemProduto() {

	}

	public ImagemProduto(String nomeArquivo, String legenda) {
		this.nomeArquivo = nomeArquivo;
		this.legenda = legenda;
	}

	public ImagemProduto(Long id, String nomeArquivo, String legenda) {
		this.id = id;
		this.nomeArquivo = nomeArquivo;
		this.legenda = legenda;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public String getLegenda() {
		return legenda;
	}

	public void setLegenda(String legenda) {
		this.legenda = legenda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getUrlImagem() {
		if (nomeArquivo.startsWith("http")) {
			return nomeArquivo;
		}
		// MOCK
		return "http://lorempixel.com/400/200/sports/";
	}

	@Override
	public String toString() {
		return "ImagemProduto{" + "id=" + id + ", legenda=" + legenda + ", nomeArquivo=" + nomeArquivo + '}';
	}

}
