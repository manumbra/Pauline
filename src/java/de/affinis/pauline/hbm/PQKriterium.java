package de.affinis.pauline.hbm;
// Generated 17.07.2013 21:19:08 by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
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
 * PQKriterien generated by hbm2java
 */
@Entity
@Table(name="p_q_kriterium"
    ,catalog="paulprod"
)
public class PQKriterium  implements java.io.Serializable {


     private Integer hid;
     private PQObjekt PQObjekt;
     private PQKriterienVorlage PQKriterienVorlage;
     private PUseraccount PUseraccountByModifiedby;
     private PUseraccount PUseraccountByCreatedby;
     private BigDecimal QKriteriumBewertung;
     private BigDecimal QKriteriumGewichtung;
     private String beschreibung;
     private Date createdat;
     private Date modifiedat;
     private String hinweis;
     private Set<PMassnahme> PQActions = new HashSet<PMassnahme>(0);

    public PQKriterium() {
    }

	
    public PQKriterium(PQObjekt PQObjekt, PQKriterienVorlage PQKriterienVorlage) {
        this.PQObjekt = PQObjekt;
        this.PQKriterienVorlage = PQKriterienVorlage;
    }
    public PQKriterium(PQObjekt PQObjekt, PQKriterienVorlage PQKriterienVorlage, PUseraccount PUseraccountByModifiedby, PUseraccount PUseraccountByCreatedby, BigDecimal QKriteriumBewertung, BigDecimal QKriteriumGewichtung, String beschreibung, Date createdat, Date modifiedat, String hinweis, Set<PMassnahme> PQActions) {
       this.PQObjekt = PQObjekt;
       this.PQKriterienVorlage = PQKriterienVorlage;
       this.PUseraccountByModifiedby = PUseraccountByModifiedby;
       this.PUseraccountByCreatedby = PUseraccountByCreatedby;
       this.QKriteriumBewertung = QKriteriumBewertung;
       this.QKriteriumGewichtung = QKriteriumGewichtung;
       this.beschreibung = beschreibung;
       this.createdat = createdat;
       this.modifiedat = modifiedat;
       this.hinweis = hinweis;
       this.PQActions = PQActions;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="hid", unique=true, nullable=false)
    public Integer getHid() {
        return this.hid;
    }
    
    public void setHid(Integer hid) {
        this.hid = hid;
    }
@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="q_objekt", nullable=false)
    public PQObjekt getPQObjekt() {
        return this.PQObjekt;
    }
    
    public void setPQObjekt(PQObjekt PQObjekt) {
        this.PQObjekt = PQObjekt;
    }
@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="q_kriterium", nullable=false)
    public PQKriterienVorlage getPQKriterienVorlage() {
        return this.PQKriterienVorlage;
    }
    
    public void setPQKriterienVorlage(PQKriterienVorlage PQKriterienVorlage) {
        this.PQKriterienVorlage = PQKriterienVorlage;
    }
@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="modifiedby")
    public PUseraccount getPUseraccountByModifiedby() {
        return this.PUseraccountByModifiedby;
    }
    
    public void setPUseraccountByModifiedby(PUseraccount PUseraccountByModifiedby) {
        this.PUseraccountByModifiedby = PUseraccountByModifiedby;
    }
@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="createdby")
    public PUseraccount getPUseraccountByCreatedby() {
        return this.PUseraccountByCreatedby;
    }
    
    public void setPUseraccountByCreatedby(PUseraccount PUseraccountByCreatedby) {
        this.PUseraccountByCreatedby = PUseraccountByCreatedby;
    }
    
    @Column(name="q_kriterium_bewertung")
    public BigDecimal getQKriteriumBewertung() {
        return this.QKriteriumBewertung;
    }
    
    public void setQKriteriumBewertung(BigDecimal QKriteriumBewertung) {
        this.QKriteriumBewertung = QKriteriumBewertung;
    }
    
    @Column(name="q_kriterium_gewichtung")
    public BigDecimal getQKriteriumGewichtung() {
        return this.QKriteriumGewichtung;
    }
    
    public void setQKriteriumGewichtung(BigDecimal QKriteriumGewichtung) {
        this.QKriteriumGewichtung = QKriteriumGewichtung;
    }
    
    @Column(name="beschreibung")
    public String getBeschreibung() {
        return this.beschreibung;
    }
    
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
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
    
    @Column(name="hinweis", length=65535)
    public String getHinweis() {
        return this.hinweis;
    }
    
    public void setHinweis(String hinweis) {
        this.hinweis = hinweis;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="PQKriterium")
    public Set<PMassnahme> getPQActions() {
        return this.PQActions;
    }
    
    public void setPQActions(Set<PMassnahme> PQActions) {
        this.PQActions = PQActions;
    }




}

