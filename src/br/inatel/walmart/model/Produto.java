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
    private String observacao, nomeProduto, precoProduto, empresaProduto, barcodeProduto;   
    private LocalDate dataVencimento;
    private double quantidadeDisponivel=0;
    
    public LocalDate getDataVencimento() {
        return dataVencimento;
    }
    
    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
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
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(double quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
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
}
