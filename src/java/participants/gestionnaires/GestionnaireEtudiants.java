/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package participants.gestionnaires;

import java.util.Collection;  
import java.util.List;
import javax.ejb.Stateless;  
import javax.persistence.EntityManager;  
import javax.persistence.PersistenceContext;  
import javax.persistence.Query;  
import participants.modeles.Enseignant;
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

    public Etudiant creeEtudiant(String nom, String prenom, String email, String password, String naissance, String miage, String photo, boolean diplome, boolean valide){
        Etudiant e = new Etudiant(nom, prenom, email, password, naissance, miage, photo, diplome, valide);
        em.persist(e);
        return e;
    }
    
    /*public Collection<Etudiant> valide(String nom, String prenom, String miage, boolean valide) {
        Query q = em.createQuery("select etu from Etudiant etu where etu.nom = \"" + nom + "\" AND etu.prenom = \"" + prenom + "\" AND etu.miage = \"" + miage + "\"");
        return q.getResultList();
    }*/
    
    public Entreprise creeEntreprise( String nom, String prenom, String mail, String pass, 
            String fonction, String tel, String nomE, String rueE, String codePostal, String villeE, String secteurE){
        Entreprise ent = new Entreprise(nom, prenom, mail, pass, fonction, tel, nomE, rueE, codePostal, villeE, secteurE);
        em.persist(ent);
        return ent;
    }
    
    public Collection<Etudiant> getOneEtudiant(String email, String pass) {
        Query q = em.createQuery("select etu from Etudiant etu where etu.mail = :email AND etu.pass = :pass");
        q.setParameter("email", email);
        q.setParameter("pass", pass);
        return q.getResultList();
    }
    
    public Collection<Etudiant> getAllEtudiant() {
        Query q = em.createQuery("select etu from Etudiant etu");
        return q.getResultList();
    }
    
    public Collection<Etudiant> getEtudiantNotChecked(String miage) {
        Query q = em.createQuery("select etu from Etudiant etu where etu.miage = :miage AND etu.valide = false");
        q.setParameter("miage", miage);
        return q.getResultList();
    }
    
    public Collection<Etudiant> getEtudiantByMiage(String miage) {
        Query q = em.createQuery("select etu from Etudiant etu where etu.miage = :miage");
        q.setParameter("miage", miage);
        return q.getResultList();
    }
    
    public void valideEtudiant(int id) {
        Query q = em.createQuery("UPDATE Etudiant etu SET etu.valide = true WHERE etu.id = :id");
        q.setParameter("id", id);
        q.executeUpdate();
    }
    
    public int getNumberEtudiant(String miage) {
        Query q = em.createQuery("select etu from Etudiant etu where etu.miage = :miage");
        q.setParameter("miage", miage);
        List<Etudiant> liste = q.getResultList();
        return liste.size();
    }
    
    public int getNumberEtudiant() {
        Query q = em.createQuery("select etu from Etudiant etu where etu.valide = false");
        List<Etudiant> liste = q.getResultList();
        return liste.size();
    }
    
    public List<Etudiant> get10Etudiant(int start) {
        Query q = em.createQuery("select etu from Etudiant etu");
        q.setFirstResult(start);
        q.setMaxResults(10);
        return q.getResultList();
    }
    
    public List<Etudiant> getEtudiantByMiage(String miage, int start) {
        Query q = em.createQuery("select etu from Etudiant etu where etu.miage = :miage");
        q.setParameter("miage", miage);
        q.setFirstResult(start);
        q.setMaxResults(12);
        return q.getResultList();
    }
    
    public boolean checkMail(String mail){
        Query q = em.createQuery("select etu from Etudiant etu where etu.mail = :mail");
        q.setParameter("mail", mail);
        List r = q.getResultList();
        boolean b = false;
        //System.out.println("Taille r : " + r.size());
        if(r.size() == 0){
            b = true;
        } 
        //System.out.println("boolean : " + b);
        return b;
    }
    
    public boolean verifCompteValide(int id){
        Query q = em.createQuery("select etu from Etudiant etu where etu.id = :id");
        q.setParameter("id", id);
        List r = q.getResultList();
        Etudiant e = (Etudiant) r.iterator().next();
        return e.isValide();
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
