/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.gestionnaires;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import miage.modeles.Miage;

/**
 *
 * @author perle
 */
@Stateless
public class GestionnaireMiage {

    @PersistenceContext  
    private EntityManager em;  
    private Miage m;
    
    public void listeMiage() {
        newMiage("Aix-Marseille");
        newMiage("Amiens");
        newMiage("Bordeaux");
        newMiage("Grenoble");
        newMiage("Guadeloupe");
        newMiage("Lille");
        newMiage("Mulhouse");
        newMiage("Nancy");
        newMiage("Nantes");
        newMiage("Nice");
        newMiage("Orléans");
        newMiage("Paris - Dauphine");
        newMiage("Paris - Descartes");
        newMiage("Paris - Evry");
        newMiage("Paris - Nanterre");
        newMiage("Paris - Orsay");
        newMiage("Paris - Sorbonne");
        newMiage("Rennes");
        newMiage("Toulouse");
    }
  
    public Miage newMiage(String miage) {
        Miage m = new Miage(miage);
        em.persist(m);
        return m;
    }
}
