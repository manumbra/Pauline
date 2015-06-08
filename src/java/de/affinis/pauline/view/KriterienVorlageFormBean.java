/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.view;

import de.affinis.pauline.dao.QKriterienVorlageDao;
import de.affinis.pauline.dao.QObjektVorlageDao;
import de.affinis.pauline.hbm.PQKriterienVorlage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

/**
 *
 * @author Marin Cordeleanu
 */
@ManagedBean
@ViewScoped
public class KriterienVorlageFormBean implements Serializable{

    private List<SelectItem> kritVorlage;

    public List<SelectItem> getKritVorlage() {
        return kritVorlage;
    }

    public void setKritVorlage(List<SelectItem> kritVorlage) {
        this.kritVorlage = kritVorlage;
    }
    

    public KriterienVorlageFormBean() {
        kritVorlage = new ArrayList<SelectItem>();
        for (int i=0; i< QObjektVorlageDao.getAlleObjektVorlagen().size(); i++) {
            int k = i+1;
            List<PQKriterienVorlage> list = QKriterienVorlageDao.getKritForObjektTyp(k);
            SelectItemGroup g = new SelectItemGroup(list.get(0).getPQObjektVorlage().getName());
            SelectItem[] array = new SelectItem[list.size()];
            for (int j =0; j<list.size(); j++) {
                array[j] = new SelectItem(list.get(j), list.get(j).getName()); 
            }
            g.setSelectItems(array);
            
            kritVorlage.add(g);
        }
        
    }
}
