package de.affinis.pauline.hbm;
// Generated 04.07.2013 19:12:12 by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Status generated by hbm2java
 */
@Entity
@Table(name="status"
    ,catalog="paulprod"
)
public class Status  implements java.io.Serializable {


     private Short hid;
     private String status;
     private String bezeichnung;

    public Status() {
    }

	
    public Status(String status) {
        this.status = status;
    }
    public Status(String status, String bezeichnung) {
       this.status = status;
       this.bezeichnung = bezeichnung;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="hid", unique=true, nullable=false)
    public Short getHid() {
        return this.hid;
    }
    
    public void setHid(Short hid) {
        this.hid = hid;
    }
    
    @Column(name="status", nullable=false, length=3)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Column(name="bezeichnung", length=50)
    public String getBezeichnung() {
        return this.bezeichnung;
    }
    
    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }




}


