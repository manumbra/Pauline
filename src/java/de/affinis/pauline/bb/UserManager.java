/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.bb;

import de.affinis.pauline.dao.UseraccountDao;
import de.affinis.pauline.hbm.PQProjekt;
import de.affinis.pauline.hbm.PUseraccount;
import de.affinis.pauline.util.FacesAccessor;
import de.affinis.pauline.view.QProjektView;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name = "UserManager")
@SessionScoped
public class UserManager implements java.io.Serializable {

    @ManagedProperty(value = "0")
    private int sessionCounter;
    private boolean qualitManagerInProjekt;
    private boolean qualitVerantwortlicherInProjekt;
    private boolean engagedInProjekt;
    private boolean admin;
    private boolean developer;
    private boolean manager;
    private boolean consultant;
    private boolean customer;
    private boolean dam; // is developer/admin/manager
    private PUseraccount PUseraccount;
    private PQProjekt qualitProjekt;
    private boolean intern;

    public boolean isIntern() {
        intern = !isCustomer();
        return intern;
    }

    public void setIntern(boolean intern) {
        this.intern = intern;
    }

    public boolean isDam() {
        if (1 == sessionCounter) {
            dam = isAdmin() || isDeveloper() || isManager();
        }
        return dam;
    }

    public void setDam(boolean dam) {
        this.dam = dam;
    }

    public boolean isAdmin() {
        if (2 == PUseraccount.getPUserrole().getHid()) {
            admin = true;
        } else {
            admin = false;
        }
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isDeveloper() {
        if (1 == PUseraccount.getPUserrole().getHid()) {
            developer = true;
        } else {
            developer = false;
        }
        return developer;
    }

    public void setDeveloper(boolean developer) {
        this.developer = developer;
    }

    public boolean isManager() {
        if (3 == PUseraccount.getPUserrole().getHid()) {
            manager = true;
        } else {
            manager = false;
        }
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public boolean isConsultant() {
        if (4 == PUseraccount.getPUserrole().getHid()) {
            consultant = true;
        } else {
            consultant = false;
        }
        return consultant;
    }

    public void setConsultant(boolean consultant) {
        this.consultant = consultant;
    }

    public boolean isCustomer() {
        if (5 == PUseraccount.getPUserrole().getHid()) {
            customer = true;
        } else {
            customer = false;
        }
        return customer;
    }

    public void setCustomer(boolean customer) {
        this.customer = customer;
    }

    public PQProjekt getQualitProjekt() {
        return qualitProjekt;
    }

    public void setQualitProjekt(PQProjekt qualitProjekt) {
        this.qualitProjekt = qualitProjekt;
    }

    public PUseraccount retrieveCurrentUser() {
        PUseraccount = (PUseraccount) FacesAccessor.getCurrentUser();
        return PUseraccount;
    }

    public String goToDashBoard() {
        return PUseraccount.getPUserrole().getRk() + "-dashboard";
    }

    public boolean isQualitVerantwortlicherInProjekt() {
        QProjektView projView = (QProjektView) FacesAccessor.getQProjektView();
        PQProjekt proj = projView.getSelectedQProjekt();
        qualitVerantwortlicherInProjekt = UseraccountDao.isQualitVerantwortlicherInProjekt(PUseraccount, proj);
        return qualitVerantwortlicherInProjekt;
    }

    public void setQualitVerantwortlicherInProjekt(boolean qualitVerantwortlicherInProjekt) {
        this.qualitVerantwortlicherInProjekt = qualitVerantwortlicherInProjekt;
    }

    public boolean isQualitManagerInProjekt() {
        QProjektView projView = (QProjektView) FacesAccessor.getQProjektView();
        PQProjekt proj = projView.getSelectedQProjekt();
        qualitManagerInProjekt = UseraccountDao.isQualitManagerInProjekt(PUseraccount, proj);
        return qualitManagerInProjekt;
    }

    public void setQualitManagerInProjekt(boolean qualitManagerInProjekt) {
        this.qualitManagerInProjekt = qualitManagerInProjekt;
    }

    public boolean isEngagedInProjekt() {
        return engagedInProjekt;
    }

    public void setEngagedInProjekt(boolean engagedInProjekt) {
        this.engagedInProjekt = engagedInProjekt;
    }

    public PUseraccount getPUseraccount() {
        return PUseraccount;
    }

    public void setPUseraccount(PUseraccount PUseraccount) {
        this.PUseraccount = PUseraccount;
    }

    public UserManager() {
        PUseraccount = new PUseraccount();
        qualitManagerInProjekt = false;
        qualitVerantwortlicherInProjekt = false;
        engagedInProjekt = false;
    }

    public int getSessionCounter() {
        return sessionCounter;
    }

    public void setSessionCounter(int sessionCounter) {
        this.sessionCounter = sessionCounter;
    }

    public void incrementSessionCounter() {
        this.sessionCounter++;
    }

    public void decrementSessionCounter() {
        this.sessionCounter--;
    }

    public String navigate() {
        if (null == PUseraccount.getPUserrole()) {
            return validatePUseraccount().getPUserrole().getRole();
        } else {
            return "home";
        }

    }

    public String login() {
        validatePUseraccount();
        if (null == PUseraccount.getHid()) {
            return "home";
        } else {
            return PUseraccount.getPUserrole().getRk();
        }
    }

    public void logout() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.invalidateSession();
        ec.redirect("../faces/home.xhtml");
        this.decrementSessionCounter();
    }

    public PUseraccount validatePUseraccount() {
        if (null == UseraccountDao.validatePUseraccount(PUseraccount.getLogin(), PUseraccount.getPasswd())) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Login Failed", "Benutzer " + PUseraccount.getLogin() + " existiert nicht, oder das angegebene Passwort ist falsch!"));
        } else {
            PUseraccount = UseraccountDao.validatePUseraccount(PUseraccount.getLogin(), PUseraccount.getPasswd());
            this.incrementSessionCounter();
        }
        return PUseraccount;
    }
}
