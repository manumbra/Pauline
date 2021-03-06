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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * HSecurityrole generated by hbm2java
 */
@Entity
@Table(name="h_securityrole"
    ,catalog="paulprod"
)
public class HSecurityrole  implements java.io.Serializable {


     private int hid;
     private String name;
     private Set<HSecurityright> HSecurityrights = new HashSet<HSecurityright>(0);
     private Set<HAuftragMitarbeiterAssignment> HAuftragMitarbeiterAssignments = new HashSet<HAuftragMitarbeiterAssignment>(0);
     private Set<HAuftragUserAssignment> HAuftragUserAssignments = new HashSet<HAuftragUserAssignment>(0);
     private Set<HUseraccountHasSecurityrole> HUseraccountHasSecurityroles = new HashSet<HUseraccountHasSecurityrole>(0);
     private Set<HRoleInAuftrag> HRoleInAuftrags = new HashSet<HRoleInAuftrag>(0);

    public HSecurityrole() {
    }

	
    public HSecurityrole(int hid) {
        this.hid = hid;
    }
    public HSecurityrole(int hid, String name, Set<HSecurityright> HSecurityrights, Set<HAuftragMitarbeiterAssignment> HAuftragMitarbeiterAssignments, Set<HAuftragUserAssignment> HAuftragUserAssignments, Set<HUseraccountHasSecurityrole> HUseraccountHasSecurityroles, Set<HRoleInAuftrag> HRoleInAuftrags) {
       this.hid = hid;
       this.name = name;
       this.HSecurityrights = HSecurityrights;
       this.HAuftragMitarbeiterAssignments = HAuftragMitarbeiterAssignments;
       this.HAuftragUserAssignments = HAuftragUserAssignments;
       this.HUseraccountHasSecurityroles = HUseraccountHasSecurityroles;
       this.HRoleInAuftrags = HRoleInAuftrags;
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
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="h_securityrole_has_right", catalog="paulprod", joinColumns = { 
        @JoinColumn(name="securityrole", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="securityright", nullable=false, updatable=false) })
    public Set<HSecurityright> getHSecurityrights() {
        return this.HSecurityrights;
    }
    
    public void setHSecurityrights(Set<HSecurityright> HSecurityrights) {
        this.HSecurityrights = HSecurityrights;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="HSecurityrole")
    public Set<HAuftragMitarbeiterAssignment> getHAuftragMitarbeiterAssignments() {
        return this.HAuftragMitarbeiterAssignments;
    }
    
    public void setHAuftragMitarbeiterAssignments(Set<HAuftragMitarbeiterAssignment> HAuftragMitarbeiterAssignments) {
        this.HAuftragMitarbeiterAssignments = HAuftragMitarbeiterAssignments;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="HSecurityrole")
    public Set<HAuftragUserAssignment> getHAuftragUserAssignments() {
        return this.HAuftragUserAssignments;
    }
    
    public void setHAuftragUserAssignments(Set<HAuftragUserAssignment> HAuftragUserAssignments) {
        this.HAuftragUserAssignments = HAuftragUserAssignments;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="HSecurityrole")
    public Set<HUseraccountHasSecurityrole> getHUseraccountHasSecurityroles() {
        return this.HUseraccountHasSecurityroles;
    }
    
    public void setHUseraccountHasSecurityroles(Set<HUseraccountHasSecurityrole> HUseraccountHasSecurityroles) {
        this.HUseraccountHasSecurityroles = HUseraccountHasSecurityroles;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="h_role_in_auftrag_security_role_assoc", catalog="paulprod", joinColumns = { 
        @JoinColumn(name="securityrole", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="roleinauftrag", nullable=false, updatable=false) })
    public Set<HRoleInAuftrag> getHRoleInAuftrags() {
        return this.HRoleInAuftrags;
    }
    
    public void setHRoleInAuftrags(Set<HRoleInAuftrag> HRoleInAuftrags) {
        this.HRoleInAuftrags = HRoleInAuftrags;
    }




}


