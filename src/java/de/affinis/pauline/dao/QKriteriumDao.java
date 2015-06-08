/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.dao;

import de.affinis.pauline.hbm.PQKriterium;
import de.affinis.pauline.hbm.PQObjekt;
import de.affinis.pauline.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marin Cordeleanu
 */
public class QKriteriumDao {

    private static List<PQKriterium> alleKriterien;
    private static List<PQKriterium> qKriteriumListFromObjekt;

    public static List<PQKriterium> getQKriteriumListFromObjekt(PQObjekt pQObjekt) {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("from PQKriterium qk where qk.PQObjekt = :objekt").setInteger("objekt", pQObjekt.getHid());
            qKriteriumListFromObjekt = (List<PQKriterium>) q.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return qKriteriumListFromObjekt;
    }

    public static List<PQKriterium> getAlleKriterien() {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("from PQKriterium");
            alleKriterien = (List<PQKriterium>) q.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }

        return alleKriterien;
    }
    
    public static void createQKriterium(PQKriterium kriterium) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(kriterium);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public static void updateQKriterium(PQKriterium kriterium) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            trns = session.beginTransaction();
            session.update(kriterium);
            trns.commit();
        } catch (Exception e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void deleteQKriterium(PQKriterium kriterium) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            trns = session.beginTransaction();
            session.delete(kriterium);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }
}
