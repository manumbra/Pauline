package de.affinis.pauline.hbm;
// Generated 04.07.2013 19:12:12 by Hibernate Tools 3.2.1.GA

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Mitarbeiter generated by hbm2java
 */
@Entity
@Table(name = "mitarbeiter", catalog = "paulprod")
public class Mitarbeiter implements java.io.Serializable {

    private int hid;
    private Gp gp;
    private Affinisgesellschaft affinisgesellschaft;
    private int manr;
    private String name;
    private String vorname;
    private String namekz;
    private String maStatus;
    private Double rkosten;
    private Double dwkosten;
    private Integer pktqsoll;
    private Integer pktqist;
    private String aktiv;
    private String email;
    private Date geburtstag;
    private byte[] bild;
    private String straße;
    private String plz;
    private String ort;
    private String land;
    private Short entfap;
    private String mobil;
    private String telefon;
    private String telefax;
    private String telefonprojekt;
    private Byte durchwahl;
    private String kontonr;
    private String blz;
    private String bank;
    private Date eintrittsdatum;
    private Date endeprobezeit;
    private Date austrittsdatum;
    private String bemerkung;
    private Set<HAuftragMitarbeiterAssignment> HAuftragMitarbeiterAssignments = new HashSet<HAuftragMitarbeiterAssignment>(0);
    private Set<HEinsatzplan> HEinsatzplans = new HashSet<HEinsatzplan>(0);
    private Set<PUseraccount> PUseraccounts = new HashSet<PUseraccount>(0);
    private Set<Branche> branches = new HashSet<Branche>(0);
    private Set<HUseraccount> HUseraccounts = new HashSet<HUseraccount>(0);
    private Set<Geschaeftsfeld> geschaeftsfelds = new HashSet<Geschaeftsfeld>(0);
    private Set<AufgabeMaAssoc> aufgabeMaAssocs = new HashSet<AufgabeMaAssoc>(0);

    public Mitarbeiter() {
    }

    public Mitarbeiter(int hid, Affinisgesellschaft affinisgesellschaft, int manr, String aktiv) {
        this.hid = hid;
        this.affinisgesellschaft = affinisgesellschaft;
        this.manr = manr;
        this.aktiv = aktiv;
    }

    public Mitarbeiter(int hid, Gp gp, Affinisgesellschaft affinisgesellschaft, int manr, String name, String vorname, String namekz, String maStatus, Double rkosten, Double dwkosten, Integer pktqsoll, Integer pktqist, String aktiv, String email, Date geburtstag, byte[] bild, String straße, String plz, String ort, String land, Short entfap, String mobil, String telefon, String telefax, String telefonprojekt, Byte durchwahl, String kontonr, String blz, String bank, Date eintrittsdatum, Date endeprobezeit, Date austrittsdatum, String bemerkung, Set<HAuftragMitarbeiterAssignment> HAuftragMitarbeiterAssignments, Set<HEinsatzplan> HEinsatzplans, Set<PUseraccount> PUseraccounts, Set<Branche> branches, Set<HUseraccount> HUseraccounts, Set<Geschaeftsfeld> geschaeftsfelds, Set<AufgabeMaAssoc> aufgabeMaAssocs) {
        this.hid = hid;
        this.gp = gp;
        this.affinisgesellschaft = affinisgesellschaft;
        this.manr = manr;
        this.name = name;
        this.vorname = vorname;
        this.namekz = namekz;
        this.maStatus = maStatus;
        this.rkosten = rkosten;
        this.dwkosten = dwkosten;
        this.pktqsoll = pktqsoll;
        this.pktqist = pktqist;
        this.aktiv = aktiv;
        this.email = email;
        this.geburtstag = geburtstag;
        this.bild = bild;
        this.straße = straße;
        this.plz = plz;
        this.ort = ort;
        this.land = land;
        this.entfap = entfap;
        this.mobil = mobil;
        this.telefon = telefon;
        this.telefax = telefax;
        this.telefonprojekt = telefonprojekt;
        this.durchwahl = durchwahl;
        this.kontonr = kontonr;
        this.blz = blz;
        this.bank = bank;
        this.eintrittsdatum = eintrittsdatum;
        this.endeprobezeit = endeprobezeit;
        this.austrittsdatum = austrittsdatum;
        this.bemerkung = bemerkung;
        this.HAuftragMitarbeiterAssignments = HAuftragMitarbeiterAssignments;
        this.HEinsatzplans = HEinsatzplans;
        this.PUseraccounts = PUseraccounts;
        this.branches = branches;
        this.HUseraccounts = HUseraccounts;
        this.geschaeftsfelds = geschaeftsfelds;
        this.aufgabeMaAssocs = aufgabeMaAssocs;
    }

