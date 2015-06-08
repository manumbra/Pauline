/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.dao;

import de.affinis.pauline.hbm.HAuftrag;
import de.affinis.pauline.hbm.Mitarbeiter;
import de.affinis.pauline.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marin Cordeleanu
 */
public class MitarbeiterDao {

    private static List<Mitarbeiter> mitarbeiterList;
    private static List<Mitarbeiter> mitarbeiterListFromAuftrag;

    public static List<Mitarbeiter> getMitarbeiterList() {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("from Mitarbeiter");
            mitarbeiterList = (List<Mitarbeiter>) q.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return mitarbeiterList;
    }

    public static List<Mitarbeiter> getMitarbeiterListFromAuftrag(HAuftrag fromAuftrag) {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("select distinct m from Mitarbeiter m, HAuftragMitarbeiterAssignment hama where hama.mitarbeiter = m.hid and hama.HAuftrag = :auftrag").setInteger("auftrag", fromAuftrag.getHid());
            mitarbeiterListFromAuftrag = (List<Mitarbeiter>) q.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return mitarbeiterListFromAuftrag;
    }

}
