/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* 
 * To change this template, choose Tools | Templates 
 * and open the template in the editor. 
 */
package servlets;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import participants.gestionnaires.GestionnaireEtudiants;
import participants.modeles.Etudiant;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import participants.modeles.Participants;

/**
 *
 * @author michel
 */
@WebServlet(name = "ServletUsers", urlPatterns = {"/ServletUsers"})
@MultipartConfig(location="/", fileSizeThreshold=1024*1024, maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5) 
//FICHIER D'UPLOAD GENERE A LA RACINE DU PROJET GLASSFISH !
public class ServletEtudiants extends HttpServlet {
    // ici injection de code ! On n'initialise pas ! 
    
    private final static Logger LOGGER
            = Logger.getLogger(ServletEtudiants.class.getCanonicalName());

    @EJB
    private GestionnaireEtudiants gestionnaireEtudiants;
    private boolean co = false;

    public boolean isCo() {
        return co;
    }

    public void setCo(boolean co) {
        this.co = co;
    }

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
        // Pratique pour décider de l'action à faire  

        response.setContentType("text/html;charset=UTF-8");
        
        String action = request.getParameter("action");
        String forwardTo = "";
        String message = "";
        HttpSession session = request.getSession(false);
        System.out.println("KKKKKKKK");
        System.out.println("Action : " + action);

        if (action != null) {

            if (action.equals("participer")) {
                // verification des parametres places dans la requete
                boolean diplome = false;
                // questions générales
                String prenom = request.getParameter("prenom");
                String nom = request.getParameter("nom");
                String email = request.getParameter("email");
                String etat = request.getParameter("group1");
                System.out.println("Etat : " + etat);
                String password = request.getParameter("password");
                
                //étudiant
                if(etat.equals("miagiste")){
                    String naissance = request.getParameter("date_naiss");
                    String photo = request.getParameter("fichier");
                    String dip = request.getParameter("group2");
                    System.out.println("dip : " + dip);

                    if (dip.equals("Ydiplome")) {
                        diplome = true;
                    }
                    Etudiant e = new Etudiant(nom, prenom, email, password, naissance, photo, diplome);
                    System.out.println(e.toString());
                    Etudiant e1 = gestionnaireEtudiants.creeEtudiant(nom, prenom, email, password, naissance, photo, diplome);

                    System.out.println("Compte étudiant créé : " + nom + prenom + email + password + ", naissance " + naissance + photo + diplome);
                }
                
                
                
                
                
                forwardTo = "index-form.jsp?";
                message = "Liste des utilisateurs";
                request.setAttribute("message", message);

            } else {
                forwardTo = "index.jsp?action=todo";
                message = "La fonctionnalité pour le paramètre " + action + " est à implémenter !";
            }
            //getServletContext().getRequestDispatcher("/index-form.jsp").forward(  
            //    request, response);
        }

        System.out.println("forward : " + forwardTo);
        RequestDispatcher dp = request.getRequestDispatcher(forwardTo);
        dp.forward(request, response);
        // Après un forward, plus rien ne peut être exécuté après !  
    }




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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Collection<Part> parts = request.getParts();
        out.write("<h2> Total parts : "+parts.size()+"</h2>");
        
        for(Part part : parts) {
            System.out.println("Name de part : " + part.getName());
            if(part.getName().equals("fichier")){
                System.out.println("Fichier trouvé");
                
                printPart(part, out);
                part.write(request.getParameter("fichier"));
            }
        }
        processRequest(request, response);
    }
    
    private void printPart(Part part, PrintWriter pw) {
        StringBuffer sb = new StringBuffer();
        sb.append("<p>");
        sb.append("Name : "+part.getName());
        sb.append("<br>");
        sb.append("Content Type : "+part.getContentType());
        sb.append("<br>");
        sb.append("Size : "+part.getSize());
        sb.append("<br>"); 
    for(String header : part.getHeaderNames()) {
        sb.append(header + " : "+part.getHeader(header));
        sb.append("<br>");
    }
    sb.append("</p>");
    pw.write(sb.toString());
    }
}