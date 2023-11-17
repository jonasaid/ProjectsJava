package servlets;

//    Gómez Marbán Jonathan Said
//    2020630657
//    5CM1
//    TAREA 1: RESOLUCION DE ECUACIONES LINEALES POR MÉTODO DE CRAMER
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import t1clases.Ecuaciones2x2;

public class Servlet1 extends HttpServlet {

    protected static void verificarEntrada(String numero){
        boolean isNumeric =  numero.matches("[+-]?\\d*");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Ecuaciones2x2 ecu1 = new Ecuaciones2x2(
            Double.parseDouble(request.getParameter("a11")),
            Double.parseDouble(request.getParameter("a12")),
            Double.parseDouble(request.getParameter("a21")),
            Double.parseDouble(request.getParameter("a22")),
            Double.parseDouble(request.getParameter("k1")),
            Double.parseDouble(request.getParameter("k2"))
        );
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Respuesta de ecuaciones</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Respuesta de ecuaciones</h1>");
            String ecuacionCadena= Ecuaciones2x2.pintarSolucionEcuacionLineal2x2Krammer(ecu1);
            out.println("<pre>"+ecuacionCadena+"</pre>");
            double resultados[] = ecu1.resolverEcuacionLineal2x2Krammer(ecu1);
            out.println("<label>x<sub>1</sub> = </label>"+resultados[0]+"<br>");
            out.println("<label>x<sub>2</sub> = </label>"+resultados[1]);
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
