/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.dao;

import de.affinis.pauline.hbm.PQProjekt;
import de.affinis.pauline.hbm.PUseraccount;
import de.affinis.pauline.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marin Cordeleanu
 */
public class QProjektDao {

    private static List<PQProjekt> qProjektList;
    private static List<PQProjekt> myQProjektList;
    private static PQProjekt projekt;
    private static List<PQProjekt> projektListInvolved;

    public static List<PQProjekt> getProjektListInvolved(PUseraccount user) {

        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("select distinct qp from PQProjekt pq, HAuftrag ha, HAuftragMitarbeiterAssignment hama "
                    + "where qp.HAuftrag = hama.HAuftrag and hama.mitarbeiter = :hid");
            q.setInteger("hid", user.getMitarbeiter().getHid());
            projektListInvolved = (List<PQProjekt>) q.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return projektListInvolved;
    }

    public static PQProjekt getProjektById(int hid) {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        projekt = null;
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("from PQProjekt where hid = :id").setInteger("id", hid);
            if (1 == q.list().size()) {
                projekt = (PQProjekt) q.list().get(0);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return projekt;
    }

    public static List<PQProjekt> getMyQProjektList(PUseraccount user) {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("from PQProjekt where createdby = :user").setInteger("user", user.getHid());
            myQProjektList = (List<PQProjekt>) q.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return myQProjektList;
    }

    public static void setMyQProjektList(List<PQProjekt> myQProjektList) {
        QProjektDao.myQProjektList = myQProjektList;
    }

    public static List<PQProjekt> getPQProjekttList() {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("from PQProjekt");
            qProjektList = (List<PQProjekt>) q.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return qProjektList;
    }

    public static void setPQProjektList(List<PQProjekt> useraccountList) {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            for (PQProjekt qP : qProjektList) {
                session.saveOrUpdate(qP);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void createPQProjekt(PQProjekt qProjekt) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(qProjekt);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void updatePQProjekt(PQProjekt qProjekt) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(qProjekt);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void deletePQProjekt(PQProjekt qProjekt) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(qProjekt);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
}
