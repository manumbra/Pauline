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
 * AufgabeMaAssocAuditTrail generated by hbm2java
 */
@Entity
@Table(name="aufgabe_ma_assoc_audit_trail"
    ,catalog="paulprod"
)
public class AufgabeMaAssocAuditTrail  implements java.io.Serializable {


     private Integer id;
     private Date auditTrailDatum;
     private int mitarbeiterid;
     private int aufgabeid;
     private Date HCreatedat;
     private Integer HCreatedby;
     private Date HModifiedat;
     private Integer HModifiedby;

    public AufgabeMaAssocAuditTrail() {
    }

	
    public AufgabeMaAssocAuditTrail(int mitarbeiterid, int aufgabeid) {
        this.mitarbeiterid = mitarbeiterid;
        this.aufgabeid = aufgabeid;
    }
    public AufgabeMaAssocAuditTrail(Date auditTrailDatum, int mitarbeiterid, int aufgabeid, Date HCreatedat, Integer HCreatedby, Date HModifiedat, Integer HModifiedby) {
       this.auditTrailDatum = auditTrailDatum;
       this.mitarbeiterid = mitarbeiterid;
       this.aufgabeid = aufgabeid;
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
    
    @Column(name="mitarbeiterid", nullable=false)
    public int getMitarbeiterid() {
        return this.mitarbeiterid;
    }
    
    public void setMitarbeiterid(int mitarbeiterid) {
        this.mitarbeiterid = mitarbeiterid;
    }
    
    @Column(name="aufgabeid", nullable=false)
    public int getAufgabeid() {
        return this.aufgabeid;
    }
    
    public void setAufgabeid(int aufgabeid) {
        this.aufgabeid = aufgabeid;
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


