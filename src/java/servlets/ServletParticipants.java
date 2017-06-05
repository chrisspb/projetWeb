/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import admins.gestionnaires.GestionnaireAdministrateurs;
import enseignants.gestionnaires.GestionnaireEnseignants;
import entreprise.gestionnaire.GestionnaireEntreprise;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import participants.gestionnaires.GestionnaireEtudiants;
import participants.modeles.Enseignant;
import participants.modeles.Etudiant;

/**
 *
 * @author perle
 */
@WebServlet(name = "ServletParticipants", urlPatterns = {"/ServletParticipants"})
public class ServletParticipants extends HttpServlet {
    @EJB
    private GestionnaireEtudiants gestionnaireEtudiants;
    @EJB
    private GestionnaireEnseignants gestionnaireEnseignants;
    @EJB
    private GestionnaireAdministrateurs gestionnaireAdministrateurs;
    @EJB
    private GestionnaireEntreprise gestionnaireEntreprise;
    


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String forwardTo = "";
        String message = "";
        Boolean connexion = false;

        HttpSession session = request.getSession();

        //System.out.println("Action : " + action);

        if (action.equals("connexion")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            //System.out.println(email + password);
            Collection enseignant = gestionnaireEnseignants.getOneEnseignant(email, password);
            
            //System.out.println("taille collection enseignant : " + enseignant.size());
            if (enseignant.size() != 0) {
                //System.out.println("Connexion de l'enseignant OK !");
                Enseignant ens = (Enseignant) enseignant.iterator().next();
                session.setAttribute("connexionEnseignant", true);
                session.setAttribute("user", true);
                //System.out.println("Enseignant placé en attribut de session : " + ens);
                session.setAttribute("enseignant", ens);
                forwardTo = "index-form.jsp?";
                message = "Vous êtes maintenant connecté(e)";
                request.setAttribute("message", message);
                connexion = true;
            }

            Collection adm = gestionnaireAdministrateurs.getOneAdm(email, password);
            if (adm.size() != 0) {
                //System.out.println("Connexion OK");
                //Administrateurs a = (Administrateurs) adm.iterator().next();
                session.setAttribute("connexionAdm", true);
                session.setAttribute("user", true);
                //System.out.println(session.getAttribute("user"));
                forwardTo = "index-form.jsp?";
                message = "Vous êtes maintenant connecté(e)";
                request.setAttribute("message", message);
                connexion = true;
            }
            
            Collection ent = gestionnaireEntreprise.getOneEntreprise(email, password);
            if(ent.size() != 0){
                //System.out.println("Connexion OK");
                session.setAttribute("user", true);
                forwardTo = "index-form.jsp?";
                message = "Vous êtes maintenant connecté(e)";
                request.setAttribute("message", message);
                connexion = true;
            }

            Collection etu = gestionnaireEtudiants.getOneEtudiant(email, password);
            //System.out.println("taille collection etudiant : " + etu.size());
            if (etu.size() != 0) {
                //System.out.println("Connexion OK");
                Etudiant e = (Etudiant) etu.iterator().next();
                boolean b = gestionnaireEtudiants.verifCompteValide(e.getId());
                if(b){
                    session.setAttribute("etuValide", true);
                }
                    //System.out.println("Compte etudiant valide");
//                } else {
//                    System.out.println("compte etudiant non valide");
//                }
                //Administrateurs a = (Administrateurs) adm.iterator().next();
                session.setAttribute("connexionEtudiant", true);
                session.setAttribute("objEtudiant", e.getId());
                session.setAttribute("user", true);
                //System.out.println(session.getAttribute("user"));
                forwardTo = "index-form.jsp?";
                message = "Vous êtes maintenant connecté(e)";
                request.setAttribute("message", message);
                connexion = true;
            }

            if (!connexion) {
                session.setAttribute("user", false);
                forwardTo = "index-form.jsp?";
                message = "Identifiants incorrects";
                request.setAttribute("message", message);
            }

        }

        if (action.equals("deconnexion")) {
            //System.out.println("Déconnexion");
            session.setAttribute("connexionEnseignant", false);
            session.setAttribute("connexionAdm", false);
            session.setAttribute("connexionEtudiant", false);
            session.setAttribute("user", false);
            session.invalidate();
            forwardTo = "index-form.jsp?";
            message = "Vous venez de vous déconnecter";
            request.setAttribute("message", message);
        }
        ///System.out.println("forward : " + forwardTo);
        RequestDispatcher dp = request.getRequestDispatcher(forwardTo);
        dp.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
