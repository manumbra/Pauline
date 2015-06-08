/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.view;

import de.affinis.pauline.dao.MassnahmeDao;
import de.affinis.pauline.hbm.PMassnahme;
import de.affinis.pauline.hbm.PQKriterium;
import de.affinis.pauline.hbm.PUseraccount;
import de.affinis.pauline.util.FacesAccessor;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.ToggleEvent;

/**
 *
 * @author Marin Cordeleanu
 */
@ManagedBean
@SessionScoped
public class PMassnahmeView implements java.io.Serializable {

    private de.affinis.pauline.hbm.PMassnahme selectedMassnahme;
    private de.affinis.pauline.hbm.PMassnahme editMassnahme;
    private List<de.affinis.pauline.hbm.PMassnahme> alleMassnahmen;
    private List<de.affinis.pauline.hbm.PMassnahme> massnahmeListKriterium;
    private PQKriterium kriterium;

    public PMassnahme getSelectedMassnahme() {
        return selectedMassnahme;
    }

    public void setSelectedMassnahme(PMassnahme selectedMassnahme) {
        this.selectedMassnahme = selectedMassnahme;
    }

    public PMassnahme getEditMassnahme() {
        return editMassnahme;
    }

    public void setEditMassnahme(PMassnahme editMassnahme) {
        this.editMassnahme = editMassnahme;
    }

    public List<PMassnahme> getAlleMassnahmen() {
        return alleMassnahmen;
    }

    public void setAlleMassnahmen(List<PMassnahme> alleMassnahmen) {
        this.alleMassnahmen = alleMassnahmen;
    }

    public List<PMassnahme> getMassnahmeListKriterium() {
        return massnahmeListKriterium;
    }

    public void setMassnahmeListKriterium(List<PMassnahme> massnahmeListKriterium) {
        this.massnahmeListKriterium = massnahmeListKriterium;
    }

    public PQKriterium getKriterium() {
        retreiveSourceKriterium();
        return kriterium;
    }

    public void setKriterium(PQKriterium kriterium) {
        this.kriterium = kriterium;
    }

    

    public List<de.affinis.pauline.hbm.PMassnahme> getActionListFromKriterium() {
        QKriteriumView kritView = (QKriteriumView) FacesAccessor.getQKriteriumView();
        PQKriterium krit = kritView.getSelectedKriterium();
        if (krit.equals(kriterium)) {
            return massnahmeListKriterium;
        } else {
            retreiveSourceKriterium();
            massnahmeListKriterium = new LinkedList<de.affinis.pauline.hbm.PMassnahme>();
            populateMassnahmeListKriterium(massnahmeListKriterium);
            return massnahmeListKriterium;
        }
    }

    private List<de.affinis.pauline.hbm.PMassnahme> filteredList;

    public List<de.affinis.pauline.hbm.PMassnahme> getFilteredList() {
        return filteredList;
    }

    public void setFilteredList(List<de.affinis.pauline.hbm.PMassnahme> filteredList) {
        this.filteredList = filteredList;
    }

    public void onRowToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Massnahme:",
                ((de.affinis.pauline.hbm.PMassnahme) event.getData()).getBeschreibung());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void createMassnahme(de.affinis.pauline.hbm.PMassnahme action) {
        Date date = new Date();
        QKriteriumView kritView = (QKriteriumView) FacesAccessor.getQKriteriumView();
        PUseraccount user = (PUseraccount) FacesAccessor.getCurrentUser();
        PQKriterium krit = kritView.getSelectedKriterium();
        action.setCreatedat(date);
        action.setModifiedat(date);
        action.setPUseraccountByCreatedby(user);
        action.setPUseraccountByModifiedby(user);
        action.setPQKriterium(krit);
        massnahmeListKriterium.add(action);
        MassnahmeDao.createPMassnahme(action);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Maßnahme:",
                action.getBeschreibung() + " wurde angelegt");

        FacesContext.getCurrentInstance().addMessage(null, msg);
        editMassnahme = new de.affinis.pauline.hbm.PMassnahme();
    }

    public void updateMassnahme(de.affinis.pauline.hbm.PMassnahme action) {
        PUseraccount user = (PUseraccount) FacesAccessor.getCurrentUser();
        action.setPUseraccountByModifiedby(user);
        action.setModifiedat(new Date());
        MassnahmeDao.updatePMassnahme(action);
    }

    public void deleteMassnahme(de.affinis.pauline.hbm.PMassnahme action) {
        massnahmeListKriterium.remove(action);
        MassnahmeDao.deletePMassnahme(action);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Maßnahme:",
                action.getBeschreibung() + " wurde gelöscht");

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Änderung verworfen", ((de.affinis.pauline.hbm.PMassnahme) event.getObject()).getBeschreibung());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onEdit(RowEditEvent event) {
        de.affinis.pauline.hbm.PMassnahme edit = (de.affinis.pauline.hbm.PMassnahme) event.getObject();
        updateMassnahme(edit);

        FacesMessage msg = new FacesMessage("Änderung erfolgreich gespeichert", ((de.affinis.pauline.hbm.PMassnahme) event.getObject()).getBeschreibung());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    private void populateMassnahmeListKriterium(List<de.affinis.pauline.hbm.PMassnahme> list) {
        retreiveSourceKriterium();
        List<de.affinis.pauline.hbm.PMassnahme> dList = MassnahmeDao.getMassNahmeKriterium(kriterium);
        if (!(dList == null)) {
            for (de.affinis.pauline.hbm.PMassnahme action : dList) {
                list.add(action);
            }
        }

    }

    private void populateAlleMassnahmen(List<de.affinis.pauline.hbm.PMassnahme> list) {
        List<de.affinis.pauline.hbm.PMassnahme> dList = MassnahmeDao.getAlleMassnahmen();
        for (de.affinis.pauline.hbm.PMassnahme qP : dList) {
            list.add(qP);
        }
    }

    private void retreiveSourceKriterium() {
        QKriteriumView kritView = (QKriteriumView) FacesAccessor.getQKriteriumView();
        kriterium = kritView.getSelectedKriterium();
    }

    public PMassnahmeView() {
        kriterium = new PQKriterium();
        selectedMassnahme = new de.affinis.pauline.hbm.PMassnahme();
        editMassnahme = new de.affinis.pauline.hbm.PMassnahme();
        alleMassnahmen = new LinkedList<de.affinis.pauline.hbm.PMassnahme>();
        massnahmeListKriterium = new LinkedList<de.affinis.pauline.hbm.PMassnahme>();
        populateAlleMassnahmen(alleMassnahmen);
        populateMassnahmeListKriterium(massnahmeListKriterium);
    }
}
