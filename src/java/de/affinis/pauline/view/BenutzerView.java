/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.view;

import de.affinis.pauline.dao.BenutzerDao;
import de.affinis.pauline.hbm.Benutzer;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.ToggleEvent;

/**
 *
 * @author Marin Cordeleanu
 */
@ManagedBean
@ViewScoped
public class BenutzerView  implements java.io.Serializable {

    private Benutzer editBenutzer;
    private Benutzer selectedBenutzer;
    private List<Benutzer> benutzerList;
    private List<Benutzer> filteredList;

    public Benutzer getEditBenutzer() {
        return editBenutzer;
    }

    public void setEditBenutzer(Benutzer editBenutzer) {
        this.editBenutzer = editBenutzer;
    }

    public Benutzer getSelectedBenutzer() {
        return selectedBenutzer;
    }

    public void setSelectedBenutzer(Benutzer selectedBenutzer) {
        this.selectedBenutzer = selectedBenutzer;
    }

    public List<Benutzer> getBenutzerList() {
        return benutzerList;
    }

    public void setBenutzerList(List<Benutzer> benutzerList) {
        this.benutzerList = benutzerList;
    }

    public List<Benutzer> getFilteredList() {
        return filteredList;
    }

    public void setFilteredList(List<Benutzer> filteredList) {
        this.filteredList = filteredList;
    }

    public void deleteBenutzer(Benutzer benutzer) {
        benutzerList.remove(benutzer);
        BenutzerDao.deleteBenutzer(benutzer);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Benutzer:",
                benutzer.getBenutzername() + " wurde gelöscht");

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void createBenutzer(Benutzer benutzer) {
        Benutzer b = new Benutzer();
        b.setBenutzername(benutzer.getBenutzername());
        b.setPasswort(benutzer.getPasswort());
        
        b.setLAenderung(new Date());
        b.setCDate(new Date());
        benutzerList.add(b);
        BenutzerDao.createBenutzer(b);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Benutzer:",
                b.getBenutzername() + " wurde angelegt");

        FacesContext.getCurrentInstance().addMessage(null, msg);
        editBenutzer = null;
    }
    
    public void updateBenutzer(Benutzer benutzer) {
        BenutzerDao.updateBenutzer(benutzer);
    }
    
    private void populateBenutzerList(List<Benutzer> bList) {
        List<Benutzer> g = BenutzerDao.getBenutzerList();
        for (Benutzer b : g) {
            bList.add(b);
        }
    }

    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Change Cancelled", ((Benutzer) event.getObject()).getBenutzername() + "  " + ((Benutzer) event.getObject()).getPasswort());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onEdit(RowEditEvent event) {
        Benutzer editedBenutzer = (Benutzer) event.getObject();
        updateBenutzer(editedBenutzer);
        FacesMessage msg = new FacesMessage("Change Successful", "Good job: " + ((Benutzer) event.getObject()).getBenutzername() + "  " + ((Benutzer) event.getObject()).getPasswort());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Benutzer:",
                ((Benutzer) event.getData()).getBenutzername());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public BenutzerView() {
        editBenutzer = new Benutzer();
        benutzerList = new LinkedList<Benutzer>();
        populateBenutzerList(benutzerList);
    }
}
