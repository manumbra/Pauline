/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.dao;

import de.affinis.pauline.hbm.PQKriterienVorlage;
import de.affinis.pauline.hbm.PQObjektVorlage;
import de.affinis.pauline.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marin Cordeleanu
 */
public class QObjektVorlageDao {

    private static List<PQObjektVorlage> alleObjektVorlagen;

    public static List<PQObjektVorlage> getAlleObjektVorlagen() {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("from PQObjektVorlage");
            alleObjektVorlagen = (List<PQObjektVorlage>) q.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }

        return alleObjektVorlagen;
    }

}
