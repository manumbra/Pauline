/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.util;

import de.affinis.pauline.bb.UserManager;
import javax.el.ELContext;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marin Cordeleanu
 */
public class FacesAccessor {

    public static Object getManagedBean(final String beanName) {
        FacesContext fc = FacesContext.getCurrentInstance();
        Object bean;

        try {
            ELContext elContext = fc.getELContext();
            bean = elContext.getELResolver().getValue(elContext, null, beanName);
        } catch (RuntimeException e) {
            throw new FacesException(e.getMessage(), e);
        }

        if (bean == null) {
            throw new FacesException("Managed bean with name '" + beanName
                    + "' was not found. Check your faces-config.xml or @ManagedBean annotation.");
        }

        return bean;
    }

    public static Object getUser() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Object user;

        try {
            ELContext elContext = fc.getELContext();
            user = elContext.getELResolver().getValue(elContext, null, "UserManager");
            UserManager um = (UserManager) user;
            user = um.getPUseraccount();
        } catch (RuntimeException e) {
            throw new FacesException(e.getMessage(), e);
        }

        if (user == null) {
            throw new FacesException("Managed bean with name 'pUseraccount' was not found. Check your faces-config.xml or @ManagedBean annotation.");
        }

        return user;
    }
    
    public static Object getCurrentUser() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Object user;

        try {
            ELContext elContext = fc.getELContext();
            user = elContext.getELResolver().getValue(elContext, null, "UserManager");
            UserManager um = (UserManager) user;
            user = um.getPUseraccount();
        } catch (RuntimeException e) {
            throw new FacesException(e.getMessage(), e);
        }

        if (user == null) {
            throw new FacesException("Managed bean with name 'pUseraccount' was not found. Check your faces-config.xml or @ManagedBean annotation.");
        }

        return user;
    }

    public static Object getAuftragBean() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Object auftragBean;

        try {
            ELContext elContext = fc.getELContext();
            auftragBean = elContext.getELResolver().getValue(elContext, null, "auftragBean");
        } catch (RuntimeException e) {
            throw new FacesException(e.getMessage(), e);
        }

        if (auftragBean == null) {
            throw new FacesException("Managed bean with name 'auftragBean' was not found. Check your faces-config.xml or @ManagedBean annotation.");
        }

        return auftragBean;
    }

    public static Object getQPProjektManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Object qProjektManager;

        try {
            ELContext elContext = fc.getELContext();
            qProjektManager = elContext.getELResolver().getValue(elContext, null, "qProjektManager");
        } catch (RuntimeException e) {
            throw new FacesException(e.getMessage(), e);
        }

        if (qProjektManager == null) {
            throw new FacesException("Managed bean with name 'qProjektManager' was not found. Check your faces-config.xml or @ManagedBean annotation.");
        }

        return qProjektManager;
    }

    public static Object getQPObjektManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Object qObjektManager;

        try {
            ELContext elContext = fc.getELContext();
            qObjektManager = elContext.getELResolver().getValue(elContext, null, "qObjektManager");
        } catch (RuntimeException e) {
            throw new FacesException(e.getMessage(), e);
        }

        if (qObjektManager == null) {
            throw new FacesException("Managed bean with name 'qObjektManager' was not found. Check your faces-config.xml or @ManagedBean annotation.");
        }

        return qObjektManager;
    }

    public static Object getQPKriteriumManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Object qKriteriumManager;

        try {
            ELContext elContext = fc.getELContext();
            qKriteriumManager = elContext.getELResolver().getValue(elContext, null, "qKriteriumManager");
        } catch (RuntimeException e) {
            throw new FacesException(e.getMessage(), e);
        }

        if (qKriteriumManager == null) {
            throw new FacesException("Managed bean with name 'qKriteriumManager' was not found. Check your faces-config.xml or @ManagedBean annotation.");
        }

        return qKriteriumManager;
    }

    public static Object getBenutzerBean() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Object BenutzerBean;
        try {
            ELContext elContext = fc.getELContext();
            BenutzerBean = elContext.getELResolver().getValue(elContext, null, "BenutzerBean");
        } catch (RuntimeException e) {
            throw new FacesException(e.getMessage(), e);
        }

        if (BenutzerBean == null) {
            throw new FacesException("Managed bean with name 'BenutzerBean' was not found. Check your faces-config.xml or @ManagedBean annotation.");
        }

        return BenutzerBean;
    }

    public static Object getBenutzerView() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Object benutzerView;
        try {
            ELContext elContext = fc.getELContext();
            benutzerView = elContext.getELResolver().getValue(elContext, null, "benutzerView");
        } catch (RuntimeException e) {
            throw new FacesException(e.getMessage(), e);
        }

        if (benutzerView == null) {
            throw new FacesException("Managed bean with name 'benutzerView' was not found. Check your faces-config.xml or @ManagedBean annotation.");
        }

        return benutzerView;
    }
    
    public static Object getQProjektView() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Object qProjektView;

        try {
            ELContext elContext = fc.getELContext();
            qProjektView = elContext.getELResolver().getValue(elContext, null, "qProjektView");
        } catch (RuntimeException e) {
            throw new FacesException(e.getMessage(), e);
        }

        if (qProjektView == null) {
            throw new FacesException("Managed bean with name 'qProjektView' was not found. Check your faces-config.xml or @ManagedBean annotation.");
        }

        return qProjektView;
    }
    
    public static Object getQObjektView() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Object qObjektView;

        try {
            ELContext elContext = fc.getELContext();
            qObjektView = elContext.getELResolver().getValue(elContext, null, "qObjektView");
        } catch (RuntimeException e) {
            throw new FacesException(e.getMessage(), e);
        }

        if (qObjektView == null) {
            throw new FacesException("Managed bean with name 'qObjektView' was not found. Check your faces-config.xml or @ManagedBean annotation.");
        }

        return qObjektView;
    }
    
    public static Object getQKriteriumView() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Object qKriteriumView;

        try {
            ELContext elContext = fc.getELContext();
            qKriteriumView = elContext.getELResolver().getValue(elContext, null, "qKriteriumView");
        } catch (RuntimeException e) {
            throw new FacesException(e.getMessage(), e);
        }

        if (qKriteriumView == null) {
            throw new FacesException("Managed bean with name 'qKriteriumView' was not found. Check your faces-config.xml or @ManagedBean annotation.");
        }

        return qKriteriumView;
    }
    
    public static Object getQKriterienVorlageView() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Object qKriterienVorlageView;

        try {
            ELContext elContext = fc.getELContext();
            qKriterienVorlageView = elContext.getELResolver().getValue(elContext, null, "qKriterienVorlageView");
        } catch (RuntimeException e) {
            throw new FacesException(e.getMessage(), e);
        }

        if (qKriterienVorlageView == null) {
            throw new FacesException("Managed bean with name 'qKriteriumView' was not found. Check your faces-config.xml or @ManagedBean annotation.");
        }

        return qKriterienVorlageView;
    }
}
