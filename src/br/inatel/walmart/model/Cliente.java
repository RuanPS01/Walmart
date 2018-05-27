/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.walmart.model;

/**
 *
 * @author 1513 MXTI
 */
public class Cliente {
    private int cpfCliente;
    private String nomeCliente, nascimentoCliente, emailCiente, enderecoCliente, telefoneCliente;

    public int getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(int cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNascimentoCliente() {
        return nascimentoCliente;
    }

    public void setNascimentoCliente(String nascimentoCliente) {
        this.nascimentoCliente = nascimentoCliente;
    }

    public String getEmailCiente() {
        return emailCiente;
    }

    public void setEmailCiente(String emailCiente) {
        this.emailCiente = emailCiente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }
    
    
}
