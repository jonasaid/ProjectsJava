package API.DB;

import API.com.EcuacionCirculo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EcuacionCirculoCRUD {
    DB db = new DB();

    public void inserta(EcuacionCirculo ec) throws SQLException {
        String query = "INSERT INTO ecuacioncirculo(centroX,centroY,radio,puntoX,puntoY,mostrarEc,tipoEc) VALUES(" + ec.getValorX() + "," + ec.getValorY() + "," + ec.getValorC() + "," + ec.getpX() + "," + ec.getpY() + "," + "\'" + ec.getMostrarEc() + "\'" + "," + "\'" + ec.getTipoEc() + "\');";
        ec.setId(db.ejecuta(query, "inserta"));
    }

    public void elimina(int id) throws SQLException {
        String query = "DELETE FROM ecuacioncirculo WHERE idEcuacionCirculo=" + id + ";";
        db.ejecuta(query, "elimina");
    }
    
    public void actualiza(int id, EcuacionCirculo ec) throws SQLException {
//      UPDATE ecuacioncirculo SET centroX = -3 , centroY = 4 , radio = 6 , puntoX = 2, puntoY = 2 WHERE idEcuacionCirculo = 2;
        String query = "UPDATE ecuacioncirculo SET centroX = "+ec.getValorX()+", centroY ="+ec.getValorY()+", radio = "+ec.getValorC()+", puntoX = "+ec.getpX()+", puntoY = "+ec.getpY()+" WHERE idEcuacionCirculo = "+id+";";
        db.ejecuta(query, "actualiza");
    }

    public EcuacionCirculo seleccionaEjercicio(int id) throws SQLException {
        String query = "SELECT * FROM ecuacioncirculo WHERE idecuacioncirculo=" + id + ";";
        Connection conexion = db.conecta();
        ResultSet rs = db.ejecuta(conexion, query);
        EcuacionCirculo ec = new EcuacionCirculo("", "", 0, 0, 0, 0, 0);
        while (rs.next()) {
            ec.setId(rs.getInt("idEcuacionCirculo"));
            ec.setValorX(rs.getFloat("centroX"));
            ec.setValorY(rs.getFloat("centroY"));
            ec.setValorC(rs.getFloat("radio"));
            ec.setpX(rs.getFloat("puntoX"));
            ec.setpY(rs.getFloat("puntoY"));
            ec.setMostrarEc(rs.getString("mostrarEC"));
            ec.setTipoEc(rs.getString("tipoEC"));
        }
        rs.close();
        db.desconecta(conexion);
        System.out.println(rs);
        return ec;
    }

    public List<EcuacionCirculo> seleccionaEjercicio() throws SQLException {
        String query = "SELECT * FROM ecuacioncirculo;";
        Connection conexion = db.conecta();
        ResultSet rs = db.ejecuta(conexion, query);
        List<EcuacionCirculo> ejercicios = new ArrayList<>();
        while (rs.next()){
            EcuacionCirculo ec = new EcuacionCirculo("", "", 0, 0, 0, 0, 0);
            ec.setId(rs.getInt("idEcuacionCirculo"));
            ec.setValorX(rs.getFloat("centroX"));
            ec.setValorY(rs.getFloat("centroY"));
            ec.setValorC(rs.getFloat("radio"));
            ec.setpX(rs.getFloat("puntoX"));
            ec.setpY(rs.getFloat("puntoY"));
            ec.setMostrarEc(rs.getString("mostrarEC"));
            ec.setTipoEc(rs.getString("tipoEC"));
            ejercicios.add(ec);
        }
        rs.close();
        db.desconecta(conexion);
        System.out.println(ejercicios.size());
        return ejercicios;
    }
}
