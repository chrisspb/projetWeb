/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enseignants.gestionnaires;

import admins.gestionnaires.*;
import javax.ejb.Stateless;
import admins.modeles.Administrateurs;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import participants.modeles.Enseignant;

/**
 *
 * @author perle
 */
@Stateless
public class GestionnaireEnseignants {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;

    public Enseignant creeEnseignant(String nom, String prenom, String mail, String pass) {
        Enseignant e = new Enseignant(nom, prenom, mail, pass);
        em.persist(e);
        return e;
    }

    
}
