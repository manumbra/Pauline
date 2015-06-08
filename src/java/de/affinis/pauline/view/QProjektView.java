/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.view;

import de.affinis.pauline.dao.QProjektDao;
import de.affinis.pauline.hbm.PQProjekt;
import de.affinis.pauline.hbm.PUseraccount;
import de.affinis.pauline.util.FacesAccessor;
import de.affinis.pauline.util.MessageUtil;
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
public class QProjektView implements java.io.Serializable {

    private PQProjekt selectedQProjekt;
    private PQProjekt editQProjekt;
    private List<PQProjekt> qProjektList;
    private List<PQProjekt> myQProjektList;

    public List<PQProjekt> getMyQProjektList() {
        return myQProjektList;
    }

    public void setMyQProjektList(List<PQProjekt> myQProjektList) {
        this.myQProjektList = myQProjektList;
    }
    private List<PQProjekt> filteredList;

    public PQProjekt getSelectedQProjekt() {
        return selectedQProjekt;
    }

    public void setSelectedQProjekt(PQProjekt selectedQProjekt) {
        this.selectedQProjekt = selectedQProjekt;
    }

    public PQProjekt getEditQProjekt() {
        return editQProjekt;
    }

    public void setEditQProjekt(PQProjekt editQProjekt) {
        this.editQProjekt = editQProjekt;
    }

    public List<PQProjekt> getQProjektList() {
        return qProjektList;
    }

    public void setQProjektList(List<PQProjekt> qProjektList) {
        this.qProjektList = qProjektList;
    }

    public List<PQProjekt> getFilteredList() {
        return filteredList;
    }

    public void setFilteredList(List<PQProjekt> filteredList) {
        this.filteredList = filteredList;
    }

    public void createQProjekt(PQProjekt pq) {
        PUseraccount useraccount = (PUseraccount) FacesAccessor.getUser();
        Date date = new Date();
        pq.setPUseraccountByCreatedby(useraccount);
        pq.setPUseraccountByModifiedby(useraccount);
        pq.setCreatedat(date);
        pq.setModifiedat(date);
        myQProjektList.add(pq);
        QProjektDao.createPQProjekt(pq);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Info:",
                "Qualitätsprojekt für den Auftrag " + pq.getHAuftrag().getName() + " wurde erstellt");

        FacesContext.getCurrentInstance().addMessage(null, msg);
        editQProjekt = new PQProjekt();
    }

    public void updateQProjekt(PQProjekt edit) {
        PUseraccount user = (PUseraccount) FacesAccessor.getCurrentUser();
        edit.setPUseraccountByModifiedby(user);
        edit.setModifiedat(new Date());
        QProjektDao.updatePQProjekt(edit);
    }

    public void deleteQProjekt(PQProjekt objekt) {
        myQProjektList.remove(objekt);
        QProjektDao.deletePQProjekt(objekt);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Qualitätsprojekt:",
                objekt.getHAuftrag().getName() + " wurde gelöscht");

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCancel(RowEditEvent event) {
        String s = MessageUtil.displayMessage("deltaVerworfen", ((PQProjekt) event.getObject()).getHAuftrag().getName());
        FacesMessage msg = new FacesMessage("Änderung verworfen", s);
        
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onEdit(RowEditEvent event) {
        PQProjekt edit = (PQProjekt) event.getObject();
        updateQProjekt(edit);

        FacesMessage msg = new FacesMessage("Änderung erfolgreich gespeichert", ((PQProjekt) event.getObject()).getHAuftrag().getName());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Qualitätsprojekt:",
                ((PQProjekt) event.getData()).getHAuftrag().getName());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    private void populateQProjektList(List<PQProjekt> qProjektList) {
        List<PQProjekt> g = QProjektDao.getPQProjekttList();
        for (PQProjekt qP : g) {
            qProjektList.add(qP);
        }
    }

    private void populateMyQProjektList(List<PQProjekt> qProjektList) {
        PUseraccount user = (PUseraccount) FacesAccessor.getCurrentUser();
        List<PQProjekt> mg = QProjektDao.getMyQProjektList(user);
        for (PQProjekt mQP : mg) {
            qProjektList.add(mQP);
        }
    }

    public QProjektView() {
        editQProjekt = new PQProjekt();
        selectedQProjekt = new PQProjekt();
        qProjektList = new LinkedList<PQProjekt>();
        myQProjektList = new LinkedList<PQProjekt>();
        populateQProjektList(qProjektList);
        populateMyQProjektList(myQProjektList);
    }
}
