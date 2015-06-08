/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.view;

import de.affinis.pauline.dao.QKriterienVorlageDao;
import de.affinis.pauline.dao.QKriteriumDao;
import de.affinis.pauline.dao.QObjektDao;
import de.affinis.pauline.hbm.Mitarbeiter;
import de.affinis.pauline.hbm.PQKriterienVorlage;
import de.affinis.pauline.hbm.PQKriterium;
import de.affinis.pauline.hbm.PQObjekt;
import de.affinis.pauline.hbm.PUseraccount;
import de.affinis.pauline.util.FacesAccessor;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author Marin Cordeleanu
 */
@ManagedBean
@SessionScoped
public class QKriterienVorlageView implements java.io.Serializable {

    private PQKriterienVorlage selectedKriterienVorlage;
    private PQKriterienVorlage editKriterienVorlage;
    private List<PQKriterienVorlage> alleKriterienVorlagen;
    private List<PQKriterienVorlage> availableKriterienVorlageForQualityObject;
    private PQObjekt forObjekt;

    public PQObjekt getForObjekt() {
        return forObjekt;
    }

    public void setForObjekt(PQObjekt forObjekt) {
        this.forObjekt = forObjekt;
    }

    public List<PQKriterienVorlage> getAvailableKriterienVorlageForQualityObject() {
        retrieveSourceObjekt();
        availableKriterienVorlageForQualityObject = QKriterienVorlageDao.getAlleKriterienVorlagen();
        for (PQKriterium krit : QKriteriumDao.getQKriteriumListFromObjekt(forObjekt)) {
            availableKriterienVorlageForQualityObject.remove(krit.getPQKriterienVorlage());
        }
        return availableKriterienVorlageForQualityObject;
    }

    public void setAvailableKriterienVorlageForQualityObject(List<PQKriterienVorlage> availableKriterienVorlageForQualityObject) {
        this.availableKriterienVorlageForQualityObject = availableKriterienVorlageForQualityObject;
    }

    public PQKriterienVorlage getSelectedKriterienVorlage() {
        return selectedKriterienVorlage;
    }

    public void setSelectedKriterienVorlage(PQKriterienVorlage selectedKriterienVorlage) {
        this.selectedKriterienVorlage = selectedKriterienVorlage;
    }

    public PQKriterienVorlage getEditKriterienVorlage() {
        return editKriterienVorlage;
    }

    public void setEditKriterienVorlage(PQKriterienVorlage editKriterienVorlage) {
        this.editKriterienVorlage = editKriterienVorlage;
    }

    public List<PQKriterienVorlage> getAlleKriterienVorlagen() {
        return alleKriterienVorlagen;
    }

    public void setAlleKriterienVorlagen(List<PQKriterienVorlage> alleKriterienVorlagen) {
        this.alleKriterienVorlagen = alleKriterienVorlagen;
    }
    private List<PQKriterienVorlage> filteredList;

    public List<PQKriterienVorlage> getFilteredList() {
        return filteredList;
    }

    public void setFilteredList(List<PQKriterienVorlage> filteredList) {
        this.filteredList = filteredList;
    }

    private void retrieveSourceObjekt() {
        QObjektView obj = (QObjektView) FacesAccessor.getQObjektView();
        forObjekt = obj.getSelectedQObjekt();
    }

    public void onRowToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "PQKriterienVorlage:",
                ((PQKriterienVorlage) event.getData()).getBeschreibung());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Kriterium ausgewählt", ((PQKriterienVorlage) event.getObject()).getName());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Kriterium ausgewählt", ((PQKriterienVorlage) event.getObject()).getName());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    private void populateAlleKriterienVorlagen(List<PQKriterienVorlage> qKriteriumList) {
        List<PQKriterienVorlage> g = QKriterienVorlageDao.getAlleKriterienVorlagen();
        for (PQKriterienVorlage qP : g) {
            qKriteriumList.add(qP);
        }
    }
    
    public void createKriterienVorlage(PQKriterienVorlage kritVorlage) {
        Date date = new Date();
        PUseraccount user = (PUseraccount) FacesAccessor.getCurrentUser();
        kritVorlage.setPUseraccountByCreatedby(user);
        kritVorlage.setPUseraccountByModifiedby(user);
        kritVorlage.setModifiedat(date);
        kritVorlage.setCreatedat(date);
        alleKriterienVorlagen.add(kritVorlage);
        QKriterienVorlageDao.createQKriterium(kritVorlage);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "PQKriterienVorlage:",
                kritVorlage.getBeschreibung() + " wurde neu erstellt.");

        FacesContext.getCurrentInstance().addMessage(null, msg);
        editKriterienVorlage = new PQKriterienVorlage();
    }


    public void showMessage() {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "PQKriterienVorlage:",
                " wurde neu erstellt.");

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    
    public void updateKriterienVorlage(PQKriterienVorlage kritVorlage) {
        Date date = new Date();
        PUseraccount user = (PUseraccount) FacesAccessor.getCurrentUser();
        kritVorlage.setPUseraccountByModifiedby(user);
        kritVorlage.setModifiedat(date);

        QKriterienVorlageDao.updateQKriterium(kritVorlage);
        QKriterienVorlageDao.createQKriterium(kritVorlage);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "PQKriterienVorlage:",
                kritVorlage.getBeschreibung() + " wurde neu erstellt.");

        FacesContext.getCurrentInstance().addMessage(null, msg);
        editKriterienVorlage = new PQKriterienVorlage();
    }

    public void deleteKriterienVorlage(PQKriterienVorlage kritVorlage) {
        alleKriterienVorlagen.remove(kritVorlage);
        QKriterienVorlageDao.deleteQKriterium(kritVorlage);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "PQKriterienVorlage:",
                kritVorlage.getBeschreibung() + " wurde neu erstellt.");

        FacesContext.getCurrentInstance().addMessage(null, msg);
        editKriterienVorlage = new PQKriterienVorlage();
    }

    public QKriterienVorlageView() {
        selectedKriterienVorlage = new PQKriterienVorlage();
        editKriterienVorlage = new PQKriterienVorlage();
        alleKriterienVorlagen = new LinkedList<PQKriterienVorlage>();
        populateAlleKriterienVorlagen(alleKriterienVorlagen);
    }

   
}
