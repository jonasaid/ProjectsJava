
package API.DB;

import API.com.EcuacionCirculo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuariosCRUD {
    DB db = new DB();

    public boolean existe(String usuario, String password) throws SQLException {
        String query = "SELECT * FROM usuarios WHERE user='" + usuario + "' AND password='" + password + "';";
        Connection conexion = db.conecta();
        try (ResultSet rs = db.ejecuta(conexion, query)) {
            if (rs.next()) {
                rs.close();
                return true;
            }
        }
        return false;
    }
}
