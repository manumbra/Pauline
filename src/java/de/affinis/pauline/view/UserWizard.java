/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.view;

import de.affinis.pauline.dao.UseraccountDao;
import de.affinis.pauline.hbm.PUseraccount;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Marin Cordeleanu
 */
@ManagedBean
@ViewScoped
public class UserWizard implements java.io.Serializable {

    private PUseraccount user = new PUseraccount();
    private boolean skip;

    public PUseraccount getUser() {
        return user;
    }

    public void setUser(PUseraccount user) {
        this.user = user;
    }

    public void save(ActionEvent actionEvent) {
        UseraccountDao.createUseraccount(user);

        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + user.getLogin());
        FacesContext.getCurrentInstance().addMessage(null, msg);
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
}
