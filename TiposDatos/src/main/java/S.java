/*C:\Users\52552\.m2\repository\com\googlecode\json-simple\json-simple\1.1\json-simple-1.1.jar*/
/*Json simple, Jackson JSON Java Parser*/
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.StandardSocketOptions;
import java.nio.charset.StandardCharsets;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class S {
    public static void main(String[] args){
        try{
            ServerSocket s = new ServerSocket(9999);
            s.setReuseAddress(true);
            s.setOption(StandardSocketOptions.SO_REUSEADDR, true);
            boolean opcion = s.getOption(StandardSocketOptions.SO_REUSEADDR);
            System.out.println("estado de la opcion SO_REUSEADDR: "+opcion);

            System.out.println("Servidor iniciado, esperando clientes..");
            for(;;){
                Socket cl = s.accept();
                System.out.println("Cliente conectado.. enviando datos..");
                JSONObject json = new JSONObject();
                json.put("nombre", "Adrian");
                json.put("apaterno","Campos");
                json.put("amaterno","Lozano");
                
                //OutputStreamWriter osw = new OutputStreamWriter(cl.getOutputStream(),StandardCharsets.UTF_8);
                PrintWriter wr = new PrintWriter(new OutputStreamWriter(cl.getOutputStream()));
                wr.write(json.toString()+"\n");
                wr.flush();
                System.out.println("json enviado..");
                System.out.println(json);
                
                JSONObject json2 = new JSONObject();
                json2.put("nombre", "Memo");
                json2.put("edad", 100);
                JSONArray list = new JSONArray();
                JSONObject innerObj = new JSONObject();
                innerObj.put("lenguaje1", "java");
                innerObj.put("lenguaje2", "C");
                innerObj.put("lenguaje3", "python");
                list.add(innerObj);
                json2.put("conocimientos", list);
                wr.write(json2.toString()+"\n");
                wr.flush();
                System.out.println("json2 enviado..");
                System.out.println(json2);
                
                wr.close();
                //envío de texto
                /*PrintWriter pw = new PrintWriter(new OutputStreamWriter(cl.getOutputStream()));
                String mensaje= "un mesaje largo largo largo largo.... ";
                //pw.println(mensaje);
                pw.print(mensaje+"\n\r");
                pw.flush();
                */
                /**DataOutputStream*******
                //datos primitivos
                DataOutputStream dos = new DataOutputStream(cl.getOutputStream());
                int v1=1;
                float v2=2.0f;
                long v3= 3;
                String v4= "cuatro";
                dos.writeInt(v1);
                dos.flush();
                dos.writeFloat(v2);
                dos.flush();
                dos.writeLong(v3);
                dos.flush();
                dos.writeUTF(v4);
                dos.flush();
                System.out.println("datos enviados");
                ***/
                cl.close();
            }//for
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
