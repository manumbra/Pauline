package de.affinis.pauline.hbm;
// Generated 04.07.2013 19:12:12 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Tantiemen generated by hbm2java
 */
@Entity
@Table(name="tantiemen"
    ,catalog="paulprod"
)
public class Tantiemen  implements java.io.Serializable {


     private int hid;
     private int mitarbeiterid;
     private Date jahr;
     private Double auslastung;
     private Double vertriebserfolg;
     private Double projekterfolg;
     private Double qualitaet;

    public Tantiemen() {
    }

	
    public Tantiemen(int hid, int mitarbeiterid, Date jahr) {
        this.hid = hid;
        this.mitarbeiterid = mitarbeiterid;
        this.jahr = jahr;
    }
    public Tantiemen(int hid, int mitarbeiterid, Date jahr, Double auslastung, Double vertriebserfolg, Double projekterfolg, Double qualitaet) {
       this.hid = hid;
       this.mitarbeiterid = mitarbeiterid;
       this.jahr = jahr;
       this.auslastung = auslastung;
       this.vertriebserfolg = vertriebserfolg;
       this.projekterfolg = projekterfolg;
       this.qualitaet = qualitaet;
    }
   
     @Id 
    
    @Column(name="hid", unique=true, nullable=false)
    public int getHid() {
        return this.hid;
    }
    
    public void setHid(int hid) {
        this.hid = hid;
    }
    
    @Column(name="mitarbeiterid", nullable=false)
    public int getMitarbeiterid() {
        return this.mitarbeiterid;
    }
    
    public void setMitarbeiterid(int mitarbeiterid) {
        this.mitarbeiterid = mitarbeiterid;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="jahr", nullable=false, length=0)
    public Date getJahr() {
        return this.jahr;
    }
    
    public void setJahr(Date jahr) {
        this.jahr = jahr;
    }
    
    @Column(name="auslastung", precision=22, scale=0)
    public Double getAuslastung() {
        return this.auslastung;
    }
    
    public void setAuslastung(Double auslastung) {
        this.auslastung = auslastung;
    }
    
    @Column(name="vertriebserfolg", precision=22, scale=0)
    public Double getVertriebserfolg() {
        return this.vertriebserfolg;
    }
    
    public void setVertriebserfolg(Double vertriebserfolg) {
        this.vertriebserfolg = vertriebserfolg;
    }
    
    @Column(name="projekterfolg", precision=22, scale=0)
    public Double getProjekterfolg() {
        return this.projekterfolg;
    }
    
    public void setProjekterfolg(Double projekterfolg) {
        this.projekterfolg = projekterfolg;
    }
    
    @Column(name="qualitaet", precision=22, scale=0)
    public Double getQualitaet() {
        return this.qualitaet;
    }
    
    public void setQualitaet(Double qualitaet) {
        this.qualitaet = qualitaet;
    }




}


