/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libldap;

import com.delimce.ldap.LdapContexto;
import com.delimce.log.LogConf;
import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import javax.naming.NamingException;

/**
 *
 * @author luis
 */
public class LibLDAP {
    
    
    private static final Logger logger = Logger.getLogger (LibLDAP.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


         LogConf.init();
         
        
        
        try {
            // TODO code application logic here

            LdapContexto res = new LdapContexto();
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            res.leerConfig("ldapconfig.properties");

            System.out.print("ingresa usuario:");
            String user = br.readLine();
            
            System.out.print("ingresa clave:");
            String pwd = br.readLine();     

            System.out.print("n de intentos a realizar:");
            int nIntentos = Integer.parseInt(br.readLine());

            res.setUser(user);
            res.setPwd(pwd);



            for (int i = 0; i < nIntentos; i++) {
                //////intentando conexion
                int ni = i+1;
                try {
                    res.getLdapContext();
                    
                    System.out.println("Connection Successful.");       
                    logger.debug("intento: "+ni+" Connection Successful.");
                } catch (NamingException ex)  {  

                    System.out.println("Connection Failed.");
                    
                     logger.debug("intento: "+ni+"  user: "+res.getUser()+" pwd: "+res.getPwd()+" "+ex);
                    
                }

                res.limpiarContexto();

            }



        } catch (IOException ex) {
            
            logger.debug(ex);
           
        }

    }
}
