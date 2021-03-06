package de.affinis.pauline.hbm;
// Generated 04.07.2013 19:12:12 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Tantiemengueltigkeit generated by hbm2java
 */
@Entity
@Table(name="tantiemengueltigkeit"
    ,catalog="paulprod"
)
public class Tantiemengueltigkeit  implements java.io.Serializable {


     private int hid;
     private Integer typid;
     private String typ;
     private Double tantiemesatz;
     private Double mtantiemeauslastung;
     private Double mtantiemesatzdb;
     private Double mtantiemeq;
     private Double mtantiemesatzumsatz;
     private Integer pktqsoll;
     private Integer pktqist;
     private int year;
     private Integer auslastungmin;
     private Integer auslastungmax;
     private Date datumvon;
     private Date datumbis;
     private String kosteneinheit;
     private Double plGeschaetzt;

    public Tantiemengueltigkeit() {
    }

	
    public Tantiemengueltigkeit(int hid, String typ, int year) {
        this.hid = hid;
        this.typ = typ;
        this.year = year;
    }
    public Tantiemengueltigkeit(int hid, Integer typid, String typ, Double tantiemesatz, Double mtantiemeauslastung, Double mtantiemesatzdb, Double mtantiemeq, Double mtantiemesatzumsatz, Integer pktqsoll, Integer pktqist, int year, Integer auslastungmin, Integer auslastungmax, Date datumvon, Date datumbis, String kosteneinheit, Double plGeschaetzt) {
       this.hid = hid;
       this.typid = typid;
       this.typ = typ;
       this.tantiemesatz = tantiemesatz;
       this.mtantiemeauslastung = mtantiemeauslastung;
       this.mtantiemesatzdb = mtantiemesatzdb;
       this.mtantiemeq = mtantiemeq;
       this.mtantiemesatzumsatz = mtantiemesatzumsatz;
       this.pktqsoll = pktqsoll;
       this.pktqist = pktqist;
       this.year = year;
       this.auslastungmin = auslastungmin;
       this.auslastungmax = auslastungmax;
       this.datumvon = datumvon;
       this.datumbis = datumbis;
       this.kosteneinheit = kosteneinheit;
       this.plGeschaetzt = plGeschaetzt;
    }
   
     @Id 
    
    @Column(name="hid", unique=true, nullable=false)
    public int getHid() {
        return this.hid;
    }
    
    public void setHid(int hid) {
        this.hid = hid;
    }
    
    @Column(name="typid")
    public Integer getTypid() {
        return this.typid;
    }
    
    public void setTypid(Integer typid) {
        this.typid = typid;
    }
    
    @Column(name="typ", nullable=false, length=14)
    public String getTyp() {
        return this.typ;
    }
    
    public void setTyp(String typ) {
        this.typ = typ;
    }
    
    @Column(name="tantiemesatz", precision=22, scale=0)
    public Double getTantiemesatz() {
        return this.tantiemesatz;
    }
    
    public void setTantiemesatz(Double tantiemesatz) {
        this.tantiemesatz = tantiemesatz;
    }
    
    @Column(name="mtantiemeauslastung", precision=22, scale=0)
    public Double getMtantiemeauslastung() {
        return this.mtantiemeauslastung;
    }
    
    public void setMtantiemeauslastung(Double mtantiemeauslastung) {
        this.mtantiemeauslastung = mtantiemeauslastung;
    }
    
    @Column(name="mtantiemesatzdb", precision=22, scale=0)
    public Double getMtantiemesatzdb() {
        return this.mtantiemesatzdb;
    }
    
    public void setMtantiemesatzdb(Double mtantiemesatzdb) {
        this.mtantiemesatzdb = mtantiemesatzdb;
    }
    
    @Column(name="mtantiemeq", precision=22, scale=0)
    public Double getMtantiemeq() {
        return this.mtantiemeq;
    }
    
    public void setMtantiemeq(Double mtantiemeq) {
        this.mtantiemeq = mtantiemeq;
    }
    
    @Column(name="mtantiemesatzumsatz", precision=22, scale=0)
    public Double getMtantiemesatzumsatz() {
        return this.mtantiemesatzumsatz;
    }
    
    public void setMtantiemesatzumsatz(Double mtantiemesatzumsatz) {
        this.mtantiemesatzumsatz = mtantiemesatzumsatz;
    }
    
    @Column(name="pktqsoll")
    public Integer getPktqsoll() {
        return this.pktqsoll;
    }
    
    public void setPktqsoll(Integer pktqsoll) {
        this.pktqsoll = pktqsoll;
    }
    
    @Column(name="pktqist")
    public Integer getPktqist() {
        return this.pktqist;
    }
    
    public void setPktqist(Integer pktqist) {
        this.pktqist = pktqist;
    }
    
    @Column(name="year", nullable=false)
    public int getYear() {
        return this.year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    @Column(name="auslastungmin")
    public Integer getAuslastungmin() {
        return this.auslastungmin;
    }
    
    public void setAuslastungmin(Integer auslastungmin) {
        this.auslastungmin = auslastungmin;
    }
    
    @Column(name="auslastungmax")
    public Integer getAuslastungmax() {
        return this.auslastungmax;
    }
    
    public void setAuslastungmax(Integer auslastungmax) {
        this.auslastungmax = auslastungmax;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="datumvon", length=10)
    public Date getDatumvon() {
        return this.datumvon;
    }
    
    public void setDatumvon(Date datumvon) {
        this.datumvon = datumvon;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="datumbis", length=10)
    public Date getDatumbis() {
        return this.datumbis;
    }
    
    public void setDatumbis(Date datumbis) {
        this.datumbis = datumbis;
    }
    
    @Column(name="kosteneinheit", length=10)
    public String getKosteneinheit() {
        return this.kosteneinheit;
    }
    
    public void setKosteneinheit(String kosteneinheit) {
        this.kosteneinheit = kosteneinheit;
    }
    
    @Column(name="pl_geschaetzt", precision=22, scale=0)
    public Double getPlGeschaetzt() {
        return this.plGeschaetzt;
    }
    
    public void setPlGeschaetzt(Double plGeschaetzt) {
        this.plGeschaetzt = plGeschaetzt;
    }




}


