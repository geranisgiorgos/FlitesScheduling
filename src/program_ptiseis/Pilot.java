/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program_ptiseis;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "PILOT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pilot.findAll", query = "SELECT p FROM Pilot p"),
    @NamedQuery(name = "Pilot.findById", query = "SELECT p FROM Pilot p WHERE p.id = :id"),
    @NamedQuery(name = "Pilot.findByFirstname", query = "SELECT p FROM Pilot p WHERE p.firstname = :firstname"),
    @NamedQuery(name = "Pilot.findByLastname", query = "SELECT p FROM Pilot p WHERE p.lastname = :lastname"),
    @NamedQuery(name = "Pilot.findByEkpaideytis", query = "SELECT p FROM Pilot p WHERE p.ekpaideytis = :ekpaideytis"),
    @NamedQuery(name = "Pilot.findByDokimastis", query = "SELECT p FROM Pilot p WHERE p.dokimastis = :dokimastis"),
    @NamedQuery(name = "Pilot.findByPic", query = "SELECT p FROM Pilot p WHERE p.pic = :pic"),
    @NamedQuery(name = "Pilot.findByEm", query = "SELECT p FROM Pilot p WHERE p.em = :em"),
    @NamedQuery(name = "Pilot.findByCommander", query = "SELECT p FROM Pilot p WHERE p.commander = :commander"),
    @NamedQuery(name = "Pilot.findByAvailable", query = "SELECT p FROM Pilot p WHERE p.available = :available"),
    @NamedQuery(name = "Pilot.findByTotalhours", query = "SELECT p FROM Pilot p WHERE p.totalhours = :totalhours"),
    @NamedQuery(name = "Pilot.findByHoursexam", query = "SELECT p FROM Pilot p WHERE p.hoursexam = :hoursexam")})
public class Pilot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "EKPAIDEYTIS")
    private Short ekpaideytis;
    @Column(name = "DOKIMASTIS")
    private Short dokimastis;
    @Column(name = "PIC")
    private Short pic;
    @Column(name = "EM")
    private Short em;
    @Column(name = "COMMANDER")
    private Short commander;
    @Column(name = "AVAILABLE")
    private Short available;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTALHOURS")
    private Float totalhours;
    @Column(name = "HOURSEXAM")
    private Float hoursexam;
    @OneToMany(mappedBy = "cop")
    private Collection<Apostoli> apostoliCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pic")
    private Collection<Apostoli> apostoliCollection1;

    public Pilot() {
    }

    public Pilot(Integer id) {
        this.id = id;
    }

    public Pilot(int id, String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id=id;
    }
    // Προσθέτει ώρες στους πιλότους
    public void addHours (float diff){
        this.totalhours += diff;
        this.hoursexam += diff;
    }
    
    // Αφαιρεί ώρες από τους πιλότους
    public void subHours (float diff){
        this.totalhours -= diff;
        this.hoursexam -= diff;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Short getEkpaideytis() {
        return ekpaideytis;
    }

    public void setEkpaideytis(Short ekpaideytis) {
        this.ekpaideytis = ekpaideytis;
    }

    public Short getDokimastis() {
        return dokimastis;
    }

    public void setDokimastis(Short dokimastis) {
        this.dokimastis = dokimastis;
    }

    public Short getPic() {
        return pic;
    }

    public void setPic(Short pic) {
        this.pic = pic;
    }

    public Short getEm() {
        return em;
    }

    public void setEm(Short em) {
        this.em = em;
    }

    public Short getCommander() {
        return commander;
    }

    public void setCommander(Short commander) {
        this.commander = commander;
    }

    public Short getAvailable() {
        return available;
    }

    public void setAvailable(Short available) {
        this.available = available;
    }

    public Float getTotalhours() {
        return totalhours;
    }

    public void setTotalhours(Float totalhours) {
        this.totalhours = totalhours;
    }

    public Float getHoursexam() {
        return hoursexam;
    }

    public void setHoursexam(Float hoursexam) {
        this.hoursexam = hoursexam;
    }

    @XmlTransient
    public Collection<Apostoli> getApostoliCollection() {
        return apostoliCollection;
    }

    public void setApostoliCollection(Collection<Apostoli> apostoliCollection) {
        this.apostoliCollection = apostoliCollection;
    }

    @XmlTransient
    public Collection<Apostoli> getApostoliCollection1() {
        return apostoliCollection1;
    }

    public void setApostoliCollection1(Collection<Apostoli> apostoliCollection1) {
        this.apostoliCollection1 = apostoliCollection1;
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
        if (!(object instanceof Pilot)) {
            return false;
        }
        Pilot other = (Pilot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "program_ptiseis.Pilot[ id=" + id + " ]";
    }
    
}
