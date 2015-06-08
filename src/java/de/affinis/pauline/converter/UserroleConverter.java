/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.converter;

import de.affinis.pauline.dao.PUserroleDao;
import de.affinis.pauline.hbm.PUserrole;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 *
 * @author Marin Cordeleanu
 */

public class UserroleConverter implements Converter {
    
    public static List<PUserrole> puserroleDB;
    
    static{
       puserroleDB = PUserroleDao.getUserroleList();
    }
    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("")){
            return null;
        } else {
            try {
                for (PUserrole h : puserroleDB) {
                    if (h.getRole().equals(value)){
                        return h;
                    }
                    
                }
            } catch (NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Kein valider Auftrag"));
            }
            
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            String name = "";
            name = String.valueOf(((PUserrole) value).getRole());
            return name;
        }
        
    }
    
}
