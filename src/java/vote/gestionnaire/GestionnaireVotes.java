/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vote.gestionnaire;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import miage.modeles.Miage;
import participants.modeles.Etudiant;
import vote.modele.Vote;

/**
 *
 * @author Christian
 */
@Stateless
public class GestionnaireVotes {

    @PersistenceContext
    private EntityManager em;
    
    /**
     *
     * @param etu
     * @param miages
     */
    public Vote ajouterVotes(int idEtu, int idMiage){
        Vote v = new Vote(idEtu, idMiage);
        return v;
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
