package de.affinis.pauline.hbm;
// Generated 04.07.2013 19:12:12 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AufgabeMaAssoc generated by hbm2java
 */
@Entity
@Table(name="aufgabe_ma_assoc"
    ,catalog="paulprod"
)
public class AufgabeMaAssoc  implements java.io.Serializable {


     private AufgabeMaAssocId id;
     private Mitarbeiter mitarbeiter;
     private HAufgabe HAufgabe;
     private Date HCreatedat;
     private Integer HCreatedby;
     private Date HModifiedat;
     private Integer HModifiedby;

    public AufgabeMaAssoc() {
    }

	
    public AufgabeMaAssoc(AufgabeMaAssocId id, Mitarbeiter mitarbeiter, HAufgabe HAufgabe) {
        this.id = id;
        this.mitarbeiter = mitarbeiter;
        this.HAufgabe = HAufgabe;
    }
    public AufgabeMaAssoc(AufgabeMaAssocId id, Mitarbeiter mitarbeiter, HAufgabe HAufgabe, Date HCreatedat, Integer HCreatedby, Date HModifiedat, Integer HModifiedby) {
       this.id = id;
       this.mitarbeiter = mitarbeiter;
       this.HAufgabe = HAufgabe;
       this.HCreatedat = HCreatedat;
       this.HCreatedby = HCreatedby;
       this.HModifiedat = HModifiedat;
       this.HModifiedby = HModifiedby;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="mitarbeiterid", column=@Column(name="mitarbeiterid", nullable=false) ), 
        @AttributeOverride(name="aufgabeid", column=@Column(name="aufgabeid", nullable=false) ) } )
    public AufgabeMaAssocId getId() {
        return this.id;
    }
    
    public void setId(AufgabeMaAssocId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="mitarbeiterid", nullable=false, insertable=false, updatable=false)
    public Mitarbeiter getMitarbeiter() {
        return this.mitarbeiter;
    }
    
    public void setMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="aufgabeid", nullable=false, insertable=false, updatable=false)
    public HAufgabe getHAufgabe() {
        return this.HAufgabe;
    }
    
    public void setHAufgabe(HAufgabe HAufgabe) {
        this.HAufgabe = HAufgabe;
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


