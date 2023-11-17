/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import API.com.EcuacionCirculo;
import API.com.RadioYCirculo;
import controlador.Controlador;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jona-
 */
public class Inserta extends HttpServlet {
    
    PrintWriter out;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Inserta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Inserta at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        controlador.Controlador cont = new Controlador();
        out = response.getWriter();
        response.setContentType("application/json");
        response.addHeader("Access-Control-Allow-Origin", "*");
        
        String tipoDeEjercicio = request.getParameter("tipoDeEjercicio");
        if (tipoDeEjercicio.contains("radioycirculo")) {
            
            RadioYCirculo rc = new RadioYCirculo(
                    Float.parseFloat(request.getParameter("valorX")),
                    Float.parseFloat(request.getParameter("valorY")),
                    Float.parseFloat(request.getParameter("valorC")),
                    request.getParameter("tipoEc")
            );
            try {
                cont.insertar(tipoDeEjercicio, rc, null);
            } catch (SQLException ex) {
                Logger.getLogger(Inserta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(tipoDeEjercicio.contains("ecuacioncirculo")){
            EcuacionCirculo ec = new EcuacionCirculo(
                    request.getParameter("mostrarEc"),
                    request.getParameter("tipoEc"),
                    Float.parseFloat(request.getParameter("valorX")),
                    Float.parseFloat(request.getParameter("valorY")),
                    Float.parseFloat(request.getParameter("puntoY")),
                    Float.parseFloat(request.getParameter("puntoX")),
                    Float.parseFloat(request.getParameter("valorC"))
            );
            try {
                cont.insertar(tipoDeEjercicio, null, ec);
            } catch (SQLException ex) {
                Logger.getLogger(Inserta.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
        
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
