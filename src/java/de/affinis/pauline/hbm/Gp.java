package de.affinis.pauline.hbm;
// Generated 04.07.2013 19:12:12 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Gp generated by hbm2java
 */
@Entity
@Table(name="gp"
    ,catalog="paulprod"
)
public class Gp  implements java.io.Serializable {


     private int hid;
     private Kundengruppe kundengruppe;
     private Branche branche;
     private String gpnr;
     private String firma;
     private String kurzbezeichnung;
     private String branchenname;
     private String active;
     private String kzRv;
     private Date rvVom;
     private Date rvKündigung;
     private String rvKündFrist;
     private String rvBez;
     private Date rvEnde;
     private Set<Affinisgesellschaft> affinisgesellschafts = new HashSet<Affinisgesellschaft>(0);
     private Set<HAuftrag> HAuftrags = new HashSet<HAuftrag>(0);
     private Set<Mitarbeiter> mitarbeiters = new HashSet<Mitarbeiter>(0);
     private Set<Mitarbeiter> mitarbeiters_1 = new HashSet<Mitarbeiter>(0);

    public Gp() {
    }

	
    public Gp(int hid, String gpnr, String active, String kzRv) {
        this.hid = hid;
        this.gpnr = gpnr;
        this.active = active;
        this.kzRv = kzRv;
    }
    public Gp(int hid, Kundengruppe kundengruppe, Branche branche, String gpnr, String firma, String kurzbezeichnung, String branchenname, String active, String kzRv, Date rvVom, Date rvKündigung, String KündFrist, String rvBez, Date rvEnde, Set<Affinisgesellschaft> affinisgesellschafts, Set<HAuftrag> HAuftrags, Set<Mitarbeiter> mitarbeiters, Set<Mitarbeiter> mitarbeiters_1) {
       this.hid = hid;
       this.kundengruppe = kundengruppe;
       this.branche = branche;
       this.gpnr = gpnr;
       this.firma = firma;
       this.kurzbezeichnung = kurzbezeichnung;
       this.branchenname = branchenname;
       this.active = active;
       this.kzRv = kzRv;
       this.rvVom = rvVom;
       this.rvKündigung = rvKündigung;
       this.rvKündFrist = rvKündFrist;
       this.rvBez = rvBez;
       this.rvEnde = rvEnde;
       this.affinisgesellschafts = affinisgesellschafts;
       this.HAuftrags = HAuftrags;
       this.mitarbeiters = mitarbeiters;
       this.mitarbeiters_1 = mitarbeiters_1;
    }
   
     @Id 
    
    @Column(name="hid", unique=true, nullable=false)
    public int getHid() {
        return this.hid;
    }
    
    public void setHid(int hid) {
        this.hid = hid;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="kundengruppe")
    public Kundengruppe getKundengruppe() {
        return this.kundengruppe;
    }
    
    public void setKundengruppe(Kundengruppe kundengruppe) {
        this.kundengruppe = kundengruppe;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="affinisbranche")
    public Branche getBranche() {
        return this.branche;
    }
    
    public void setBranche(Branche branche) {
        this.branche = branche;
    }
    
    @Column(name="gpnr", nullable=false)
    public String getGpnr() {
        return this.gpnr;
    }
    
    public void setGpnr(String gpnr) {
        this.gpnr = gpnr;
    }
    
    @Column(name="firma")
    public String getFirma() {
        return this.firma;
    }
    
    public void setFirma(String firma) {
        this.firma = firma;
    }
    
    @Column(name="kurzbezeichnung", length=10)
    public String getKurzbezeichnung() {
        return this.kurzbezeichnung;
    }
    
    public void setKurzbezeichnung(String kurzbezeichnung) {
        this.kurzbezeichnung = kurzbezeichnung;
    }
    
    @Column(name="branchenname")
    public String getBranchenname() {
        return this.branchenname;
    }
    
    public void setBranchenname(String branchenname) {
        this.branchenname = branchenname;
    }
    
    @Column(name="active", nullable=false, length=1)
    public String getActive() {
        return this.active;
    }
    
    public void setActive(String active) {
        this.active = active;
    }
    
    @Column(name="kz_rv", nullable=false, length=1)
    public String getKzRv() {
        return this.kzRv;
    }
    
    public void setKzRv(String kzRv) {
        this.kzRv = kzRv;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="rv_vom", length=10)
    public Date getRvVom() {
        return this.rvVom;
    }
    
    public void setRvVom(Date rvVom) {
        this.rvVom = rvVom;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="rv_kündigung", length=10)
    public Date getRvKündigung() {
        return this.rvKündigung;
    }
    
    public void setRvKündigung(Date rvKündigung) {
        this.rvKündigung = rvKündigung;
    }
    
    @Column(name="rv_künd_frist", length=25)
    public String getRvKündFrist() {
        return this.rvKündFrist;
    }
    
    public void setRvKündFrist(String rvKündFrist) {
        this.rvKündFrist = rvKündFrist;
    }
    
    @Column(name="rv_bez", length=50)
    public String getRvBez() {
        return this.rvBez;
    }
    
    public void setRvBez(String rvBez) {
        this.rvBez = rvBez;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="rv_ende", length=10)
    public Date getRvEnde() {
        return this.rvEnde;
    }
    
    public void setRvEnde(Date rvEnde) {
        this.rvEnde = rvEnde;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="gp")
    public Set<Affinisgesellschaft> getAffinisgesellschafts() {
        return this.affinisgesellschafts;
    }
    
    public void setAffinisgesellschafts(Set<Affinisgesellschaft> affinisgesellschafts) {
        this.affinisgesellschafts = affinisgesellschafts;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="gp")
    public Set<HAuftrag> getHAuftrags() {
        return this.HAuftrags;
    }
    
    public void setHAuftrags(Set<HAuftrag> HAuftrags) {
        this.HAuftrags = HAuftrags;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="gp")
    public Set<Mitarbeiter> getMitarbeiters() {
        return this.mitarbeiters;
    }
    
    public void setMitarbeiters(Set<Mitarbeiter> mitarbeiters) {
        this.mitarbeiters = mitarbeiters;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="gp")
    public Set<Mitarbeiter> getMitarbeiters_1() {
        return this.mitarbeiters_1;
    }
    
    public void setMitarbeiters_1(Set<Mitarbeiter> mitarbeiters_1) {
        this.mitarbeiters_1 = mitarbeiters_1;
    }




}


