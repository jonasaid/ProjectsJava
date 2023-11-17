package API.DB;

import API.com.EcuacionCirculo;
import API.com.RadioYCirculo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RadioYCirculoCRUD {
    DB db = new DB();

    public void inserta(RadioYCirculo rc) throws SQLException {
        String query = "INSERT INTO radioycirculo (centroX,centroY,radio,bandera) VALUES(" + rc.getValorX() + "," + rc.getValorY() + "," + rc.getValorC() + "," + " \'" + rc.getTipoEc() + "\'" + ");";
        rc.setId(db.ejecuta(query, "inserta"));
    }

    public void elimina(int id) throws SQLException {
        String query = "DELETE FROM radioycirculo WHERE idRadioYCirculo=" + id + ";";
        db.ejecuta(query, "elimina");
    }
    
     public void actualiza(int id, RadioYCirculo rc) throws SQLException {
        String query = "UPDATE radioycirculo SET centroX = "+rc.getValorX()+" , centroY = "+rc.getValorY() +", radio = "+rc.getValorC()+" WHERE idRadioYCirculo = "+id+";";
        db.ejecuta(query, "actualiza");
    }

    public RadioYCirculo seleccionaEjercicio(int id) throws SQLException {
        String query = "SELECT * FROM radioycirculo WHERE idRadioYCirculo=" + id + ";";
        Connection con = db.conecta();
        ResultSet rs = db.ejecuta(con, query);
        RadioYCirculo rc = new RadioYCirculo(0, 0, 0, "");
        while (rs.next()) {
            rc.setValorX(rs.getFloat("centroX"));
            rc.setValorY(rs.getFloat("centroY"));
            rc.setValorC(rs.getFloat("radio"));
            rc.setTipoEc(rs.getString("bandera"));
        }
        rs.close();
        con.close();
        return rc;
    }

    public List<RadioYCirculo> seleccionaEjercicio() throws SQLException {
        String query = "SELECT * FROM radioycirculo;";
        Connection con = db.conecta();
        ResultSet rs = db.ejecuta(con, query);
        List<RadioYCirculo> ejercicios = new ArrayList<>();
        while (rs.next()) {
            RadioYCirculo rc = new RadioYCirculo(0, 0, 0, "");
            rc.setId(rs.getInt("idRadioYCirculo"));
            rc.setValorX(rs.getFloat("centroX"));
            rc.setValorY(rs.getFloat("centroY"));
            rc.setValorC(rs.getFloat("radio"));
            rc.setTipoEc(rs.getString("bandera"));
            ejercicios.add(rc);
        }
        rs.close();
        con.close();
        return ejercicios;
    }

}
