import java.net.*;
import java.io.*;
/**
 *
 * @author Axel
 */
public class CecoJC2 {
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
           PrintWriter pw = new PrintWriter(new OutputStreamWriter(cl.getOutputStream()));
            BufferedReader br2 = new BufferedReader(new InputStreamReader(cl.getInputStream()));
            while(true){
                System.out.println("Escribe un mensaje-- <enter> pare enviar, \"salir\" para terminar:");
                String msj = br.readLine();
                System.out.println("se enviarán "+msj.length()+"letras");
                byte[] b = msj.getBytes();
                System.out.println("se enviarán "+b.length+"bytes");
                //dos.write(b);
                //dos.flush();
                pw.println(msj);
                pw.flush();
                System.out.println("Mensaje enviado..");
                if(msj.compareToIgnoreCase("salir")==0){
                    System.out.println("termina aplicacion cliente..");
                    br2.close();
                    br.close();
                    pw.close();
                    cl.close();
                    System.exit(0);
                }else{
                    //byte[] beco = new byte[65535];
                    //int n= dis.read(beco);
                    String eco = br2.readLine();
                    System.out.println("Eco recibido: "+eco);
                }//else
            }//while
        }catch(Exception e){
            e.printStackTrace();
        }//catch
    }//main
}//class