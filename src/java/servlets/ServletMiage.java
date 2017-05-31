/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

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
import miage.gestionnaires.GestionnaireMiage;
import miage.modeles.Miage;
import participants.gestionnaires.GestionnaireEtudiants;
import participants.modeles.Etudiant;

/**
 *
 * @author perle
 */
@WebServlet(name = "ServletMiage", urlPatterns = {"/ServletMiage"})
public class ServletMiage extends HttpServlet {
    
    @EJB
    private GestionnaireEtudiants gestionnaireEtudiants;
    @EJB
    private GestionnaireMiage gestionnaireMiage;

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

        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        String forwardTo = "";
        String message = "";

        if (action != null) {

            if (action.equals("lien_participer")) {
                Collection<Miage> liste = gestionnaireMiage.getAllMiage();
                request.setAttribute("listeDesMiages", liste);

                forwardTo = "participer-form.jsp?action=lien_participer";
                message = "Liste des utilisateurs";
                request.setAttribute("message", message);

            }
            else if (action.equals("lien_admin")) {
                Collection<Miage> liste = gestionnaireMiage.getAllMiage();
                request.setAttribute("listeDesMiages", liste);

                forwardTo = "admin-form.jsp?action=lien_admin";
                message = "Liste des utilisateurs";
                request.setAttribute("message", message);

            }
            else if (action.equals("trombinoscope")) {
                Collection<Miage> liste = gestionnaireMiage.getAllMiage();
                request.setAttribute("listeDesMiages", liste);

                forwardTo = "trombinoscope-form.jsp?action=trombinoscope";
                message = "Liste des utilisateurs";
                request.setAttribute("message", message);
            }
            else if (action.equals("trombi_miage")) {
                String miage = request.getParameter("choix_miage");
                Collection<Etudiant> liste = gestionnaireEtudiants.getEtudiantByMiage(miage);
                request.setAttribute("listeDesEtudiants", liste); 
                System.out.println(liste);
                request.setAttribute("miage_choisie", miage);
                Collection<Miage> listeM = gestionnaireMiage.getAllMiage();
                request.setAttribute("listeDesMiages", listeM);
                forwardTo = "trombinoscope-form.jsp?action=trombi_miage";
            }
            else {
                forwardTo = "index.jsp?action=todo";
                message = "La fonctionnalité pour le paramètre " + action + " est à implémenter !";
            }
        }

        System.out.println("forward : " + forwardTo);
        RequestDispatcher dp = request.getRequestDispatcher(forwardTo);
        dp.forward(request, response);
        // Après un forward, plus rien ne peut être exécuté après !  
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
