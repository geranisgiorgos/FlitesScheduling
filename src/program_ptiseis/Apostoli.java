/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program_ptiseis;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "APOSTOLI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apostoli.findAll", query = "SELECT a FROM Apostoli a"),
    @NamedQuery(name = "Apostoli.findById", query = "SELECT a FROM Apostoli a WHERE a.id = :id"),
    @NamedQuery(name = "Apostoli.findByCallsign", query = "SELECT a FROM Apostoli a WHERE a.callsign = :callsign"),
    @NamedQuery(name = "Apostoli.findByTakeoff", query = "SELECT a FROM Apostoli a WHERE a.takeoff = :takeoff"),
    @NamedQuery(name = "Apostoli.findByLanding", query = "SELECT a FROM Apostoli a WHERE a.landing = :landing"),
    @NamedQuery(name = "Apostoli.findByApostoliReal", query = "SELECT a FROM Apostoli a WHERE a.apostoliRealid = :apostolirealid"),
    @NamedQuery(name = "Apostoli.findByProorismos", query = "SELECT a FROM Apostoli a WHERE a.proorismos = :proorismos")
})

public class Apostoli implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CALLSIGN")
    private String callsign;
    @Column(name = "TAKEOFF")
    @Temporal(TemporalType.TIME)
    private Date takeoff;
    @Column(name = "LANDING")
    @Temporal(TemporalType.TIME)
    private Date landing;
    @Column(name = "PROORISMOS")
    private String proorismos;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "apostoli")
    private ApostoliReal apostoliReal;
    @JoinColumn(name = "AEROSKAFOSSN", referencedColumnName = "SN")
    @ManyToOne(optional = false)
    private Aeroskafos aeroskafossn;
    @JoinColumn(name = "APOSTOLI_REALID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ApostoliReal apostoliRealid;
    @JoinColumn(name = "ASKISIID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Askisi askisiid;
    @JoinColumn(name = "COP", referencedColumnName = "ID")
    @ManyToOne
    private Pilot cop;
    @JoinColumn(name = "PIC", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Pilot pic;
    @JoinColumn(name = "PROGRAMMA_PTISEONID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ProgrammaPtiseon programmaPtiseonid;

    public Apostoli() {
    }

    public Apostoli(Integer id) {
        this.id = id;
    }

    public Apostoli(Integer id, String callsign) {
        this.id = id;
        this.callsign = callsign;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getCallsign() {
        return callsign;
    }

    public void setCallsign(String callsign) {
        String oldCallsign = this.callsign;
        this.callsign = callsign;
        changeSupport.firePropertyChange("callsign", oldCallsign, callsign);
    }

    public Date getTakeoff() {
        return takeoff;
    }

    public void setTakeoff(Date takeoff) {
        Date oldTakeoff = this.takeoff;
        this.takeoff = takeoff;
        changeSupport.firePropertyChange("takeoff", oldTakeoff, takeoff);
    }

    public Date getLanding() {
        return landing;
    }

    public void setLanding(Date landing) {
        Date oldLanding = this.landing;
        this.landing = landing;
        changeSupport.firePropertyChange("landing", oldLanding, landing);
    }

    public String getProorismos() {
        return proorismos;
    }

    public void setProorismos(String proorismos) {
        String oldProorismos = this.proorismos;
        this.proorismos = proorismos;
        changeSupport.firePropertyChange("proorismos", oldProorismos, proorismos);
    }

    public void setApostoliReal(ApostoliReal apostoliReal) {
        this.apostoliReal = apostoliReal;
    }

    public Aeroskafos getAeroskafossn() {
        return aeroskafossn;
    }

    public void setAeroskafossn(Aeroskafos aeroskafossn) {
        Aeroskafos oldAeroskafossn = this.aeroskafossn;
        this.aeroskafossn = aeroskafossn;
        changeSupport.firePropertyChange("aeroskafossn", oldAeroskafossn, aeroskafossn);
    }

    public ApostoliReal getApostoliRealid() {
        return apostoliRealid;
    }

    public void setApostoliRealid(ApostoliReal apostoliRealid) {
        ApostoliReal oldApostoliRealid = this.apostoliRealid;
        this.apostoliRealid = apostoliRealid;
        changeSupport.firePropertyChange("apostoliRealid", oldApostoliRealid, apostoliRealid);
    }

    public Askisi getAskisiid() {
        return askisiid;
    }

    public void setAskisiid(Askisi askisiid) {
        Askisi oldAskisiid = this.askisiid;
        this.askisiid = askisiid;
        changeSupport.firePropertyChange("askisiid", oldAskisiid, askisiid);
    }

    public Pilot getCop() {
        return cop;
    }

    public void setCop(Pilot cop) {
        Pilot oldCop = this.cop;
        this.cop = cop;
        changeSupport.firePropertyChange("cop", oldCop, cop);
    }

    public Pilot getPic() {
        return pic;
    }

    public void setPic(Pilot pic) {
        Pilot oldPic = this.pic;
        this.pic = pic;
        changeSupport.firePropertyChange("pic", oldPic, pic);
    }

    public ProgrammaPtiseon getProgrammaPtiseonid() {
        return programmaPtiseonid;
    }

    public void setProgrammaPtiseonid(ProgrammaPtiseon programmaPtiseonid) {
        ProgrammaPtiseon oldProgrammaPtiseonid = this.programmaPtiseonid;
        this.programmaPtiseonid = programmaPtiseonid;
        changeSupport.firePropertyChange("programmaPtiseonid", oldProgrammaPtiseonid, programmaPtiseonid);
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
        if (!(object instanceof Apostoli)) {
            return false;
        }
        Apostoli other = (Apostoli) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "program_ptiseis.Apostoli[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
