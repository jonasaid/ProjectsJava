package controlador;

import API.DB.DB;
import API.DB.EcucionCirculoCRUD;
import API.DB.RadioYCirculoCRUD;
import API.com.EcuacionCirculo;
import API.com.Ejercicio;
import API.com.RadioYCirculo;
import API.com.Resultado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controlador {
    DB db = new DB();
    
    public void seleccionarEjercicio(int id, Ejercicio ej) throws SQLException{
        
        if (ej.getTipoEc().contains("porPuntos")||ej.getTipoEc().contains("radioDe")) {            
            EcucionCirculoCRUD ecCRUD = new EcucionCirculoCRUD();
            ResultSet rs = ecCRUD.seleccionaEjercicio(id);
            EcuacionCirculo ec = (EcuacionCirculo) ej;
            while (rs.next()) {                                        
                ec.setValorX(rs.getFloat("centroX"));
                ec.setValorY(rs.getFloat("centroY"));
                ec.setValorC(rs.getFloat("radio"));
                ec.setpX(rs.getFloat("puntoX"));
                ec.setpY(rs.getFloat("puntoY"));
                ec.setMostrarEc(rs.getString("mostrarEc"));
                ec.setTipoEc(rs.getString("tipoEc"));
            }            
            Resultado resolver = ec.resolver();
            System.out.println("Controlador: "+resolver);
            
        }else if(ej.getTipoEc().contains("tipo1")||ej.getTipoEc().contains("tipo2")){
            RadioYCirculoCRUD rcCRUD = new RadioYCirculoCRUD();
            ResultSet rs = rcCRUD.seleccionaEjercicio(id); 
            RadioYCirculo rc = (RadioYCirculo) ej;        
            while (rs.next()) {                                        
                rc.setValorX(rs.getFloat("centroX"));
                rc.setValorY(rs.getFloat("centroY"));
                rc.setValorC(rs.getFloat("radio"));
                rc.setTipoEc(rs.getString("tipoEc"));
            }            
            Resultado resolver = rc.resolver();
            System.out.println("Controlador: "+resolver);            
        }else{
            ej = new Ejercicio(0, 0, 0, "tipoX") {};
        }
    }
}
