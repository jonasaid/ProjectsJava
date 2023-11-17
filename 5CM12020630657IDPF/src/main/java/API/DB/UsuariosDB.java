package API.DB;

import API.com.RadioYCirculo;
import API.com.Usuarios;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuariosDB {
    protected DB db;
    
    public String validaUsuario(String user, String psw) throws SQLException{

        String query = "SELECT * FROM usuarios;";
        String usuarioCorrecto = "false"; 
        Connection con = db.conecta();
        ResultSet rs = db.ejecuta(con, query);
        Usuarios rc = new Usuarios();
        while (rs.next()) {
            rc.setUser(rs.getString("user"));
            rc.setPassword(rs.getString("password"));
            if (rc.getUser().contains(user) && rc.getPassword().contains(psw)) {
                usuarioCorrecto = "true";
                return usuarioCorrecto;
            }
        }
        rs.close();
        con.close();
        System.out.println(rs);
        return usuarioCorrecto;
//        String query = "SELECT * FROM usuarios;";
//        String usuarioCorrecto = "false";
//        try (Connection con = db.conecta()) {
//            ResultSet rs = db.ejecuta(con, query);
//            Usuarios usuario = new Usuarios();
//            while (rs.next()) {
//                usuario.setUser(rs.getString("user"));
//                usuario.setPassword(rs.getString("password"));
//                if (usuario.getUser().contains(user) && usuario.getPassword().contains(psw)) {
//                    usuarioCorrecto = "true";
//                }
//            }
//            rs.close();
//        }
//        return usuarioCorrecto;
    }
}
