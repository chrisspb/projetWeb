/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import enseignants.gestionnaires.GestionnaireEnseignants;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
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
 * @author Christian
 */
@WebServlet(name = "ServletEnseignants", urlPatterns = {"/ServletEnseignants"})
public class ServletEnseignants extends HttpServlet {

    @EJB
    private GestionnaireEtudiants gestionnaireEtudiants;
    @EJB
    private GestionnaireEnseignants gestionnaireEnseignants;

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
        response.setContentType("text/html;charset=UTF-8");

        String forwardTo = "";
        String message = "";
        HttpSession session = request.getSession(false);

        if (action.equals("inscriptionEnseignants")) {
            String prenom = request.getParameter("prenom");
            String nom = request.getParameter("nom");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String miage = request.getParameter("choix_miage");
            Enseignant ens = gestionnaireEnseignants.creeEnseignant(nom, prenom, email, password, miage);
            forwardTo = "index-form.jsp?";
            message = "Enseignant créé";
            request.setAttribute("message", message);
        } else if (action.equals("confirmer_inscription")) {

            Enseignant e = (Enseignant) session.getAttribute("enseignant");
            System.out.println("enseignant : " + e);
            //Collection m = gestionnaireEnseignants.getMiageEnseignant(e.getMiage());
            //String miage = (String) m.iterator().next();
            String miage = e.getMiage();
            System.out.println("miage : " + miage);

            Collection<Etudiant> liste = gestionnaireEtudiants.getEtudiantNotChecked(miage);
            request.setAttribute("listeDesEtudiants", liste);

            forwardTo = "confirmer-form.jsp?action=confirmer_inscription";
            message = "Enseignant créé";
            request.setAttribute("message", message);
        } else if (action.equals("validerEtudiant")) {
            String[] valeurs = request.getParameterValues("check");
            
            for (String str : valeurs) {
                int idEtu = Integer.parseInt(str.trim());
                System.out.println(idEtu);
                gestionnaireEtudiants.valideEtudiant(idEtu);
            }

            forwardTo = "index-form.jsp?";
            message = "Etudiant(s) validé(s)";
            request.setAttribute("message", message);
        }

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
