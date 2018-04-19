/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program_ptiseis;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "APOSTOLI_REAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApostoliReal.findAll", query = "SELECT a FROM ApostoliReal a"),
    @NamedQuery(name = "ApostoliReal.findById", query = "SELECT a FROM ApostoliReal a WHERE a.id = :id"),
    @NamedQuery(name = "ApostoliReal.findByBiblioPtiseonid", query = "SELECT a FROM ApostoliReal a WHERE a.biblioPtiseonid = :biblioPtiseonid"),
    @NamedQuery(name = "ApostoliReal.findByTakeoff", query = "SELECT a FROM ApostoliReal a WHERE a.takeoff = :takeoff"),
    @NamedQuery(name = "ApostoliReal.findByLanding", query = "SELECT a FROM ApostoliReal a WHERE a.landing = :landing"),
    @NamedQuery(name = "ApostoliReal.findByPic", query = "SELECT a FROM ApostoliReal a WHERE a.pic = :pic"),
    @NamedQuery(name = "ApostoliReal.findByCop", query = "SELECT a FROM ApostoliReal a WHERE a.cop = :cop"),
    @NamedQuery(name = "ApostoliReal.findByApostoli", query = "SELECT a FROM ApostoliReal a WHERE a.apostoliid = :apostoliid"),
    @NamedQuery(name = "ApostoliReal.findByAeroskafossn", query = "SELECT a FROM ApostoliReal a WHERE a.aeroskafossn = :aeroskafossn")})
public class ApostoliReal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "BIBLIO_PTISEONID")
    private int biblioPtiseonid;
    @Column(name = "TAKEOFF")
    @Temporal(TemporalType.TIME)
    private Date takeoff;
    @Column(name = "LANDING")
    @Temporal(TemporalType.TIME)
    private Date landing;
    @Basic(optional = false)
    @Column(name = "PIC")
    private int pic;
    @Column(name = "COP")
    private Integer cop;
    @Basic(optional = false)
    @Column(name = "AEROSKAFOSSN")
    private String aeroskafossn;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Apostoli apostoli;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apostoliRealid")
    private Collection<Apostoli> apostoliCollection;
    @Column(name = "PROORISMOS")
    private String proorismos;
    @Basic(optional = false)
    @Column(name = "APOSTOLIID")
    private int apostoliid;
    @Column(name = "COMPLETED")
    private Short completed;
    public String getProorismos() {
        return proorismos;
    }

    public void setProorismos(String proorismos) {
        this.proorismos = proorismos;
    }
    
    public ApostoliReal() {
    }

    public ApostoliReal(Integer id) {
        this.id = id;
    }

    public Short getCompleted() {
        return completed;
    }

    public void setCompleted(Short completed) {
        this.completed = completed;
    }

    public void setApostoliId(int apostoliId) {
        this.apostoliid = apostoliId;
    }

    public void setBiblioPtiseonid(int biblioPtiseonid) {
        this.biblioPtiseonid = biblioPtiseonid;
    }

    public ApostoliReal(Integer id, int programmaPtiseonid, int pic, Integer cop, String aeroskafossn) {
        this.id = id;
        this.biblioPtiseonid = programmaPtiseonid;
        this.pic = pic;
        this.cop = cop;
        this.aeroskafossn = aeroskafossn;
    }

    public ApostoliReal(Integer id, int programmaPtiseonid, int pic, String aeroskafossn) {
        this.id = id;
        this.biblioPtiseonid = programmaPtiseonid;
        this.pic = pic;
        this.aeroskafossn = aeroskafossn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getProgrammaPtiseonid() {
        return biblioPtiseonid;
    }

    public void setProgrammaPtiseonid(int programmaPtiseonid) {
        this.biblioPtiseonid = programmaPtiseonid;
    }

    public Date getTakeoff() {
        return takeoff;
    }

    public void setTakeoff(Date takeoff) {
        this.takeoff = takeoff;
    }

    public Date getLanding() {
        return landing;
    }

    public void setLanding(Date landing) {
        this.landing = landing;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public Integer getCop() {
        return cop;
    }

    public void setCop(Integer cop) {
        this.cop = cop;
    }

    public String getAeroskafossn() {
        return aeroskafossn;
    }

    public void setAeroskafossn(String aeroskafossn) {
        this.aeroskafossn = aeroskafossn;
    }



    public void setApostoli(Apostoli apostoli) {
        this.apostoli = apostoli;
    }

    @XmlTransient
    public Collection<Apostoli> getApostoliCollection() {
        return apostoliCollection;
    }

    public int getBiblioPtiseonid() {
        return biblioPtiseonid;
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
        if (!(object instanceof ApostoliReal)) {
            return false;
        }
        ApostoliReal other = (ApostoliReal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "program_ptiseis.ApostoliReal[ id=" + id + " ]";
    }
    
}
