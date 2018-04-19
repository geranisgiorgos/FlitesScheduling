/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program_ptiseis;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "BIBLIO_PTISEON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BiblioPtiseon.findAll", query = "SELECT b FROM BiblioPtiseon b"),
    @NamedQuery(name = "BiblioPtiseon.findByDate", query = "SELECT p FROM BiblioPtiseon p WHERE p.date = :date"),
    @NamedQuery(name = "BiblioPtiseon.findById", query = "SELECT b FROM BiblioPtiseon b WHERE b.id = :id")})
public class BiblioPtiseon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    //private ProgrammaPtiseon programmaPtiseon;

    @Basic(optional = false)
    @Column(name = "\"DATE\"")
    @Temporal(TemporalType.DATE)
    private Date date;
    
    public BiblioPtiseon() {
    }

    public BiblioPtiseon(Integer id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BiblioPtiseon)) {
            return false;
        }
        BiblioPtiseon other = (BiblioPtiseon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "program_ptiseis.BiblioPtiseon[ id=" + id + " ]";
    }
    
}
