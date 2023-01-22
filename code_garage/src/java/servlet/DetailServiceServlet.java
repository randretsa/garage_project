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
import metier.Service;

/**
 *
 * @author randretsa
 */
@WebServlet(name = "DetailServiceServlet", urlPatterns = {"/detailserviceservlet"})
public class DetailServiceServlet extends HttpServlet {

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

                            Service service = new Service();

                            Service Services = service.getService_By_Id(null,request.getParameter("id"));

                            
                            request.setAttribute("Services", Services);
                         
                        }catch(Exception e){
                             out.print(e.getStackTrace());
                        }

                         
                         RequestDispatcher dispat = request.getRequestDispatcher("/detail.jsp");
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
                String marge_beneficiaire= request.getParameter("marge_beneficiaire");
                String id = request.getParameter("id");
                Connexion connexion = null;
                try{
                    
                   connexion = new Connexion();
                   Service service = new Service();
                   
                   service.getUpdate_marge_beneficiaire(null, marge_beneficiaire, id);
                }catch(Exception e){

                    out.print(e);
                   
                }
                
  
        
        response.sendRedirect("/code_garage/devisservlet");
       
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
