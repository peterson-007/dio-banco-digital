package com.banco;

import java.util.ArrayList;
import java.util.List;


public class Cliente {
    private String nome;
    private String cpf;
    private List<Conta> contas;

    public Cliente(){
    }

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    //Método criado para adicionar conta na lista private (não existe acesso ao método .add)
    public void adicionarConta(Conta conta){

        if(this.contas != null) {
            this.contas.add(conta);
        } else {
            List<Conta> contas = new ArrayList<Conta>();
            this.contas = contas;
            this.contas.add(conta);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
}
