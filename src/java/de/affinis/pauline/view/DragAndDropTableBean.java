/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.view;

import de.affinis.pauline.bb.AuftragBean;
import de.affinis.pauline.hbm.HAuftrag;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.DragDropEvent;

/**
 *
 * @author Marin Cordeleanu
 */
@ManagedBean
@SessionScoped
public class DragAndDropTableBean implements Serializable {

    //@ManagedProperty(value = "#{pUseraccount}")
    //private PUseraccount pUseraccount; // +setter
    private AuftragBean auftragBean = new AuftragBean();
    private List<HAuftrag> hauftragsSmall;
    private List<HAuftrag> droppedHAuftrags;
    private HAuftrag selectedHAuftrag;

    public HAuftrag getSelectedHAuftrag() {
        return selectedHAuftrag;
    }

    public DragAndDropTableBean() {
        AuftragBean auftragBean = new AuftragBean();
        hauftragsSmall = auftragBean.getHAuftragList();
        droppedHAuftrags = new ArrayList<HAuftrag>();
    }
    
    public List<HAuftrag> getHauftragsSmall() {
        return hauftragsSmall;
    }

    public void onAuftragDrop(DragDropEvent ddEvent) {
        HAuftrag HAuftrag = ((HAuftrag) ddEvent.getData());

        droppedHAuftrags.add(HAuftrag);
        hauftragsSmall.remove(HAuftrag);
    }

    public List<HAuftrag> getDroppedHAuftrags() {
        return droppedHAuftrags;
    }
}
