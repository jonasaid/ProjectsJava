/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegos;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ConexionDB {
    Connection con;
    ResultSet rs;
    Statement stm;
    public void conectar() throws SQLException {   
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        con = DriverManager.getConnection("jdbc:mysql://localhost/juego","root","");
    }
    
    
    public void desconectar() throws SQLException{
        stm.close();
        rs.close();
        con.close();
    }
    
    public void registrarUsuario(User user) throws SQLException{
        String query = "insert into user (user, password) values(?, ?)";
        conectar();
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, user.getUser());
        pst.setString(2, user.getPassword());
        stm = con.createStatement();
        int rs = pst.executeUpdate();
        //desconectar();
    }
    
    public ArrayList<Juego> buscarJuegos(String nombreJuego) throws SQLException{
        String query = "select * from juego where LOWER(juego) like ?";
        conectar();
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, "%" + nombreJuego.toLowerCase() + "%");
        stm = con.createStatement();
        rs = pst.executeQuery();
        ArrayList<Juego> juegos=new ArrayList();
        while(rs.next()){
            Juego j= new Juego();
            j.setId(rs.getInt("id"));
            j.setNameJuego(rs.getString("juego"));
            j.setDescripcion(rs.getString("descripcion"));
            j.setLink(rs.getString("imagen"));
            juegos.add(j);
        }
        return juegos;
    }
    
    public Juego verJuego(String nombre) throws SQLException{
        String query="select * from juego where juego=?";
        conectar();
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, nombre);
        stm = con.createStatement();
        rs = pst.executeQuery();
        rs.next();
        Juego j= new Juego();
        j.setId(rs.getInt("id"));
        j.setNameJuego(rs.getString("juego"));
        j.setDescripcion(rs.getString("descripcion"));
        j.setLink(rs.getString("imagen"));
        
    return j;
    }
    
    public Juego verJuego(int id) throws SQLException{
        String query="select * from juego where id=?";
        conectar();
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, id);
        stm = con.createStatement();
        rs = pst.executeQuery();
        rs.next();
        Juego j= new Juego();
        j.setId(rs.getInt("id"));
        j.setNameJuego(rs.getString("juego"));
        j.setDescripcion(rs.getString("descripcion"));
        j.setLink(rs.getString("imagen"));
        
    return j;
    }
    
    
    
    public void agregarALista(int juegoId, int userId) throws SQLException{
        String query="insert into juego_user (fk_id_user,fk_id_juego) values(?,?)";
        conectar();
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1,userId );
        pst.setInt(2,juegoId );
        stm = con.createStatement();
        try {
            int rs = pst.executeUpdate(); 
        } catch (SQLException e) {
            
        }
    }
    
    public void modificar(Juego juego) throws SQLException{
        String query="update juego set descripcion = ? , imagen = ? where id = ?";
        conectar();
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1,juego.getDescripcion());
        pst.setString(2, juego.getLink());
        pst.setInt(3, juego.getId());
        stm = con.createStatement();
        try {
            int rs = pst.executeUpdate(); 
        } catch (SQLException e) {
            
        }
    }

    public void borrrarDeLista(int juegoId, int userId) throws SQLException{
        conectar();
        String query = "delete from juego_user where fk_id_juego = ? and fk_id_user = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, juegoId);
        pst.setInt(2, userId);
        int rs = pst.executeUpdate();
    }
    
    public void borrrarDeLista(String nombreJuego, int userId) throws SQLException{
        conectar();
        Juego juego = this.verJuego(nombreJuego);
        String query = "delete from juego_user where fk_id_juego = ? and fk_id_user = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, juego.getId());
        pst.setInt(2, userId);
        int rs = pst.executeUpdate();
    }
    
    public ArrayList<Juego> verDeLista(int userId) throws SQLException{
        String query="select * from juego_user join juego on juego.id = juego_user.fk_id_juego where juego_user.fk_id_user=?";
        conectar();
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, userId);
        stm = con.createStatement();
        rs = pst.executeQuery();
        ArrayList<Juego> juegos=new ArrayList();
        while(rs.next()){
            Juego j= new Juego();
            j.setId(rs.getInt("fk_id_juego"));
            j.setNameJuego(rs.getString("juego"));
            j.setDescripcion(rs.getString("descripcion"));
            j.setLink(rs.getString("imagen"));
            juegos.add(j);
        }
        return juegos;
    
    }
    
    public ArrayList<User> verUsuariosJuego(int juegoId, int userId) throws SQLException{
        String query = "select * from user join juego_user on user.id = juego_user.fk_id_user where juego_user.fk_id_juego = ? and juego_user.fk_id_user != ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, juegoId);
        pst.setInt(2, userId);
        rs = pst.executeQuery();
        ArrayList<User> users = new ArrayList();
        while(rs.next()){
            User u= new User();
            u.setId(rs.getInt("id"));
            u.setUser(rs.getString("user"));
            u.setPassword(rs.getString("password"));
            users.add(u);
        }
        return users;
    }
    
    public void insertarJuego(Juego juego) throws SQLException{
        String query = "insert into juego (juego, descripcion, imagen) values(?, ?, ?)";
        conectar();
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, juego.getNameJuego());
        pst.setString(2, juego.getDescripcion());
        pst.setString(3, juego.getLink());
        stm = con.createStatement();
        int rs = pst.executeUpdate();
    return;
    }
    
    public User validarUsuario(User user) throws SQLException{
        String query="select *from user where user=? and password=?";
        conectar();
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, user.getUser());
        pst.setString(2, user.getPassword());
        stm = con.createStatement();
        rs = pst.executeQuery();
        if(rs.next()){
            User u= new User();
            u.setId(rs.getInt("id"));
            u.setUser(rs.getString("user"));
            u.setPassword(rs.getString("password"));
            return u;
        }
        else{
            return null;
        }
    }
}
