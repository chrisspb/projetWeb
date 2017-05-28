/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admins.gestionnaires;

import javax.ejb.Stateless;
import admins.modeles.Administrateurs;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author perle
 */
@Stateless
public class GesionnaireAdministrateurs {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext  
    private EntityManager em;
    
    public Administrateurs creeAdmin(String email, String password){
        Administrateurs a = new Administrateurs(email, password);
        em.persist(a);
        return a;
    }
}
