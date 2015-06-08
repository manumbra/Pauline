package de.affinis.pauline.bb;

import de.affinis.pauline.hbm.Mitarbeiter;
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
import org.primefaces.event.ToggleEvent;

@ManagedBean
@SessionScoped
public class MitarbeiterBean implements java.io.Serializable {

    private Mitarbeiter selectedMitarbeiter;
    private List<Mitarbeiter> filteredMitarbeiter;

    public List<Mitarbeiter> getFilteredMitarbeiter() {
        return filteredMitarbeiter;
    }

    public void setFilteredMitarbeiter(List<Mitarbeiter> filteredMitarbeiter) {
        this.filteredMitarbeiter = filteredMitarbeiter;
    }

    public Mitarbeiter getSelectedMitarbeiter() {
        return selectedMitarbeiter;
    }

    public void setSelectedMitarbeiter(Mitarbeiter selectedMitarbeiter) {
        this.selectedMitarbeiter = selectedMitarbeiter;
    }

    public String showMeS() {
        String s = "s";
        return s;
    }

    public MitarbeiterBean() {
    }

    public void onRowToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Mitarbeiter:",
                 ((Mitarbeiter) event.getData()).getVorname() +" "+ ((Mitarbeiter) event.getData()).getName());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public static List<Mitarbeiter> getAllMitarbeiter() {


        List<Mitarbeiter> mitarbeiterList;
        mitarbeiterList = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Mitarbeiter");
            mitarbeiterList = (List<Mitarbeiter>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mitarbeiterList;
    }

    public List<Mitarbeiter> getMitarbeiterList() {


        List<Mitarbeiter> mitarbeiterList;
        mitarbeiterList = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Mitarbeiter");
            mitarbeiterList = (List<Mitarbeiter>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mitarbeiterList;
    }
}
