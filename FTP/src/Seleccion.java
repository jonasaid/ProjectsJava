
import java.io.File;
import javax.swing.JFileChooser;




public class Seleccion {
    static File archivo=null;
    public static void main(String[] args){
      JFileChooser fileChooser = new JFileChooser(); 
      int resultado = fileChooser.showOpenDialog(null);
      if(resultado==JFileChooser.APPROVE_OPTION){
          archivo = fileChooser.getSelectedFile();
          System.out.println("Archivo seleccionado: "+archivo.getAbsolutePath());
      }
    }
      public File getArchivo(){
          return archivo;
      }
      public Seleccion()
      {
          String[] a=new String[0];
          main(a);
      }
    }//main