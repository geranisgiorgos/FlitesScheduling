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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "PROGRAMMA_PTISEON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgrammaPtiseon.findAll", query = "SELECT p FROM ProgrammaPtiseon p"),
    @NamedQuery(name = "ProgrammaPtiseon.findById", query = "SELECT p FROM ProgrammaPtiseon p WHERE p.id = :id"),
    @NamedQuery(name = "ProgrammaPtiseon.findByDate", query = "SELECT p FROM ProgrammaPtiseon p WHERE p.date = :date")})
public class ProgrammaPtiseon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "\"Date\"")
    @Temporal(TemporalType.DATE)
    private Date date;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programmaPtiseonid")
    private Collection<Apostoli> apostoliCollection;
    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "programmaPtiseon")
    //private BiblioPtiseon biblioPtiseon;

    public ProgrammaPtiseon() {
    }

    public ProgrammaPtiseon(Integer id) {
        this.id = id;
    }

    public ProgrammaPtiseon(Integer id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @XmlTransient
    public Collection<Apostoli> getApostoliCollection() {
        return apostoliCollection;
    }

    public void setApostoliCollection(Collection<Apostoli> apostoliCollection) {
        this.apostoliCollection = apostoliCollection;
    }

//    public BiblioPtiseon getBiblioPtiseon() {
//        return biblioPtiseon;
//    }

//    public void setBiblioPtiseon(BiblioPtiseon biblioPtiseon) {
//        this.biblioPtiseon = biblioPtiseon;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgrammaPtiseon)) {
            return false;
        }
        ProgrammaPtiseon other = (ProgrammaPtiseon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "program_ptiseis.ProgrammaPtiseon[ id=" + id + " ]";
    }
    
}
