<%-- 
    Document   : info
    Created on : 21 mai 2017, 18:30:09
    Author     : perle
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informations</title>
    </head>
    <body>
        <div class="marge">
            <div class="card">
                <div class="card-content">
                    <span class="card-title center-align">INFORMATIONS PRATIQUES</span>

                    </br>

                    <b>Accessibilité :</b>
                    <div class="input-field col s12">
                        <li>En voiture :</li>
                        <li>En train :</li>
                        <li>En bus :</li>
                    </div>

                    </br>

                    <b>Lieux :</b>
                    <div class="input-field col s12">
                        <p>Pour les hébergements :</p>
                        <li>Hôtel :</li>
                        <li>Hôtel :</li>
                        <li>Auberge de jeunesse :</li>
                    </div>
                    </br>
                    <p>(les petits déjeuners sont compris)</p>
                </div>
            </div>

            <h5 class="center titre">TARIFS</h5>

            </br>

            <p class="center"><b>Attention : la date de cloture des inscriptions est le 23 Mai 2017 !</b></p>

            </br>

            <div class="row">
                <div class="col s12 m4">
                    <div class="card pack">
                        <div class="card-content light-green lighten-1">
                            <h5 class="center"><b>110&euro;</b></h5>
                        </div>
                        <div class="card-content">
                            <span class="card-title center">PACK ETUDIANT</span>
                            <div class="center contenu">
                                <p>Hébergement mardi, mercredi, jeudi et vendredi soir</p>
                                <p>Repas du mercredi midi au vendredi</p>
                                <p>Soirée Entreprise</p>
                                <p>Soirée Gala</p>
                                <p>Transport</p>
                            </div>
                        </div>
                        <c:if test = "${sessionScope['connexionEtudiant'] == true}">
                            <div class="card-action">
                                <a href="#achatE" id="packE"><i class="material-icons">shopping_cart</i></a>
                            </div>
                        </c:if>
                    </div>
                </div>
                <div class="col s12 m4">
                    <div class="card pack">
                        <div class="card-content amber lighten-3">
                            <h5 class="center"><b>160&euro;</b></h5>
                        </div>
                        <div class="card-content">
                            <span class="card-title center">PACK DIPLÔMÉ</span>
                            <div class="center contenu">
                                <p>Hébergement mardi, mercredi, jeudi et vendredi soir</p>
                                <p>Repas du mercredi midi au vendredi</p>
                                <p>Soirée Entreprise</p>
                                <p>Soirée Gala</p>
                                <p>Transport</p>
                            </div>
                        </div>
                        <c:if test = "${sessionScope['connexionEtudiant'] == true}">
                            <div class="card-action">
                                <a href="#achatD" id="packD"><i class="material-icons">shopping_cart</i></a>
                            </div>
                        </c:if>
                    </div>
                </div>
                <div class="col s12 m4">
                    <div class="card pack">
                        <div class="card-content amber lighten-3">
                            <h5 class="center"><b>100&euro;</b></h5>
                        </div>
                        <div class="card-content">
                            <span class="card-title center">PACK DIPLÔMÉ SANS HEBERGEMENT</span>
                            <div class="center contenu">
                                <p>Repas du mercredi midi au vendredi</p>
                                <p>Soirée Entreprise</p>
                                <p>Soirée Gala</p>
                                <p>Transport</p>
                            </div>
                        </div>
                        <c:if test = "${sessionScope['connexionEtudiant'] == true}">
                            <div class="card-action">
                                <a href="#achatDSH" id="packDSH"><i class="material-icons">shopping_cart</i></a>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>

            </br>

            <div class="card">
                <div class="card-content">
                    <span class="card-title center-align"><b>Règlements</b></span>

                    </br>

                    <div class="contenu">
                        <p>Les règlements s'effectueront soit par virement bancaire
                            (un RIB vous sera fourni) soit via notre site WeezEvent.</p>
                        <p>Il ne sera possible de régler qu'après validation de votre inscription.</p>
                    </div>
                </div>
            </div>

            <div class="modal fade" id="achatE" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <!--Content-->
                    <div class="modal-content">
                        <!--Header-->
                        <div class="modal-header">
                            <h4 class="modal-title" id="titre">Votre panier</h4>
                        </div>
                        <!--Body-->
                        <div class="modal-body">
                            <table class="table table-hover centered">
                                <thead>
                                    <tr>
                                        <th>Pack</th>
                                        <th>Prix</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>ETUDIANT</td>
                                        <td>110&euro;</td>
                                    </tr>
                                </tbody>
                            </table>
                            <div class="modal-footer">
                                <a href="#!" class="btn modal-action modal-close waves-effect waves-light grey">Fermer</a>
                                <form action="https://www.paypal.com/cgi-bin/webscr" method="post">

                                    <!-- Identify your business so that you can collect the payments. -->
                                    <input type="hidden" name="business" value="adresse@miage.fr">

                                    <!-- Specify a Buy Now button. -->
                                    <input type="hidden" name="cmd" value="_xclick">

                                    <!-- Specify details about the item that buyers will purchase. -->
                                    <input type="hidden" name="item_name" value="JNM 2018 - Pack etudiant">
                                    <input type="hidden" name="amount" value="110">
                                    <input type="hidden" name="currency_code" value="EUR">

                                    <!-- Display the payment button. -->
                                    <input class="btn waves-effect waves-light light-blue accent-3 left" type="submit" value="Acheter" name="submit"/>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal fade" id="achatD" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <!--Content-->
                    <div class="modal-content">
                        <!--Header-->
                        <div class="modal-header">
                            <h4 class="modal-title" id="titre">Votre panier</h4>
                        </div>
                        <!--Body-->
                        <div class="modal-body">
                            <table class="table table-hover centered">
                                <thead>
                                    <tr>
                                        <th>Pack</th>
                                        <th>Prix</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>DIPLÔMÉ</td>
                                        <td>160&euro;</td>
                                    </tr>
                                </tbody>
                            </table>
                            <div class="modal-footer">
                                <a href="#!" class="btn modal-action modal-close waves-effect waves-light grey">Fermer</a>
                                <form action="https://www.paypal.com/cgi-bin/webscr" method="post">

                                    <!-- Identify your business so that you can collect the payments. -->
                                    <input type="hidden" name="business" value="adresse@miage.fr">

                                    <!-- Specify a Buy Now button. -->
                                    <input type="hidden" name="cmd" value="_xclick">

                                    <!-- Specify details about the item that buyers will purchase. -->
                                    <input type="hidden" name="item_name" value="JNM 2018 - Pack diplome">
                                    <input type="hidden" name="amount" value="160">
                                    <input type="hidden" name="currency_code" value="EUR">

                                    <!-- Display the payment button. -->
                                    <input class="btn waves-effect waves-light light-blue accent-3 left" type="submit" value="Acheter" name="submit"/>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal fade" id="achatDSH" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <!--Content-->
                    <div class="modal-content">
                        <!--Header-->
                        <div class="modal-header">
                            <h4 class="modal-title" id="titre">Votre panier</h4>
                        </div>
                        <!--Body-->
                        <div class="modal-body">
                            <table class="table table-hover centered">
                                <thead>
                                    <tr>
                                        <th>Pack</th>
                                        <th>Prix</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>DIPLÔMÉ SANS HÉBERGEMENT</td>
                                        <td>100&euro;</td>
                                    </tr>
                                </tbody>
                            </table>
                            <div class="modal-footer">
                                <a href="#!" class="btn modal-action modal-close waves-effect waves-light grey">Fermer</a>
                                <form action="https://www.paypal.com/cgi-bin/webscr" method="post">

                                    <!-- Identify your business so that you can collect the payments. -->
                                    <input type="hidden" name="business" value="adresse@miage.fr">

                                    <!-- Specify a Buy Now button. -->
                                    <input type="hidden" name="cmd" value="_xclick">

                                    <!-- Specify details about the item that buyers will purchase. -->
                                    <input type="hidden" name="item_name" value="JNM 2018 - Pack diplome sans hebergement">
                                    <input type="hidden" name="amount" value="100">
                                    <input type="hidden" name="currency_code" value="EUR">

                                    <!-- Display the payment button. -->
                                    <input class="btn waves-effect waves-light light-blue accent-3 left" type="submit" value="Acheter" name="submit"/>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
