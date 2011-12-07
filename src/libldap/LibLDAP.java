/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libldap;

import com.delimce.ldap.LdapConexion;
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
     LdapContext algo =  res.getLdapContext();
        
    }
    
    
    
    
    
    
    
}
