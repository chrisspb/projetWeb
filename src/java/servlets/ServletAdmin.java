/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import admins.gestionnaires.GestionnaireAdministrateurs;
import admins.modeles.Administrateurs;
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

/**
 *
 * @author Christian
 */
@WebServlet(name = "ServletAdmin", urlPatterns = {"/ServletAdmin"})
public class ServletAdmin extends HttpServlet {

    @EJB
    private GestionnaireAdministrateurs gestionnaireAdministrateurs;
    
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
        System.out.println("KKKKKKKK");
        System.out.println("Action : " + action);
        
        if(action.equals("connexion")){
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                System.out.println("kk - " + email + password);
                Collection adm = gestionnaireAdministrateurs.getOneAdm(email, password);
                if(adm.size() == 0){
                    System.out.println("Login - password incorrect"); 
                    session = request.getSession(false);
                    session.setAttribute("user", false);
                    forwardTo = "index-form.jsp?";  
                    message = "Identifiants incorrects";
                    request.setAttribute("message", message);
                    
                } else {
                    System.out.println("Connexion OK");  
                    session = request.getSession(true);
                    //Administrateurs a = (Administrateurs) adm.iterator().next();
                    session.setAttribute("connexionAdm", true);
                    System.out.println("kk - " + session.getAttribute("user"));
                    forwardTo = "index-form.jsp?";   
                    message = "Vous êtes maintenant connecté(e)";
                    request.setAttribute("message", message);
                }
        }
        System.out.println("forward : " + forwardTo);
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
