/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admins.gestionnaires;

import javax.ejb.Stateless;
import admins.modeles.Administrateurs;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author perle
 */
@Stateless
public class GestionnaireAdministrateurs {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;

    public void adminTest() {
        creeAdmin("admin@gmail.com", "admin");
    }

    public Administrateurs creeAdmin(String email, String password) {
        Administrateurs a = new Administrateurs(email, password);
        em.persist(a);
        return a;
    }
    public boolean connexionAdm(String email, String pass){
        Query q = em.createQuery("select a from Administrateurs a where a.mail = \"" + email + "\" AND a.pass = \"" + pass + "\"");
        System.out.println("la requete est passee");
        List verif = q.getResultList();
        if(verif.size() != 0){
            System.out.println("Connexion OK"); 
            return true;
        } else {
            return false;
        }
    }
    
}
