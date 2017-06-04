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
                    <form class="col s12" action="ServletMiage" method="post">
                        <div class="row">
                            <div class="input-field col s7 offset-l1">
                                <select id="choix_miage" name="choix_miage">
                                    <option value="" disabled selected>Choisissez la MIAGE :</option>
                                    <c:forEach var="m" items="${requestScope['listeDesMiages']}">

                                        <c:choose>
                                            <c:when test="${param['choix_miage'] == m.miage}">
                                                <option value="${m.miage}" selected>${m.miage}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${m.miage}">${m.miage}</option>
                                            </c:otherwise>
                                        </c:choose>
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
            <c:if test="${param['choix_miage'] !=null}">
                <c:choose>
                    <c:when test="${not empty requestScope['listeDesEtudiants']}">
                        <h5 class="titre center">Trombinoscope des étudiants de la Miage de ${param['choix_miage']}</h5>
                        <div class="row">
                            <c:forEach var="u" items="${listeDesEtudiants}">
                                <div class="col s3 m3">
                                    <div class="card">  
                                        <div class="card-image">
                                            <img src="resources/user.png">
                                        </div>
                                        <div class="card-content">
                                            <p class="center">${u.prenom} ${u.nom}</p>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="pagination center">
                            <c:if test="${page != 1}">
                                <td><a href="ServletMiage?choix_miage=${param['choix_miage']}&action=trombi_miage&page=${page - 1}" class="waves-effect waves-light light-blue accent-3 btn"><i class="material-icons left">skip_previous</i>Précédent</a></td>
                            </c:if>
                            <c:if test="${page lt nbPage}">
                                <td><a href="ServletMiage?choix_miage=${param['choix_miage']}&action=trombi_miage&page=${page + 1}" class="waves-effect waves-light light-blue accent-3 btn"><i class="material-icons right">skip_next</i>Suivant</a></td>
                            </c:if>
                        </div> 
                    </c:when>
                    <c:otherwise>
                        <span class="red-text center-align"><b>Aucun étudiant n'a été trouvé pour la Miage de ${param['choix_miage']}</b></span>
                    </c:otherwise>
                </c:choose>
            </c:if>
        </div>
    </body>
</html>
