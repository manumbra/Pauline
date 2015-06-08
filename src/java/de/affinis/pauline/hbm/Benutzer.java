package de.affinis.pauline.hbm;
// Generated 05.07.2013 09:57:30 by Hibernate Tools 3.2.1.GA


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
 * Benutzer generated by hbm2java
 */
@Entity
@Table(name="benutzer"
    ,catalog="paulprod"
)
public class Benutzer  implements java.io.Serializable {


     private Integer uid;
     private String benutzername;
     private String passwort;
     private Date LAenderung;
     private Date CDate;

    public Benutzer() {
    }

	
    public Benutzer(String benutzername, String passwort) {
        this.benutzername = benutzername;
        this.passwort = passwort;
    }
    public Benutzer(String benutzername, String passwort, Date LAenderung, Date CDate) {
       this.benutzername = benutzername;
       this.passwort = passwort;
       this.LAenderung = LAenderung;
       this.CDate = CDate;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="uid", unique=true, nullable=false)
    public Integer getUid() {
        return this.uid;
    }
    
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    
    @Column(name="benutzername", nullable=false, length=35)
    public String getBenutzername() {
        return this.benutzername;
    }
    
    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }
    
    @Column(name="passwort", nullable=false, length=25)
    public String getPasswort() {
        return this.passwort;
    }
    
    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="l_aenderung", length=19)
    public Date getLAenderung() {
        return this.LAenderung;
    }
    
    public void setLAenderung(Date LAenderung) {
        this.LAenderung = LAenderung;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="c_date", length=10)
    public Date getCDate() {
        return this.CDate;
    }
    
    public void setCDate(Date CDate) {
        this.CDate = CDate;
    }




}

