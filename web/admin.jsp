<%-- 
    Document   : admin
    Created on : 23 mai 2017, 17:37:24
    Author     : perle
--%>

<%@page import="miage.gestionnaires.GestionnaireMiage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page administrateur</title>
    </head>
    <body>
        <div class="marge">
            <div class="card center-align">
                <div class="card-content">
                    <span class="card-title">Inscrire un enseignant</span>
                    </br>
                    <form class="col s12" action="ServletEnseignants" method="post">
                        <div class="row">
                            <div class="input-field col s6">
                                <i class="material-icons prefix">perm_identity</i>
                                <input id="icon_nom" type="text" class="validate" name="nom">
                                <label for="icon_nom" class="">Nom</label>
                            </div>
                            <div class="input-field col s6">
                                <input id="icon_prenom" type="text" class="validate" name="prenom">
                                <label for="icon_prenom" class="">Prénom</label>
                            </div>
                            <div class="input-field col s12">
                                <i class="material-icons prefix">email</i>
                                <input id="icon_email" type="email" class="validate" name="email" required>
                                <label for="icon_email" data-error="email non valide" data-success="email valide" class="">Email</label>
                            </div>
                            <div class="input-field col s12">
                                <i class="material-icons prefix">lock</i>
                                <input id="icon_password" type="password" class="validate" name="password">
                                <label for="icon_password">Mot de passe</label>
                            </div>

                            <div class="input-field col s12">
                                <p>Vous êtes :</p>
                                <p>
                                    <input name="group1" type="radio" id="miagiste" disabled="disabled"/>
                                    <label for="miagiste">Miagiste</label>
                                </p>
                                <p>
                                    <input name="group1" type="radio" id="enseignant" value="enseignant" checked="checked"/>
                                    <label for="enseignant">Enseignant</label>
                                </p>
                                <p>
                                    <input name="group1" type="radio" id="entreprise" disabled="disabled"/>
                                    <label for="entreprise">Entreprise partenaire</label>
                                </p> 
                            </div>

                            <div class="input-field col s12">
                                <select id="choix_miage" name="choix_miage">
                                    <option value="" disabled selected>MIAGE de l'enseignant :</option>
                                    <c:forEach var="m" items="${requestScope['listeDesMiages']}">
                                        <option value="${m.miage}">${m.miage}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        </br>
                        <input type="hidden" name="action" value="inscriptionEnseignants"/>  
                        <input class="btn waves-effect waves-light light-blue accent-3" type="submit" value="Inscrire" name="submit"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
