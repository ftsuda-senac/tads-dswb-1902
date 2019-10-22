package br.senac.tads.dsw.exemplosspring.produto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author fernando.tsuda
 */
@Entity
public class ImagemProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 500)
	@Column(unique = true)
	private String nomeArquivo;

	@Size(max = 1000)
	@Column
	private String legenda;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_produto")
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
