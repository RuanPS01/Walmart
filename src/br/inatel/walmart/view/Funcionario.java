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
@Table(name = "funcionario", catalog = "walmart", schema = "")
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")
    , @NamedQuery(name = "Funcionario.findByCpfFuncionario", query = "SELECT f FROM Funcionario f WHERE f.cpfFuncionario = :cpfFuncionario")
    , @NamedQuery(name = "Funcionario.findByNomeFuncionario", query = "SELECT f FROM Funcionario f WHERE f.nomeFuncionario = :nomeFuncionario")
    , @NamedQuery(name = "Funcionario.findByEmailFuncionario", query = "SELECT f FROM Funcionario f WHERE f.emailFuncionario = :emailFuncionario")
    , @NamedQuery(name = "Funcionario.findByTelefoneFuncionario", query = "SELECT f FROM Funcionario f WHERE f.telefoneFuncionario = :telefoneFuncionario")
    , @NamedQuery(name = "Funcionario.findByEnderecoFuncionario", query = "SELECT f FROM Funcionario f WHERE f.enderecoFuncionario = :enderecoFuncionario")
    , @NamedQuery(name = "Funcionario.findByNascimentoFuncionario", query = "SELECT f FROM Funcionario f WHERE f.nascimentoFuncionario = :nascimentoFuncionario")})
public class Funcionario implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cpfFuncionario")
    private String cpfFuncionario;
    @Column(name = "nomeFuncionario")
    private String nomeFuncionario;
    @Column(name = "emailFuncionario")
    private String emailFuncionario;
    @Column(name = "telefoneFuncionario")
    private String telefoneFuncionario;
    @Column(name = "enderecoFuncionario")
    private String enderecoFuncionario;
    @Column(name = "nascimentoFuncionario")
    private String nascimentoFuncionario;
    private String usuarioFuncionario;
    private String senhaFuncionario;

    public Funcionario() {
    }

    public Funcionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setUsuarioFuncionario(String u){
        String oldU = this.usuarioFuncionario;
        this.usuarioFuncionario = u;
        changeSupport.firePropertyChange("usuarioFuncionario", oldU, u);
    }
    
    public void setSenhaFuncionario(String s){
        String oldS = this.senhaFuncionario;
        this.senhaFuncionario = s;
        changeSupport.firePropertyChange("senhaFuncionario", oldS, s);
    }
    
    public String getSenhaFuncionario(){
        return this.senhaFuncionario;
    }
    
    public String getUsuarioFuncionario(){
        return this.usuarioFuncionario;
    }
    
    public void setCpfFuncionario(String cpfFuncionario) {
        String oldCpfFuncionario = this.cpfFuncionario;
        this.cpfFuncionario = cpfFuncionario;
        changeSupport.firePropertyChange("cpfFuncionario", oldCpfFuncionario, cpfFuncionario);
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        String oldNomeFuncionario = this.nomeFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        changeSupport.firePropertyChange("nomeFuncionario", oldNomeFuncionario, nomeFuncionario);
    }

    public String getEmailFuncionario() {
        return emailFuncionario;
    }

    public void setEmailFuncionario(String emailFuncionario) {
        String oldEmailFuncionario = this.emailFuncionario;
        this.emailFuncionario = emailFuncionario;
        changeSupport.firePropertyChange("emailFuncionario", oldEmailFuncionario, emailFuncionario);
    }

    public String getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    public void setTelefoneFuncionario(String telefoneFuncionario) {
        String oldTelefoneFuncionario = this.telefoneFuncionario;
        this.telefoneFuncionario = telefoneFuncionario;
        changeSupport.firePropertyChange("telefoneFuncionario", oldTelefoneFuncionario, telefoneFuncionario);
    }

    public String getEnderecoFuncionario() {
        return enderecoFuncionario;
    }

    public void setEnderecoFuncionario(String enderecoFuncionario) {
        String oldEnderecoFuncionario = this.enderecoFuncionario;
        this.enderecoFuncionario = enderecoFuncionario;
        changeSupport.firePropertyChange("enderecoFuncionario", oldEnderecoFuncionario, enderecoFuncionario);
    }

    public String getNascimentoFuncionario() {
        return nascimentoFuncionario;
    }

    public void setNascimentoFuncionario(String nascimentoFuncionario) {
        String oldNascimentoFuncionario = this.nascimentoFuncionario;
        this.nascimentoFuncionario = nascimentoFuncionario;
        changeSupport.firePropertyChange("nascimentoFuncionario", oldNascimentoFuncionario, nascimentoFuncionario);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpfFuncionario != null ? cpfFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.cpfFuncionario == null && other.cpfFuncionario != null) || (this.cpfFuncionario != null && !this.cpfFuncionario.equals(other.cpfFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.inatel.walmart.view.Funcionario[ cpfFuncionario=" + cpfFuncionario + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
