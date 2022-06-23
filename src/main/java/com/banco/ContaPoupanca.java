package com.banco;

import javax.swing.*;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        JOptionPane.showMessageDialog(null,"==Extrato Conta Poupanca==");
        super.imprimirInfosComuns();
    }
}
