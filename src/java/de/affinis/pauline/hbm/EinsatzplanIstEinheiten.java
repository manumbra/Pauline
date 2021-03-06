package de.affinis.pauline.hbm;
// Generated 04.07.2013 19:12:12 by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EinsatzplanIstEinheiten generated by hbm2java
 */
@Entity
@Table(name="einsatzplan_ist_einheiten"
    ,catalog="paulprod"
)
public class EinsatzplanIstEinheiten  implements java.io.Serializable {


     private int hid;
     private Double istEinheiten;

    public EinsatzplanIstEinheiten() {
    }

	
    public EinsatzplanIstEinheiten(int hid) {
        this.hid = hid;
    }
    public EinsatzplanIstEinheiten(int hid, Double istEinheiten) {
       this.hid = hid;
       this.istEinheiten = istEinheiten;
    }
   
     @Id 
    
    @Column(name="hid", unique=true, nullable=false)
    public int getHid() {
        return this.hid;
    }
    
    public void setHid(int hid) {
        this.hid = hid;
    }
    
    @Column(name="ist_einheiten", precision=22, scale=0)
    public Double getIstEinheiten() {
        return this.istEinheiten;
    }
    
    public void setIstEinheiten(Double istEinheiten) {
        this.istEinheiten = istEinheiten;
    }




}


