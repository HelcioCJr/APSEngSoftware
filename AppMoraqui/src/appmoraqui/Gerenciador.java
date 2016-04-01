/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmoraqui;

/**
 *
 * @author Marcello
 */
public class Gerenciador {
    private int codGerenciador;
    private String nome;
    private String rg;
    private String cpf;

    public int getCodGerenciador() {
        return codGerenciador;
    }

    public void setCodGerenciador(int codGerenciador) {
        this.codGerenciador = codGerenciador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public void AprovarUsuario(Usuario user,boolean status){
        user.setAprovado(status);
    }
    
}
