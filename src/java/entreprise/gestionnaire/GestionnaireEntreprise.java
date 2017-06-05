/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entreprise.gestionnaire;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import participants.modeles.Enseignant;
import participants.modeles.Entreprise;

/**
 *
 * @author Christian
 */
@Stateless
public class GestionnaireEntreprise {

    @PersistenceContext
    private EntityManager em;


    public Entreprise creeEntreprise(String nom, String prenom, String mail, String pass, 
            String fonction, String tel, String nomE, String rueE, String codePostal, String villeE, String secteurE) {
        Entreprise e = new Entreprise(nom, prenom, mail, pass, fonction, tel, nomE, rueE, codePostal, villeE, secteurE);
        em.persist(e);
        return e;
    }
    
    public Collection<Entreprise> getOneEntreprise(String email, String pass) {
        Query q = em.createQuery("select e from Entreprise e where e.mail = :email AND e.pass = :pass");
        q.setParameter("email", email);
        q.setParameter("pass", pass);
        return q.getResultList();
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
