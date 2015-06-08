/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import de.affinis.pauline.dao.MitarbeiterDao;
import de.affinis.pauline.hbm.Mitarbeiter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Marin Cordeleanu
 */
@ManagedBean
@SessionScoped
public class MitarbeiterTable implements java.io.Serializable {

    private Mitarbeiter selectedMitarbeiter;
    private List<Mitarbeiter> mitarbeiterList;
    private List<Mitarbeiter> filteredList;

    public Mitarbeiter getSelectedMitarbeiter() {
        return selectedMitarbeiter;
    }

    public void setSelectedMitarbeiter(Mitarbeiter selectedMitarbeiter) {
        this.selectedMitarbeiter = selectedMitarbeiter;
    }

    public void releaseSelectedMitarbeiter() {
        selectedMitarbeiter = new Mitarbeiter();
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

    public MitarbeiterTable() {
        mitarbeiterList = new LinkedList<Mitarbeiter>();
        populateMitarbeiterList(mitarbeiterList);
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Car Selected", ((Mitarbeiter) event.getObject()).getEmail());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Car Unselected", ((Mitarbeiter) event.getObject()).getEmail());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}