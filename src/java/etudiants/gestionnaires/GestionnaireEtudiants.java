/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etudiants.gestionnaires;

import java.util.Collection;  
import javax.ejb.Stateless;  
import javax.persistence.EntityManager;  
import javax.persistence.PersistenceContext;  
import javax.persistence.Query;  
import etudiants.modeles.Etudiant;

/**
 *
 * @author perle
 */
@Stateless
public class GestionnaireEtudiants {
    
    @PersistenceContext  
    private EntityManager em;

    public Etudiant creeEtudiant(String lastname, String firstname, String mail, String pass, String naissance, String photo, boolean diplome){
        Etudiant e = new Etudiant(lastname, firstname, mail, pass, naissance, photo, diplome);
        em.persist(e);
        return e;
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
