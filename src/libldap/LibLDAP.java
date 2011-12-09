/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libldap;

import com.delimce.ldap.LdapContexto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author luis
 */



public class LibLDAP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       
        try {
            // TODO code application logic here
             
           LdapContexto res = new LdapContexto();
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader (isr);
           
           res.leerConfig("ldapconfig.properties");
           
           System.out.print("ingresa usuario:");
           String user = br.readLine();  
           
           System.out.print("ingresa clave:");
           String pwd = br.readLine();
           
           System.out.print("n de intentos a realizar:");
           int nIntentos = Integer.parseInt(br.readLine());
                      
           res.setUser(user);
           res.setPwd(pwd);
           
           
           
           for(int i=0;i<nIntentos;i++){
           //////intentando conexion
            try {
                res.getLdapContext();
                
                System.out.println("Connection Successful."); 
            } catch (NamingException ex) {
                System.out.println("Connection Failed. ");
                
                Logger.getLogger(LibLDAP.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                res.limpiarContexto();
            
           }
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(LibLDAP.class.getName()).log(Level.SEVERE, null, ex);
            
          //  Logger.getLogger(LibLDAP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
