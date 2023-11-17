import java.net.*;
import java.io.*;
/**
 *
 * @author Axel
 */
public class Cliente {
    public static void main(String[] args){
        try{
            String dir = "::1";
            int pto= 1234;
            Socket cl = new Socket(dir,pto);
            System.out.println("Conexion establecida. Recibiendo datos..");
            ObjectInputStream ois = new ObjectInputStream(cl.getInputStream());
            Dato d1 = (Dato)ois.readObject();
            System.out.println("Datos recibidos:\n v1:"+d1.v1+" v2:"+d1.v2+" v3:"+d1.v3);
            ois.close();
//            DataInputStream dis = new DataInputStream(cl.getInputStream());
//            int v1 = dis.readInt();
//            float v2 = dis.readFloat();
//            System.out.println("Datos recibidos: v1="+v1+" v2="+v2);
            //BufferedReader br = new BufferedReader(new InputStreamReader(cl.getInputStream()));
            //String mensaje = br.readLine();
            //System.out.println("Mensaje recibido: "+mensaje);
            //br.close();
//            dis.close();
            cl.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }//main
}
