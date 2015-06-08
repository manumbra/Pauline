/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.bb;

import de.affinis.pauline.hbm.PQKriterium;
import de.affinis.pauline.hbm.PQObjekt;
import de.affinis.pauline.util.FacesAccessor;
import de.affinis.pauline.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.ToggleEvent;

/**
 *
 * @author Marin Cordeleanu
 */
@ManagedBean
@SessionScoped
public class QKriteriumManager implements java.io.Serializable {

    private PQKriterium selectedPQKriterium;
    private List<PQKriterium> filteredPQKriterien;
    private List<PQKriterium> myPQKriterien;

    public PQKriterium getSelectedPQKriterium() {
        return selectedPQKriterium;
    }

    public void setSelectedPQKriterium(PQKriterium selectedPQKriterium) {
        this.selectedPQKriterium = selectedPQKriterium;
    }

    public List<PQKriterium> getFilteredPQKriterien() {
        return filteredPQKriterien;
    }

    public void setFilteredPQKriterien(List<PQKriterium> filteredPQKriterien) {
        this.filteredPQKriterien = filteredPQKriterien;
    }

    public List<PQKriterium> getMyPQKriterien() {
        QObjektManager pQObjektManager = (QObjektManager) FacesAccessor.getQPObjektManager();
        PQObjekt selectedQObjekt = pQObjektManager.getSelectedPQObjekt();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            trns = session.beginTransaction();
            myPQKriterien = session.createQuery("from PQKriterium where q_objekt = :qObjekt").setInteger("qObjekt", selectedQObjekt.getHid()).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
        }

        return myPQKriterien;
    }

    public void setMyPQKriterien(List<PQKriterium> myPQKriterien) {
        this.myPQKriterien = myPQKriterien;
    }

    //////////////////////////////////////////////////////
    public void onRowToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Qualitätskriterium:",
                ((PQKriterium) event.getData()).getPQKriterienVorlage().getName());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void addPQKriterium(PQKriterium pQKriterium) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            trns = session.beginTransaction();
            session.save(pQKriterium);
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

    public void deletePQKriterium(Integer hid) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            trns = session.beginTransaction();
            PQKriterium pQKriterium = (PQKriterium) session.load(PQKriterium.class, new Integer(hid));
            session.delete(pQKriterium);
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

    public void updatePQKriterium(PQKriterium pQKriterium) {
        //QKriteriumManager kriteriumManager = (QKriteriumManager) FacesAccessor.getQPKriteriumManager();

        //PQKriterium pQKriterium = kriteriumManager.getSelectedPQKriterium();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            trns = session.beginTransaction();
            session.update(pQKriterium);
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

    public List<PQKriterium> getAllPQKriterien() {
        List<PQKriterium> pQObjekts = new ArrayList<PQKriterium>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            trns = session.beginTransaction();
            pQObjekts = session.createQuery("from PQKriterium").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
        }
        return pQObjekts;
    }

    public PQKriterium getPQKriteriumById(Integer hid) {
        PQKriterium pQObjekt = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from PQKriterium where hid = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", hid);
            pQObjekt = (PQKriterium) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
        }
        return pQObjekt;
    }

    public PQKriterium getPQKriteriumByAuftragId(Integer hid) {
        PQKriterium pQObjekt = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from PQKriterium where HAuftrag.hid = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", hid);
            pQObjekt = (PQKriterium) query.uniqueResult();
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
    public QKriteriumManager() {
        myPQKriterien = new ArrayList<PQKriterium>();
        getMyPQKriterien();
    }

    public void onEdit(RowEditEvent event) {
        selectedPQKriterium = ((PQKriterium)  event.getObject());
        updatePQKriterium(selectedPQKriterium);
        onCancel(event);
    } 

    
    
    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Kriterium:",
               ((PQKriterium)  event.getObject()).getPQKriterienVorlage().getName());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
