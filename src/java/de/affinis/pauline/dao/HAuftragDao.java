/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.dao;

import de.affinis.pauline.hbm.HAuftrag;
import de.affinis.pauline.hbm.PUseraccount;
import de.affinis.pauline.util.HibernateUtil;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marin Cordeleanu
 */
public class HAuftragDao {

    private static List<HAuftrag> auftragList;
    private static List<HAuftrag> myAuftragList;
    private static List<HAuftrag> availableForMeAuftragList;
    private static List<HAuftrag> auftragListInvolved;

    public static List<HAuftrag> getAuftragListInvolved(PUseraccount user) {

        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("select distinct ha from HAuftrag ha, HAuftragMitarbeiterAssignment hama where hama.HAuftrag = ha.hid and hama.mitarbeiter = :hid").setInteger("hid", user.getMitarbeiter().getHid());
            auftragListInvolved = (List<HAuftrag>) q.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return auftragListInvolved;
    }

    public static List<HAuftrag> getAuftragList() {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("from HAuftrag");
            auftragList = (List<HAuftrag>) q.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return auftragList;
    }

    public static List<HAuftrag> getMyAuftragList(PUseraccount useraccount) {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("select ha from HAuftrag ha, HAuftragMitarbeiterAssignment hama where hama.HAuftrag = ha.hid and hama.HSecurityrole = 9 and hama.mitarbeiter = :hid").setInteger("hid", useraccount.getMitarbeiter().getHid());
            myAuftragList = (List<HAuftrag>) q.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return myAuftragList;
    }

    public static List<HAuftrag> getAvailableForMeAuftragList() {
        List<HAuftrag> tempList = new LinkedList<HAuftrag>();
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();

            availableForMeAuftragList = myAuftragList;
            Query q = session.createQuery("select ha from HAuftrag ha, PQProjekt pq where ha.hid = pq.HAuftrag");
            tempList = (List<HAuftrag>) q.list();
            for (HAuftrag ha : tempList) {
                availableForMeAuftragList.remove(ha);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return availableForMeAuftragList;
    }
}
