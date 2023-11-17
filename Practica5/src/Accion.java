
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
public class Accion extends Pelicula{
    //Creamos los atributos de una de las clases nietas
    private int numPersecuciones, numEnfrentamientos;
    private double nivelViolencia;

    //Este es el constructor y tiene 2 parametros más agregados que el de la clase Cine 
    public Accion(String nombre, int duracionMin, int apariciones, String director, int persecuciones, int enfrentamientos) {
        super(nombre, duracionMin, apariciones, director);
        numPersecuciones = persecuciones;
        numEnfrentamientos = enfrentamientos;
    }
    
    @Override//metodo venderEntrada() sobre escrito, asignamos el valor del primer parametro al atributo nivelViolencia, el resto es la misma implementación que de su clase padre
    double venderEntrada(double nivel, int personas){
        nivelViolencia = nivel;
        return super.venderEntrada(nivelViolencia, personas);
    }
    
    @Override//metodo imprimirPelicula() sobre escrito, agregamos a la implementacion que imprima los demás atributos
    void imprimirPelicula(){
        super.imprimirPelicula();
        System.out.println("La pelicula tiene "+numPersecuciones+" persecuciones, hay "+ numEnfrentamientos+ " enfrentamientos y tiene una calificacion de " + nivelViolencia + " segun la critica\n");
    }
 
}
