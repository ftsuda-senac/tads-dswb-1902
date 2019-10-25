package br.senac.tads.dsw.exemplospringsecurity.service;

import java.util.List;


/**
 *
 * @author fernando.tsuda
 */
public class UsuarioSistema {

    private String username;

    private String nomeCompleto;

    private String hashSenha;

    private List<Papel> papeis;

    public UsuarioSistema() {
    }

    public UsuarioSistema(String username, String nomeCompleto,
            String senhaAberta, List<Papel> papeis) {
        this.username = username;
        this.nomeCompleto = nomeCompleto;
        setSenha(senhaAberta);
        this.papeis = papeis;
    }

    public final void setSenha(String senhaAberta) {
        this.hashSenha = senhaAberta;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getHashSenha() {
        return hashSenha;
    }

    public void setHashSenha(String hashSenha) {
        this.hashSenha = hashSenha;
    }

    public List<Papel> getPapeis() {
        return papeis;
    }

    public void setPapeis(List<Papel> papeis) {
        this.papeis = papeis;
    }

}
