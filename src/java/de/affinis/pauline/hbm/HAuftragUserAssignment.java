package de.affinis.pauline.hbm;
// Generated 04.07.2013 19:12:12 by Hibernate Tools 3.2.1.GA


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * HAuftragUserAssignment generated by hbm2java
 */
@Entity
@Table(name="h_auftrag_user_assignment"
    ,catalog="paulprod"
)
public class HAuftragUserAssignment  implements java.io.Serializable {


     private HAuftragUserAssignmentId id;
     private HAuftrag HAuftrag;
     private HUseraccount HUseraccount;
     private HSecurityrole HSecurityrole;
     private Integer hid;

    public HAuftragUserAssignment() {
    }

	
    public HAuftragUserAssignment(HAuftragUserAssignmentId id, HAuftrag HAuftrag, HUseraccount HUseraccount, HSecurityrole HSecurityrole) {
        this.id = id;
        this.HAuftrag = HAuftrag;
        this.HUseraccount = HUseraccount;
        this.HSecurityrole = HSecurityrole;
    }
    public HAuftragUserAssignment(HAuftragUserAssignmentId id, HAuftrag HAuftrag, HUseraccount HUseraccount, HSecurityrole HSecurityrole, Integer hid) {
       this.id = id;
       this.HAuftrag = HAuftrag;
       this.HUseraccount = HUseraccount;
       this.HSecurityrole = HSecurityrole;
       this.hid = hid;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="auftrag", column=@Column(name="auftrag", nullable=false) ), 
        @AttributeOverride(name="role", column=@Column(name="role", nullable=false) ), 
        @AttributeOverride(name="useraccount", column=@Column(name="useraccount", nullable=false) ) } )
    public HAuftragUserAssignmentId getId() {
        return this.id;
    }
    
    public void setId(HAuftragUserAssignmentId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="auftrag", nullable=false, insertable=false, updatable=false)
    public HAuftrag getHAuftrag() {
        return this.HAuftrag;
    }
    
    public void setHAuftrag(HAuftrag HAuftrag) {
        this.HAuftrag = HAuftrag;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="useraccount", nullable=false, insertable=false, updatable=false)
    public HUseraccount getHUseraccount() {
        return this.HUseraccount;
    }
    
    public void setHUseraccount(HUseraccount HUseraccount) {
        this.HUseraccount = HUseraccount;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="role", nullable=false, insertable=false, updatable=false)
    public HSecurityrole getHSecurityrole() {
        return this.HSecurityrole;
    }
    
    public void setHSecurityrole(HSecurityrole HSecurityrole) {
        this.HSecurityrole = HSecurityrole;
    }
    
    @Column(name="hid")
    public Integer getHid() {
        return this.hid;
    }
    
    public void setHid(Integer hid) {
        this.hid = hid;
    }




}


