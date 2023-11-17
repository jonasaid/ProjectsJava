import java.net.*;
import java.io.*;
/**
 *
 * @author Axel
 */
public class CecoJC {
    public static void main(String[] args){
        try{
            int pto = 1235;
            //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
            Socket cl = new Socket("2001::1234:1",pto);
            //Socket cl = new Socket("192.168.1.73",pto);
            //Socket cl = new Socket("192.168.1.65",pto);
            //Socket cl = new Socket("127.0.0.1",pto);
            cl.setOOBInline(true);
            DataOutputStream dos = new DataOutputStream(cl.getOutputStream());
            DataInputStream dis = new DataInputStream(cl.getInputStream());
            while(true){
                System.out.println("Escribe un mensaje-- <enter> pare enviar, \"salir\" para terminar:");
                String msj = br.readLine();
                System.out.println("se enviarán "+msj.length()+"letras");
                byte[] b = msj.getBytes();
                System.out.println("se enviarán "+b.length+"bytes");
                dos.write(b);
                dos.flush();
                System.out.println("Mensaje enviado..");
                if(msj.compareToIgnoreCase("salir")==0){
                    System.out.println("termina aplicacion cliente..");
                    dis.close();
                    dos.close();
                    cl.close();
                    System.exit(0);
                }else{
                    byte[] beco = new byte[65535];
                    int n= dis.read(beco);
                    String eco = new String(beco,0,n);
                    System.out.println("Eco recibido: "+eco);
                }//else
            }//while
        }catch(Exception e){
            e.printStackTrace();
        }//catch
    }//main
}//class
