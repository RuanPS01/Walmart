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
@Table(name = "cliente", catalog = "walmart", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByCpfCliente", query = "SELECT c FROM Cliente c WHERE c.cpfCliente = :cpfCliente")
    , @NamedQuery(name = "Cliente.findByNomeCliente", query = "SELECT c FROM Cliente c WHERE c.nomeCliente = :nomeCliente")
    , @NamedQuery(name = "Cliente.findByEmailCiente", query = "SELECT c FROM Cliente c WHERE c.emailCiente = :emailCiente")
    , @NamedQuery(name = "Cliente.findByTelefoneCliente", query = "SELECT c FROM Cliente c WHERE c.telefoneCliente = :telefoneCliente")
    , @NamedQuery(name = "Cliente.findByEnderecoCliente", query = "SELECT c FROM Cliente c WHERE c.enderecoCliente = :enderecoCliente")
    , @NamedQuery(name = "Cliente.findByNascimentoCliente", query = "SELECT c FROM Cliente c WHERE c.nascimentoCliente = :nascimentoCliente")})
public class Cliente implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cpfCliente")
    private Integer cpfCliente;
    @Column(name = "nomeCliente")
    private String nomeCliente;
    @Column(name = "emailCiente")
    private String emailCiente;
    @Column(name = "telefoneCliente")
    private String telefoneCliente;
    @Column(name = "enderecoCliente")
    private String enderecoCliente;
    @Column(name = "nascimentoCliente")
    private String nascimentoCliente;

    public Cliente() {
    }

    public Cliente(Integer cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public Integer getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(Integer cpfCliente) {
        Integer oldCpfCliente = this.cpfCliente;
        this.cpfCliente = cpfCliente;
        changeSupport.firePropertyChange("cpfCliente", oldCpfCliente, cpfCliente);
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        String oldNomeCliente = this.nomeCliente;
        this.nomeCliente = nomeCliente;
        changeSupport.firePropertyChange("nomeCliente", oldNomeCliente, nomeCliente);
    }

    public String getEmailCiente() {
        return emailCiente;
    }

    public void setEmailCiente(String emailCiente) {
        String oldEmailCiente = this.emailCiente;
        this.emailCiente = emailCiente;
        changeSupport.firePropertyChange("emailCiente", oldEmailCiente, emailCiente);
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        String oldTelefoneCliente = this.telefoneCliente;
        this.telefoneCliente = telefoneCliente;
        changeSupport.firePropertyChange("telefoneCliente", oldTelefoneCliente, telefoneCliente);
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        String oldEnderecoCliente = this.enderecoCliente;
        this.enderecoCliente = enderecoCliente;
        changeSupport.firePropertyChange("enderecoCliente", oldEnderecoCliente, enderecoCliente);
    }

    public String getNascimentoCliente() {
        return nascimentoCliente;
    }

    public void setNascimentoCliente(String nascimentoCliente) {
        String oldNascimentoCliente = this.nascimentoCliente;
        this.nascimentoCliente = nascimentoCliente;
        changeSupport.firePropertyChange("nascimentoCliente", oldNascimentoCliente, nascimentoCliente);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpfCliente != null ? cpfCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.cpfCliente == null && other.cpfCliente != null) || (this.cpfCliente != null && !this.cpfCliente.equals(other.cpfCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.inatel.walmart.view.Cliente[ cpfCliente=" + cpfCliente + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
