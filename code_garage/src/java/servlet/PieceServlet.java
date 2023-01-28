/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import connexion.Connexion;
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
@WebServlet(name = "PieceServlet", urlPatterns = {"/pieceservlet"})
public class PieceServlet extends HttpServlet {

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

                            Piece piece = new Piece();
                            ArrayList<Piece> list_piece = piece.getListePiece(null);

                            
                            request.setAttribute("ListPiece", list_piece);
                         
                        }catch(Exception e){
                             out.print(e.getStackTrace());
                        }

                         
                         RequestDispatcher dispat = request.getRequestDispatcher("/PieceFormulaire.jsp");
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
                String idpiece= request.getParameter("piece");
                          
        
                        try{

                            Piece piece = new Piece();
                            ArrayList<Piece> list_piece = piece.getListePiece(null);
                            ArrayList<Piece> list_piece2 = new ArrayList<Piece>();

                            for (int i = 0; i < list_piece.size(); i++) {
                                if (list_piece.get(i).getId() == Integer.parseInt(idpiece)) {
                                    list_piece2.add(list_piece.get(i));
                                }
                            }

                            
                            request.setAttribute("ListPiece", list_piece2);
                         
                        }catch(Exception e){
                             out.print(e.getStackTrace());
                        }

                         
                         RequestDispatcher dispat = request.getRequestDispatcher("/ListePiece.jsp");
                         dispat.forward(request,response); 
                
  
        
        //response.sendRedirect("/gestion_institut/noteservlet");
       
    }
}
