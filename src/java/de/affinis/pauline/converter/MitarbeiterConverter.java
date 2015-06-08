package de.affinis.pauline.converter;

import de.affinis.pauline.dao.MitarbeiterDao;
import de.affinis.pauline.hbm.Mitarbeiter;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class MitarbeiterConverter implements Converter {

    public static List<Mitarbeiter> mitarbeiterDB;

    static {
        mitarbeiterDB = MitarbeiterDao.getMitarbeiterList();
    }

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
        if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                for (Mitarbeiter m : mitarbeiterDB) {
                    String s = m.getVorname() + " " + m.getName();
                    if (s.equals(submittedValue)) {
                        return m;
                    }
                }

            } catch (NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid mitarbeiter"));
            }
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            String vollName = "";
            vollName = String.valueOf(((Mitarbeiter) value).getVorname()) +" "+ String.valueOf(((Mitarbeiter) value).getName());
            return vollName;
        }
    }
}
