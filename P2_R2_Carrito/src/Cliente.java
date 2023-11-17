import java.net.*;
import java.io.*;

public class Cliente{
    
        public static String generarRuta(){
            File f = new File("");
            String ruta = f.getAbsolutePath();
            String carpeta="MiMusica";
            String ruta_archivos = ruta+"\\"+carpeta+"\\";
            System.out.println("ruta:"+ruta_archivos);
            File f2 = new File(ruta_archivos);
            f2.mkdirs();
            f2.setWritable(true);
            return ruta_archivos;
        }

	public static void main(String[] args)throws Exception{
		Socket cl = new Socket("localhost",8500);
		System.out.println("Conexion con servidor exitosa");
		ObjectInputStream ois = new ObjectInputStream(cl.getInputStream());
		Disco [] disco = (Disco [])ois.readObject();
		
		/*ObjectOutputStream oos = new ObjectOutputStream(cl.getOutputStream());
		//ObjectInputStream ois = new ObjectInputStream(cl.getInputStream());
		Objeto ob = new Objeto(5,4);
		oos.writeObject(ob);*/
		
		for(int i=0, num=disco.length; i < num; i++){
				Socket cl2 = new Socket("localhost",4444);
				Socket cl3 = new Socket("localhost",4445);
				
				System.out.println("-----------------");
				System.out.println("Disco: "+disco[i].getTitulo());
				System.out.println("Artista: "+disco[i].getArtista());
				System.out.println("Genero: "+disco[i].getGenero());
				System.out.println("Precio: "+disco[i].getPrecio());
				System.out.println("Imagen: "+disco[i].getNombreImagen());
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(cl2.getOutputStream()));
				pw.println(disco[i].getNombreImagen());
				pw.flush();
				
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("imagec\\"+disco[i].getNombreImagen()));
				BufferedInputStream bis = new BufferedInputStream(cl3.getInputStream());
				
				//cl2.setSoTimeout(3000);
				byte[] buf = new byte[1500];
				int leidos;
				while((leidos=bis.read(buf,0,buf.length))!=-1){
					bos.write(buf,0,leidos);
					bos.flush();
					}//while
				bis.close();
				bos.close();
				System.out.println("Archivo copiado....");
		}
		Socket cl2 = new Socket("localhost",3001);
		Socket cl3 = new Socket("localhost",3002);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(cl2.getOutputStream()));
		pw.println("Ya");
		pw.flush();
	}
}
