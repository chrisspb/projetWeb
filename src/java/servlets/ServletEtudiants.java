/* 
 * To change this template, choose Tools | Templates 
 * and open the template in the editor. 
 */  
package servlets;  
  
import java.io.IOException;  
import java.util.Collection;  
import java.util.List;
import javax.ejb.EJB;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;
import etudiants.gestionnaires.GestionnaireEtudiants;  
import etudiants.modeles.Etudiants;  
  
/** 
 * 
 * @author michel 
 */  

@WebServlet(name="ServletUsers", urlPatterns={"/ServletUsers"})
public class ServletEtudiants extends HttpServlet {  
    // ici injection de code ! On n'initialise pas ! 
    
    
    
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
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods. 
     * @param request servlet request 
     * @param response servlet response 
     * @throws ServletException if a servlet-specific error occurs 
     * @throws IOException if an I/O error occurs 
     */  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        // Pratique pour décider de l'action à faire  
        String action = request.getParameter("action");  
        String forwardTo = "";  
        String message = "";  
        HttpSession session = request.getSession(false);
        System.out.println("KKKKKKKK");
        System.out.println("Action : " + action);
  
        if (action != null) {  
            
            if(action.equals("participer")){
                // verification des parametres places dans la requete
                boolean diplome = false;
                String prenom = request.getParameter("prenom"); 
                String nom = request.getParameter("nom");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String naissance = request.getParameter("naissance");
                String photo = request.getParameter("photo");
                String dip = request.getParameter("group2");
                System.out.println("dip : " + dip);
                
                if(dip.equals("Ydiplome")){
                    diplome = true;
                }
                
                //traitement des parametres
                //gestionnaireEtudiants.creeEtudiant(nom, prenom, email, password, naissance, photo, diplome);
                
                //Collection<Utilisa-teur> liste = gestionnaireUtilisateurs.getAllUsers(); 
                System.out.println("Compte créé : " + nom + prenom + email + dip + naissance + photo + diplome);
                forwardTo = "index-form.jsp?";
                message = "Liste des utilisateurs";
                request.setAttribute("message", message);
                
            }
            
            else {  
                forwardTo = "index.jsp?action=todo";  
                message = "La fonctionnalité pour le paramètre " + action + " est à implémenter !";  
            }  
            //getServletContext().getRequestDispatcher("/index-form.jsp").forward(  
            //    request, response);
        }  
        
        System.out.println("forward : " + forwardTo);
        RequestDispatcher dp = request.getRequestDispatcher(forwardTo + "&message=" + message);   
        dp.forward(request, response); 
        // Après un forward, plus rien ne peut être exécuté après !  
    }  

    // Récupérer la session : httpSession session = request.getSession(false);
    
    
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