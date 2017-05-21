<%-- 
    Document   : index
    Created on : 21 mai 2017, 12:12:28
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
                <form class="s12">
                    <div class="row">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">email</i>
                            <input id="icon_email" type="text" class="validate">
                            <label for="icon_email" class="">Email</label>
                        </div>
                        <div class="input-field col s12">
                            <i class="material-icons prefix">lock</i>
                            <input id="icon_password" type="tel" class="validate">
                            <label for="icon_password">Mot de passe</label>
                        </div>
                    </div>
                </form>
                <div class="card-action">
                    <a class="modal-trigger tooltipped accent-color-text" data-position="bottom" data-delay="50" data-tooltip="Click to send" href="#modal" data-tooltip-id="24f3edbc-7d49-147f-eae7-6076ef521241">Envoyer</a>
                </div>
                <div id="modal" class="modal modal-lg">
                    <div class="modal-content modal-close">
                        <h4>Oops!</h4>
                        <p>This part is missing right now! Come back later to see it in action!</p>
                    </div>
                    <div class="modal-footer">
                        <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Okay</a>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
