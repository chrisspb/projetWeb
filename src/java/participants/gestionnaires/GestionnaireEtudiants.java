/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package participants.gestionnaires;

import java.util.Collection;  
import javax.ejb.Stateless;  
import javax.persistence.EntityManager;  
import javax.persistence.PersistenceContext;  
import javax.persistence.Query;  
import participants.modeles.Etudiant;

/**
 *
 * @author perle
 */
@Stateless
public class GestionnaireEtudiants {
    
    @PersistenceContext  
    private EntityManager em;

    public Etudiant creeEtudiant(String nom, String prenom, String email, String password, String naissance, String photo, boolean diplome){
        Etudiant e = new Etudiant(nom, prenom, email, password, naissance, photo, diplome);
        em.persist(e);
        return e;
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
