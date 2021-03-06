package de.affinis.pauline.hbm;
// Generated 27.07.2013 04:23:03 by Hibernate Tools 3.2.1.GA

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PUserrole generated by hbm2java
 */
@Entity
@Table(name = "p_userrole", catalog = "paulprod")
public class PUserrole implements java.io.Serializable {

    private Integer hid;
    private String role;
    private String rk;
    private Set<PUseraccount> PUseraccounts = new HashSet<PUseraccount>(0);

    public PUserrole() {
    }

    public PUserrole(String role) {
        this.role = role;
    }

    public PUserrole(String role, Set<PUseraccount> PUseraccounts) {
        this.role = role;
        this.PUseraccounts = PUseraccounts;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "hid", unique = true, nullable = false)
    public Integer getHid() {
        return this.hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    @Column(name = "role", nullable = false)
    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    @Column(name = "rk", nullable = false)
    public String getRk() {
        return this.rk;
    }

    public void setRk(String rk) {
        this.rk = rk;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "PUserrole")
    public Set<PUseraccount> getPUseraccounts() {
        return this.PUseraccounts;
    }

    public void setPUseraccounts(Set<PUseraccount> PUseraccounts) {
        this.PUseraccounts = PUseraccounts;
    }

    public boolean equals(Object object) {
        // Basic checks.
        if (object == this) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        // Property checks.
        PUserrole other = (PUserrole) object;
        if (role == null ? other.role != null : !role.equals(other.role)) {
            return false;
        }
        

        // All passed.
        return true;
    }
}
