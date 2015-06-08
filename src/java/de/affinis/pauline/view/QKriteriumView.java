/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.view;

import de.affinis.pauline.dao.QKriteriumDao;
import de.affinis.pauline.dao.QObjektDao;
import de.affinis.pauline.dao.QProjektDao;
import de.affinis.pauline.hbm.PQKriterienVorlage;
import de.affinis.pauline.hbm.PQKriterium;
import de.affinis.pauline.hbm.PQObjekt;
import de.affinis.pauline.hbm.PQProjekt;
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
import javax.faces.event.ActionEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.ToggleEvent;

/**
 *
 * @author Marin Cordeleanu
 */
@ManagedBean
@SessionScoped
public class QKriteriumView implements java.io.Serializable {

    private PQKriterium selectedKriterium;
    private PQKriterium editKriterium;
    private List<PQKriterium> alleKriterien;
    private List<PQKriterium> kriteriumListFromObjekt;
    private PQObjekt fromObjekt;
    private PQProjekt fromProjekt;

    public PQProjekt getFromProjekt() {
        retrieveSourceProjekt();
        return fromProjekt;
    }

    public void setFromProjekt(PQProjekt fromProjekt) {
        this.fromProjekt = fromProjekt;
    }
    private BigDecimal restGewichtung;
    private boolean skip;

    public BigDecimal getRestGewichtung() {
        recalculateGewichtung();
        return restGewichtung;
    }

    public void setRestGewichtung(BigDecimal restGewichtung) {
        this.restGewichtung = restGewichtung;
    }

    public PQObjekt getFromObjekt() {
        retrieveSourceObjekt();
        return fromObjekt;
    }

    public void setFromObjekt(PQObjekt fromObjekt) {
        this.fromObjekt = fromObjekt;
    }

    public PQKriterium getSelectedKriterium() {
        return selectedKriterium;
    }

    public void setSelectedKriterium(PQKriterium selectedKriterium) {
        this.selectedKriterium = selectedKriterium;
    }

    public PQKriterium getEditKriterium() {
        return editKriterium;
    }

    public void setEditKriterium(PQKriterium editKriterium) {
        this.editKriterium = editKriterium;
    }

    public List<PQKriterium> getAlleKriterien() {
        return alleKriterien;
    }

    public void setAlleKriterien(List<PQKriterium> alleKriterien) {
        this.alleKriterien = alleKriterien;
    }

    public List<PQKriterium> getKriteriumListFromObjekt() {
        QObjektView obj = (QObjektView) FacesAccessor.getQObjektView();
        PQObjekt objekt = obj.getSelectedQObjekt();
        if (objekt.equals(fromObjekt)) {
            return kriteriumListFromObjekt;
        } else {
            retrieveSourceObjekt();
            kriteriumListFromObjekt = new LinkedList<PQKriterium>();
            populateKriteriumListFromObjekt(kriteriumListFromObjekt);
            return kriteriumListFromObjekt;
        }
    }

    public void setKriteriumListFromObjekt(List<PQKriterium> kriteriumListFromObjekt) {
        this.kriteriumListFromObjekt = kriteriumListFromObjekt;
    }
    private List<PQKriterium> filteredList;

    public List<PQKriterium> getFilteredList() {
        return filteredList;
    }

    public void setFilteredList(List<PQKriterium> filteredList) {
        this.filteredList = filteredList;
    }

