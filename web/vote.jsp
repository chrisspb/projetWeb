<%-- 
    Document   : vote
    Created on : 23 mai 2017, 16:24:39
    Author     : perle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                            <select multiple id="vote_shirt" data-limit="3" name = "votes_shirt">
                                <option value="" disabled selected>Choisir 3 Miage maximum</option>
                                <option value="aix">Aix-Marseille</option>
                                <option value="amiens">Amiens</option>
                                <option value="brodeaux">Bordeaux</option>
                                <option value="grenoble">Grenoble</option>
                                <option value="guadeloupe">Guadeloupe</option>
                                <option value="lille">Lille</option>
                                <option value="mulhouse">Mulhouse</option>
                                <option value="nancy">Nancy</option>
                                <option value="nantes">Nantes</option>
                                <option value="nice">Nice</option>
                                <option value="orlean">Orléans</option>
                                <option value="dauphine">Paris - Dauphine</option>
                                <option value="descartes">Paris - Descartes</option>
                                <option value="evry">Paris - Evry</option>
                                <option value="nanterre">Paris - Nanterre</option>
                                <option value="orsay">Paris - Orsay</option>
                                <option value="sorbonne">Paris - Sorbonne</option>
                                <option value="rennes">Rennes</option>
                                <option value="toulouse">Toulouse</option>
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
                        <form action="ServletUsers" method="post">
                            <select multiple id="vote_video" data-limit="3">
                                <option value="" disabled selected>Choisir 3 Miage maximum</option>
                                <option value="aix">Aix-Marseille</option>
                                <option value="amiens">Amiens</option>
                                <option value="brodeaux">Bordeaux</option>
                                <option value="grenoble">Grenoble</option>
                                <option value="guadeloupe">Guadeloupe</option>
                                <option value="lille">Lille</option>
                                <option value="mulhouse">Mulhouse</option>
                                <option value="nancy">Nancy</option>
                                <option value="nantes">Nantes</option>
                                <option value="nice">Nice</option>
                                <option value="orlean">Orléans</option>
                                <option value="dauphine">Paris - Dauphine</option>
                                <option value="descartes">Paris - Descartes</option>
                                <option value="evry">Paris - Evry</option>
                                <option value="nanterre">Paris - Nanterre</option>
                                <option value="orsay">Paris - Orsay</option>
                                <option value="sorbonne">Paris - Sorbonne</option>
                                <option value="rennes">Rennes</option>
                                <option value="toulouse">Toulouse</option>
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
