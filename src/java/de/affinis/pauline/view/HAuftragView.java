/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.view;

import de.affinis.pauline.dao.HAuftragDao;
import de.affinis.pauline.hbm.HAuftrag;
import de.affinis.pauline.hbm.PUseraccount;
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
public class HAuftragView implements java.io.Serializable  {

    public HAuftragView() {
        myAuftragList = new LinkedList<HAuftrag>();
        auftragList = new LinkedList<HAuftrag>();
        availableForMeAuftragList = new LinkedList<HAuftrag>();
        populateAuftragList(auftragList);
        populateMyAuftragList(myAuftragList);
        populateAvailableForMeAuftragList(availableForMeAuftragList);
    }
    private HAuftrag selectedHAuftrag;
    private List<HAuftrag> auftragList;
    private List<HAuftrag> myAuftragList;
    private List<HAuftrag> availableForMeAuftragList;

    public HAuftrag getSelectedHAuftrag() {
        return selectedHAuftrag;
    }

    public void setSelectedHAuftrag(HAuftrag selectedHAuftrag) {
        this.selectedHAuftrag = selectedHAuftrag;
    }

    public List<HAuftrag> getAuftragList() {
        return auftragList;
    }

    public void setAuftragList(List<HAuftrag> auftragList) {
        this.auftragList = auftragList;
    }

    public List<HAuftrag> getMyAuftragList() {
        return myAuftragList;
    }

    public void setMyAuftragList(List<HAuftrag> myAuftragList) {
        this.myAuftragList = myAuftragList;
    }

    public List<HAuftrag> getAvailableForMeAuftragList() {
        return availableForMeAuftragList;
    }

    public void setAvailableForMeAuftragList(List<HAuftrag> availableForMeAuftragList) {
        this.availableForMeAuftragList = availableForMeAuftragList;
    }

    private void populateMyAuftragList(List<HAuftrag> aList) {
        PUseraccount useraccount = (PUseraccount) FacesAccessor.getUser();
        List<HAuftrag> l = HAuftragDao.getMyAuftragList(useraccount);
        for (HAuftrag h : l) {
            aList.add(h);
        }
    }
    
    private void populateAvailableForMeAuftragList(List<HAuftrag> aList) {
        List<HAuftrag> l = HAuftragDao.getAvailableForMeAuftragList();
        for (HAuftrag h : l) {
            aList.add(h);
        }
    }
    
    private void populateAuftragList(List<HAuftrag> aList) {
        List<HAuftrag> l = HAuftragDao.getAuftragList();
        for (HAuftrag h : l) {
            aList.add(h);
        }
    }
}
