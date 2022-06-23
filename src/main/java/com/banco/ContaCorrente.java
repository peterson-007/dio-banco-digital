package com.banco;

import javax.swing.*;

public class ContaCorrente extends Conta {



    public ContaCorrente(Cliente cliente){
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        JOptionPane.showMessageDialog(null,"==Extrato Conta corrente==");
        super.imprimirInfosComuns();
    }
}


