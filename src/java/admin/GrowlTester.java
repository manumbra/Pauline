/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import de.affinis.pauline.util.MessageUtil;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marin Cordeleanu
 */
@ManagedBean
@RequestScoped
public class GrowlTester  implements java.io.Serializable  {
    public void update() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", MessageUtil.displayMessage("registrationSuccessful")));
    }
}
