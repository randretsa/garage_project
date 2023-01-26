/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import connexion.Connexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Employee;
import metier.Niveau;
import metier.Poste;

/**
 *
 * @author randretsa
 */
@WebServlet(name = "InsertEmployeServlet", urlPatterns = {"/insertemploye"})
public class InsertEmployeServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CandidatServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CandidatServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        //processRequest(request, response);
            
                        PrintWriter out = response.getWriter();          
        
                        try{

                            Niveau niveau = new Niveau();
                            Poste poste = new Poste();
                            ArrayList<Niveau> list_niveau = niveau.liste_niveau(null);
                            ArrayList<Poste> list_poste = poste.liste_poste(null);
                            
                         request.setAttribute("list_niveau", list_niveau);
                         request.setAttribute("list_poste", list_poste);
                         
                        }catch(Exception e){
                             out.print(e.getStackTrace());
                        }

                         
                         RequestDispatcher dispat = request.getRequestDispatcher("/insertion_employe.jsp");
                         dispat.forward(request,response);           

                
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
                
                PrintWriter out = response.getWriter();
            
          //      Object o = request.getSession().getAttribute("id_candidat");
                String nom= request.getParameter("nom");
                String prenom = request.getParameter("prenom");
                String date = request.getParameter("date_naissance");
                String idniveau = request.getParameter("niveau");
                String idposte = request.getParameter("poste");
                Employee employee = null;
                Connexion connexion = null;
                try{
                    
                    connexion = new Connexion();
                    employee = new Employee();
                    java.util.Date date_naissance = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                    //out.print(nom + prenom + date_naissance + idniveau + idposte);
                    
                    employee.saveEmploye(connexion.Connex("postgres"), nom, prenom, date_naissance,Integer.parseInt(idposte),Integer.parseInt(idniveau));
                   
                }catch(Exception e){

                    out.print(e);
                   
                }
                
  
        
        //response.sendRedirect("/gestion_institut/noteservlet");
       
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
