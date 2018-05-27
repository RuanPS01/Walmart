/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.walmart.model;
import java.time.LocalDate;
import java.time.Period;
/** Classe com dados de cadastro do remédio 
 *
 * @author ruanp
 */
public class Produto{
    private int idProduto;
    private String observacao, nomeProduto, precoProduto, empresaProduto, barcodeProduto;     
    private LocalDate dataVencimentoProduto;
    private double quantidadeDisponivelProduto = 0;
    
    public int getId() {
        return idProduto;
    }

    public void setId(int id) {
        this.idProduto = id;
    }
    
    public LocalDate getDataVencimento() {
        return dataVencimentoProduto;
    }
    
    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimentoProduto = dataVencimento;
    }
    
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeRemedio) {
        this.nomeProduto = nomeRemedio;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public double getQuantidadeDisponivel() {
        return quantidadeDisponivelProduto;
    }

    public void setQuantidadeDisponivel(double quantidadeDisponivel) {
        this.quantidadeDisponivelProduto = quantidadeDisponivel;
    }
    
    public String getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(String precoProduto) {
        this.precoProduto = precoProduto;
    }
    
    public String getEmpresa() {
        return empresaProduto;
    }

    public void setEmpresa(String empresa) {
        this.empresaProduto = empresa;
    }
    
    public String getBarcodeProduto() {
        return barcodeProduto;
    }

    public void setBarcodeProduto(String barcodeProduto) {
        this.barcodeProduto = barcodeProduto;
    }
}
