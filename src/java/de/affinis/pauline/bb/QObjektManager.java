/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.bb;

import de.affinis.pauline.hbm.HAuftrag;
import de.affinis.pauline.hbm.PQKriterium;
import de.affinis.pauline.hbm.PQObjekt;
import de.affinis.pauline.hbm.PQProjekt;
import de.affinis.pauline.hbm.PUseraccount;
import de.affinis.pauline.util.FacesAccessor;
import de.affinis.pauline.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
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
public class QObjektManager implements java.io.Serializable {

    private PQObjekt selectedPQObjekt;
    private List<PQObjekt> filteredPQObjekts;
    private List<PQObjekt> myPQObjekts;
    private List<PQKriterium> localCriteria;

    public List<PQKriterium> getLocalCriteria() {
        
        Set<PQKriterium> criteriaSet = selectedPQObjekt.getPQKriterien();
        localCriteria = new ArrayList<PQKriterium>(criteriaSet);
        
        return localCriteria;
    }

    public void setLocalCriteria(List<PQKriterium> localCriteria) {
        this.localCriteria = localCriteria;
    }
    
    

    public PQObjekt getSelectedPQObjekt() {
        return selectedPQObjekt;
    }

    public void setSelectedPQObjekt(PQObjekt selectedPQObjekt) {
        this.selectedPQObjekt = selectedPQObjekt;
    }

    public List<PQObjekt> getFilteredPQObjekts() {
        return filteredPQObjekts;
    }

    public void setFilteredPQObjekts(List<PQObjekt> filteredPQObjekts) {
        this.filteredPQObjekts = filteredPQObjekts;
    }

    public List<PQObjekt> getMyPQObjektsFromSelectedPQProjekt() {
        PUseraccount useraccount = (PUseraccount) FacesAccessor.getUser();
        QProjektManager pQProjektManager = (QProjektManager) FacesAccessor.getQPProjektManager();
        PQProjekt selectedQProjekt = pQProjektManager.getSelectedPQProjekt();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            trns = session.beginTransaction();
            myPQObjekts = session.createQuery("from PQObjekt where q_projekt = :qProjekt").setInteger("qProjekt", selectedQProjekt.getHid()).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
        }
        return myPQObjekts;
    }

    public void setMyPQObjekts(List<PQObjekt> myPQObjekt) {
        this.myPQObjekts = myPQObjekts;
    }

    public String navigateToObjektDetails() {
        System.out.println(selectedPQObjekt.getBeschreibung());
        return "q-objekt";

    }
    //////////////////////////////////////////////////////

    public void onRowToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Qualitätsobjekt:",
                ((PQObjekt) event.getData()).getName());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void addPQObjekt(PQObjekt pQObjekt) {
        PUseraccount useraccount = (PUseraccount) FacesAccessor.getUser();
        AuftragBean auftragBean = (AuftragBean) FacesAccessor.getAuftragBean();
        //HAufgabe selectedAuftrag = auftragBean.getSelectedHAuftrag().getAufg;
        //pQObjekt.setHAufgabe(selectedAuftrag);
        pQObjekt.setCreatedat(new Date());
        pQObjekt.setModifiedat(new Date());
        pQObjekt.setPUseraccountByCreatedby(useraccount);
        pQObjekt.setPUseraccountByModifiedby(useraccount);
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            trns = session.beginTransaction();
            session.save(pQObjekt);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
        }
    }

    public void deletePQObjekt(Integer hid) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            trns = session.beginTransaction();
            PQObjekt pQObjekt = (PQObjekt) session.load(PQObjekt.class, new Integer(hid));
            session.delete(pQObjekt);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
        }
    }

    public void updatePQObjekt(PQObjekt pQObjekt) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            trns = session.beginTransaction();
            session.update(pQObjekt);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
        }
    }

    public List<PQObjekt> getAllPQObjekts() {
        List<PQObjekt> pQObjekts = new ArrayList<PQObjekt>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            trns = session.beginTransaction();
            pQObjekts = session.createQuery("from PQObjekt").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
        }
        return pQObjekts;
    }

    public PQObjekt getPQObjektById(Integer hid) {
        PQObjekt pQObjekt = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from PQObjekt where hid = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", hid);
            pQObjekt = (PQObjekt) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
        }
        return pQObjekt;
    }

    public PQObjekt getPQObjektByAuftragId(Integer hid) {
        PQObjekt pQObjekt = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from PQObjekt where HAuftrag.hid = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", hid);
            pQObjekt = (PQObjekt) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
        }
        return pQObjekt;
    }

//////////////////////////////////////////////////////
    /**
     * Creates a new instance of QProjektManager
     */
    public QObjektManager() {
    }
}
