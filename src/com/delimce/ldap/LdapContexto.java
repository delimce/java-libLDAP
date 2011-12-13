/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.delimce.ldap;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.naming.ldap.LdapContext;

/**
 * clase para manipular una vez generado el objeto ctx
 * @author luis
 */
public class LdapContexto extends LdapConexion {
    
    
    private LdapContext ctx = null; ///objeto de contexto LDAP

    public LdapContexto() {
    }
    
    public LdapContexto(String ldapconfig) throws NamingException {
        
        this.leerConfig(ldapconfig);
        this.ctx = this.getLdapContext();
       
    }
    
    
    
    
    public void limpiarContexto() {

        try {
            if (this.ctx != null) {
                this.ctx.close();
                this.ctx = null;
            }
        } catch (NamingException ex) {
            Logger.getLogger(LdapContexto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
}
