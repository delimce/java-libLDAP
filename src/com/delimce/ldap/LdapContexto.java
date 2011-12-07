/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.delimce.ldap;

import javax.naming.NamingException;
import javax.naming.ldap.LdapContext;

/**
 * clase para manipular una vez generado el objeto ctx
 * @author luis
 */
public class LdapContexto extends LdapConexion {
    
    
    public LdapContext ctx = null; ///objeto de contexto LDAP

    public LdapContexto() {
    }
    
    public LdapContexto(String ldapconfig) throws NamingException {
        
        this.leerConfig(ldapconfig);
        this.ctx = this.getLdapContext();
       
    }
    
    
}
