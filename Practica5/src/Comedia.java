
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
public class Comedia extends Pelicula{
    //Creamos los atributos de una de las clases nietas
    private int numPersonajesPrincipales, numChistes;
    private double nivelFelicidad;

    //Este es el constructor y tiene 2 parametros más agregados que el de la clase Cine   
    public Comedia(String nombre, int duracionMin, int apariciones, String director, int numPersonajes, int chistes) {
        super(nombre, duracionMin, apariciones, director);
        numPersonajesPrincipales = numPersonajes;
        numChistes = chistes;
    }
    
    @Override//metodo venderEntrada() sobre escrito, asignamos el valor del primer parametro al atributo nivelFelicidad, el resto es la misma implementación que de su clase padre
    double venderEntrada(double nivel, int personas){
        nivelFelicidad = nivel;
        return super.venderEntrada(nivelFelicidad, personas);
    }
    
    @Override//metodo imprimirPelicula() sobre escrito, agregamos a la implementacion que imprima los demás atributos
    void imprimirPelicula(){
        super.imprimirPelicula();
        System.out.println("La pelicula tiene "+numPersonajesPrincipales+" personajes principales, cuentan aproximadamente "+ numChistes+ " chistes y tiene una calificacion de " + nivelFelicidad + " segun la critica\n");
    }
 
   
}
