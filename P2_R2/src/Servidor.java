import java.net.*;
import java.io.*;

public class Servidor{
	public static void main(String[] args)throws Exception{
		Disco [] disco = getDiscos();
		for(int i=0, num=disco.length; i < num; i++){
			System.out.println("-----------------");
			System.out.println("Disco: "+disco[i].getTitulo());
			System.out.println("Artista: "+disco[i].getArtista());
			System.out.println("Genero: "+disco[i].getGenero());
			System.out.println("Precio: "+disco[i].getPrecio());
			System.out.println("Imagen: "+disco[i].getNombreImagen());
			System.out.println("Cantidad: "+disco[i].getCantidad());
			System.out.println("-----------------");
		}
		
		ServerSocket ss = new ServerSocket(8500);
		System.out.println("Servidor iniciado");
		for(;;){
			Socket cl = ss.accept();
			ObjectOutputStream oos = new ObjectOutputStream(cl.getOutputStream());
			oos.writeObject(disco);
			
			while(true){
				Socket cl2 = ss.accept();
				Socket cl3 = ss.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(cl2.getInputStream()));
				String nombreArchivo=br.readLine();
				System.out.println(nombreArchivo);
				if(nombreArchivo.equals("Ya"))
					break;
				BufferedOutputStream bos = new BufferedOutputStream(cl3.getOutputStream());
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream("images\\"+nombreArchivo));
				int leidos=0;
				int completados=0;
				byte[] buf = new byte[1500];
				int fin;
				int tam_bloque=(bis.available()>=1500)? 1500 :bis.available();
				int tam_arch = bis.available();
				int b_leidos;
				while((b_leidos=bis.read(buf,0,buf.length))!= -1){
					bos.write(buf,0,b_leidos);
					bos.flush();
					leidos += tam_bloque;
					completados = (leidos * 100) / tam_arch;
					System.out.println("Completado: "+completados+" %");
					tam_bloque=(bis.available()>=1024)? 1024 :bis.available();
				}//while
				bis.close();
				bos.close();
			}
			Socket cl4 = ss.accept();
			Socket cl5 = ss.accept();
			
			ObjectInputStream ois = new ObjectInputStream(cl4.getInputStream());
			Disco [] carrito = (Disco [])ois.readObject();
                        for(int i=0, numDisco=disco.length; i<numDisco;i++){
                            for(int n=0, numCarrito = carrito.length; (n < numCarrito && carrito[n]!=null); n++){
                                if(carrito[n].getTitulo().equals(disco[i].getTitulo())){
                                    disco[i].setCantidad(disco[i].getCantidad()-carrito[n].getCantidad());
                                    break;
                                }
                            }
                        }
			String ticket=" Se realizo la venta \n";
			float total= 0.0f;
			for(int i=0, numCarrito = carrito.length; (i < numCarrito && carrito[i]!=null); i++){
				total += carrito[i].getCantidad()*carrito[i].getPrecio();
				ticket+=" Album: "+carrito[i].getTitulo()+" -- "+ "Precio: "+carrito[i].getPrecio()+ " -- ";
				ticket+="Subtotal: "+(carrito[i].getCantidad()*carrito[i].getPrecio())+ "\n";
			}
			ticket+="---------------------------Total : "+total+"\n";
			ticket+=null;
			System.out.println(ticket);
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(cl5.getOutputStream()));
			pw.println(ticket);
			pw.flush();
		}	
	}
	
	public static Disco [] getDiscos(){
		Disco [] disco =  null;
		try{
			File archivo = new File ("Discos.txt");
			FileReader fr = new FileReader (archivo);
			BufferedReader br = new BufferedReader(fr);
			String linea = "";
			String [] datos;
			int numeroDiscos=1,i=0,num=0;	
			while(br.readLine() != null)
				numeroDiscos++;
			fr = new FileReader (archivo);	
			br = new BufferedReader(fr);
			disco = new Disco[numeroDiscos];
			while((linea = br.readLine()) != null){
				datos = linea.split(",");
				disco[i] = new Disco();
				disco[i].setTitulo(datos[1]);
				disco[i].setArtista(datos[0]);
				disco[i].setGenero(datos[2]);
				disco[i].setPrecio(Float.parseFloat(datos[3]));
				disco[i].setNombreImagen(datos[4]);
				disco[i].setCantidad(i+1);
                                i++;
			}
		}
		catch(FileNotFoundException f){
			System.out.println(f);
		}
		catch(IOException e){
			System.out.println(e);
		}
		return disco;
	}
}