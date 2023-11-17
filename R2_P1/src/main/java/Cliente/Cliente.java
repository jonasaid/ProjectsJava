package Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente{
    
    private int pto=1234;
    private String dir="127.0.0.1";
    private Socket cliente;
    
    
    public Socket crearCliente() throws IOException{
        cliente = new Socket(dir,pto);
        System.out.println("Conexion establecida. Recibiendo datos...");
        return cliente;
    }
    
    public void cerrarCliente(Socket cl) throws IOException{
        cl.close();
        System.out.println("Adios");
    }
   
    public void enviarArchivo(String nombre, long tam, String ruta) throws IOException{
        crearCliente();
        System.out.println("Preparandose pare enviar archivo "+ruta+" de "+tam+" bytes\n\n");
        try (DataOutputStream dos = new DataOutputStream(cliente.getOutputStream()); 
            DataInputStream dis = new DataInputStream(new FileInputStream(ruta))) {
            dos.writeUTF(nombre);
            dos.flush();
            dos.writeLong(tam);
            dos.flush();
            long enviados = 0;
            int leidos=0,porcentaje=0;
            while(enviados<tam){
                byte[] b = new byte[1500];
                leidos=dis.read(b);
                System.out.println("enviados: "+leidos);
                dos.write(b,0,leidos);
                dos.flush();
                enviados = enviados + leidos;
                porcentaje = (int)((enviados*100)/tam);
                System.out.print("\rEnviado el "+porcentaje+" % del archivo");
            }
            System.out.println("\nArchivo enviado..");
        }
        cliente.close();
    }

}
    
    
    
    
    
 
