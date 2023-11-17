/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import API.DB.RadioYCirculoCRUD;
import API.com.EcuacionCirculo;
import API.com.Ejercicio;
import API.com.RadioYCirculo;
import API.com.Resultado;
import controlador.Controlador;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jona-
 */
public class Resuelve extends HttpServlet {

    PrintWriter out;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
        Controlador cont = new Controlador();
        out = response.getWriter();
        response.setContentType("application/json");
        response.addHeader("Access-Control-Allow-Origin", "*");

        String tipoDeEjercicio = request.getParameter("tipoDeEjercicio");
        int idEjercicio = Integer.parseInt(request.getParameter("id"));
        Controlador controlador = new Controlador();
        StringBuilder jsonBuilder = new StringBuilder();
        try {
            Ejercicio ejercicio = controlador.seleccionarEjercicio(idEjercicio, tipoDeEjercicio);
            Resultado resultado = ejercicio.resolver();
            jsonBuilder.append("{");
            jsonBuilder.append("\"c1\":");
            jsonBuilder.append(resultado.getC1());
            jsonBuilder.append(",");
            jsonBuilder.append("\"c2\":");
            jsonBuilder.append(resultado.getC2());
            jsonBuilder.append(",");
            jsonBuilder.append("\"radio\":");
            jsonBuilder.append(resultado.getR());
            jsonBuilder.append(",");
            jsonBuilder.append("\"resuelta\":");
            jsonBuilder.append(resultado.isResuelta());
            jsonBuilder.append("}");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        out.write(jsonBuilder.toString());

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
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
