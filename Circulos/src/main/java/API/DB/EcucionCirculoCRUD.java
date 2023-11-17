package API.DB;

import API.com.EcuacionCirculo;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EcucionCirculoCRUD {
    DB db = new DB();
    
    public void inserta(EcuacionCirculo ec) throws SQLException{
        String query = "INSERT INTO ecuacioncirculo(centroX,centroY,radio,puntoX,puntoY,mostrarEc,tipoEc) VALUES("+ec.getValorX()+","+ec.getValorY()+","+ec.getValorC()+","+ec.getpX()+","+ec.getpY()+","+ "\'" + ec.getMostrarEc()+ "\'" + ","+ "\'"+ ec.getTipoEc()+ "\');";        
        ec.setId(db.ejecuta(query,"inserta"));
    }
    
    public void elimina(int id) throws SQLException{
        String query="DELETE FROM ecuacioncirculo WHERE idEcuacionCirculo="+id+";";
        db.ejecuta(query,"elimina");
    }
    
    public ResultSet seleccionaEjercicio(int id) throws SQLException{
        String query="SELECT * FROM ecuacioncirculo WHERE idecuacioncirculo="+id+";";
        ResultSet rs = db.ejecuta(query);
        System.out.println(rs);
        return rs;
    }
    
    public ResultSet seleccionaEjercicio() throws SQLException{
        String query="SELECT * FROM ecuacioncirculo;";
        ResultSet rs = db.ejecuta(query);
        System.out.println(rs);
        return rs;
    }
}
