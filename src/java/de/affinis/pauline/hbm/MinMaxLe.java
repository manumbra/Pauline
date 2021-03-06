package de.affinis.pauline.hbm;
// Generated 04.07.2013 19:12:12 by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MinMaxLe generated by hbm2java
 */
@Entity
@Table(name="min_max_le"
    ,catalog="paulprod"
)
public class MinMaxLe  implements java.io.Serializable {


     private int hid;
     private float minimum;
     private float maximum;

    public MinMaxLe() {
    }

    public MinMaxLe(int hid, float minimum, float maximum) {
       this.hid = hid;
       this.minimum = minimum;
       this.maximum = maximum;
    }
   
     @Id 
    
    @Column(name="hid", unique=true, nullable=false)
    public int getHid() {
        return this.hid;
    }
    
    public void setHid(int hid) {
        this.hid = hid;
    }
    
    @Column(name="minimum", nullable=false, precision=12, scale=0)
    public float getMinimum() {
        return this.minimum;
    }
    
    public void setMinimum(float minimum) {
        this.minimum = minimum;
    }
    
    @Column(name="maximum", nullable=false, precision=12, scale=0)
    public float getMaximum() {
        return this.maximum;
    }
    
    public void setMaximum(float maximum) {
        this.maximum = maximum;
    }




}


