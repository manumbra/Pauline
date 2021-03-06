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
 * Makosten generated by hbm2java
 */
@Entity
@Table(name="makosten"
    ,catalog="paulprod"
)
public class Makosten  implements java.io.Serializable {


     private int hid;
     private int mitarbeiterId;
     private Date gueltigVon;
     private Double tagesgehalt;
     private Double dienstwagenkosten;
     private Double kostenintern;
     private Double kostenIct;
     private Double kostenIctpl;

    public Makosten() {
    }

	
    public Makosten(int hid, int mitarbeiterId) {
        this.hid = hid;
        this.mitarbeiterId = mitarbeiterId;
    }
    public Makosten(int hid, int mitarbeiterId, Date gueltigVon, Double tagesgehalt, Double dienstwagenkosten, Double kostenintern, Double kostenIct, Double kostenIctpl) {
       this.hid = hid;
       this.mitarbeiterId = mitarbeiterId;
       this.gueltigVon = gueltigVon;
       this.tagesgehalt = tagesgehalt;
       this.dienstwagenkosten = dienstwagenkosten;
       this.kostenintern = kostenintern;
       this.kostenIct = kostenIct;
       this.kostenIctpl = kostenIctpl;
    }
   
     @Id 
    
    @Column(name="hid", unique=true, nullable=false)
    public int getHid() {
        return this.hid;
    }
    
    public void setHid(int hid) {
        this.hid = hid;
    }
    
    @Column(name="mitarbeiter_id", nullable=false)
    public int getMitarbeiterId() {
        return this.mitarbeiterId;
    }
    
    public void setMitarbeiterId(int mitarbeiterId) {
        this.mitarbeiterId = mitarbeiterId;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="gueltig_von", length=10)
    public Date getGueltigVon() {
        return this.gueltigVon;
    }
    
    public void setGueltigVon(Date gueltigVon) {
        this.gueltigVon = gueltigVon;
    }
    
    @Column(name="tagesgehalt", precision=22, scale=0)
    public Double getTagesgehalt() {
        return this.tagesgehalt;
    }
    
    public void setTagesgehalt(Double tagesgehalt) {
        this.tagesgehalt = tagesgehalt;
    }
    
    @Column(name="dienstwagenkosten", precision=22, scale=0)
    public Double getDienstwagenkosten() {
        return this.dienstwagenkosten;
    }
    
    public void setDienstwagenkosten(Double dienstwagenkosten) {
        this.dienstwagenkosten = dienstwagenkosten;
    }
    
    @Column(name="kostenintern", precision=22, scale=0)
    public Double getKostenintern() {
        return this.kostenintern;
    }
    
    public void setKostenintern(Double kostenintern) {
        this.kostenintern = kostenintern;
    }
    
    @Column(name="kosten_ict", precision=22, scale=0)
    public Double getKostenIct() {
        return this.kostenIct;
    }
    
    public void setKostenIct(Double kostenIct) {
        this.kostenIct = kostenIct;
    }
    
    @Column(name="kosten_ictpl", precision=22, scale=0)
    public Double getKostenIctpl() {
        return this.kostenIctpl;
    }
    
    public void setKostenIctpl(Double kostenIctpl) {
        this.kostenIctpl = kostenIctpl;
    }




}


