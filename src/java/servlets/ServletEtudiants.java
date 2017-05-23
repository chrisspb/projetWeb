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
import etudiants.gestionnaires.GestionnaireEtudiants;
import etudiants.modeles.Etudiants;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author michel
 */
@WebServlet(name = "ServletUsers", urlPatterns = {"/ServletUsers"})
@MultipartConfig
@Path("C:\\Users\\Christian\\Desktop")
    @Produces(MediaType.TEXT_HTML)
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
                String prenom = request.getParameter("prenom");
                String nom = request.getParameter("nom");
                String email = request.getParameter("email");
                String etat = request.getParameter("group1");
                System.out.println("Etat : " + etat);
                String password = request.getParameter("password");
                String naissance = request.getParameter("date_naiss");
                String photo = request.getParameter("fichier");
                String dip = request.getParameter("group2");
                System.out.println("dip : " + dip);

                if (dip.equals("Ydiplome")) {
                    diplome = true;
                }
                
                //TEST DE LA MORT
                this.uploadFile(request, response);

                //traitement des parametres
                //gestionnaireEtudiants.creeEtudiant(nom, prenom, email, password, naissance, photo, diplome);
                //Collection<Utilisa-teur> liste = gestionnaireUtilisateurs.getAllUsers(); 
                System.out.println("Compte créé : " + nom + prenom + email + password + ", naissance " + naissance + photo + diplome);
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

    // Récupérer la session : httpSession session = request.getSession(false);
    
    private void uploadFile(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    

    // Create path components to save the file
    final String path = "C:\\Users\\Christian\\Desktop";
    final Part filePart = request.getPart("fichier");
        System.out.println("Nom fichier : " + getFileName(filePart));
    final String fileName = getFileName(filePart);

    OutputStream out = null;
    InputStream filecontent = null;
    //final PrintWriter writer = response.getWriter();

    
        try {
        out = new FileOutputStream(new File(path + File.separator
                + fileName));
        filecontent = filePart.getInputStream();

        int read = 0;
        final byte[] bytes = new byte[1024];

        while ((read = filecontent.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        //writer.println("New file " + fileName + " created at " + path);
        //LOGGER.log(Level.INFO, "File{0}being uploaded to {1}",
        //        new Object[]{fileName, path});
    }
    catch (FileNotFoundException fne) {
        //writer.println("You either did not specify a file to upload or are "
        //        + "trying to upload a file to a protected or nonexistent "
        //        + "location.");
        //writer.println("<br/> ERROR: " + fne.getMessage());

        LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}",
                new Object[]{fne.getMessage()});
    } finally {
        if (out != null) {
            out.close();
        }
        if (filecontent != null) {
            filecontent.close();
        }
//        if (writer != null) {
//            writer.close();
//        }
            System.out.println("Scoobidou");
    }
}

private String getFileName(final Part part) {
    final String partHeader = part.getHeader("content-disposition");
    LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
    for (String content : part.getHeader("content-disposition").split(";")) {
        if (content.trim().startsWith("filename")) {
            return content.substring(
                    content.indexOf('=') + 1).trim().replace("\"", "");
        }
    }
    return null;
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
        processRequest(request, response);
    }
    
}
