/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.delimce.ldap;

/**
 *
 * @author luis
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable; 
import java.util.Properties;
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
    private String user; //usuario
    private String pwd;  //password
    private String server ; //servidor
    private String tconexion; //tipo de conexion

    public boolean isConectado() {
        return conectado;
    }
    private boolean conectado = false; //si se pudo conectar  o no
    
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
    
     public LdapContext getLdapContext() throws NamingException{  
                       
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
            
            LdapContext ctx = null;
            ctx = new InitialLdapContext(varConex, null);  
            this.conectado = true;
        return ctx;  
    }
     
     
     /**
      * metodo para leer la configuracion de un archivo externo
      * @param archivo 
      */
     
      public void leerConfig(String archivo) {

        try {
            //se crea una instancia a la clase Properties
            Properties propiedades = new Properties();
            //se leen el archivo .properties
            
            try{
                
             propiedades.load(new FileInputStream(archivo));
             
             
            }catch (NullPointerException e2){
                
                System.out.println("No es posible leer el archivo de propiedades de conexion \n " + e2);
                
            }
             
            //si el archivo de propiedades NO esta vacio retornan las propiedes leidas
            if (!propiedades.isEmpty()) {
                
                this.server = propiedades.getProperty("server").trim(); ///motor de base de datos a usar Mysql, Postgres u Oracle
                this.user = propiedades.getProperty("user").trim(); ////nombre o ip del servidor
                this.pwd = propiedades.getProperty("pwd").trim(); ///nombre de la base de datos
                this.tconexion = propiedades.getProperty("tconexion").trim(); ///usuario de la db
              
                           
            } else {//sino  retornara NULL
                System.out.print("el archivo esta vacio: " + archivo);
            }
        } catch (IOException ex) {
            System.out.println("No es posible leer el archivo de propiedades de conexion " + archivo);
        }
    }
     
     
        
}
