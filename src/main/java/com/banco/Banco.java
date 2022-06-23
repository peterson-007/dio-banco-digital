package com.banco;

import java.util.List;


public class Banco {
    private String nome;
    private static List<Cliente> clientes;
    private static List<Conta> contas;


    public static void addCliente(String nome,String cpf){
        Cliente cliente = new Cliente(nome,cpf);
        clientes.add(cliente);

    };

    public static void criarContaCorrente(Cliente cliente){
        Conta conta = new ContaCorrente(cliente);
        contas.add(conta);
    }





    private void listarClientes() {
        if (clientes.size() == 0) {
            System.out.println("\nNão existem clientes !!!\n");
        } else {
            System.out.println("\nLista de Clientes\n");
            for (int i = 0; i < clientes.size(); i++) {
                Cliente c = clientes.get(i);
                System.out.println("Cadastro número: " + i);
                System.out.println("\tNome: " + c.getNome());
                System.out.println("\tContas: " + c.getContas());

            }
            System.out.println("\nFim da lista\n");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
}
