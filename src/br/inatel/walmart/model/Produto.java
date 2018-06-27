/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.walmart.model;

/**
 *
 * @author RuanPatrickdeSouza
 */
public class Produto {
    private int idProduto,quantidadeDisponivelProduto;
    private String nomeProduto, observacao, empresaProduto, barcodeProduto, dataVencimentoProduto;
    private Double precoProduto;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidadeDisponivelProduto() {
        return quantidadeDisponivelProduto;
    }

    public void setQuantidadeDisponivelProduto(int quantidadeDisponivelProduto) {
        this.quantidadeDisponivelProduto = quantidadeDisponivelProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getEmpresaProduto() {
        return empresaProduto;
    }

    public void setEmpresaProduto(String empresaProduto) {
        this.empresaProduto = empresaProduto;
    }

    public String getBarcodeProduto() {
        return barcodeProduto;
    }

    public void setBarcodeProduto(String barcodeProduto) {
        this.barcodeProduto = barcodeProduto;
    }

    public String getDataVencimentoProduto() {
        return dataVencimentoProduto;
    }

    public void setDataVencimentoProduto(String dataVencimentoProduto) {
        this.dataVencimentoProduto = dataVencimentoProduto;
    }

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }
    
    
}