    public void onRowToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "PQKriterium:",
                ((PQKriterium) event.getData()).getPQKriterienVorlage().getBeschreibung());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void createKriterium(PQKriterium kriterium) {
        Date date = new Date();
        retrieveSourceObjekt();
        QKriterienVorlageView kritVorlageView = (QKriterienVorlageView) FacesAccessor.getQKriterienVorlageView();
        PQKriterienVorlage kritVorlage = kritVorlageView.getSelectedKriterienVorlage();
        kriterium.setPQKriterienVorlage(kritVorlage);
        PUseraccount user = (PUseraccount) FacesAccessor.getCurrentUser();
        kriterium.setPUseraccountByCreatedby(user);
        kriterium.setPUseraccountByModifiedby(user);
        kriterium.setModifiedat(date);
        kriterium.setCreatedat(date);
        kriterium.setPQObjekt(fromObjekt);
        kriteriumListFromObjekt.add(kriterium);
        QKriteriumDao.createQKriterium(kriterium);
        recalculateBewertung();
        recalculateGewichtung();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Kriterium:",
                kriterium.getPQKriterienVorlage().getName() + " wurde angelegt");

        FacesContext.getCurrentInstance().addMessage(null, msg);
        editKriterium = new PQKriterium();
    }

    private void recalculateGewichtung() {
        restGewichtung = new BigDecimal(BigInteger.ONE);
        for (PQKriterium krit : kriteriumListFromObjekt) {
            if (krit.getQKriteriumGewichtung() != null) {
                restGewichtung = restGewichtung.subtract(krit.getQKriteriumGewichtung());
            }

        }
    }

    private void recalculateBewertung() {
        BigDecimal i = new BigDecimal("0.00");
        for (PQKriterium krit : kriteriumListFromObjekt) {
            if (krit.getQKriteriumBewertung() != null && krit.getQKriteriumGewichtung() != null) {
                i = i.add(krit.getQKriteriumBewertung().multiply(krit.getQKriteriumGewichtung()));
            }
        }

        fromObjekt = QObjektDao.getPQObjektById(fromObjekt.getHid());
        fromObjekt.setQObjektBewertung(i);
        QObjektDao.updatePQObjekt(fromObjekt);

        QObjektView objView = (QObjektView) FacesAccessor.getQObjektView();
        objView.setObjektListFromProjekt(QObjektDao.objektListFromProjekt(fromProjekt));
        objView.setSelectedQObjekt(fromObjekt);


        List<PQObjekt> objektList = objView.getObjektListFromProjekt();


        BigDecimal o = new BigDecimal("0.00");
        for (PQObjekt objekt : objektList) {
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

    public void updateKriterium(PQKriterium kriterium) {
        PUseraccount user = (PUseraccount) FacesAccessor.getCurrentUser();
        kriterium.setPUseraccountByModifiedby(user);
        kriterium.setModifiedat(new Date());
        QKriteriumDao.updateQKriterium(kriterium);
        recalculateBewertung();
        recalculateGewichtung();

    }

    public void deleteKriterium(PQKriterium kriterium) {
        kriteriumListFromObjekt.remove(kriterium);
        QKriteriumDao.deleteQKriterium(kriterium);
        recalculateBewertung();
        recalculateGewichtung();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Kriterium:",
                kriterium.getPQKriterienVorlage().getName() + " wurde gelöscht");

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Änderung verworfen", ((PQKriterium) event.getObject()).getPQKriterienVorlage().getName());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onEdit(RowEditEvent event) {
        PQKriterium edit = (PQKriterium) event.getObject();
        updateKriterium(edit);

        FacesMessage msg = new FacesMessage("Änderung erfolgreich gespeichert", ((PQKriterium) event.getObject()).getPQKriterienVorlage().getName());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    private void populateKriteriumListFromObjekt(List<PQKriterium> qKriteriumList) {
        retrieveSourceObjekt();
        List<PQKriterium> list = QKriteriumDao.getQKriteriumListFromObjekt(fromObjekt);
        if (null != list) {
            for (PQKriterium kriterium : list) {
                qKriteriumList.add(kriterium);
            }

        }
    }

    private void populateAlleKriterien(List<PQKriterium> qKriteriumList) {
        List<PQKriterium> g = QKriteriumDao.getAlleKriterien();
        for (PQKriterium qP : g) {
            qKriteriumList.add(qP);
        }
    }

    private void retrieveSourceObjekt() {
        QObjektView obj = (QObjektView) FacesAccessor.getQObjektView();
        fromObjekt = obj.getSelectedQObjekt();
    }

    private void retrieveSourceProjekt() {
        QProjektView obj = (QProjektView) FacesAccessor.getQProjektView();
        fromProjekt = obj.getSelectedQProjekt();
    }

    public void save(ActionEvent actionEvent) {
        createKriterium(editKriterium);
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {

        if (skip) {
            skip = false;   //reset in case user goes back  
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }

    public QKriteriumView() {
        fromObjekt = new PQObjekt();
        retrieveSourceObjekt();
        fromProjekt = new PQProjekt();
        retrieveSourceProjekt();
        selectedKriterium = new PQKriterium();
        editKriterium = new PQKriterium();
        alleKriterien = new LinkedList<PQKriterium>();
        kriteriumListFromObjekt = new LinkedList<PQKriterium>();
        populateAlleKriterien(alleKriterien);
        populateKriteriumListFromObjekt(kriteriumListFromObjekt);
    }
}
