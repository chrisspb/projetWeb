/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package participants.modeles;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author perle
 */
@Entity
public class Etudiant implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String naissance; 
    private String photo;
    private boolean diplome; 
    
    // attributs participant
    private String nom, prenom, mail, pass;

    
  
       public Etudiant() {  
    }  
       
       public Etudiant(int id){
           this.id = id;
       }
  
    public Etudiant(final String nom, final String prenom, final String mail, final String pass, final String naissance, final String photo, final boolean diplome) {  
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.pass = pass;
        this.naissance = naissance;
        this.photo = photo;
        this.diplome = diplome;
                
    }  

    public String getNaissance() {
        return naissance;
    }

    public void setNaissance(String naissance) {
        this.naissance = naissance;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isDiplome() {
        return diplome;
    }

    public void setDiplome(boolean diplome) {
        this.diplome = diplome;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Etudiant other = (Etudiant) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Etudiant{" + "id=" + id + ", naissance=" + naissance + ", photo=" + photo + ", diplome=" + diplome + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", pass=" + pass + '}';
    }

 
}
