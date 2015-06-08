/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.view;

import de.affinis.pauline.dao.MitarbeiterDao;
import de.affinis.pauline.hbm.HAuftrag;
import de.affinis.pauline.hbm.Mitarbeiter;
import de.affinis.pauline.hbm.PQProjekt;
import de.affinis.pauline.util.FacesAccessor;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.ToggleEvent;

/**
 *
 * @author Marin Cordeleanu
 */
@ManagedBean
@ViewScoped
public class MitarbeiterView implements java.io.Serializable {

    private Mitarbeiter selectedMitarbeiter;
    private List<Mitarbeiter> mitarbeiterList;
    private List<Mitarbeiter> filteredList;
    private List<Mitarbeiter> mitarbeiterListFromAuftrag;
    private HAuftrag fromAuftrag;

    public HAuftrag getFromAuftrag() {
        return fromAuftrag;
    }

    public void setFromAuftrag(HAuftrag fromAuftrag) {
        this.fromAuftrag = fromAuftrag;
    }

    public List<Mitarbeiter> getMitarbeiterListFromAuftrag() {
        mitarbeiterListFromAuftrag = new LinkedList<Mitarbeiter>();
        populateMitarbeiterListFromAuftrag(mitarbeiterListFromAuftrag);
        return mitarbeiterListFromAuftrag;
    }

    public void setMitarbeiterListFromAuftrag(List<Mitarbeiter> mitarbeiterListFromAuftrag) {
        this.mitarbeiterListFromAuftrag = mitarbeiterListFromAuftrag;
    }

    public Mitarbeiter getSelectedMitarbeiter() {
        return selectedMitarbeiter;
    }

    public void setSelectedMitarbeiter(Mitarbeiter selectedMitarbeiter) {
        this.selectedMitarbeiter = selectedMitarbeiter;
    }

    public List<Mitarbeiter> getMitarbeiterList() {
        return mitarbeiterList;
    }

    public void setMitarbeiterList(List<Mitarbeiter> mitarbeiterList) {
        this.mitarbeiterList = mitarbeiterList;
    }

    public List<Mitarbeiter> getFilteredList() {
        return filteredList;
    }

    public void setFilteredList(List<Mitarbeiter> filteredList) {
        this.filteredList = filteredList;
    }

    public void onRowToggle(ToggleEvent event) {
        Mitarbeiter m = ((Mitarbeiter) event.getData());
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "User:",
                m.getName() + ", " + m.getVorname());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<Mitarbeiter> completeMitarbeiter(String query) {
        List<Mitarbeiter> suggestions = new ArrayList<Mitarbeiter>();


        for (Mitarbeiter m : mitarbeiterList) {
            if (m.getName().startsWith(query) || m.getVorname().startsWith(query)) {
                suggestions.add(m);
            }
        }

        return suggestions;
    }

    private void populateMitarbeiterList(List<Mitarbeiter> list) {
        List<Mitarbeiter> g = MitarbeiterDao.getMitarbeiterList();
        for (Mitarbeiter u : g) {
            list.add(u);
        }
    }
    
    private void populateMitarbeiterListFromAuftrag(List<Mitarbeiter> list) {
        retrieveFromAuftrag();
        List<Mitarbeiter> g = MitarbeiterDao.getMitarbeiterListFromAuftrag(fromAuftrag);
        for (Mitarbeiter u : g) {
            list.add(u);
        }
    }
    
    private void retrieveFromAuftrag() {
        QProjektView projView = (QProjektView) FacesAccessor.getQProjektView();
        PQProjekt projekt = projView.getSelectedQProjekt();
        fromAuftrag = projekt.getHAuftrag();
    }

    public MitarbeiterView() {
        selectedMitarbeiter = new Mitarbeiter();
        fromAuftrag = new HAuftrag();
        mitarbeiterList = new LinkedList<Mitarbeiter>();
        mitarbeiterListFromAuftrag = new LinkedList<Mitarbeiter>();
        populateMitarbeiterList(mitarbeiterList);
    }
}
