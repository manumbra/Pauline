package de.affinis.pauline.hbm;
// Generated 04.07.2013 19:12:12 by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * HAuftragMitarbeiterAssignmentId generated by hbm2java
 */
@Embeddable
public class HAuftragMitarbeiterAssignmentId  implements java.io.Serializable {


     private int auftrag;
     private int role;
     private int mitarbeiterid;

    public HAuftragMitarbeiterAssignmentId() {
    }

    public HAuftragMitarbeiterAssignmentId(int auftrag, int role, int mitarbeiterid) {
       this.auftrag = auftrag;
       this.role = role;
       this.mitarbeiterid = mitarbeiterid;
    }
   

    @Column(name="auftrag", nullable=false)
    public int getAuftrag() {
        return this.auftrag;
    }
    
    public void setAuftrag(int auftrag) {
        this.auftrag = auftrag;
    }

    @Column(name="role", nullable=false)
    public int getRole() {
        return this.role;
    }
    
    public void setRole(int role) {
        this.role = role;
    }

    @Column(name="mitarbeiterid", nullable=false)
    public int getMitarbeiterid() {
        return this.mitarbeiterid;
    }
    
    public void setMitarbeiterid(int mitarbeiterid) {
        this.mitarbeiterid = mitarbeiterid;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof HAuftragMitarbeiterAssignmentId) ) return false;
		 HAuftragMitarbeiterAssignmentId castOther = ( HAuftragMitarbeiterAssignmentId ) other; 
         
		 return (this.getAuftrag()==castOther.getAuftrag())
 && (this.getRole()==castOther.getRole())
 && (this.getMitarbeiterid()==castOther.getMitarbeiterid());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getAuftrag();
         result = 37 * result + this.getRole();
         result = 37 * result + this.getMitarbeiterid();
         return result;
   }   


}


