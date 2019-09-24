package br.senac.tads.dsw.exemplosspring1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class DadosPessoais implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank(message = "Campo nome é obrigatório")
	@Size(max = 100)
	private String nome;

	private String descricao;

	@Email(message = "Formato do e-mail é inválido")
	@NotEmpty(message = "E-mail deve ser preenchido")
	private String email;

	@NotBlank(message = "Senha deve ser preenchida")
	private String senha;

	@NotBlank(message = "Repetir a senha deve ser preenchida")
	private String senhaRepetida;

    @Min(1)
    @Max(99)
	private int numeroSorte;

	private int sexo;

	@Size(min = 1, message = "Selecione pelo menos 1 interesse")
	private String[] interesses;

	@Digits(integer = 1, fraction = 2)
	private BigDecimal altura;

	@Digits(integer = 3, fraction = 1)
	private BigDecimal peso;

	@Past(message = "Data de nascimento deve ser anterior a data atual")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dtNascimento;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenhaRepetida() {
		return senhaRepetida;
	}

	public void setSenhaRepetida(String senhaRepetida) {
		this.senhaRepetida = senhaRepetida;
	}

	public int getNumeroSorte() {
		return numeroSorte;
	}

	public void setNumeroSorte(int numeroSorte) {
		this.numeroSorte = numeroSorte;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public String[] getInteresses() {
		return interesses;
	}

	public void setInteresses(String[] interesses) {
		this.interesses = interesses;
	}

	public BigDecimal getAltura() {
		return altura;
	}

	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

}