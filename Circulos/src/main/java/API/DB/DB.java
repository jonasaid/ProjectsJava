package API.DB;

import java.sql.*;

public class DB {

    private static String url = "jdbc:mysql://localhost:3306/CirculoBD";
    private static String username = "root";
    private static String password = "rootroot";

    public static Connection conecta() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, username, password);
            System.out.println("Se conectó con la BD");
        } catch(Exception e) {
            System.err.println("No se pudo conectar con la BD: " + e);
        }
        return con;
    }

    public static void desconecta(Connection con) throws SQLException {
        con.close();
    }

    public ResultSet ejecuta(String sentencia) throws SQLException {
        ResultSet rs = null;
        Connection con = conecta();
        
        try {
            PreparedStatement query;
            
            query = con.prepareStatement(sentencia);
            rs = query.executeQuery();
            rs.close();

        } catch (Exception e) {
            System.err.println("Error al ejecutar la sentencia: " + e);
        }
        desconecta(con);
        return rs;
    }
    
    public int ejecuta(String sentencia, String tipo) throws SQLException {
        ResultSet rs = null;
        Connection con = conecta();
        int id=0;
        if (tipo.contains("inserta")) {
            try {
                PreparedStatement query;

                query = con.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
                int res = query.executeUpdate();
                rs = query.getGeneratedKeys();
                rs.next();
                id = (int) rs.getLong(1);
                
                if (res>0) {
                    System.out.println("Ejercicio Insertado");
                }else{
                    System.err.println("Error al insertar el ejercicio");
                }               

            } catch (Exception e) {
                System.err.println("Error al ejecutar la sentencia de INSERT: " + e);
            }
        }else if ("elimina".contains(tipo)) {
            PreparedStatement query;

                query = con.prepareStatement(sentencia);
                int res = query.executeUpdate();
                
                if (res>0) {
                    System.out.println("Ejercicio Eliminado");
                }else{
                    System.err.println("Error al eliminar el ejercicio");
                }               

        }
        desconecta(con);
        return id;
    } 
    

}
