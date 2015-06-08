package de.affinis.pauline.hbm;
// Generated 04.07.2013 19:12:12 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * LeistungseinheitMinmaxAssoc generated by hbm2java
 */
@Entity
@Table(name="leistungseinheit_minmax_assoc"
    ,catalog="paulprod"
)
public class LeistungseinheitMinmaxAssoc  implements java.io.Serializable {


     private int hid;
     private int leistungseinheitId;
     private int minmaxId;
     private String infotext;
     private Set<HAuftrag> HAuftrags = new HashSet<HAuftrag>(0);

    public LeistungseinheitMinmaxAssoc() {
    }

	
    public LeistungseinheitMinmaxAssoc(int hid, int leistungseinheitId, int minmaxId, String infotext) {
        this.hid = hid;
        this.leistungseinheitId = leistungseinheitId;
        this.minmaxId = minmaxId;
        this.infotext = infotext;
    }
    public LeistungseinheitMinmaxAssoc(int hid, int leistungseinheitId, int minmaxId, String infotext, Set<HAuftrag> HAuftrags) {
       this.hid = hid;
       this.leistungseinheitId = leistungseinheitId;
       this.minmaxId = minmaxId;
       this.infotext = infotext;
       this.HAuftrags = HAuftrags;
    }
   
     @Id 
    
    @Column(name="hid", unique=true, nullable=false)
    public int getHid() {
        return this.hid;
    }
    
    public void setHid(int hid) {
        this.hid = hid;
    }
    
    @Column(name="leistungseinheit_id", nullable=false)
    public int getLeistungseinheitId() {
        return this.leistungseinheitId;
    }
    
    public void setLeistungseinheitId(int leistungseinheitId) {
        this.leistungseinheitId = leistungseinheitId;
    }
    
    @Column(name="minmax_id", nullable=false)
    public int getMinmaxId() {
        return this.minmaxId;
    }
    
    public void setMinmaxId(int minmaxId) {
        this.minmaxId = minmaxId;
    }
    
    @Column(name="infotext", nullable=false)
    public String getInfotext() {
        return this.infotext;
    }
    
    public void setInfotext(String infotext) {
        this.infotext = infotext;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="leistungseinheitMinmaxAssoc")
    public Set<HAuftrag> getHAuftrags() {
        return this.HAuftrags;
    }
    
    public void setHAuftrags(Set<HAuftrag> HAuftrags) {
        this.HAuftrags = HAuftrags;
    }




}


