<%-- 
    Document   : header
    Created on : 21 mai 2017, 12:12:58
    Author     : perle
--%>

<nav>
    <div class="nav-wrapper">
        <a href="index-form.jsp" class="brand-logo">JNM 2018</a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
            <li><a href="info-form.jsp">Infos pratiques</a></li>
            <li><a class="disabled">Activités</a></li>
            <li>|</li>
            <li><a href="#connexion">Se connecter</a></li>
            <li><a href="participer-form.jsp">Participer</a></li>
        </ul>
    </div>
</nav>

<div id="connexion" class="modal">
    <div class="modal-content center-align">
        <h4>Se connecter</h4>
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
        <div class="modal-footer">
            <input type="hidden" name="action" value="connexion"/>  
            <input class="btn waves-effect waves-light" type="submit" value="Connexion" name="submit"/>
        </div>
    </div>
</div>
