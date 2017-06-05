<%-- 
    Document   : header
    Created on : 21 mai 2017, 12:12:58
    Author     : perle
--%>

<ul id="dropdown1" class="dropdown-content">
    <li><a href="video-form.jsp">Vidéo</a></li>
    <li><a href="shirt-form.jsp">T-Shirt</a></li>
    <li class="divider"></li>
    <li><a href="">Diners</a></li>
    <li><a href="">Gala</a></li>
    <li class="divider sortie"></li>
    <li><a href="">Sortie 1</a></li>
</ul>

<ul id="dropdown2" class="dropdown-content">
    <li><a href="video-form.jsp">Vidéo</a></li>
    <li><a href="shirt-form.jsp">T-Shirt</a></li>
    <li class="divider sortie"></li>
    <li><a href="">Diners</a></li>
    <li><a href="">Gala</a></li>
    <li class="divider sortie"></li>
    <li><a href="">Sortie 1</a></li>
</ul>

<nav class="blue darken-1">
    <div class="nav-wrapper">
        <a href="index-form.jsp" class="brand-logo"><img src="resources/logo_jnm.ico" height="150px"/></a>
        <ul class="right hide-on-med-and-down">
            <li><a href="info-form.jsp">Infos pratiques</a></li>
            <li><a class="dropdown-button" data-beloworigin="true" data-activates="dropdown1">Activités<i class="material-icons right">arrow_drop_down</i></a></li>
            <li><a href="vote-form.jsp">Voter</a></li>
            <li>|</li>
            <li><a href="#connexion">Se connecter</a></li>
            <li><a href="participer-form.jsp">Participer</a></li>
        </ul>
        <ul id="nav-mobile" class="side-nav">
            <li><a href="info-form.jsp">Infos pratiques</a></li>
            <li><a class="dropdown-button" data-beloworigin="true" data-activates="dropdown2">Activités<i class="material-icons right">arrow_drop_down</i></a></li>
            <c:if test = "${sessionScope['user'] == true}">
                <li><a href="vote-form.jsp">Voter</a></li>
            </c:if>
            <li>|</li>
            <c:if test = "${sessionScope['user'] != true}">
                <li><a href="#connexion">Se connecter</a></li>
            </c:if>
            <li><a href="participer-form.jsp">Participer</a></li>
            <c:if test = "${sessionScope['user'] == true}">
                <li><a href="ServletUsers?action=deconnexion" class="right"><i class="medium material-icons">power_settings_new</i></a></li>
            </c:if>
        </ul>
        <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">reorder</i></a>
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
            <div class="modal-footer">
                <div class="options">
                    <p>Pas encore inscrit ? <a href="participer-form.jsp">S'inscrire</a></p>
                </div>
                <input type="hidden" name="action" value="connexion"/>  
                <input class="btn waves-effect waves-light light-blue accent-3" type="submit" value="Connexion" name="submit"/>
            </div>
        </form>

    </div>
</div>