    @Id
    @Column(name = "hid", unique = true, nullable = false)
    public int getHid() {
        return this.hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "geschaeftspartner")
    public Gp getGp() {
        return this.gp;
    }

    public void setGp(Gp gp) {
        this.gp = gp;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "affinisgesellschaft", nullable = false)
    public Affinisgesellschaft getAffinisgesellschaft() {
        return this.affinisgesellschaft;
    }

    public void setAffinisgesellschaft(Affinisgesellschaft affinisgesellschaft) {
        this.affinisgesellschaft = affinisgesellschaft;
    }

    @Column(name = "manr", nullable = false)
    public int getManr() {
        return this.manr;
    }

    public void setManr(int manr) {
        this.manr = manr;
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "vorname")
    public String getVorname() {
        return this.vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    @Column(name = "namekz", length = 3)
    public String getNamekz() {
        return this.namekz;
    }

    public void setNamekz(String namekz) {
        this.namekz = namekz;
    }

    @Column(name = "maStatus", length = 30)
    public String getMaStatus() {
        return this.maStatus;
    }

    public void setMaStatus(String maStatus) {
        this.maStatus = maStatus;
    }

    @Column(name = "rkosten", precision = 22, scale = 0)
    public Double getRkosten() {
        return this.rkosten;
    }

    public void setRkosten(Double rkosten) {
        this.rkosten = rkosten;
    }

    @Column(name = "dwkosten", precision = 22, scale = 0)
    public Double getDwkosten() {
        return this.dwkosten;
    }

    public void setDwkosten(Double dwkosten) {
        this.dwkosten = dwkosten;
    }

    @Column(name = "pktqsoll")
    public Integer getPktqsoll() {
        return this.pktqsoll;
    }

    public void setPktqsoll(Integer pktqsoll) {
        this.pktqsoll = pktqsoll;
    }

    @Column(name = "pktqist")
    public Integer getPktqist() {
        return this.pktqist;
    }

    public void setPktqist(Integer pktqist) {
        this.pktqist = pktqist;
    }

    @Column(name = "aktiv", nullable = false, length = 1)
    public String getAktiv() {
        return this.aktiv;
    }

    public void setAktiv(String aktiv) {
        this.aktiv = aktiv;
    }

    @Column(name = "email")
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "geburtstag", length = 10)
    public Date getGeburtstag() {
        return this.geburtstag;
    }

    public void setGeburtstag(Date geburtstag) {
        this.geburtstag = geburtstag;
    }

    @Column(name = "bild")
    public byte[] getBild() {
        return this.bild;
    }

    public void setBild(byte[] bild) {
        this.bild = bild;
    }

    @Column(name = "straße", length = 50)
    public String getStraße() {
        return this.straße;
    }

    public void setStraße(String straße) {
        this.straße = straße;
    }

