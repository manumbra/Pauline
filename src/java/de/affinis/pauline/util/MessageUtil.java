/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Marin Cordeleanu
 */
public class MessageUtil {

    public static String displayMessage(String template, String object0, String object1, String object2, String object3) {

        Locale currentLocale = new Locale("de", "DE");

        ResourceBundle messages = ResourceBundle.getBundle("MessageBundle",
                currentLocale);

        Object[] messageArguments = {object0, object1, object2, object3};

        MessageFormat formatter = new MessageFormat("");
        formatter.setLocale(currentLocale);

        formatter.applyPattern(messages.getString(template));
        String output = formatter.format(messageArguments);

        return output;

    }

    public static String displayMessage(String template, String object0, String object1, String object2) {

        Locale currentLocale = new Locale("de", "DE");

        ResourceBundle messages = ResourceBundle.getBundle("MessageBundle",
                currentLocale);

        Object[] messageArguments = {object0, object1, object2};

        MessageFormat formatter = new MessageFormat("");
        formatter.setLocale(currentLocale);

        formatter.applyPattern(messages.getString(template));
        String output = formatter.format(messageArguments);

        return output;

    }

    public static String displayMessage(String template, String object0, String object1) {

        Locale currentLocale = new Locale("de", "DE");

        ResourceBundle messages = ResourceBundle.getBundle("MessageBundle",
                currentLocale);

        Object[] messageArguments = {object0, object1};

        MessageFormat formatter = new MessageFormat("");
        formatter.setLocale(currentLocale);

        formatter.applyPattern(messages.getString(template));
        String output = formatter.format(messageArguments);

        return output;

    }

    public static String displayMessage(String template, String object0) {

        Locale currentLocale = new Locale("de", "DE");

        ResourceBundle messages = ResourceBundle.getBundle("MessageBundle",
                currentLocale);

        Object[] messageArguments = {object0};

        MessageFormat formatter = new MessageFormat("");
        formatter.setLocale(currentLocale);

        formatter.applyPattern(messages.getString(template));
        String output = formatter.format(messageArguments);

        return output;

    }

    public static String displayMessage(String template) {

        Locale currentLocale = new Locale("de", "DE");

        ResourceBundle messages = ResourceBundle.getBundle("MessageBundle",
                currentLocale);


        MessageFormat formatter = new MessageFormat("");
        formatter.setLocale(currentLocale);

        String output = messages.getString(template);


        return output;

    }

    public static String displayMessage(String template, Object[] messageArguments) {

        Locale currentLocale = new Locale("de", "DE");

        ResourceBundle messages = ResourceBundle.getBundle("MessageBundle",
                currentLocale);


        MessageFormat formatter = new MessageFormat("");
        formatter.setLocale(currentLocale);

        formatter.applyPattern(messages.getString(template));
        String output = formatter.format(messageArguments);

        return output;

    }
}
