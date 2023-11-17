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


public class Actualiza extends HttpServlet {
    PrintWriter out;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Actualiza</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Actualiza at " + request.getContextPath() + "</h1>");
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
        int id = Integer.parseInt(request.getParameter("id"));
        
        if (tipoDeEjercicio.contains("radioycentro")) {

            RadioYCirculo rc = new RadioYCirculo(
                    Float.parseFloat(request.getParameter("valorX")),
                    Float.parseFloat(request.getParameter("valorY")),
                    Float.parseFloat(request.getParameter("valorC")),
                    request.getParameter("tipoEc")
            );
            try {
                cont.actualizar(tipoDeEjercicio, id, rc, null);
            } catch (SQLException ex) {
                Logger.getLogger(Inserta.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (tipoDeEjercicio.contains("ecuacioncirculo")) {
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
                cont.actualizar(tipoDeEjercicio, id, null, ec);
            } catch (SQLException ex) {
                Logger.getLogger(Inserta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
