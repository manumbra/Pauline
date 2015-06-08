package de.affinis.pauline.bb;

import de.affinis.pauline.hbm.Benutzer;
import de.affinis.pauline.hbm.HAuftrag;
import de.affinis.pauline.hbm.PQObjekt;
import de.affinis.pauline.hbm.PQProjekt;
import de.affinis.pauline.hbm.PUseraccount;
import de.affinis.pauline.util.FacesAccessor;
import de.affinis.pauline.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.ToggleEvent;

/**
 *
 * @author Marin Cordeleanu
 */
@ManagedBean
@SessionScoped
public class QProjektManager implements java.io.Serializable {

    private PQProjekt selectedPQProjekt = new PQProjekt();
    private List<PQProjekt> filteredPQProjekts;
    private List<PQProjekt> myPQProjekts;
    private List<PQObjekt> localObjekts;

    public void setMyPQProjekts(List<PQProjekt> myPQProjekts) {
        this.myPQProjekts = myPQProjekts;
    }

    public QProjektManager() {
    }

    public List<PQObjekt> getLocalObjekts() {
        Set<PQObjekt> objectSet = selectedPQProjekt.getPQObjekts();
        localObjekts = new ArrayList<PQObjekt>(objectSet);
        return localObjekts;
    }

    public void setLocalObjekts(List<PQObjekt> localObjekts) {
        this.localObjekts = localObjekts;
    }

    public PQProjekt getSelectedPQProjekt() {
        return selectedPQProjekt;
    }

    public void setSelectedPQProjekt(PQProjekt selectedPQProjekt) {
        this.selectedPQProjekt = selectedPQProjekt;
    }

    public List<PQProjekt> getFilteredPQProjekts() {
        return filteredPQProjekts;
    }

    public void setFilteredPQProjekts(List<PQProjekt> filteredPQProjekts) {
        this.filteredPQProjekts = filteredPQProjekts;
    }

    public List<PQProjekt> getMyPQProjekts() {
        if (null == myPQProjekts) {
            myPQProjekts = new LinkedList<PQProjekt>();
        }
        if (myPQProjekts.isEmpty()) {
            PUseraccount useraccount = (PUseraccount) FacesAccessor.getUser();
            Transaction trns = null;
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            try {
                trns = session.beginTransaction();
                myPQProjekts = session.createQuery("from PQProjekt where createdby = :hid").setInteger("hid", useraccount.getHid()).list();

            } catch (RuntimeException e) {
                e.printStackTrace();
            } finally {
                session.flush();
            }

        }
        return myPQProjekts;
    }

    public void addPQProjekt(PQProjekt pQProjekt) {
        PUseraccount userAccount = (PUseraccount) FacesAccessor.getUser();
        AuftragBean auftragBean = (AuftragBean) FacesAccessor.getAuftragBean();
        HAuftrag selectedAuftrag = auftragBean.getSelectedHAuftrag();
        pQProjekt.setHAuftrag(selectedAuftrag);
        pQProjekt.setCreatedat(new Date());
        pQProjekt.setModifiedat(new Date());
        pQProjekt.setPUseraccountByCreatedby(userAccount);
        pQProjekt.setPUseraccountByModifiedby(userAccount);
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            trns = session.beginTransaction();
            session.save(pQProjekt);
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

    public void deletePQProjektById(Integer hid) {

        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trns = session.beginTransaction();
            PQProjekt pQProjekt = (PQProjekt) session.load(PQProjekt.class, new Integer(hid));
            session.delete(pQProjekt);
            trns.commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void deletePQProjekt(PQProjekt p) {
        myPQProjekts.remove(p);
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trns = session.beginTransaction();
            session.delete(p);
            trns.commit();

        } catch (RuntimeException e) {

            e.printStackTrace();
        }

    }

    public void updatePQProjekt(PQProjekt pQProjekt) {
        PUseraccount userAccount = (PUseraccount) FacesAccessor.getUser();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            Transaction trns = session.beginTransaction();
            pQProjekt.setModifiedat(new Date());
            pQProjekt.setPUseraccountByModifiedby(userAccount);
            session.merge(pQProjekt);
            trns.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
        }
    }

    public void createPQProjekt(PQProjekt pQProjekt) {
        PUseraccount userAccount = (PUseraccount) FacesAccessor.getUser();
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trns = session.beginTransaction();
            pQProjekt.setCreatedat(new Date());
            pQProjekt.setPUseraccountByCreatedby(userAccount);
            pQProjekt.setModifiedat(new Date());
            pQProjekt.setPUseraccountByModifiedby(userAccount);
            session.save(pQProjekt);
            trns.commit();
        } catch (RuntimeException e) {

            e.printStackTrace();
        }
    }

    public List<PQProjekt> getAllPQProjekts() {
        List<PQProjekt> pQProjekts = new ArrayList<PQProjekt>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            trns = session.beginTransaction();
            pQProjekts = session.createQuery("from PQProjekt").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
        }
        return pQProjekts;
    }

    public PQProjekt getPQProjektById(Integer hid) {
        PQProjekt pQProjekt = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from PQProjekt where hid = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", hid);
            pQProjekt = (PQProjekt) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
        }
        return pQProjekt;
    }

    public PQProjekt getPQProjektByAuftragId(Integer hid) {
        PQProjekt pQProjekt = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from PQProjekt where HAuftrag.hid = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", hid);
            pQProjekt = (PQProjekt) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
        }
        return pQProjekt;
    }

    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Change Cancelled", ((PQProjekt) event.getObject()).getBeschreibung());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onEdit(RowEditEvent event) {
        PQProjekt editedQProjekt = (PQProjekt) event.getObject();
        updatePQProjekt(editedQProjekt);
        FacesMessage msg = new FacesMessage("Change Successful", "Good job" + ((PQProjekt) event.getObject()).getBeschreibung());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
