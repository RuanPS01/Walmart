/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.walmart.model;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
/** Classe com dados de cadastro do remédio 
 *
 * @author ruanp
 */
public class Produto{
    private int idProduto;
    private String nomeProduto, observacao, empresaProduto, barcodeProduto, dataVencimentoProduto;
    private LocalDate localDateVencimentoProduto;
    private int quantidadeDisponivelProduto = 0; 
    private double precoProduto;
    
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int id) {
        this.idProduto = id;
    }
    
    public String getDataStringVencimento() {
        return dataVencimentoProduto;
    }
    
    public void setDataStringVencimento(String dataVencimento) {
        this.dataVencimentoProduto = dataVencimento;
    }

    public LocalDate getLocalDateVencimentoProduto() {
        return localDateVencimentoProduto;
    }

    public void setLocalDateVencimentoProduto(LocalDate localDateVencimentoProduto) {
        this.localDateVencimentoProduto = localDateVencimentoProduto;
        dataVencimentoProduto = getLocalDateVencimentoProduto().getDayOfMonth()+"/"+getLocalDateVencimentoProduto().getMonthValue()+"/"+getLocalDateVencimentoProduto().getYear();
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
    
    public String getEmpresaProduto() {
        return empresaProduto;
    }

    public void setEmpresaProduto(String empresa) {
        this.empresaProduto = empresa;
    }
    
    public String getBarcodeProduto() {
        return barcodeProduto;
    }

    public void setBarcodeProduto(String barcodeProduto) {
        this.barcodeProduto = barcodeProduto;
    }
    
     public int getQuantidadeDisponivelProduto() {
        return quantidadeDisponivelProduto;
    }

    public void setQuantidadeDisponivelProduto(int quantidadeDisponivelProduto) {
        this.quantidadeDisponivelProduto = quantidadeDisponivelProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }
}
