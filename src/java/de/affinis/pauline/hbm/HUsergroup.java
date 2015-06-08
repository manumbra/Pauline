package de.affinis.pauline.hbm;
// Generated 04.07.2013 19:12:12 by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * HUsergroup generated by hbm2java
 */
@Entity
@Table(name="h_usergroup"
    ,catalog="paulprod"
)
public class HUsergroup  implements java.io.Serializable {


     private int hid;
     private String name;

    public HUsergroup() {
    }

	
    public HUsergroup(int hid) {
        this.hid = hid;
    }
    public HUsergroup(int hid, String name) {
       this.hid = hid;
       this.name = name;
    }
   
     @Id 
    
    @Column(name="hid", unique=true, nullable=false)
    public int getHid() {
        return this.hid;
    }
    
    public void setHid(int hid) {
        this.hid = hid;
    }
    
    @Column(name="name")
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }




}

