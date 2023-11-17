import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;
public class Cliente_ftp{
    static Seleccion selector=null;
	public static void main(String[] args) throws Exception{
            String ip=JOptionPane.showInputDialog("Favor de introducir la IP a la cual desea conectarse");
            Socket cl = new Socket(InetAddress.getByName(ip),9999);
            //System.out.println("Cliente conectado..\n transfiriendo archivo..");
            selector=new Seleccion();
            BufferedInputStream bis = new BufferedInputStream(cl.getInputStream());
            //BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("cancion2.mp3"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(selector.getArchivo().getAbsolutePath()));
            cl.setSoTimeout(3000);
            byte[] buf = new byte[1024];
            int leidos;
            while((leidos=bis.read(buf,0,buf.length))!=-1){
                    bos.write(buf,0,leidos);
                    bos.flush();
                    }//while
            bis.close();
            bos.close();
            System.out.println("Archivo copiado....");
		
	}//main
	
}//class