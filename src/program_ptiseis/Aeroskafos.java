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
@Table(name = "AEROSKAFOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aeroskafos.findAll", query = "SELECT a FROM Aeroskafos a"),
    @NamedQuery(name = "Aeroskafos.findBySn", query = "SELECT a FROM Aeroskafos a WHERE a.sn = :sn"),
    @NamedQuery(name = "Aeroskafos.findByHoursA", query = "SELECT a FROM Aeroskafos a WHERE a.hoursA = :hoursA"),
    @NamedQuery(name = "Aeroskafos.findByHoursB", query = "SELECT a FROM Aeroskafos a WHERE a.hoursB = :hoursB"),
    @NamedQuery(name = "Aeroskafos.findByAvailable", query = "SELECT a FROM Aeroskafos a WHERE a.available = :available")})
public class Aeroskafos implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SN")
    private String sn;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "HOURS_A")
    private Float hoursA;
    @Column(name = "HOURS_B")
    private Float hoursB;
    @Basic(optional = false)
    @Column(name = "AVAILABLE")
    private short available;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aeroskafossn")
    private Collection<Apostoli> apostoliCollection;

    public Aeroskafos() {
    }

    public Aeroskafos(String sn) {
        this.sn = sn;
    }

    public Aeroskafos(String sn, Float hoursA, Float hoursB) {
        this.sn = sn;
        this.hoursA = hoursA;
        this.hoursB = hoursB;
    }

    public Aeroskafos(String sn, short available) {
        this.sn = sn;
        this.available = available;
    }

    public String getSn() {
        return sn;
    }

    //  Προσθέτουμε τις ώρες πτήσης από το υπόλοιπο για τις επιθεωρήσεις
    public void addHours(float diff){
        hoursA += diff;
        hoursB += diff;
    }
    
    //  Αφαιρούμε τις ώρες πτήσης από το υπόλοιπο για τις επιθεωρήσεις
    public void subHours(float diff){
        hoursA -= diff;
        hoursB -= diff;
    }
    
    public void setSn(String sn) {
        String oldSn = this.sn;
        this.sn = sn;
        changeSupport.firePropertyChange("sn", oldSn, sn);
    }

    public Float getHoursA() {
        return hoursA;
    }

    public void setHoursA(Float hoursA) {
        Float oldHoursA = this.hoursA;
        this.hoursA = hoursA;
        changeSupport.firePropertyChange("hoursA", oldHoursA, hoursA);
    }

    public Float getHoursB() {
        return hoursB;
    }

    public void setHoursB(Float hoursB) {
        Float oldHoursB = this.hoursB;
        this.hoursB = hoursB;
        changeSupport.firePropertyChange("hoursB", oldHoursB, hoursB);
    }

    public short getAvailable() {
        return available;
    }

    public void setAvailable(short available) {
        short oldAvailable = this.available;
        this.available = available;
        changeSupport.firePropertyChange("available", oldAvailable, available);
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
        hash += (sn != null ? sn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aeroskafos)) {
            return false;
        }
        Aeroskafos other = (Aeroskafos) object;
        if ((this.sn == null && other.sn != null) || (this.sn != null && !this.sn.equals(other.sn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "program_ptiseis.Aeroskafos[ sn=" + sn + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
