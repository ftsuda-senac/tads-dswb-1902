/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring.i18n;

import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author ftsuda
 */
public class Info {

    @NotBlank(message = "{info.nome.blank}")
    private String nome;

    @NotBlank(message = "{info.email.blank}")
    @Email(message = "{info.email.invalid}")
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "{info.dtNascimento.notpast}")
    private LocalDate dtNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

}
