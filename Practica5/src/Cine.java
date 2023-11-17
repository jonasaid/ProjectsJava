
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jona-
 */
public class Cine {
    //Se ha decidido que esta clase en vez de que herede a la clase Pelicula este agregada
    //Creamos los atributos de la clase
    protected String nombre;
    private String ubicacion;
    protected List<Pelicula> peli;//Cambiamos de un tipo Pelicula a una Lista tipo Pelicula
    
    //Este es el constructor de la clase Cine, recibe el nombre, la ubicacion y una lista de peliculas
    public Cine(String nombre, String ubicacion, List<Pelicula> pelis){
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }
   
    //Este metodo imprime los valores de los atributos nombre y ubicacion. 
    void imprimirCine(){
        System.out.println("El nombre del cine es: "+nombre+" que se ubica en: "+ubicacion+"\n");
    }
}
