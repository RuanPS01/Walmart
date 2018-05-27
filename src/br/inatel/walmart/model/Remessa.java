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
    private int idRemessa;
    private String tipoRemessa, empresaRemessa, funcionarioRemessa, horaRemessa;
    private Date dataRemessa;

    public int getId() {
        return idRemessa;
    }

    public void setId(int id) {
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

    public String getFuncionario() {
        return funcionarioRemessa;
    }

    public void setFuncionario(String funcionario) {
        this.funcionarioRemessa = funcionario;
    }

    public String getHora() {
        return horaRemessa;
    }

    public void setHora(String hora) {
        this.horaRemessa = hora;
    }

    public Date getData() {
        return dataRemessa;
    }

    public void setData(Date data) {
        this.dataRemessa = data;
    }
    
    
    
}
