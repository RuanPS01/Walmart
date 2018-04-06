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
    private String observacao, nomeProduto;
    private LocalDate dataVencimento;
    private double quantidadeDisponivel=0, aDose=1;
    
    /** Classe com dados de cadastro do remédio 
     *   @return Obtenção da data de vencimento do remédio em formato LocalDate
    */
    public LocalDate getDataVencimento() {
        return dataVencimento;
    }
    
    /** Classe com dados de cadastro do remédio
     * @param Parâmetro da data de vencimento do remédio
    */
    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    
    /** Classe com dados de cadastro do remédio
     * @param Obtenção do nome do remédio
    */
    public String getNomeProduto() {
        return nomeProduto;
    }
    
    /** Classe com dados de cadastro do remédio
     * @param Parâmetro do nome do remédio
    */
    public void setNomeProduto(String nomeRemedio) {
        this.nomeProduto = nomeRemedio;
    }

    /** Classe com dados de cadastro do remédio
     * @param Obtenção da observação do remédio
    */
    public String getObservacao() {
        return observacao;
    }
    
    /** Classe com dados de cadastro do remédio
     * @param Parâmetro da observação do remédio
    */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    /** Classe com dados de cadastro do remédio
     * @param Obtenção da quantidade disponível do remédio
    */
    public double getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }
    
    /** Classe com dados de cadastro do remédio
     * @param Parâmetro da observação do remédio
    */
    public void setQuantidadeDisponivel(double quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }
    
    /** Classe com dados de cadastro do remédio
     * @param Obtenção da dose do remédio
    */
    public double getaDose() {
        return aDose;
    }
    
    /** Classe com dados de cadastro do remédio
     * @param Parâmetro da dose do remédio
    */
    public void setaDose(double aDose) {
        this.aDose = aDose;
    }
}
