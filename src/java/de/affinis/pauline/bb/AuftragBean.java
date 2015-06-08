/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.bb;

import de.affinis.pauline.hbm.HAuftrag;
import de.affinis.pauline.hbm.PUseraccount;
import de.affinis.pauline.util.FacesAccessor;
import de.affinis.pauline.util.HibernateUtil;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.event.ToggleEvent;

/**
 *
 * @author Marin Cordeleanu
 */
@ManagedBean
@SessionScoped
public class AuftragBean implements java.io.Serializable {

    private HAuftrag selectedHAuftrag;
    private List<HAuftrag> filteredHAuftrag;
    private List<HAuftrag> myHAuftragList;
    

    public HAuftrag getSelectedHAuftrag() {
        return selectedHAuftrag;
    }

    public void setSelectedHAuftrag(HAuftrag selectedHAuftrag) {
        this.selectedHAuftrag = selectedHAuftrag;
    }

    public List<HAuftrag> getFilteredHAuftrag() {
        return filteredHAuftrag;
    }

    public void setFilteredHAuftrag(List<HAuftrag> filteredHAuftrag) {
        this.filteredHAuftrag = filteredHAuftrag;
    }

    public AuftragBean() {
    }

    public void onRowToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Auftrag:",
                ((HAuftrag) event.getData()).getAuftragsnummer());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public static List<HAuftrag> getAllAuftraege() {
        List<HAuftrag> auftragList = null;

        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from HAuftrag");
            auftragList = (List<HAuftrag>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return auftragList;
    }

    

    public List<HAuftrag> getMyHAuftragList() {
        
        PUseraccount useraccount = (PUseraccount) FacesAccessor.getUser();
        
            try {
                Session session = HibernateUtil.getSessionFactory().getCurrentSession();
                Transaction tx = session.beginTransaction();
                myHAuftragList = session.createQuery("select ha from HAuftrag ha, HAuftragMitarbeiterAssignment hama, PQProjekt qp where qp.HAuftrag = ha.hid and hama.HAuftrag = ha.hid and hama.HSecurityrole = 9 and hama.mitarbeiter.hid = :hid").setInteger("hid", useraccount.getMitarbeiter().getHid()).list();
                
            } catch (Exception e) {
                e.printStackTrace();
            }


        return myHAuftragList;
    }

    public List<HAuftrag> getHAuftragList() {


        List<HAuftrag> auftragList;
        auftragList = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from HAuftrag");
            auftragList = (List<HAuftrag>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return auftragList;
    }
}
