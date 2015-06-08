/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import de.affinis.pauline.util.MailUtil;

/**
 *
 * @author Marin Cordeleanu
 */
public class Main {  
  
    public static void main(String[] args) {  
        String[] recipients = new String[]{"cord_marin@yahoo.com"};  
        String[] bccRecipients = new String[]{"ds@act-solutions.eu"};  
        String subject = "Hi this is test Mail";  
        String messageBody = "Test Mail from codesstore.blogspot.com";  
        new MailUtil().sendMail(recipients, bccRecipients, subject, messageBody);  
  
    }  
}  