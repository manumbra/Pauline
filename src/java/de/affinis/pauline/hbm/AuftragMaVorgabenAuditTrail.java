package de.affinis.pauline.hbm;
// Generated 04.07.2013 19:12:12 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AuftragMaVorgabenAuditTrail generated by hbm2java
 */
@Entity
@Table(name="auftrag_ma_vorgaben_audit_trail"
    ,catalog="paulprod"
)
public class AuftragMaVorgabenAuditTrail  implements java.io.Serializable {


     private Integer id;
     private Date auditTrailDatum;
     private int hid;
     private int auftragid;
     private int mitarbeiterid;
     private Double internsatz;
     private Double fakturierungssatz;
     private Double internrksatz;
     private Double rksatzfakt;
     private Integer kostensatzUeberschrieben;
     private Date HCreatedat;
     private Integer HCreatedby;
     private Date HModifiedat;
     private Integer HModifiedby;

    public AuftragMaVorgabenAuditTrail() {
    }

	
    public AuftragMaVorgabenAuditTrail(int hid, int auftragid, int mitarbeiterid) {
        this.hid = hid;
        this.auftragid = auftragid;
        this.mitarbeiterid = mitarbeiterid;
    }
    public AuftragMaVorgabenAuditTrail(Date auditTrailDatum, int hid, int auftragid, int mitarbeiterid, Double internsatz, Double fakturierungssatz, Double internrksatz, Double rksatzfakt, Integer kostensatzUeberschrieben, Date HCreatedat, Integer HCreatedby, Date HModifiedat, Integer HModifiedby) {
       this.auditTrailDatum = auditTrailDatum;
       this.hid = hid;
       this.auftragid = auftragid;
       this.mitarbeiterid = mitarbeiterid;
       this.internsatz = internsatz;
       this.fakturierungssatz = fakturierungssatz;
       this.internrksatz = internrksatz;
       this.rksatzfakt = rksatzfakt;
       this.kostensatzUeberschrieben = kostensatzUeberschrieben;
       this.HCreatedat = HCreatedat;
       this.HCreatedby = HCreatedby;
       this.HModifiedat = HModifiedat;
       this.HModifiedby = HModifiedby;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="audit_trail_datum", length=19)
    public Date getAuditTrailDatum() {
        return this.auditTrailDatum;
    }
    
    public void setAuditTrailDatum(Date auditTrailDatum) {
        this.auditTrailDatum = auditTrailDatum;
    }
    
    @Column(name="hid", nullable=false)
    public int getHid() {
        return this.hid;
    }
    
    public void setHid(int hid) {
        this.hid = hid;
    }
    
    @Column(name="auftragid", nullable=false)
    public int getAuftragid() {
        return this.auftragid;
    }
    
    public void setAuftragid(int auftragid) {
        this.auftragid = auftragid;
    }
    
    @Column(name="mitarbeiterid", nullable=false)
    public int getMitarbeiterid() {
        return this.mitarbeiterid;
    }
    
    public void setMitarbeiterid(int mitarbeiterid) {
        this.mitarbeiterid = mitarbeiterid;
    }
    
    @Column(name="internsatz", precision=22, scale=0)
    public Double getInternsatz() {
        return this.internsatz;
    }
    
    public void setInternsatz(Double internsatz) {
        this.internsatz = internsatz;
    }
    
    @Column(name="fakturierungssatz", precision=22, scale=0)
    public Double getFakturierungssatz() {
        return this.fakturierungssatz;
    }
    
    public void setFakturierungssatz(Double fakturierungssatz) {
        this.fakturierungssatz = fakturierungssatz;
    }
    
    @Column(name="internrksatz", precision=22, scale=0)
    public Double getInternrksatz() {
        return this.internrksatz;
    }
    
    public void setInternrksatz(Double internrksatz) {
        this.internrksatz = internrksatz;
    }
    
    @Column(name="rksatzfakt", precision=22, scale=0)
    public Double getRksatzfakt() {
        return this.rksatzfakt;
    }
    
    public void setRksatzfakt(Double rksatzfakt) {
        this.rksatzfakt = rksatzfakt;
    }
    
    @Column(name="kostensatz_ueberschrieben")
    public Integer getKostensatzUeberschrieben() {
        return this.kostensatzUeberschrieben;
    }
    
    public void setKostensatzUeberschrieben(Integer kostensatzUeberschrieben) {
        this.kostensatzUeberschrieben = kostensatzUeberschrieben;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="h_createdat", length=10)
    public Date getHCreatedat() {
        return this.HCreatedat;
    }
    
    public void setHCreatedat(Date HCreatedat) {
        this.HCreatedat = HCreatedat;
    }
    
    @Column(name="h_createdby")
    public Integer getHCreatedby() {
        return this.HCreatedby;
    }
    
    public void setHCreatedby(Integer HCreatedby) {
        this.HCreatedby = HCreatedby;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="h_modifiedat", length=10)
    public Date getHModifiedat() {
        return this.HModifiedat;
    }
    
    public void setHModifiedat(Date HModifiedat) {
        this.HModifiedat = HModifiedat;
    }
    
    @Column(name="h_modifiedby")
    public Integer getHModifiedby() {
        return this.HModifiedby;
    }
    
    public void setHModifiedby(Integer HModifiedby) {
        this.HModifiedby = HModifiedby;
    }




}

