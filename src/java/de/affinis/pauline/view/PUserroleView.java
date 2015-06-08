/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.view;

import de.affinis.pauline.dao.PUserroleDao;
import de.affinis.pauline.hbm.PUserrole;
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
public class PUserroleView implements java.io.Serializable {

    List<PUserrole> PUserroleList;
    PUserrole selectedUserrole;

    public List<PUserrole> getPUserroleList() {
        return PUserroleList;
    }

    public void setPUserroleList(List<PUserrole> PUserroleList) {
        this.PUserroleList = PUserroleList;
    }

    public PUserrole getSelectedUserrole() {
        return selectedUserrole;
    }

    public void setSelectedUserrole(PUserrole selectedUserrole) {
        this.selectedUserrole = selectedUserrole;
    }

    public PUserroleView() {
        PUserroleList = new LinkedList<PUserrole>();
        populateUserrole(PUserroleList);
    }

    private void populateUserrole(List<PUserrole> userrole) {
        List<PUserrole> l = PUserroleDao.getUserroleList();
        for (PUserrole g : l) {
            userrole.add(g);
        }
    }
}
