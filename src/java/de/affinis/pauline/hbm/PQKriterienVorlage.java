package de.affinis.pauline.hbm;
// Generated 17.07.2013 21:19:08 by Hibernate Tools 3.2.1.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PQKriterienVorlage generated by hbm2java
 */
@Entity
@Table(name = "p_q_kriterien_vorlage", catalog = "paulprod")
public class PQKriterienVorlage implements java.io.Serializable {

    private Integer hid;
    private PUseraccount PUseraccountByCreatedby;
    private PUseraccount PUseraccountByModifiedby;
    private String name;
    private String beschreibung;
    private Date createdat;
    private Date modifiedat;
    private String hinweis;
    private PQObjektVorlage PQObjektVorlage;
    private Set<PQKriterium> PQKriterien = new HashSet<PQKriterium>(0);

    public PQKriterienVorlage() {
    }

    public PQKriterienVorlage(String name) {
        this.name = name;
    }

    public PQKriterienVorlage(PUseraccount PUseraccountByCreatedby, PUseraccount PUseraccountByModifiedby, String name) {
        this.PUseraccountByCreatedby = PUseraccountByCreatedby;
        this.PUseraccountByModifiedby = PUseraccountByModifiedby;
        this.name = name;
    }

    public PQKriterienVorlage(PUseraccount PUseraccountByCreatedby, PUseraccount PUseraccountByModifiedby, String name, String beschreibung, Date createdat, Date modifiedat, String hinweis, Set<PQKriterium> PQKriterien) {
        this.PUseraccountByCreatedby = PUseraccountByCreatedby;
        this.PUseraccountByModifiedby = PUseraccountByModifiedby;
        this.name = name;
        this.beschreibung = beschreibung;
        this.createdat = createdat;
        this.modifiedat = modifiedat;
        this.hinweis = hinweis;
        this.PQKriterien = PQKriterien;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "createdby", nullable = false)
    public PUseraccount getPUseraccountByCreatedby() {
        return this.PUseraccountByCreatedby;
    }

    public void setPUseraccountByCreatedby(PUseraccount PUseraccountByCreatedby) {
        this.PUseraccountByCreatedby = PUseraccountByCreatedby;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "modifiedby", nullable = false)
    public PUseraccount getPUseraccountByModifiedby() {
        return this.PUseraccountByModifiedby;
    }

    public void setPUseraccountByModifiedby(PUseraccount PUseraccountByModifiedby) {
        this.PUseraccountByModifiedby = PUseraccountByModifiedby;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "beschreibung")
    public String getBeschreibung() {
        return this.beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdat", length = 19)
    public Date getCreatedat() {
        return this.createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modifiedat", length = 19)
    public Date getModifiedat() {
        return this.modifiedat;
    }

    public void setModifiedat(Date modifiedat) {
        this.modifiedat = modifiedat;
    }

    @Column(name = "hinweis", length = 65535)
    public String getHinweis() {
        return this.hinweis;
    }

    public void setHinweis(String hinweis) {
        this.hinweis = hinweis;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "p_q_objekt_vorlage")
    public PQObjektVorlage getPQObjektVorlage() {
        return PQObjektVorlage;
    }

    public void setPQObjektVorlage(PQObjektVorlage PQObjektVorlage) {
        this.PQObjektVorlage = PQObjektVorlage;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "PQKriterienVorlage")
    public Set<PQKriterium> getPQKriterien() {
        return this.PQKriterien;
    }

    public void setPQKriterien(Set<PQKriterium> PQKriterien) {
        this.PQKriterien = PQKriterien;
    }

    @Override
    public boolean equals(Object object) {
        // Basic checks.
        if (object == this) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        // Property checks.
        PQKriterienVorlage other = (PQKriterienVorlage) object;
        if (beschreibung == null ? other.beschreibung != null : !beschreibung.equals(other.beschreibung)) {
            return false;
        }


        // All passed.
        return true;
    }
}
