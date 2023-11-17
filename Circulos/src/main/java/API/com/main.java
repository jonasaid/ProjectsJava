package API.com;

import API.DB.RadioYCirculoCRUD;
import API.DB.EcucionCirculoCRUD;
import API.com.Resultado;
import API.com.EcuacionCirculo;
import API.com.RadioYCirculo;
import controlador.Controlador;
import java.sql.SQLException;

public class main {

    public static void main(String[] args) throws SQLException {
        
        RadioYCirculoCRUD rcCRUD = new RadioYCirculoCRUD();       
        EcucionCirculoCRUD ecCRUD = new EcucionCirculoCRUD();
        
        RadioYCirculo ryc = new RadioYCirculo(-2, 2, 16, "tipo1");
        Resultado res = null;
        res = ryc.resolver();
        System.out.println(res);
        rcCRUD.inserta(ryc);
//        rcCRUD.elimina(3);
        rcCRUD.seleccionaEjercicio(5);
        rcCRUD.seleccionaEjercicio();
        
        Controlador controla = new Controlador();
        controla.seleccionarEjercicio(16, ryc);
        
        RadioYCirculo ryc2 = new RadioYCirculo(2, -3, (float) -0.75, "tipo2");
        res = ryc2.resolver();
        System.out.println(res);
        rcCRUD.inserta(ryc2);
        
        RadioYCirculo ryc3 = new RadioYCirculo(2, -3, (float) -0.75, "tipoX");
        res = ryc3.resolver();
        System.out.println(res);
        rcCRUD.inserta(ryc3);
        
        EcuacionCirculo ec = new EcuacionCirculo("estandar", "porPuntos", -3, 4, 1, 2, 0);
        res = ec.resolver();
        System.out.println(res);
        ecCRUD.inserta(ec);
        
        EcuacionCirculo ec2 = new EcuacionCirculo("general", "porPuntos", -3, 4, 1, 2, 0);
        res = ec2.resolver();
        System.out.println(res);
        ecCRUD.inserta(ec2);
        
        EcuacionCirculo ec3 = new EcuacionCirculo("estandar", "radioDe", (float) .5, (float) -1.5, 1, 2, 5);
        res = ec3.resolver();
        System.out.println(res);
        ecCRUD.inserta(ec3);

        EcuacionCirculo ec4 = new EcuacionCirculo("general", "radioDe", (float) .5, (float) -1.5, 1, 2, 5);
        res = ec4.resolver();
        System.out.println(res);        
        ecCRUD.inserta(ec4);

        EcuacionCirculo ec5 = new EcuacionCirculo("general", "adioDe", (float) .5, (float) -1.5, 1, 2, 5);
        res = ec5.resolver();
        System.out.println(res);
        ecCRUD.inserta(ec5);
//        ecCRUD.elimina(3);
        ecCRUD.seleccionaEjercicio(5);
        ecCRUD.seleccionaEjercicio();        
    }
    
}
