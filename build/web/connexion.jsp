<%-- 
    Document   : connexion
    Created on : 21 mai 2017, 14:55:03
    Author     : perle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="card center-align">
            <div class="card-content">
                <span class="card-title">Se connecter</span>
                <form class="s12" action="ServletUsers" method="post">
                    <div class="row">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">email</i>
                            <input id="icon_email" type="text" class="validate" name="email">
                            <label for="icon_email" class="">Email</label>
                        </div>
                        <div class="input-field col s12">
                            <i class="material-icons prefix">lock</i>
                            <input id="icon_password" type="password" class="validate" name="password">
                            <label for="icon_password">Mot de passe</label>
                        </div>
                    </div>
                </form>
                <input type="hidden" name="action" value="connexion"/>  
                <input class="btn waves-effect waves-light" type="submit" value="Connexion" name="submit"/>
            </div>
        </div>
    </body>
</html>
