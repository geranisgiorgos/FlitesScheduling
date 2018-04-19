/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program_ptiseis;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "ASKISI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Askisi.findAll", query = "SELECT a FROM Askisi a"),
    @NamedQuery(name = "Askisi.findById", query = "SELECT a FROM Askisi a WHERE a.id = :id"),
    @NamedQuery(name = "Askisi.findByPlithosAp", query = "SELECT a FROM Askisi a WHERE a.plithosAp = :plithosAp"),
    @NamedQuery(name = "Askisi.findByPlithosEm", query = "SELECT a FROM Askisi a WHERE a.plithosEm = :plithosEm"),
    @NamedQuery(name = "Askisi.findByIsxysAp", query = "SELECT a FROM Askisi a WHERE a.isxysAp = :isxysAp"),
    @NamedQuery(name = "Askisi.findByIsxysEm", query = "SELECT a FROM Askisi a WHERE a.isxysEm = :isxysEm")})
public class Askisi implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "PLITHOS_AP")
    private Integer plithosAp;
    @Column(name = "PLITHOS_EM")
    private Integer plithosEm;
    @Column(name = "ISXYS_AP")
    private Integer isxysAp;
    @Column(name = "ISXYS_EM")
    private Integer isxysEm;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "askisiid")
    private Collection<Apostoli> apostoliCollection;

    public Askisi() {
    }

    public Askisi(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        String oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Integer getPlithosAp() {
        return plithosAp;
    }

    public void setPlithosAp(Integer plithosAp) {
        Integer oldPlithosAp = this.plithosAp;
        this.plithosAp = plithosAp;
        changeSupport.firePropertyChange("plithosAp", oldPlithosAp, plithosAp);
    }

    public Integer getPlithosEm() {
        return plithosEm;
    }

    public void setPlithosEm(Integer plithosEm) {
        Integer oldPlithosEm = this.plithosEm;
        this.plithosEm = plithosEm;
        changeSupport.firePropertyChange("plithosEm", oldPlithosEm, plithosEm);
    }

    public Integer getIsxysAp() {
        return isxysAp;
    }

    public void setIsxysAp(Integer isxysAp) {
        Integer oldIsxysAp = this.isxysAp;
        this.isxysAp = isxysAp;
        changeSupport.firePropertyChange("isxysAp", oldIsxysAp, isxysAp);
    }

    public Integer getIsxysEm() {
        return isxysEm;
    }

    public void setIsxysEm(Integer isxysEm) {
        Integer oldIsxysEm = this.isxysEm;
        this.isxysEm = isxysEm;
        changeSupport.firePropertyChange("isxysEm", oldIsxysEm, isxysEm);
    }

    @XmlTransient
    public Collection<Apostoli> getApostoliCollection() {
        return apostoliCollection;
    }

    public void setApostoliCollection(Collection<Apostoli> apostoliCollection) {
        this.apostoliCollection = apostoliCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Askisi)) {
            return false;
        }
        Askisi other = (Askisi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "program_ptiseis.Askisi[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
