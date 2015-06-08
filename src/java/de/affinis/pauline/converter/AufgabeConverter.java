/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.converter;

import de.affinis.pauline.dao.HAufgabeDao;
import de.affinis.pauline.hbm.HAufgabe;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Marin Cordeleanu
 */
@FacesConverter(value = "AufgabeConverter")
public class AufgabeConverter implements Converter {
    
    public static List<HAufgabe> aufgabeDB;
    
    static{
       aufgabeDB = HAufgabeDao.getAufgabenList();
    }
    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("")){
            return null;
        } else {
            try {
                for (HAufgabe h : aufgabeDB) {
                    if (h.getAufgabe().equals(value)){
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
            name = String.valueOf(((HAufgabe) value).getAufgabe());
            return name;
        }
        
    }
    
}
