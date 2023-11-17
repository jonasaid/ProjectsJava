import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.StandardSocketOptions;

public class Servidor {
   public static void main(String[] args){
       try{
           ServerSocket s = new ServerSocket(1234);
           s.setOption(StandardSocketOptions.SO_REUSEADDR, true);
           //s.setReuseAddress(true);
           boolean v = s.getOption(StandardSocketOptions.SO_REUSEADDR);
           System.out.println("opcion REUSEADDR: "+v);
           System.out.println("Servidor iniciado... esperando clientes..");
           for(;;){
               Socket cl = s.accept();
               System.out.println("Cliente conectado desde: "+cl.getInetAddress()+":"+cl.getPort());
               ObjectOutputStream oos = new ObjectOutputStream(cl.getOutputStream());
               Dato d1 = new Dato(1,2.0f,"tres");
               oos.writeObject(d1);
               oos.close();
               //PrintWriter pw = new PrintWriter(new OutputStreamWriter(cl.getOutputStream()));
//               DataOutputStream dos = new DataOutputStream(cl.getOutputStream());
//               dos.writeInt(5);
//               dos.writeFloat(7.0f);
//               dos.close();
//               //pw.println("mensaje desde el servidor..");
               //pw.close();
               cl.close();
           }//for
       }catch(Exception e){
           e.printStackTrace();
       }//catch
   }    //main
}
