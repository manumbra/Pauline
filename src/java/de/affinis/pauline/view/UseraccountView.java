/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.view;

import de.affinis.pauline.dao.UseraccountDao;
import de.affinis.pauline.hbm.PUseraccount;
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
public class UseraccountView implements java.io.Serializable {

    private PUseraccount editUseraccount;
    private PUseraccount selectedUseraccount;
    private List<PUseraccount> useraccountList;
    private List<PUseraccount> filteredList;

    public PUseraccount getEditUseraccount() {
        return editUseraccount;
    }

    public void setEditUseraccount(PUseraccount editUseraccount) {
        this.editUseraccount = editUseraccount;
    }

    public PUseraccount getSelectedUseraccount() {
        return selectedUseraccount;
    }

    public void setSelectedUseraccount(PUseraccount selectedUseraccount) {
        this.selectedUseraccount = selectedUseraccount;
    }

    public List<PUseraccount> getUseraccountList() {
        return useraccountList;
    }

    public void setUseraccountList(List<PUseraccount> useraccountList) {
        this.useraccountList = useraccountList;
    }

    public List<PUseraccount> getFilteredList() {
        return filteredList;
    }

    public void setFilteredList(List<PUseraccount> filteredList) {
        this.filteredList = filteredList;
    }

    public void createUseraccount(PUseraccount user) {
        user.setCreatedat(new Date());
        user.setModifiedat(new Date());
        useraccountList.add(user);
        UseraccountDao.createUseraccount(user);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "User:",
                user.getLogin() + " has been created");

        FacesContext.getCurrentInstance().addMessage(null, msg);
        editUseraccount = new PUseraccount();
    }

    public void updateUseraccount(PUseraccount useraccount) {
        useraccount.setModifiedat(new Date());
        UseraccountDao.updateUseraccount(useraccount);
    }

    public void deleteBenutzer(PUseraccount useraccount) {
        useraccountList.remove(useraccount);
        UseraccountDao.deleteUseraccount(useraccount);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Benutzer:",
                useraccount.getLogin() + " wurde gelöscht");

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Change Cancelled", ((PUseraccount) event.getObject()).getLogin() + "  " + ((PUseraccount) event.getObject()).getPasswd());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onEdit(RowEditEvent event) {
        PUseraccount edit = (PUseraccount) event.getObject();
        updateUseraccount(edit);
        FacesMessage msg = new FacesMessage("Change Successful", "Good job: " + ((PUseraccount) event.getObject()).getLogin() + "  " + ((PUseraccount) event.getObject()).getPasswd());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "User:",
                ((PUseraccount) event.getData()).getLogin());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    private void populateUseraccountList(List<PUseraccount> uList) {
        List<PUseraccount> g = UseraccountDao.getUseraccountList();
        for (PUseraccount u : g) {
            uList.add(u);
        }
    }

    public UseraccountView() {
        editUseraccount = new PUseraccount();
        useraccountList = new LinkedList<PUseraccount>();
        populateUseraccountList(useraccountList);
    }
}
