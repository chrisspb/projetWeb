<%-- 
    Document   : confirmer
    Created on : 27 mai 2017, 16:11:36
    Author     : perle
--%>

<%@page import="miage.gestionnaires.GestionnaireMiage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmer la participation des étudiants</title>
    </head>
    <body>
        <div class="marge">
            <h5 class="list center">Liste des étudiants inscrits</h5>  

            </br>

            <table border="10" class="centered responsive-table">  
                <!-- La ligne de titre du tableau des comptes -->
                <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Prenom</th>
                        <th>Supprimer</th>
                    </tr>
                </thead>

                <!-- Ici on affiche les lignes, une par utilisateur -->  
                <!-- cette variable montre comment on peut utiliser JSTL et EL pour calculer -->  
                <tbody>
                <c:set var="total" value="0"/>  

                <c:forEach var="u" items="${requestScope['listeDesUsers']}">  

                    <tr>  
                        <td>${u.nom}</td>  
                        <td>${u.prenom}</td>
                        <td><a id="supp" href="#" onclick="supprimer();"><i class="material-icons">delete</i></a></td>
                    </tr>  
                </c:forEach>  
                </tbody>
            </table>  

            </br>

            <div class="pagination center">
                <c:if test="${requestScope['nbUser'] != 0}">
                    <c:forEach begin="1" end="${requestScope['nbUser']+requestScope['pagesup']}" var="i">
                        <a href="ServletUsers?action=listerLesUtilisateurs&page=${i}">${1+(i-1)*10} - ${(i*10)}</a>
                    </c:forEach>
                </c:if>
            </div> 
        </div>
    </body>

    <script>
        function supprimer() {
            var $toastContent = $('<span>bite</span>');
            Materialize.toast($toastContent, 5000);
        }
    </script>
</html>
