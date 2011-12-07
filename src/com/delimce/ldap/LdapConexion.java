/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.delimce.ldap;

/**
 *
 * @author luis
 */

import java.util.Hashtable; 
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

/**
 * clase para la conexion para un directorio Ldap o DA
 * @author luis
 */
public class LdapConexion {
    
    private Hashtable varConex;  //
    private String user = "ldelima@novatec"; //usuario
    private String pwd =  "!\"#$Qwer";  //password
    private String server = "ldap://novatec-server:389"; //servidor
    private String tconexion = "Simple"; //tipo de conexion

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getTconexion() {
        return tconexion;
    }

    public void setTconexion(String tconexion) {
        this.tconexion = tconexion;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
    /**
     * metodo que ejecuta la conexion y devuelve el objeto contexto
     * @return 
     */
    
     public LdapContext getLdapContext(){  
        LdapContext ctx = null;  
        try{  
            
            this.varConex = new Hashtable();
            

            varConex.put(Context.INITIAL_CONTEXT_FACTORY,  
                    "com.sun.jndi.ldap.LdapCtxFactory");  
            varConex.put(Context.SECURITY_AUTHENTICATION,this.tconexion);  
            //it can be <domain\\userid> something that you use for windows login  
            //it can also be  
            varConex.put(Context.SECURITY_PRINCIPAL, this.user);
            varConex.put(Context.SECURITY_CREDENTIALS,this.pwd);  
            //in following property we specify ldap protocol and connection url.  
            //generally the port is 389  
            varConex.put(Context.PROVIDER_URL,this.server);  
            ctx = new InitialLdapContext(varConex, null);  
          
            System.out.println("Connection Successful.");  
        }catch(NamingException nex){  
            System.out.println("LDAP Connection: FAILED");  
            nex.printStackTrace();  
        }  
        return ctx;  
    }  
    
}
