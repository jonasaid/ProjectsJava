package API.com;

import API.DB.DB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuarios {
    protected String user;
    protected String password;

    public Usuarios() {
    }
    
    public Usuarios(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
