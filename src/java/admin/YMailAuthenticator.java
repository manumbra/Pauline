/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

/**
 *
 * @author Marin Cordeleanu
 */
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


class YMailAuthenticator extends Authenticator {
     String user;
     String pw;
     public YMailAuthenticator (String username, String password)
     {
        super();
        this.user = username;
        this.pw = password;
     }
    public PasswordAuthentication getPasswordAuthentication()
    {
       return new PasswordAuthentication(user, pw);
    }
}