package de.affinis.pauline.view;

import de.affinis.pauline.bb.MitarbeiterBean;
import de.affinis.pauline.hbm.Mitarbeiter;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.DualListModel;

@ManagedBean
@SessionScoped
public class PickListBean implements java.io.Serializable {

    private MitarbeiterBean mitarbeiterBean;
    private DualListModel<Mitarbeiter> mitarbeiter;

    public PickListBean() {

        List<Mitarbeiter> source = new ArrayList<Mitarbeiter>();
        List<Mitarbeiter> target = new ArrayList<Mitarbeiter>();


        MitarbeiterBean mitarbeiterBean1 = new MitarbeiterBean();
        source = mitarbeiterBean1.getMitarbeiterList();


        mitarbeiter = new DualListModel<Mitarbeiter>(source, target);
    }

    public DualListModel<Mitarbeiter> getMitarbeiter() {
        return mitarbeiter;
    }

    public void setMitarbeiter(DualListModel<Mitarbeiter> mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }
}
