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
public class UseraccountDao {

    private static List<PUseraccount> useraccountList;
    private static PUseraccount user;

    public static PUseraccount getUser() {
        return user;
    }

    public static List<PUseraccount> getUseraccountList() {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("from PUseraccount");
            useraccountList = (List<PUseraccount>) q.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return useraccountList;
    }

    public static PUseraccount findUserByLogin(String username) {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("select u from PUseraccount u where u.login");
            user = (PUseraccount) q.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }

    public static void setUseraccountList(List<PUseraccount> useraccountList) {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            for (PUseraccount u : useraccountList) {
                session.saveOrUpdate(u);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void createUseraccount(PUseraccount user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void updateUseraccount(PUseraccount useraccount) {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            session.update(useraccount);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteUseraccount(PUseraccount useraccount) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            trns = session.beginTransaction();
            session.delete(useraccount);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
    }

    public static boolean isQualitManagerInProjekt(PUseraccount user, PQProjekt projekt) {
        boolean b = false;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            trns = session.beginTransaction();

            Query q = session.createQuery("select hama from HAuftragMitarbeiterAssignment hama "
                    + "where hama.mitarbeiter = :mID and hama.HAuftrag = :aID and hama.HSecurityrole = :sID");
            q.setInteger("mID", user.getMitarbeiter().getHid());
            q.setInteger("aID", projekt.getHAuftrag().getHid());
            q.setInteger("sID", 8);
            List<PUseraccount> list = (List<PUseraccount>) q.list();
            b = 0 != list.size();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
        return b;
    }

    public static boolean isQualitVerantwortlicherInProjekt(PUseraccount user, PQProjekt projekt) {
        boolean b = false;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            trns = session.beginTransaction();
            Query q = session.createQuery("select hama from HAuftragMitarbeiterAssignment hama "
                    + "where hama.mitarbeiter = :mID and hama.HAuftrag = :aID and hama.HSecurityrole = :sID");
            q.setInteger("mID", user.getMitarbeiter().getHid());
            q.setInteger("aID", projekt.getHAuftrag().getHid());
            q.setInteger("sID", 9);
            List<PUseraccount> list = (List<PUseraccount>) q.list();
            b = 0 != list.size();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        }
        return b;
    }

    public static PUseraccount validatePUseraccount(String login, String password) {
        List<PUseraccount> PUseraccountList = null;
        boolean b = false;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from PUseraccount where login = :login and passwd = :password");
            q.setString("login", login);
            q.setString("password", password);
            PUseraccountList = (List<PUseraccount>) q.list();


        } catch (Exception e) {
            e.printStackTrace();
        }
        if (PUseraccountList.size() == 1) {
                    return PUseraccountList.get(0);
        } else return null;

    }
}