    @Column(name = "plz", length = 15)
    public String getPlz() {
        return this.plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    @Column(name = "ort", length = 50)
    public String getOrt() {
        return this.ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    @Column(name = "land", length = 30)
    public String getLand() {
        return this.land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    @Column(name = "entfap")
    public Short getEntfap() {
        return this.entfap;
    }

    public void setEntfap(Short entfap) {
        this.entfap = entfap;
    }

    @Column(name = "mobil", length = 20)
    public String getMobil() {
        return this.mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    @Column(name = "telefon", length = 20)
    public String getTelefon() {
        return this.telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Column(name = "telefax", length = 20)
    public String getTelefax() {
        return this.telefax;
    }

    public void setTelefax(String telefax) {
        this.telefax = telefax;
    }

    @Column(name = "telefonprojekt", length = 20)
    public String getTelefonprojekt() {
        return this.telefonprojekt;
    }

    public void setTelefonprojekt(String telefonprojekt) {
        this.telefonprojekt = telefonprojekt;
    }

    @Column(name = "durchwahl")
    public Byte getDurchwahl() {
        return this.durchwahl;
    }

    public void setDurchwahl(Byte durchwahl) {
        this.durchwahl = durchwahl;
    }

    @Column(name = "kontonr", length = 10)
    public String getKontonr() {
        return this.kontonr;
    }

    public void setKontonr(String kontonr) {
        this.kontonr = kontonr;
    }

    @Column(name = "blz", length = 8)
    public String getBlz() {
        return this.blz;
    }

    public void setBlz(String blz) {
        this.blz = blz;
    }

    @Column(name = "bank", length = 30)
    public String getBank() {
        return this.bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "eintrittsdatum", length = 10)
    public Date getEintrittsdatum() {
        return this.eintrittsdatum;
    }

    public void setEintrittsdatum(Date eintrittsdatum) {
        this.eintrittsdatum = eintrittsdatum;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "endeprobezeit", length = 10)
    public Date getEndeprobezeit() {
        return this.endeprobezeit;
    }

    public void setEndeprobezeit(Date endeprobezeit) {
        this.endeprobezeit = endeprobezeit;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "austrittsdatum", length = 10)
    public Date getAustrittsdatum() {
        return this.austrittsdatum;
    }

    public void setAustrittsdatum(Date austrittsdatum) {
        this.austrittsdatum = austrittsdatum;
    }

    @Column(name = "bemerkung")
    public String getBemerkung() {
        return this.bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "mitarbeiter")
    public Set<HAuftragMitarbeiterAssignment> getHAuftragMitarbeiterAssignments() {
        return this.HAuftragMitarbeiterAssignments;
    }

    public void setHAuftragMitarbeiterAssignments(Set<HAuftragMitarbeiterAssignment> HAuftragMitarbeiterAssignments) {
        this.HAuftragMitarbeiterAssignments = HAuftragMitarbeiterAssignments;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mitarbeiter")
    public Set<HEinsatzplan> getHEinsatzplans() {
        return this.HEinsatzplans;
    }

    public void setHEinsatzplans(Set<HEinsatzplan> HEinsatzplans) {
        this.HEinsatzplans = HEinsatzplans;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mitarbeiter")
    public Set<PUseraccount> getPUseraccounts() {
        return this.PUseraccounts;
    }

    public void setPUseraccounts(Set<PUseraccount> PUseraccounts) {
        this.PUseraccounts = PUseraccounts;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mitarbeiter")
    public Set<Branche> getBranches() {
        return this.branches;
    }

    public void setBranches(Set<Branche> branches) {
        this.branches = branches;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mitarbeiter")
    public Set<HUseraccount> getHUseraccounts() {
        return this.HUseraccounts;
    }

    public void setHUseraccounts(Set<HUseraccount> HUseraccounts) {
        this.HUseraccounts = HUseraccounts;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mitarbeiter")
    public Set<Geschaeftsfeld> getGeschaeftsfelds() {
        return this.geschaeftsfelds;
    }

    public void setGeschaeftsfelds(Set<Geschaeftsfeld> geschaeftsfelds) {
        this.geschaeftsfelds = geschaeftsfelds;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mitarbeiter")
    public Set<AufgabeMaAssoc> getAufgabeMaAssocs() {
        return this.aufgabeMaAssocs;
    }

    public void setAufgabeMaAssocs(Set<AufgabeMaAssoc> aufgabeMaAssocs) {
        this.aufgabeMaAssocs = aufgabeMaAssocs;
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
        Mitarbeiter other = (Mitarbeiter) object;
        if (name == null ? other.name != null : !name.equals(other.name)) {
            return false;
        }
        
        if (vorname == null ? other.vorname != null : !vorname.equals(other.vorname)) {
            return false;
        }


        // All passed.
        return true;
    }
}
