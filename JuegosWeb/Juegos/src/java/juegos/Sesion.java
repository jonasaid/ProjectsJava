package juegos;
public class Sesion {
    static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Sesion.user = user;
    }
    
}
