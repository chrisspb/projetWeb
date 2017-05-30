<%-- 
    Document   : confirmer
    Created on : 27 mai 2017, 16:11:36
    Author     : perle
--%>

<%@page import="miage.gestionnaires.GestionnaireMiage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmer la participation des étudiants</title>
    </head>
    <body>
        <div class="marge">
            <h5 class="center titre">Confirmer la participation des étudiants</h5> 
            </br></br>
            <form class="col s12" action="ServletEnseignants" method="post">
                <table border="10" class="centered responsive-table">  
                    <!-- La ligne de titre du tableau des comptes -->
                    <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Prenom</th>
                            <th>Confirmer</th>
                        </tr>
                    </thead>

                    <!-- Ici on affiche les lignes, une par utilisateur -->  
                    <!-- cette variable montre comment on peut utiliser JSTL et EL pour calculer -->  
                    <tbody> 
                        <c:forEach var="u" items="${requestScope['listeDesEtudiants']}">  
                            <tr>  
                                <td>${u.nom}</td>  
                                <td>${u.prenom}</td>
                                <td>${u.miage}</td>
                                <td><input type="checkbox" id="${u.id}"/><label for="${u.id}"></label></td>
                            </tr>  
                        </c:forEach>
                    </tbody>
                </table>
                </br></br>
                <input type="hidden" name="action" value="validerEtudiant"/>  
                <input class="btn waves-effect waves-light light-blue accent-3" type="submit" value="Confirmer" name="submit"/>
            </form>
        </div>
    </body>
</html>
