/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.dao;

import de.affinis.pauline.hbm.PQObjekt;
import de.affinis.pauline.hbm.PQProjekt;
import de.affinis.pauline.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marin Cordeleanu
 */
public class QObjektDao {
    private static List<PQObjekt> allQObjektList;
    private static List<PQObjekt> qObjektListFromProjekt;
    private static PQObjekt randomObjekt;

    public static PQObjekt getRandomObjekt() {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("from PQObjekt");
            List<PQObjekt> list = (List<PQObjekt>) q.list();
            randomObjekt = list.get(0);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return randomObjekt;
    }
    
    
    
    public static List<PQObjekt> objektListFromProjekt(PQProjekt pQProjekt){
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("from PQObjekt qo where qo.PQProjekt = :projekt").setInteger("projekt", pQProjekt.getHid());
            qObjektListFromProjekt = (List<PQObjekt>) q.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return qObjektListFromProjekt;
    }

    public static List<PQObjekt> getAllQObjektList() {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("from PQObjekt");
            allQObjektList = (List<PQObjekt>) q.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        
        return allQObjektList;
    }

    public static void setAllQObjektList(List<PQObjekt> allQObjektList) {
        QObjektDao.allQObjektList = allQObjektList;
    }

    public static void createPQObjekt(PQObjekt pQObjekt) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(pQObjekt);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
    
    
    
    public static PQObjekt getPQObjektById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        PQObjekt objekt = null;
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("from PQObjekt qo where qo.hid = :id").setInteger("id", id);
            objekt = (PQObjekt) q.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return objekt;
    }
    
    public static void updatePQObjekt(PQObjekt pQObjekt) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(pQObjekt);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public static void deletePQObjekt(PQObjekt pQObjekt) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(pQObjekt);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    
}
