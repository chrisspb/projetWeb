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
import participants.modeles.Entreprise;
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
    
    public Entreprise creeEntreprise( String nom, String prenom, String mail, String pass, 
            String fonction, String tel, String nomE, String rueE, String codePostal, String villeE, String secteurE){
        Entreprise ent = new Entreprise(nom, prenom, mail, pass, fonction, tel, nomE, rueE, codePostal, villeE, secteurE);
        em.persist(ent);
        return ent;
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
