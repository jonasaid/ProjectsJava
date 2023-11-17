package API.DB;

import API.com.RadioYCirculo;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RadioYCirculoCRUD {
    DB db = new DB();
    
    public void inserta(RadioYCirculo rc) throws SQLException{
        String query =  "INSERT INTO radioycirculo (centroX,centroY,radio,bandera) VALUES("+rc.getValorX()+","+rc.getValorY()+","+rc.getValorC()+","+ " \'"+rc.getTipoEc()+"\'"+");";
        rc.setId(db.ejecuta(query,"inserta"));        
    }
    
    public void elimina(int id) throws SQLException{
        String query="DELETE FROM radioycirculo WHERE idRadioYCirculo="+id+";";
        db.ejecuta(query,"elimina");
    }
    
    public ResultSet seleccionaEjercicio(int id) throws SQLException{
        String query="SELECT * FROM radioycirculo WHERE idRadioYCirculo="+id+";";
        ResultSet rs = db.ejecuta(query);
        System.out.println(rs);
        return rs;
    }
    
    public ResultSet seleccionaEjercicio() throws SQLException{
        String query="SELECT * FROM radioycirculo;";
        ResultSet rs = db.ejecuta(query);
        System.out.println(rs);
        return rs;
    }
    
}
