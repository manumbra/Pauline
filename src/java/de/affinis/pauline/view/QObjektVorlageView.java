/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.view;

import de.affinis.pauline.dao.QObjektVorlageDao;
import de.affinis.pauline.hbm.PQObjektVorlage;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marin Cordeleanu
 */
@ManagedBean
@SessionScoped
public class QObjektVorlageView implements java.io.Serializable {

    private PQObjektVorlage selectedObjektVorlage;
    private PQObjektVorlage editObjektVorlage;
    private List<PQObjektVorlage> alleObjektVorlagen;



    public PQObjektVorlage getSelectedObjektVorlage() {
        return selectedObjektVorlage;
    }

    public void setSelectedObjektVorlage(PQObjektVorlage selectedObjektVorlage) {
        this.selectedObjektVorlage = selectedObjektVorlage;
    }

    public PQObjektVorlage getEditObjektVorlage() {
        return editObjektVorlage;
    }

    public void setEditObjektVorlage(PQObjektVorlage editObjektVorlage) {
        this.editObjektVorlage = editObjektVorlage;
    }

    public List<PQObjektVorlage> getAlleObjektVorlagen() {
        return alleObjektVorlagen;
    }

    public void setAlleObjektVorlagen(List<PQObjektVorlage> alleObjektVorlagen) {
        this.alleObjektVorlagen = alleObjektVorlagen;
    }
    private List<PQObjektVorlage> filteredList;

    public List<PQObjektVorlage> getFilteredList() {
        return filteredList;
    }

    public void setFilteredList(List<PQObjektVorlage> filteredList) {
        this.filteredList = filteredList;
    }


    private void populateAlleKriterienVorlagen(List<PQObjektVorlage> qObjektVorlageList) {
        List<PQObjektVorlage> g = QObjektVorlageDao.getAlleObjektVorlagen();
        for (PQObjektVorlage qOV : g) {
            qObjektVorlageList.add(qOV);
        }
    }
    

    public QObjektVorlageView() {
        selectedObjektVorlage = new PQObjektVorlage();
        editObjektVorlage = new PQObjektVorlage();
        alleObjektVorlagen = new LinkedList<PQObjektVorlage>();
        populateAlleKriterienVorlagen(alleObjektVorlagen);
    }

   
}
