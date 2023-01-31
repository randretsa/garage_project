/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import connexion.Connexion;
import facturation.Facture;
import magasin.Piece;

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
@WebServlet(name = "ListFactureServlet", urlPatterns = {"/listfactureservlet"})
public class ListFactureServlet extends HttpServlet {

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
                            Facture facture = new Facture();
                           
                            request.setAttribute("listfacture", facture.getAllFacture(null));
                         
                        }catch(Exception e){
                             out.print(e.getStackTrace());
                        }

                         
                         RequestDispatcher dispat = request.getRequestDispatcher("/TableFacture.jsp");
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
                            String montant= request.getParameter("montant");
                          String idfacture = request.getParameter("idfacture");
        
                        try{

                            Facture facture = new Facture();

                            String id = request.getParameter("idfacture");
                            facture.setIdFacture(Integer.parseInt(id));
                           
                            facture.payer(null,Double.parseDouble(montant));
                            
                            request.setAttribute("Facture", facture.getFactureById(null, id));
                            

                            
                         
                        }catch(Exception e){
                             out.print(e.getStackTrace());
                        }

                         
                         RequestDispatcher dispat = request.getRequestDispatcher("/Facture.jsp");
                         dispat.forward(request,response); 
                
  
        
        //response.sendRedirect("/gestion_institut/noteservlet");
       
    }
}
