/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.affinis.pauline.util;

import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Marin Cordeleanu
 */
public class PropertiesUtil {

    private static final Properties prop = new Properties();

    static {
        try {
            //load a properties file from class path, inside static method
            prop.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("./resources/messages.properties"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static String getProperty(String s1) {
        
        return prop.getProperty(s1);
    }
}
