/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import juegos.ConexionDB;
import juegos.Juego;
import juegos.Sesion;

/**
 *
 * @author imarban
 */
@WebServlet(name = "AgregarListaPreferidos", urlPatterns = {"/agregar-lista"})
public class AgregarListaPreferidos extends HttpServlet {

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
        
        ConexionDB bd = new ConexionDB();
        try {
            ArrayList<Juego> juegos = bd.verDeLista(Sesion.getUser().getId());
            request.setAttribute("juegos", juegos);
        } catch (SQLException ex) {
            Logger.getLogger(AgregarListaPreferidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getRequestDispatcher("/ListaPreferidos.jsp").forward(request, response);
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
        int id = Integer.valueOf(request.getParameter("id"));
        
        ConexionDB bd = new ConexionDB();
        try {
            bd.agregarALista(id, Sesion.getUser().getId());
            ArrayList<Juego> juegos = bd.verDeLista(Sesion.getUser().getId());
            request.setAttribute("juegos", juegos);
            request.getRequestDispatcher("/ListaPreferidos.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AgregarListaPreferidos.class.getName()).log(Level.SEVERE, null, ex);
        }
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
