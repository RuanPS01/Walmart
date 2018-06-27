/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.walmart.model;

import java.util.Date;

/**
 *
 * @author 1513 MXTI
 */
public class Remessa {
    private int idRemessa,funcionarioRemessa;
    private String tipoRemessa, empresaRemessa, horaRemessa, dataRemessa, nomeFuncionario;

    public int getIdRemessa() {
        return idRemessa;
    }

    public void setIdRemessa(int id) {
        this.idRemessa = id;
    }

    public String getTipo() {
        return tipoRemessa;
    }

    public void setTipo(String tipo) {
        this.tipoRemessa = tipo;
    }

    public String getEmpresa() {
        return empresaRemessa;
    }

    public void setEmpresa(String empresa) {
        this.empresaRemessa = empresa;
    }

    public int getFuncionarioRemessa() {
        return funcionarioRemessa;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public void setFuncionarioRemessa(int funcionarioRemessa) {
        this.funcionarioRemessa = funcionarioRemessa;
    }

    public String getHora() {
        return horaRemessa;
    }

    public void setHora(String hora) {
        this.horaRemessa = hora;
    }

    public String getData() {
        return dataRemessa;
    }

    public void setData(String data) {
        this.dataRemessa = data;
    }
    
    
    
}
