/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.dao;

import de.affinis.pauline.hbm.PUserrole;
import de.affinis.pauline.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marin Cordeleanu
 */
public class PUserroleDao {

    private static List<PUserrole> userroleList;


    public static List<PUserrole> getUserroleList() {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("from PUserrole");
            userroleList = (List<PUserrole>) q.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return userroleList;
    }

    public static void setUserroleList(List<PUserrole> userroleList) {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            for (PUserrole b : userroleList) {
                session.saveOrUpdate(b);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
}
