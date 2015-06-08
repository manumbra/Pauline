/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.view;

import de.affinis.pauline.dao.PStatusDao;
import de.affinis.pauline.dao.QObjektDao;
import de.affinis.pauline.dao.QProjektDao;
import de.affinis.pauline.hbm.PQObjekt;
import de.affinis.pauline.hbm.PQProjekt;
import de.affinis.pauline.hbm.PStatus;
import de.affinis.pauline.hbm.PUseraccount;
import de.affinis.pauline.util.FacesAccessor;
import java.math.BigDecimal;
import java.math.BigInteger;
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
public class QObjektView implements java.io.Serializable {

    private PQObjekt selectedQObjekt;
    private PQObjekt editQObjekt;
    private List<PQObjekt> allQObjektList;
    private List<PQObjekt> objektListFromProjekt;
    private PQProjekt fromProjekt;
    private BigDecimal restGewichtung;
    private boolean type;

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        
        this.type = type;
    }
    
    public void findType() {
        type = editQObjekt.getPQObjektVorlage().getHid() == 1;
        if (!type) {
            editQObjekt.setName(editQObjekt.getPQObjektVorlage().getName());
        }
    }
    
    public void findTask() {
        editQObjekt.setName(editQObjekt.getHAufgabe().getAufgabe());
    }
    
    

    public BigDecimal getRestGewichtung() {
        recalculateGewichtung();
        return restGewichtung;
    }

    public void setRestGewichtung(BigDecimal restGewichtung) {
        this.restGewichtung = restGewichtung;
    }

    public PQProjekt getFromProjekt() {
        retrieveSourceProjekt();
        return fromProjekt;
    }

    public void setFromProjekt(PQProjekt fromProjekt) {
        this.fromProjekt = fromProjekt;
    }

    public List<PQObjekt> getObjektListFromProjekt() {
        QProjektView proj = (QProjektView) FacesAccessor.getQProjektView();
        PQProjekt projekt = proj.getSelectedQProjekt();
        if (projekt.equals(fromProjekt)) {
            return objektListFromProjekt;
        } else {
            setFromProjekt(projekt);
            objektListFromProjekt = new LinkedList<PQObjekt>();
            populateObjektListFromProjekt(objektListFromProjekt);
            return objektListFromProjekt;
        }
    }

    public void setObjektListFromProjekt(List<PQObjekt> objektListFromProjekt) {
        this.objektListFromProjekt = objektListFromProjekt;
    }

    public PQObjekt getSelectedQObjekt() {
        return selectedQObjekt;
    }

    public void setSelectedQObjekt(PQObjekt selectedQObjekt) {
        this.selectedQObjekt = selectedQObjekt;
    }

    public PQObjekt getEditQObjekt() {
        return editQObjekt;
    }

    public void setEditQObjekt(PQObjekt editQObjekt) {
        this.editQObjekt = editQObjekt;
    }

    public List<PQObjekt> getAllQObjektList() {
        return allQObjektList;
    }

    public void setAllQObjektList(List<PQObjekt> allQObjektList) {
        this.allQObjektList = allQObjektList;
    }

    public List<PQObjekt> getFilteredList() {
        return filteredList;
    }

    public void setFilteredList(List<PQObjekt> filteredList) {
        this.filteredList = filteredList;
    }
    private List<PQObjekt> filteredList;

    public void createObjekt(PQObjekt objekt) {
        Date date = new Date();//assigns current date for createdat and modifiedat fields
        QProjektView projView = (QProjektView) FacesAccessor.getQProjektView();//gets the current project bean
        PQProjekt proj = projView.getSelectedQProjekt();//gets the currently selected project
        PUseraccount user = (PUseraccount) FacesAccessor.getCurrentUser();//gets the active user
        PStatus status = PStatusDao.getOpenStatus();
        objekt.setPUseraccountByCreatedby(user);//sets the user that created the object
        objekt.setPUseraccountByModifiedby(user);//sets the user that modified the object
        objekt.setModifiedat(date);//sets last modification date
        objekt.setCreatedat(date);//sets creation date
        objekt.setPQProjekt(proj);//assigns the newly created object a project
        objekt.setPStatus(status);
        objektListFromProjekt.add(objekt);//adds the object to the view
        QObjektDao.createPQObjekt(objekt);//persists the object into the database
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Qualitätsobjekt:",
                objekt.getName() + " wurde erstellt");//composes the message

        FacesContext.getCurrentInstance().addMessage(null, msg);//displays message
        editQObjekt = new PQObjekt();//erases the auxiliary variable for further use
    }

    public void updateObjekt(PQObjekt objekt) {
        PUseraccount user = (PUseraccount) FacesAccessor.getCurrentUser();
        objekt.setPUseraccountByModifiedby(user);
        objekt.setModifiedat(new Date());
        QObjektDao.updatePQObjekt(objekt);

        PQProjekt proj = objekt.getPQProjekt();
        QProjektView projView = (QProjektView) FacesAccessor.getQProjektView();
        projView.setMyQProjektList(QProjektDao.getMyQProjektList(proj.getPUseraccountByCreatedby()));

        recalculateBewertung();
    }

    private void recalculateBewertung() {
        BigDecimal o = new BigDecimal("0.00");
        for (PQObjekt objekt : objektListFromProjekt) {
            if (objekt.getQObjektBewertung() != null && objekt.getQObjektGewichtung() != null) {
                o = o.add(objekt.getQObjektBewertung().multiply(objekt.getQObjektGewichtung()));
            }
        }
        
        fromProjekt = QProjektDao.getProjektById(fromProjekt.getHid());
        fromProjekt.setQKeyFigure(o);
        QProjektDao.updatePQProjekt(fromProjekt);
        
        PUseraccount useraccount = (PUseraccount) FacesAccessor.getUser();
        QProjektView projView = (QProjektView) FacesAccessor.getQProjektView();
        projView.setMyQProjektList(QProjektDao.getMyQProjektList(useraccount));
        projView.setSelectedQProjekt(fromProjekt);
    }

    public void deleteObjekt(PQObjekt objekt) {
        objektListFromProjekt.remove(objekt);
        QObjektDao.deletePQObjekt(objekt);
        recalculateBewertung();
        recalculateGewichtung();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Qualitätsobjekt:",
                objekt.getName() + " wurde gelöscht");

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Qualitätsobjekt:",
                ((PQObjekt) event.getData()).getName());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Änderung verworfen", ((PQObjekt) event.getObject()).getName());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onEdit(RowEditEvent event) {
        PQObjekt edit = (PQObjekt) event.getObject();
        updateObjekt(edit);

        FacesMessage msg = new FacesMessage("Änderung erfolgreich gespeichert", ((PQObjekt) event.getObject()).getName());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    private void populateObjektListFromProjekt(List<PQObjekt> qObjektList) {
        QProjektView obj = (QProjektView) FacesAccessor.getQProjektView();
        PQProjekt projekt = obj.getSelectedQProjekt();
        List<PQObjekt> list = QObjektDao.objektListFromProjekt(projekt);
        for (PQObjekt objekt : list) {
            objektListFromProjekt.add(objekt);
        }
    }

    private void populateAllObjektList(List<PQObjekt> qObjektList) {
        List<PQObjekt> g = QObjektDao.getAllQObjektList();
        for (PQObjekt qP : g) {
            qObjektList.add(qP);
        }
    }

    public void recalculateGewichtung() {
        restGewichtung = new BigDecimal(BigInteger.ONE);
        for (PQObjekt krit : objektListFromProjekt) {
            if (krit.getQObjektGewichtung() != null) {
                restGewichtung = restGewichtung.subtract(krit.getQObjektGewichtung());
            }

        }
    }
    
    private void retrieveSourceProjekt() {
        QProjektView obj = (QProjektView) FacesAccessor.getQProjektView();
        fromProjekt = obj.getSelectedQProjekt();
    }

    public QObjektView() {
        editQObjekt = new PQObjekt();
        selectedQObjekt = new PQObjekt();
        allQObjektList = new LinkedList<PQObjekt>();
        objektListFromProjekt = new LinkedList<PQObjekt>();
        restGewichtung = new BigDecimal(BigInteger.ONE);
        populateAllObjektList(allQObjektList);
        populateObjektListFromProjekt(objektListFromProjekt);
    }
}
