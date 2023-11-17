package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    
    
    public ServerSocket crearServidor() throws IOException{
        int pto = 1234;
        ServerSocket servidor = new ServerSocket(pto);
        servidor.setReuseAddress(true);
        System.out.println("Servidor iniciado, esperando por archivos...");
        return servidor;
    }
    
    public static String generarRuta(){
        File f = new File("");
        String ruta = f.getAbsolutePath();
        String carpeta="archivos";
        String ruta_archivos = ruta+"\\"+carpeta+"\\";
        System.out.println("ruta:"+ruta_archivos);
        File f2 = new File(ruta_archivos);
        f2.mkdirs();
        f2.setWritable(true);
        return ruta_archivos;
    }
    
    public void recibirArchivo() {
        try {
            ServerSocket servidor = crearServidor();
            String ruta_archivos = generarRuta();
            
            for(;;){
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado desde "+cliente.getInetAddress()+":"+cliente.getPort());
                DataInputStream dis = new DataInputStream(cliente.getInputStream());
                String nombre = dis.readUTF();
                long tam = dis.readLong();
                System.out.println("Comienza descarga del archivo "+nombre+" de "+tam+" bytes\n\n");
                DataOutputStream dos = new DataOutputStream(new FileOutputStream(ruta_archivos+nombre));
                long recibidos=0;
                int l=0, porcentaje=0;
                while(recibidos<tam){
                    byte[] b = new byte[1500];
                    l = dis.read(b);
                    System.out.println("leidos: "+l);
                    dos.write(b,0,l);
                    dos.flush();
                    recibidos = recibidos + l;
                    porcentaje = (int)((recibidos*100)/tam);
                    System.out.print("\rRecibido el "+ porcentaje +" % del archivo");
                }
                System.out.println("Archivo recibido.");
                dos.close();
                dis.close();
                cliente.close();
            }  
            
        } catch(Exception e) { e.printStackTrace(); }
    }

}
