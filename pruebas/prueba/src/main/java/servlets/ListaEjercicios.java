/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import API.com.EcuacionCirculo;
import API.com.Ejercicio;
import controlador.Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jona-
 */
public class ListaEjercicios extends HttpServlet {

    PrintWriter out;
    private StringBuilder append;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListaEjercicios</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListaEjercicios at " + request.getContextPath() + "</h1>");
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
        try {
            List<Ejercicio> ejercicios = cont.seleccionarEjercicios(tipoDeEjercicio);
            if (tipoDeEjercicio.equals("radioycentro")) {
                StringBuilder jsonBuilder = new StringBuilder();
                jsonBuilder.append("[");
                for (Ejercicio ejercicio : ejercicios) {
                    jsonBuilder.append("{");
                    jsonBuilder.append("\"id\":");
                    jsonBuilder.append(ejercicio.getId());
                    jsonBuilder.append(",");
                    jsonBuilder.append("\"valorX\":");
                    jsonBuilder.append(ejercicio.getValorX());
                    jsonBuilder.append(",");
                    jsonBuilder.append("\"valorY\":");
                    jsonBuilder.append(ejercicio.getValorY());
                    jsonBuilder.append(",");
                    jsonBuilder.append("\"valorC\":");
                    jsonBuilder.append(ejercicio.getValorC());
                    jsonBuilder.append(",");
                    jsonBuilder.append("\"tipoEc\":");
                    jsonBuilder.append("\"" + ejercicio.getTipoEc() + "\"");
                    jsonBuilder.append("},");
                }
                jsonBuilder.deleteCharAt(jsonBuilder.length() - 1);
                jsonBuilder.append("]");
                String contenido = jsonBuilder.toString();

                out.write(contenido);
            } else {
                StringBuilder jsonBuilder = new StringBuilder();
                jsonBuilder.append("[");
                for (Ejercicio ejercicio : ejercicios) {
                    EcuacionCirculo ec = (EcuacionCirculo) ejercicio;
                    jsonBuilder.append("{");
                    jsonBuilder.append("\"id\":");
                    jsonBuilder.append(ec.getId());
                    jsonBuilder.append(",");
                    jsonBuilder.append("\"valorX\":");
                    jsonBuilder.append(ec.getValorX());
                    jsonBuilder.append(",");
                    jsonBuilder.append("\"valorY\":");
                    jsonBuilder.append(ec.getValorY());
                    jsonBuilder.append(",");
                    jsonBuilder.append("\"valorC\":");
                    jsonBuilder.append(ec.getValorC());
                    jsonBuilder.append(",");
                    jsonBuilder.append("\"puntoX\":");
                    jsonBuilder.append(ec.getpX());
                    jsonBuilder.append(",");
                    jsonBuilder.append("\"puntoY\":");
                    jsonBuilder.append(ec.getpY());
                    jsonBuilder.append(",");
                    jsonBuilder.append("\"mostrarEc\":");
                    jsonBuilder.append("\"" + ec.getMostrarEc() + "\"");
                    jsonBuilder.append(",");
                    jsonBuilder.append("\"tipoEc\":");
                    jsonBuilder.append("\"" + ec.getTipoEc() + "\"");
                    jsonBuilder.append("},");
                }
                jsonBuilder.deleteCharAt(jsonBuilder.length() - 1);
                jsonBuilder.append("]");
                String contenido = jsonBuilder.toString();

                out.write(contenido);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
