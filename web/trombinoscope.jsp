<%-- 
    Document   : trombinoscope
    Created on : 30 mai 2017, 19:07:11
    Author     : perle
--%>

<%@page import="miage.gestionnaires.GestionnaireMiage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trombinoscope</title>
    </head>
    <body>
        <div class="marge">
            <div class="card center-align">
                <div class="card-content">
                    <span class="card-title">Choisir une Miage</span>
                    </br>
                    <form class="col s12" action="ServletUsers" method="get">
                        <div class="row">
                            <div class="input-field col s8">
                                <select id="choix_miage" name="choix_miage" onchange="rafraichir();">
                                    <option value="" disabled selected>Choisissez la MIAGE :</option>
                                    <c:forEach var="m" items="${requestScope['listeDesMiages']}">
                                        <option value="${m.miage}">${m.miage}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="input-field col s3">
                                <input type="hidden" name="action" value="trombi_miage" id="trombi_miage"/>  
                                <input class="btn waves-effect waves-light light-blue accent-3" type="submit" value="Afficher" name="submit"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            </br>
            <c:if test="${param['action'] == 'trombi_miage'}" > 
                <table border="10" class="centered responsive-table" id="trombi" hidden>  
                    <!-- La ligne de titre du tableau des comptes -->
                    <thead>
                        <tr>
                            <th>Photo</th>
                            <th>Nom</th>
                            <th>Prenom</th>
                        </tr>
                    </thead>

                    <!-- Ici on affiche les lignes, une par utilisateur -->  
                    <!-- cette variable montre comment on peut utiliser JSTL et EL pour calculer -->  
                    <tbody> 
                        <c:forEach var="u" items="${requestScope['listeDesEtudiants']}">  
                            <tr>  
                                <td>${u.photo}</td>
                                <td>${u.nom}</td>  
                                <td>${u.prenom}</td>
                            </tr>  
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </body>
</html>
