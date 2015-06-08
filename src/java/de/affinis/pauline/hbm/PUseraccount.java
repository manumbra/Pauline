package de.affinis.pauline.hbm;
// Generated 15.07.2013 19:07:36 by Hibernate Tools 3.2.1.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PUseraccount generated by hbm2java
 */
@Entity
@Table(name = "p_useraccount", catalog = "paulprod")
public class PUseraccount implements java.io.Serializable {

    private Integer hid;
    private PUserrole PUserrole;
    private Mitarbeiter mitarbeiter;
    private String login;
    private String passwd;
    private Date createdat;
    private Date modifiedat;
    private Set<PQProjekt> PQProjektsForModifiedby = new HashSet<PQProjekt>(0);
    private Set<PMassnahme> PQActionsForCreatedby = new HashSet<PMassnahme>(0);
    private Set<PQProjekt> PQProjektsForCreatedby = new HashSet<PQProjekt>(0);
    private Set<PMassnahme> PQActionsForModifiedby = new HashSet<PMassnahme>(0);
    private Set<PQKriterium> PQKriterienForCreatedby = new HashSet<PQKriterium>(0);
    private Set<PQObjekt> PQObjektsForCreatedby = new HashSet<PQObjekt>(0);
    private Set<PQKriterienVorlage> PQKriterienVorlagesForModifiedby = new HashSet<PQKriterienVorlage>(0);
    private Set<PQObjekt> PQObjektsForModifiedby = new HashSet<PQObjekt>(0);
    private Set<PQKriterienVorlage> PQKriterienVorlagesForCreatedby = new HashSet<PQKriterienVorlage>(0);
    private Set<PQKriterium> PQKriterienForModifiedby = new HashSet<PQKriterium>(0);

    public PUseraccount() {
    }

    public PUseraccount(PUserrole PUserrole, Mitarbeiter mitarbeiter, String login, String passwd,Date createdat, Date modifiedat, Set<PQProjekt> PQProjektsForModifiedby, Set<PMassnahme> PQActionsForCreatedby, Set<PQProjekt> PQProjektsForCreatedby, Set<PMassnahme> PQActionsForModifiedby, Set<PQKriterium> PQKriterienForCreatedby, Set<PQObjekt> PQObjektsForCreatedby, Set<PQKriterienVorlage> PQKriterienVorlagesForModifiedby, Set<PQObjekt> PQObjektsForModifiedby, Set<PQKriterienVorlage> PQKriterienVorlagesForCreatedby, Set<PQKriterium> PQKriterienForModifiedby) {
        this.PUserrole = PUserrole;
        this.mitarbeiter = mitarbeiter;
        this.login = login;
        this.passwd = passwd;
        this.createdat = createdat;
        this.modifiedat = modifiedat;
        this.PQProjektsForModifiedby = PQProjektsForModifiedby;
        this.PQActionsForCreatedby = PQActionsForCreatedby;
        this.PQProjektsForCreatedby = PQProjektsForCreatedby;
        this.PQActionsForModifiedby = PQActionsForModifiedby;
        this.PQKriterienForCreatedby = PQKriterienForCreatedby;
        this.PQObjektsForCreatedby = PQObjektsForCreatedby;
        this.PQKriterienVorlagesForModifiedby = PQKriterienVorlagesForModifiedby;
        this.PQObjektsForModifiedby = PQObjektsForModifiedby;
        this.PQKriterienVorlagesForCreatedby = PQKriterienVorlagesForCreatedby;
        this.PQKriterienForModifiedby = PQKriterienForModifiedby;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "hid", unique = true, nullable = false)
    public Integer getHid() {
        return this.hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="role", nullable=false)
    public PUserrole getPUserrole() {
        return this.PUserrole;
    }
    
    public void setPUserrole(PUserrole PUserrole) {
        this.PUserrole = PUserrole;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mitarbeiter")
    public Mitarbeiter getMitarbeiter() {
        return this.mitarbeiter;
    }

    public void setMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }

