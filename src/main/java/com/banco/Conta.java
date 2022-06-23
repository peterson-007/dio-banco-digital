package com.banco;

import javax.swing.*;

public abstract class Conta implements IConta{
    private static final int AGENCIA_PADRAO=1;
    private static int SEQUENCIAL = 1;

    protected Cliente cliente;
    protected int agencia;
    protected int numero;
    protected double saldo;


    public Conta(Cliente cliente){
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            JOptionPane.showMessageDialog(null,"Saque realizado com sucesso!");
        }else {
            JOptionPane.showMessageDialog(null,"Não foi possível realizar o saque!");
        }
    }

    @Override
    public void depositar(double valor){
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino){
        this.saldo-=valor;
        contaDestino.depositar(valor);
    }



    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    protected void imprimirInfosComuns() {

        //Formatar saldo
        String saldo = String.format("R$%,.2f", this.saldo);

        JOptionPane.showMessageDialog(null, "Titular: "+ this.cliente.getNome()+"\n"+
                "CPF: "+ this.cliente.getCpf()+"\n"+
                "Agencia: "+ this.agencia+"\n"+
                "Numero da conta: "+ this.numero+"\n"+
                "Saldo: "+ saldo
        );

    }

}
