/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libldap;

import com.delimce.ldap.LdapConexion;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.naming.ldap.LdapContext;

/**
 *
 * @author luis
 */



public class LibLDAP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         
       LdapConexion res = new LdapConexion();
       
       res.leerConfig("ldapconfig.properties");
       
        try {
            LdapContext algo =  res.getLdapContext();
            
            System.out.println("Connection Successful."+res.isConectado()); 
        } catch (NamingException ex) {
            System.out.println("Connection Failed. "+res.isConectado());
            
          //  Logger.getLogger(LibLDAP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    
    
    
}
