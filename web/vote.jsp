<%-- 
    Document   : vote
    Created on : 23 mai 2017, 16:24:39
    Author     : perle
--%>

<%@page import="miage.gestionnaires.GestionnaireMiage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Voter</title>
    </head>
    <body>
        <div class="marge">
            <div class="card center-align">
                <div class="card-content">
                    <span class="card-title">Vote pour le meilleur t-shirt</span>
                    </br>
                    <div class="row">
                        <form action="ServletUsers" method="post" enctype="multipart/form-data">
                            <select multiple id="vote_shirt" data-limit="3" name="vote_shirt" >
                                <option value="" disabled selected>Choisir 3 Miage maximum</option>
                                <c:forEach var="m" items="${requestScope['listeDesMiages']}">
                                    <c:choose>
                                        <c:when test="${sessionScope['grisé'] == true}">
                                            <option value="${m.id}" disabled selected>${m.miage}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${m.id}">${m.miage}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                            </br>
                            <input type="hidden" name="action" value="valider_vote_shirt"/>  
                            <input class="btn waves-effect waves-light light-blue accent-3" type="submit" value="Valider" name="submit"/>
                        </form>
                    </div>
                </div>
            </div>

            </br></br></br>

            <div class="card center-align">
                <div class="card-content">
                    <span class="card-title">Vote pour la meilleure vidéo</span>
                    </br>
                    <div class="row">
                        <form action="ServletUsers" method="post" enctype="multipart/form-data">
                            <select multiple id="vote_video" data-limit="3" name="vote_video">
                                <option value="" disabled selected>Choisir 3 Miage maximum</option>
                                <c:forEach var="m" items="${requestScope['listeDesMiages']}">
                                    <c:choose>
                                        <c:when test="${sessionScope['grisé'] == true}">
                                            <option value="${m.id}" disabled selected>${m.miage}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${m.id}">${m.miage}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                            </br>
                            <input type="hidden" name="action" value="valider_vote_video"/>  
                            <input class="btn waves-effect waves-light light-blue accent-3" type="submit" value="Valider" name="submit"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
