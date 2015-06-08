package de.affinis.pauline.hbm;
// Generated 04.07.2013 19:12:12 by Hibernate Tools 3.2.1.GA


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

/**
 * Branche generated by hbm2java
 */
@Entity
@Table(name="branche"
    ,catalog="paulprod"
)
public class Branche  implements java.io.Serializable {


     private int hid;
     private Mitarbeiter mitarbeiter;
     private String affinisbranche;
     private String active;
     private Set<HAuftrag> HAuftrags = new HashSet<HAuftrag>(0);
     private Set<HAuftrag> HAuftrags_1 = new HashSet<HAuftrag>(0);
     private Set<Gp> gps = new HashSet<Gp>(0);

    public Branche() {
    }

	
    public Branche(int hid, String affinisbranche, String active) {
        this.hid = hid;
        this.affinisbranche = affinisbranche;
        this.active = active;
    }
    public Branche(int hid, Mitarbeiter mitarbeiter, String affinisbranche, String active, Set<HAuftrag> HAuftrags, Set<HAuftrag> HAuftrags_1, Set<Gp> gps) {
       this.hid = hid;
       this.mitarbeiter = mitarbeiter;
       this.affinisbranche = affinisbranche;
       this.active = active;
       this.HAuftrags = HAuftrags;
       this.HAuftrags_1 = HAuftrags_1;
       this.gps = gps;
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
    @JoinColumn(name="mitarbeiter")
    public Mitarbeiter getMitarbeiter() {
        return this.mitarbeiter;
    }
    
    public void setMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }
    
    @Column(name="affinisbranche", nullable=false, length=10)
    public String getAffinisbranche() {
        return this.affinisbranche;
    }
    
    public void setAffinisbranche(String affinisbranche) {
        this.affinisbranche = affinisbranche;
    }
    
    @Column(name="active", nullable=false, length=1)
    public String getActive() {
        return this.active;
    }
    
    public void setActive(String active) {
        this.active = active;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="branche")
    public Set<HAuftrag> getHAuftrags() {
        return this.HAuftrags;
    }
    
    public void setHAuftrags(Set<HAuftrag> HAuftrags) {
        this.HAuftrags = HAuftrags;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="branche")
    public Set<HAuftrag> getHAuftrags_1() {
        return this.HAuftrags_1;
    }
    
    public void setHAuftrags_1(Set<HAuftrag> HAuftrags_1) {
        this.HAuftrags_1 = HAuftrags_1;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="branche")
    public Set<Gp> getGps() {
        return this.gps;
    }
    
    public void setGps(Set<Gp> gps) {
        this.gps = gps;
    }




}


