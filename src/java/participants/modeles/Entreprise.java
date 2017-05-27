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
 * @author Christian
 */
@Entity
public class Entreprise implements Serializable{
    
        // attributs participant
    private String nom, prenom, mail, pass;
    
    //attributs enseignant
    private String fonction, tel, nomE, rueE, villeE, secteurE, codePostal;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    public Entreprise(){
        
    }
    
    
    public Entreprise(final String nom, final String prenom, final String mail, final String pass, 
            final String fonction, final String tel, final String nomE, final String rueE, final String codePostal, final String villeE, final String secteurE){
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.pass = pass;
        this.fonction = fonction;
        this.tel = tel;
        this.nomE = nomE;
        this.rueE = rueE;
        this.villeE = villeE;
        this.secteurE = secteurE;
        this.codePostal = codePostal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Entreprise{" + "nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", pass=" + pass + ", fonction=" + fonction + ", tel=" + tel + ", nomE=" + nomE + ", rueE=" + rueE + ", villeE=" + villeE + ", secteurE=" + secteurE + ", codePostal=" + codePostal + ", id=" + id + '}';
    }
    
    
}
