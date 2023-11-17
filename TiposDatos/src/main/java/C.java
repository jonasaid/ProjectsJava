import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 *
 * @author axele
 */
public class C {
    public static void main(String[] args){
        try{
            int pto=9999;
            Socket cl = new Socket("127.0.0.1",pto);
            System.out.println("Conexion con servidor establecida, recibiendo datos..");
            InputStreamReader isr = new InputStreamReader(cl.getInputStream(),StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);         
            //StringBuilder sb = new StringBuilder();
            String line;         
            line = br.readLine();   ///JSON1
            System.out.println("JSON recibido: \n"+line);
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(line);
            String nombre = (String) json.get("nombre");
            System.out.println("nombre:"+nombre);
            String apaterno = (String) json.get("apaterno");
            System.out.println("apellido paterno:"+apaterno);
            String amaterno = (String) json.get("amaterno");
            System.out.println("apellido materno:"+amaterno);
            /******************************************/
            String line2 = br.readLine();////JSON2
            System.out.println("\nJSON2 recibido:\n "+line2);
            JSONParser parser2 = new JSONParser();
            JSONObject json2 = (JSONObject) parser2.parse(line2);
            String nombre2 = (String) json2.get("nombre");
            System.out.println("nombre:"+nombre2);
            int edad = ((Long)json2.get("edad")).intValue();
            System.out.println("edad:"+edad);
            JSONArray lenguajes = (JSONArray) json2.get("conocimientos");
            Iterator i = lenguajes.iterator();
            while(i.hasNext()){
                JSONObject tmp = (JSONObject)i.next();
                System.out.println("ob:"+ tmp);
                String lenguaje1 = (String)tmp.get("lenguaje1");
                System.out.println("Lenguaje1: "+lenguaje1);
                String lenguaje2 = (String)tmp.get("lenguaje2");
                System.out.println("Lenguaje2: "+lenguaje2);
                String lenguaje3 = (String)tmp.get("lenguaje3");
                System.out.println("Lenguaje3: "+lenguaje3);

              

            }//while
            
            
            
            
            
            
           
           //orientado a caracter
            /*
            BufferedReader br = new BufferedReader(new InputStreamReader(cl.getInputStream()));
            String datos = br.readLine();
            System.out.println("Mensaje recibido: "+datos);
            */
            
            //datos primitivos
            /*
            DataInputStream dis = new DataInputStream(cl.getInputStream());
            int v1 = dis.readInt();
            System.out.println("v1:"+v1);
            float v2 = dis.readFloat();
            System.out.println("v2:"+v2);
            long v3 = dis.readLong();
            System.out.println("v3:"+v3);
            String v4 = dis.readUTF();
            System.out.println("v4:"+v4);
            */
            cl.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
