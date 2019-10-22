package br.senac.tads.dsw.exemplosspring.produto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
	@NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
	@NamedQuery(name = "Produto.findByCategoriaId", 
		query ="SELECT p FROM Produto p INNER JOIN p.categorias c WHERE c.id IN :idCat"),
	@NamedQuery(name = "Produto.findById", 
		query = "SELECT p FROM Produto p WHERE p.id = :idProd")
//	@NamedQuery(name = "Produto.findById", 
//		query = "SELECT p FROM Produto p LEFT JOIN FETCH p.categorias "
//				+ "LEFT JOIN FETCH p.imagens WHERE p.id = :idProd") // FETCH USADO NA QUERY QUANDO open-in-view=false
})
// Referência namedEntityGraphs: https://thoughts-on-java.org/jpa-21-entity-graph-part-1-named-entity/
@NamedEntityGraphs({
	@NamedEntityGraph(name = "graph.ProdutoCategoriasImagens", 
			attributeNodes = { 
					@NamedAttributeNode(value = "categorias"), 
					@NamedAttributeNode(value = "imagens")
			})
})
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min = 1, max = 100)
	@Column
	//@Column(length = 100, nullable = false)
	private String nome;

	@Size(max = 1000)
	@Column
	private String descricao;

	@NotNull
	@Digits(integer = 9, fraction =  2)
	@Column
	//@Column(precision = 9, scale = 2, nullable = false)
	private BigDecimal precoCompra;

	@NotNull
	@Digits(integer = 9, fraction =  2)
	@Column
	private BigDecimal precoVenda;

	@NotNull
	@Min(0)
	@Column
	private int quantidade;

	@Column
	private boolean disponivel;

	@Column(nullable = false)
	private LocalDateTime dtCadastro;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "produto_categoria",
			joinColumns = @JoinColumn(name = "id_produto"),
			inverseJoinColumns = 
			@JoinColumn(name = "id_categoria"))
	private Set<Categoria> categorias;

	@OneToMany(mappedBy = "produto", fetch = FetchType.LAZY, 
			cascade = { CascadeType.PERSIST, CascadeType.MERGE }, 
			orphanRemoval = true)
	private Set<ImagemProduto> imagens;

	private transient Set<Integer> idsCategorias;
	
	// Usando lista como apoio para receber dados do form (Set gera erro)
	// https://stackoverflow.com/a/28505620
	private transient List<ImagemProduto> imagensList;

	@Transient
	private String observacoes;

	public Produto() {

	}

	public Produto(String nome, String descricao, BigDecimal precoCompra, BigDecimal precoVenda,
			int quantidade, boolean disponivel, LocalDateTime dtCadastro) {
		this.nome = nome;
		this.descricao = descricao;
		this.precoCompra = precoCompra;
		this.precoVenda = precoVenda;
		this.quantidade = quantidade;
		this.disponivel = disponivel;
		this.dtCadastro = dtCadastro;
	}
	public Produto(Long id, String nome, String descricao, BigDecimal precoCompra, BigDecimal precoVenda,
			int quantidade, boolean disponivel, LocalDateTime dtCadastro) {
		this(nome, descricao, precoCompra, precoVenda, quantidade, disponivel, dtCadastro);
		this.id = id;
	}

	public Produto(String nome, String descricao, BigDecimal precoCompra, BigDecimal precoVenda,
			int quantidade, boolean disponivel, LocalDateTime dtCadastro, Set<ImagemProduto> imagens,
			Set<Categoria> categorias) {
		this(nome, descricao, precoCompra, precoVenda, quantidade, disponivel, dtCadastro);
		this.imagens = imagens;
		this.categorias = categorias;
	}
	
	public Produto(Long id, String nome, String descricao, BigDecimal precoCompra, BigDecimal precoVenda,
			int quantidade, boolean disponivel, LocalDateTime dtCadastro, Set<ImagemProduto> imagens,
			Set<Categoria> categorias) {
		this(nome, descricao, precoCompra, precoVenda, quantidade, disponivel, dtCadastro, imagens, categorias);
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

	public LocalDateTime getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(LocalDateTime dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Set<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Set<ImagemProduto> getImagens() {
		return imagens;
	}

	public void setImagens(Set<ImagemProduto> imagens) {
		this.imagens = imagens;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Set<Integer> getIdsCategorias() {
		return idsCategorias;
	}

	public void setIdsCategorias(Set<Integer> idsCategorias) {
		this.idsCategorias = idsCategorias;
	}

	public List<ImagemProduto> getImagensList() {
		return imagensList;
	}

	public void setImagensList(List<ImagemProduto> imagensList) {
		this.imagensList = imagensList;
	}

	@Override
	public String toString() {
		return "Produto{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", precoCompra=" + precoCompra
				+ ", precoVenda=" + precoVenda + ", quantidade=" + quantidade + ", dtCadastro=" + dtCadastro
				+ ", categorias=" + categorias + ", imagens=" + imagens + ", idsCategorias=" + idsCategorias
				+ ", observacoes=" + observacoes + '}';
	}

}
