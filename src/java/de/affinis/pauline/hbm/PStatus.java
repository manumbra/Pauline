package de.affinis.pauline.hbm;
// Generated 27.07.2013 04:23:03 by Hibernate Tools 3.2.1.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PUserrole generated by hbm2java
 */
@Entity
@Table(name = "p_status", catalog = "paulprod")
public class PStatus implements java.io.Serializable {

    private Integer id;
    private String status;
    private String sk;

    public PStatus() {
    }

    public PStatus(String status) {
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "status", nullable = false)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Column(name = "sk", nullable = false)
    public String getSk() {
        return this.sk;
    }

    public void setSk(String sk) {
        this.sk = sk;
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
        PStatus other = (PStatus) object;
        if (status == null ? other.status != null : !status.equals(other.status)) {
            return false;
        }
        

        // All passed.
        return true;
    }
}
