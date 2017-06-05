/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vote.modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import miage.modeles.Miage;
import participants.modeles.Etudiant;

/**
 *
 * @author Christian
 */
@Entity
public class Vote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int etudiant;
    private int miage;
    
    public Vote(){
         
    }
    
    public Vote(int idEtu, int idMiage){
        this.etudiant = idEtu;
        this.miage = idMiage;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + this.etudiant;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vote other = (Vote) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.etudiant != other.etudiant) {
            return false;
        }
        if (this.miage != other.miage) {
            return false;
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(int etudiant) {
        this.etudiant = etudiant;
    }

    public int getMiage() {
        return miage;
    }

    public void setMiage(int miage) {
        this.miage = miage;
    }

    @Override
    public String toString() {
        return "Vote {" + "id=" + id + ", etudiant=" + etudiant + ", miage=" + miage + '}';
    }


    
    
}