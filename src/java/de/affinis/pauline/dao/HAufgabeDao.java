/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.dao;

import de.affinis.pauline.hbm.HAufgabe;
import de.affinis.pauline.hbm.HAuftrag;
import de.affinis.pauline.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marin Cordeleanu
 */
public class HAufgabeDao {

    private static List<HAufgabe> myAufgabenList;
    private static List<HAufgabe> aufgabenList;
    private static List<HAufgabe> aufgabenListFromHAuftrag;
    private static List<HAufgabe> availableAufgabenListFromHAuftrag;

    public static List<HAufgabe> getAufgabenList() {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("from HAufgabe");
            aufgabenList = (List<HAufgabe>) q.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }

        return aufgabenList;
    }

    public static List<HAufgabe> getAvailableAufgabenListFromHAuftrag(HAuftrag auftrag) {
        availableAufgabenListFromHAuftrag = getAufgabenListFromHAuftrag(auftrag);
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("select ha from HAufgabe ha, PQObjekt qo where qo.HAufgabe = ha.hid");
            List<HAufgabe> tempList = (List<HAufgabe>) q.list();
            for (HAufgabe ha : tempList){
                availableAufgabenListFromHAuftrag.remove(ha);
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }

        return availableAufgabenListFromHAuftrag;
    }

    public static List<HAufgabe> getAufgabenListFromHAuftrag(HAuftrag auftrag) {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("select ha from HAufgabe ha where ha.HAuftrag = :auftrag").setInteger("auftrag", auftrag.getHid());
            aufgabenListFromHAuftrag = (List<HAufgabe>) q.list();
            
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }

        return aufgabenListFromHAuftrag;
    }
    
    
}
