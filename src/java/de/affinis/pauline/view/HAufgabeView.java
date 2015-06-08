/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.view;

import de.affinis.pauline.dao.HAufgabeDao;
import de.affinis.pauline.hbm.HAufgabe;
import de.affinis.pauline.hbm.HAuftrag;
import de.affinis.pauline.hbm.PQProjekt;
import de.affinis.pauline.util.FacesAccessor;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Marin Cordeleanu
 */
@ManagedBean
@ViewScoped
public class HAufgabeView implements java.io.Serializable {

    public HAufgabeView() {
        availableAufgabenListFromHAuftrag = new LinkedList<HAufgabe>();
        aufgabenList = new LinkedList<HAufgabe>();
        aufgabenListFromHAuftrag = new LinkedList<HAufgabe>();
        populateAvailableAufgabenListFromHAuftrag(availableAufgabenListFromHAuftrag);
        populateAufgabenList(aufgabenList);
        populateAufgabenListFromHAuftrag(aufgabenListFromHAuftrag);
    }
    private HAufgabe selectedHAufgabe;
    private List<HAufgabe> aufgabenList;
    private List<HAufgabe> myAufgabenList;
    private List<HAufgabe> aufgabenListFromHAuftrag;
    private List<HAufgabe> availableAufgabenListFromHAuftrag;

    public List<HAufgabe> getAvailableAufgabenListFromHAuftrag() {
        List<HAufgabe> list = new LinkedList<HAufgabe>();
        populateAvailableAufgabenListFromHAuftrag(list);
        availableAufgabenListFromHAuftrag = list;
        return availableAufgabenListFromHAuftrag;
    }

    public void setAvailableAufgabenListFromHAuftrag(List<HAufgabe> availableAufgabenListFromHAuftrag) {
        this.availableAufgabenListFromHAuftrag = availableAufgabenListFromHAuftrag;
    }

    public HAufgabe getSelectedHAufgabe() {
        return selectedHAufgabe;
    }

    public void setSelectedHAufgabe(HAufgabe selectedHAufgabe) {
        this.selectedHAufgabe = selectedHAufgabe;
    }

    public List<HAufgabe> getAufgabenList() {
        return aufgabenList;
    }

    public void setAufgabenList(List<HAufgabe> aufgabenList) {
        this.aufgabenList = aufgabenList;
    }

    public List<HAufgabe> getMyAufgabenList() {
        return myAufgabenList;
    }

    public void setMyAufgabenList(List<HAufgabe> myAufgabenList) {
        this.myAufgabenList = myAufgabenList;
    }

    public List<HAufgabe> getAufgabenListFromHAuftrag() {
        return aufgabenListFromHAuftrag;
    }

    public void setAufgabenListFromHAuftrag(List<HAufgabe> aufgabenListFromHAuftrag) {
        this.aufgabenListFromHAuftrag = aufgabenListFromHAuftrag;
    }

    private void populateAvailableAufgabenListFromHAuftrag(List<HAufgabe> aList) {
        QProjektView obj = (QProjektView) FacesAccessor.getQProjektView();
        PQProjekt projekt = obj.getSelectedQProjekt();
        HAuftrag auftrag = projekt.getHAuftrag();
        List<HAufgabe> l = HAufgabeDao.getAvailableAufgabenListFromHAuftrag(auftrag);
        for (HAufgabe h : l) {
            aList.add(h);
        }
    }

    private void populateAufgabenListFromHAuftrag(List<HAufgabe> aList) {
        QProjektView obj = (QProjektView) FacesAccessor.getQProjektView();
        PQProjekt projekt = obj.getSelectedQProjekt();
        HAuftrag auftrag = projekt.getHAuftrag();
        List<HAufgabe> l = HAufgabeDao.getAufgabenListFromHAuftrag(auftrag);
        for (HAufgabe h : l) {
            aList.add(h);
        }
    }

    private void populateAufgabenList(List<HAufgabe> aList) {
        List<HAufgabe> l = HAufgabeDao.getAufgabenList();
        for (HAufgabe h : l) {
            aList.add(h);
        }
    }
}
