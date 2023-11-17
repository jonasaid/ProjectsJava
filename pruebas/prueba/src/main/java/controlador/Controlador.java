package controlador;

import API.DB.DB;
import API.DB.EcuacionCirculoCRUD;
import API.DB.RadioYCirculoCRUD;
import API.com.EcuacionCirculo;
import API.com.Ejercicio;
import API.com.RadioYCirculo;
import API.com.Resultado;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Controlador {
    public void seleccionarEjercicio(int id, String tipoDeEjercicio) throws SQLException {
        if (tipoDeEjercicio.equalsIgnoreCase("ecuacioncirculo")) {
            EcuacionCirculoCRUD ecCRUD = new EcuacionCirculoCRUD();
            EcuacionCirculo ec = ecCRUD.seleccionaEjercicio(id);
            Resultado resolver = ec.resolver();
        } else if (tipoDeEjercicio.equalsIgnoreCase("radiocentro")) {
            RadioYCirculoCRUD rcCRUD = new RadioYCirculoCRUD();
            RadioYCirculo rc = rcCRUD.seleccionaEjercicio(id);
            Resultado resolver = rc.resolver();
        }
    }

    public List<Ejercicio> seleccionarEjercicios(String tipoDeEjercicio) throws SQLException {
        if (tipoDeEjercicio.equalsIgnoreCase("ecuacioncirculo")) {
            EcuacionCirculoCRUD ecCRUD = new EcuacionCirculoCRUD();
            List<EcuacionCirculo> ejerciciosEcCirculo =ecCRUD.seleccionaEjercicio();
            List<Ejercicio> ejercicios = new ArrayList<>();
            for (EcuacionCirculo ec: ejerciciosEcCirculo) {
                ejercicios.add(ec);
            }
            return ejercicios;
            
        } else if (tipoDeEjercicio.equalsIgnoreCase("radioycentro")) {
            RadioYCirculoCRUD rcCRUD = new RadioYCirculoCRUD();
            List<RadioYCirculo> ejerciciosEcCirculo =rcCRUD.seleccionaEjercicio();
            List<Ejercicio> ejercicios = new ArrayList<>();
            for (RadioYCirculo rc: ejerciciosEcCirculo) {
                ejercicios.add(rc);
            }
            return ejercicios;
        }
        return new ArrayList<>();
    }
    
    public void eliminar(String tipoDeEjercicio, int id) throws SQLException {
        if (tipoDeEjercicio.equalsIgnoreCase("ecuacioncirculo")) {
            EcuacionCirculoCRUD ecCRUD = new EcuacionCirculoCRUD();
            ecCRUD.elimina(id);
            
        } else if (tipoDeEjercicio.equalsIgnoreCase("radioycentro")) {
            RadioYCirculoCRUD rcCRUD = new RadioYCirculoCRUD();
            rcCRUD.elimina(id);
        }   
    }

        public void insertar(String tipoDeEjercicio, RadioYCirculo rc, EcuacionCirculo ec) throws SQLException {
        if (tipoDeEjercicio.equalsIgnoreCase("ecuacioncirculo")) {
            EcuacionCirculoCRUD ecCRUD = new EcuacionCirculoCRUD();
            ecCRUD.inserta(ec);
            
        } else if (tipoDeEjercicio.equalsIgnoreCase("radiocentro")) {
            RadioYCirculoCRUD rcCRUD = new RadioYCirculoCRUD();
            rcCRUD.inserta(rc);
        }   
    }
}