    @Column(name = "login")
    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "passwd", length = 1024)
    public String getPasswd() {
        return this.passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PUseraccountByModifiedby")
    public Set<PQProjekt> getPQProjektsForModifiedby() {
        return this.PQProjektsForModifiedby;
    }

    public void setPQProjektsForModifiedby(Set<PQProjekt> PQProjektsForModifiedby) {
        this.PQProjektsForModifiedby = PQProjektsForModifiedby;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PUseraccountByCreatedby")
    public Set<PMassnahme> getPQActionsForCreatedby() {
        return this.PQActionsForCreatedby;
    }

    public void setPQActionsForCreatedby(Set<PMassnahme> PQActionsForCreatedby) {
        this.PQActionsForCreatedby = PQActionsForCreatedby;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PUseraccountByCreatedby")
    public Set<PQProjekt> getPQProjektsForCreatedby() {
        return this.PQProjektsForCreatedby;
    }

    public void setPQProjektsForCreatedby(Set<PQProjekt> PQProjektsForCreatedby) {
        this.PQProjektsForCreatedby = PQProjektsForCreatedby;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PUseraccountByModifiedby")
    public Set<PMassnahme> getPQActionsForModifiedby() {
        return this.PQActionsForModifiedby;
    }

    public void setPQActionsForModifiedby(Set<PMassnahme> PQActionsForModifiedby) {
        this.PQActionsForModifiedby = PQActionsForModifiedby;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PUseraccountByCreatedby")
    public Set<PQKriterium> getPQKriterienForCreatedby() {
        return this.PQKriterienForCreatedby;
    }

    public void setPQKriterienForCreatedby(Set<PQKriterium> PQKriterienForCreatedby) {
        this.PQKriterienForCreatedby = PQKriterienForCreatedby;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PUseraccountByCreatedby")
    public Set<PQObjekt> getPQObjektsForCreatedby() {
        return this.PQObjektsForCreatedby;
    }

    public void setPQObjektsForCreatedby(Set<PQObjekt> PQObjektsForCreatedby) {
        this.PQObjektsForCreatedby = PQObjektsForCreatedby;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PUseraccountByModifiedby")
    public Set<PQKriterienVorlage> getPQKriterienVorlagesForModifiedby() {
        return this.PQKriterienVorlagesForModifiedby;
    }

    public void setPQKriterienVorlagesForModifiedby(Set<PQKriterienVorlage> PQKriterienVorlagesForModifiedby) {
        this.PQKriterienVorlagesForModifiedby = PQKriterienVorlagesForModifiedby;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PUseraccountByModifiedby")
    public Set<PQObjekt> getPQObjektsForModifiedby() {
        return this.PQObjektsForModifiedby;
    }

    public void setPQObjektsForModifiedby(Set<PQObjekt> PQObjektsForModifiedby) {
        this.PQObjektsForModifiedby = PQObjektsForModifiedby;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PUseraccountByCreatedby")
    public Set<PQKriterienVorlage> getPQKriterienVorlagesForCreatedby() {
        return this.PQKriterienVorlagesForCreatedby;
    }

    public void setPQKriterienVorlagesForCreatedby(Set<PQKriterienVorlage> PQKriterienVorlagesForCreatedby) {
        this.PQKriterienVorlagesForCreatedby = PQKriterienVorlagesForCreatedby;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "PUseraccountByModifiedby")
    public Set<PQKriterium> getPQKriterienForModifiedby() {
        return this.PQKriterienForModifiedby;
    }

    public void setPQKriterienForModifiedby(Set<PQKriterium> PQKriterienForModifiedby) {
        this.PQKriterienForModifiedby = PQKriterienForModifiedby;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="createdat", length=19)
    public Date getCreatedat() {
        return this.createdat;
    }
    
    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modifiedat", length=19)
    public Date getModifiedat() {
        return this.modifiedat;
    }
    
    public void setModifiedat(Date modifiedat) {
        this.modifiedat = modifiedat;
    }
}
