/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.walmart.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Polez
 */
@Entity
@Table(name = "produto", catalog = "walmart", schema = "")
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p")
    , @NamedQuery(name = "Produto.findByIdProduto", query = "SELECT p FROM Produto p WHERE p.idProduto = :idProduto")
    , @NamedQuery(name = "Produto.findByPrecoProduto", query = "SELECT p FROM Produto p WHERE p.precoProduto = :precoProduto")
    , @NamedQuery(name = "Produto.findByNomeProduto", query = "SELECT p FROM Produto p WHERE p.nomeProduto = :nomeProduto")
    , @NamedQuery(name = "Produto.findByObservacao", query = "SELECT p FROM Produto p WHERE p.observacao = :observacao")
    , @NamedQuery(name = "Produto.findByEmpresaProduto", query = "SELECT p FROM Produto p WHERE p.empresaProduto = :empresaProduto")
    , @NamedQuery(name = "Produto.findByBarcodeProduto", query = "SELECT p FROM Produto p WHERE p.barcodeProduto = :barcodeProduto")
    , @NamedQuery(name = "Produto.findByDataVencimentoProduto", query = "SELECT p FROM Produto p WHERE p.dataVencimentoProduto = :dataVencimentoProduto")
    , @NamedQuery(name = "Produto.findByQuantidadeDisponivelProduto", query = "SELECT p FROM Produto p WHERE p.quantidadeDisponivelProduto = :quantidadeDisponivelProduto")})
public class Produto implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idProduto")
    private Integer idProduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precoProduto")
    private Double precoProduto;
    @Column(name = "nomeProduto")
    private String nomeProduto;
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "empresaProduto")
    private String empresaProduto;
    @Column(name = "barcodeProduto")
    private String barcodeProduto;
    @Column(name = "dataVencimentoProduto")
    private String dataVencimentoProduto;
    @Column(name = "quantidadeDisponivelProduto")
    private Integer quantidadeDisponivelProduto;

    public Produto() {
    }

    public Produto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        Integer oldIdProduto = this.idProduto;
        this.idProduto = idProduto;
        changeSupport.firePropertyChange("idProduto", oldIdProduto, idProduto);
    }

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        Double oldPrecoProduto = this.precoProduto;
        this.precoProduto = precoProduto;
        changeSupport.firePropertyChange("precoProduto", oldPrecoProduto, precoProduto);
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        String oldNomeProduto = this.nomeProduto;
        this.nomeProduto = nomeProduto;
        changeSupport.firePropertyChange("nomeProduto", oldNomeProduto, nomeProduto);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        String oldObservacao = this.observacao;
        this.observacao = observacao;
        changeSupport.firePropertyChange("observacao", oldObservacao, observacao);
    }

    public String getEmpresaProduto() {
        return empresaProduto;
    }

    public void setEmpresaProduto(String empresaProduto) {
        String oldEmpresaProduto = this.empresaProduto;
        this.empresaProduto = empresaProduto;
        changeSupport.firePropertyChange("empresaProduto", oldEmpresaProduto, empresaProduto);
    }

    public String getBarcodeProduto() {
        return barcodeProduto;
    }

    public void setBarcodeProduto(String barcodeProduto) {
        String oldBarcodeProduto = this.barcodeProduto;
        this.barcodeProduto = barcodeProduto;
        changeSupport.firePropertyChange("barcodeProduto", oldBarcodeProduto, barcodeProduto);
    }

    public String getDataVencimentoProduto() {
        return dataVencimentoProduto;
    }

    public void setDataVencimentoProduto(String dataVencimentoProduto) {
        String oldDataVencimentoProduto = this.dataVencimentoProduto;
        this.dataVencimentoProduto = dataVencimentoProduto;
        changeSupport.firePropertyChange("dataVencimentoProduto", oldDataVencimentoProduto, dataVencimentoProduto);
    }

    public Integer getQuantidadeDisponivelProduto() {
        return this.quantidadeDisponivelProduto;
    }

    public void setQuantidadeDisponivelProduto(Integer quantidadeDisponivelProduto) {
        Integer oldQuantidadeDisponivelProduto = this.quantidadeDisponivelProduto;
        this.quantidadeDisponivelProduto = quantidadeDisponivelProduto;
        changeSupport.firePropertyChange("quantidadeDisponivelProduto", oldQuantidadeDisponivelProduto, quantidadeDisponivelProduto);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.inatel.walmart.view.Produto[ idProduto=" + idProduto + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
