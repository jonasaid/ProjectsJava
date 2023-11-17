
import java.time.LocalTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jona-
 */
public class Terror extends Pelicula{
    //Creamos los atributos de una de las clases nietas
    private String personajeTerror;
    private double nivelMedio;

    //Este es el constructor y tiene un parametro más agregado que el de la clase Cine 
    public Terror(String nombre, int duracionMin, int apariciones, String director, String serMaligno) {
        super(nombre, duracionMin, apariciones, director);
        personajeTerror = serMaligno;
    }
    
    @Override//metodo venderEntrada() sobre escrito, asignamos el valor del primer parametro al atributo nivelMiedo, el resto es la misma implementación que de su clase padre
    double venderEntrada(double nivel, int personas){
        nivelMedio = nivel;
        return super.venderEntrada(nivelMedio, personas);
    }

    @Override//metodo imprimirPelicula() sobre escrito, agregamos a la implementacion que imprima los demás atributos
    void imprimirPelicula(){
        super.imprimirPelicula();
        System.out.println(personajeTerror+" es el ser maligno de esta peli y tiene una calificacion de " + nivelMedio + " segun la critica\n");
    }
}
