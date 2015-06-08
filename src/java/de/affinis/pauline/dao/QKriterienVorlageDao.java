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
public class QKriterienVorlageDao {

    private static List<PQKriterienVorlage> alleKriterienVorlagen;
    private static List<PQKriterienVorlage> kritForObjektTyp;

    public static List<PQKriterienVorlage> getKritForObjektTyp(int typ) {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("select p from PQKriterienVorlage p where p.PQObjektVorlage = :typ").setInteger("typ", typ);
            kritForObjektTyp = (List<PQKriterienVorlage>) q.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return kritForObjektTyp;
    }
    
    
    
    
    

    public static List<PQKriterienVorlage> getAlleKriterienVorlagen() {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("from PQKriterienVorlage");
            alleKriterienVorlagen = (List<PQKriterienVorlage>) q.list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }

        return alleKriterienVorlagen;
    }

    public static PQKriterienVorlage findById(Integer id) {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        PQKriterienVorlage kritVorlage = new PQKriterienVorlage();
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("select kv from PQKriterienVorlage kv where kv.hid = :id").setInteger("id", id);
            kritVorlage = (PQKriterienVorlage) q.list().get(0);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return kritVorlage;
    }

    public static PQKriterienVorlage findByName(String name) {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        PQKriterienVorlage kritVorlage = new PQKriterienVorlage();
        try {
            tx = session.beginTransaction();
            Query q = session.createQuery("select kv from PQKriterienVorlage kv where kv.hid = :name").setString("name", name);
            kritVorlage = (PQKriterienVorlage) q.list().get(0);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }

        return kritVorlage;
    }

    public static void createQKriterium(PQKriterienVorlage kriterium) {
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

    public static void updateQKriterium(PQKriterienVorlage kriterium) {
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

    public static void deleteQKriterium(PQKriterienVorlage kriterium) {
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
