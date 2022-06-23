package com.banco;

import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {

        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes() {



        int operacao =
                Integer.parseInt(JOptionPane.showInputDialog("** Selecione uma operação **\n" +
                        "|   Opção 1 - Criar conta Corrente\n" +
                        "|   Opção 2 - Criar conta Poupanca\n" +
                        "|   Opção 3 - Depositar\n" +
                        "|   Opção 4 - Sacar\n" +
                        "|   Opção 5 - Transferir\n" +
                        "|   Opção 6 - Listar\n" +
                        "|   Opção 7 - Sair\n"));

        switch (operacao) {
            case 1:
                criarContaCorrente();
                break;

            case 2:
                criarContaPoupanca();
                break;

            case 3:
                depositar();
                break;

            case 4:
                sacar();
                break;

            case 5:
                transferir();
                break;

            case 6:
                listarContas();
                break;

            case 7:
                JOptionPane.showMessageDialog(null,"Obrigado por utilizar nosso banco!");
                System.exit(0); // para o sistema

            default:
                JOptionPane.showMessageDialog(null,"Opção inválida!");
                operacoes();
                break;
        }
    }

    public static void criarContaCorrente(){

        Cliente cliente = new Cliente();

        cliente.setNome(JOptionPane.showInputDialog("Nome do cliente:"));
        cliente.setCpf(JOptionPane.showInputDialog("CPF do cliente:"));

        Conta conta = new ContaCorrente(cliente);

        cliente.adicionarConta(conta);

        contasBancarias.add(conta);
        JOptionPane.showMessageDialog(null,"--- Sua conta foi criada com sucesso! ---");

        operacoes();
    }

    public static void criarContaPoupanca(){

        Cliente cliente = new Cliente();

        cliente.setNome(JOptionPane.showInputDialog("Nome do cliente:"));
        cliente.setCpf(JOptionPane.showInputDialog("CPF do cliente:"));

        Conta conta = new ContaPoupanca(cliente);

        cliente.adicionarConta(conta);

        contasBancarias.add(conta);
        JOptionPane.showMessageDialog(null,"--- Sua conta foi criada com sucesso! ---");

        operacoes();
    }

    //Método que percorre a lista de contas e retorna a conta desejada
    public static Conta encontrarConta(int numeroConta){
        Conta conta = null;
        if(contasBancarias.size()>0){
            for (Conta c: contasBancarias) {
                if(c.getNumero()== numeroConta){
                    conta = c;
                }
            }
        }
        return conta;
    }



    public static void depositar(){

        int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta:"));

        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {

            double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor a ser depositado:"));
            conta.depositar(valor);
            JOptionPane.showMessageDialog(null,"Depósito realizado com sucesso!");

        } else{
            JOptionPane.showMessageDialog(null,"---Conta não encontrada!---");
        }

        operacoes();
    }

    public static void sacar(){

        int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta:"));

        Conta conta = encontrarConta(numeroConta);

        if(conta != null){

            double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor que deseja sacar:"));
            conta.sacar(valor);

        } else{
            JOptionPane.showMessageDialog(null,"---Conta não encontrada!---");
        }

        operacoes();
    }

    public static void transferir(){

        int numeroContaRemetente =
                Integer.parseInt(JOptionPane.showInputDialog("Número da conta remetente: "));

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if(contaRemetente != null) {

            int numeroContaDestinatario =
                    Integer.parseInt(JOptionPane.showInputDialog("Número da conta do destinatário: "));

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if(contaDestinatario != null) {

                Double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor da transferência: "));

                contaRemetente.transferir(valor,contaDestinatario);
                JOptionPane.showMessageDialog(null,"Transferencia realizada com sucesso!");

            }else {
                JOptionPane.showMessageDialog(null,"--- A conta para depósito não foi encontrada ---");
            }

        }else {
            JOptionPane.showMessageDialog(null,"--- Conta para transferência não encontrada ---");
        }
        operacoes();
    }

    public static void listarContas(){

        if (contasBancarias.size() > 0 ){
            for(Conta conta: contasBancarias){
                conta.imprimirExtrato();
            }
        }else {
            JOptionPane.showMessageDialog(null,"---Não há contas cadastradas!---");
        }

        operacoes();
    }



}
