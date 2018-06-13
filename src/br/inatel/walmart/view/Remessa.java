/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.walmart.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Polez
 */
@Entity
@Table(name = "remessa", catalog = "walmart", schema = "")
@NamedQueries({
    @NamedQuery(name = "Remessa.findAll", query = "SELECT r FROM Remessa r")
    , @NamedQuery(name = "Remessa.findByIdRemessa", query = "SELECT r FROM Remessa r WHERE r.idRemessa = :idRemessa")
    , @NamedQuery(name = "Remessa.findByDataRemessa", query = "SELECT r FROM Remessa r WHERE r.dataRemessa = :dataRemessa")
    , @NamedQuery(name = "Remessa.findByHoraRemessa", query = "SELECT r FROM Remessa r WHERE r.horaRemessa = :horaRemessa")
    , @NamedQuery(name = "Remessa.findByEmpresaRemessa", query = "SELECT r FROM Remessa r WHERE r.empresaRemessa = :empresaRemessa")
    , @NamedQuery(name = "Remessa.findByFuncionarioRemessa", query = "SELECT r FROM Remessa r WHERE r.funcionarioRemessa = :funcionarioRemessa")})
public class Remessa implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idRemessa")
    private Integer idRemessa;
    @Column(name = "dataRemessa")
    @Temporal(TemporalType.DATE)
    private Date dataRemessa;
    @Column(name = "horaRemessa")
    private String horaRemessa;
    @Column(name = "empresaRemessa")
    private String empresaRemessa;
    @Column(name = "funcionarioRemessa")
    private String funcionarioRemessa;

    public Remessa() {
    }

    public Remessa(Integer idRemessa) {
        this.idRemessa = idRemessa;
    }

    public Integer getIdRemessa() {
        return idRemessa;
    }

    public void setIdRemessa(Integer idRemessa) {
        Integer oldIdRemessa = this.idRemessa;
        this.idRemessa = idRemessa;
        changeSupport.firePropertyChange("idRemessa", oldIdRemessa, idRemessa);
    }

    public Date getDataRemessa() {
        return dataRemessa;
    }

    public void setDataRemessa(Date dataRemessa) {
        Date oldDataRemessa = this.dataRemessa;
        this.dataRemessa = dataRemessa;
        changeSupport.firePropertyChange("dataRemessa", oldDataRemessa, dataRemessa);
    }

    public String getHoraRemessa() {
        return horaRemessa;
    }

    public void setHoraRemessa(String horaRemessa) {
        String oldHoraRemessa = this.horaRemessa;
        this.horaRemessa = horaRemessa;
        changeSupport.firePropertyChange("horaRemessa", oldHoraRemessa, horaRemessa);
    }

    public String getEmpresaRemessa() {
        return empresaRemessa;
    }

    public void setEmpresaRemessa(String empresaRemessa) {
        String oldEmpresaRemessa = this.empresaRemessa;
        this.empresaRemessa = empresaRemessa;
        changeSupport.firePropertyChange("empresaRemessa", oldEmpresaRemessa, empresaRemessa);
    }

    public String getFuncionarioRemessa() {
        return funcionarioRemessa;
    }

    public void setFuncionarioRemessa(String funcionarioRemessa) {
        String oldFuncionarioRemessa = this.funcionarioRemessa;
        this.funcionarioRemessa = funcionarioRemessa;
        changeSupport.firePropertyChange("funcionarioRemessa", oldFuncionarioRemessa, funcionarioRemessa);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRemessa != null ? idRemessa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Remessa)) {
            return false;
        }
        Remessa other = (Remessa) object;
        if ((this.idRemessa == null && other.idRemessa != null) || (this.idRemessa != null && !this.idRemessa.equals(other.idRemessa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.inatel.walmart.view.Remessa[ idRemessa=" + idRemessa + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
