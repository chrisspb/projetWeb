<%-- 
    Document   : ajout
    Created on : 27 mai 2017, 15:56:13
    Author     : perle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajout d'une MIAGE</title>
    </head>
    <body>
        <div class="marge">
            <div class="card center-align">
                <div class="card-content">
                    <span class="card-title">Ajouter une Miage</span>
                    </br>
                    <form class="col s12" action="ServletEnseignants" method="post">
                        <div class="row">
                            <div class="input-field col s12">
                                <i class="material-icons prefix">business</i>
                                <input id="icon_miage" type="text" class="validate" id="miage" name="miage">
                                <label for="icon_miage" class="">Nom de la Miage</label>
                            </div>
                        </div>
                        </br>
                        <input type="hidden" name="action" value="ajout_miage"/>  
                        <input class="btn waves-effect waves-light light-blue accent-3" type="submit" value="Ajouter" name="submit"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
