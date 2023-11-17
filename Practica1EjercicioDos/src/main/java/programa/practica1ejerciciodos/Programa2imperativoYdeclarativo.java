/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa.practica1ejerciciodos;

import java.util.Arrays;//proporciona múltiples métodos para manipular Arrays sobre múltiples tipos de datos
import java.util.List;//Permite agrupar una colección de elementos en forma de lista



/**
 *
 * @author jona-
 */
public class Programa2imperativoYdeclarativo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Practica 1 ejercicio 2, encontrar en una lista de colores si se encuentra el color rojo
        //19 Marzo 2021, Java 8 net beans 12.1, Jonathan Gómez Marbán y Rogelio Hernández Vázquez
        
        boolean hasRed = false;
        String[ ] colors = {"azul", "amarillo", "verde", "morado", "blanco", "rojo"}; //se declara e inicializa el arreglo "colors"
        
        System.out.println("********* IMPERATIVO ***********");
        for(String color : colors){ // Se recorre el arreglo iterando sobre cada posicion del arreglo y se va guardando en "color" 
            if(color.equals("rojo")){// se verifica si es igual a la cadena rojo
                hasRed= true;//En caso de serlo se sale del ciclo, cambiando el valor booleano
                break;
            }
        }
        System.out.println("¿El color es rojo? " + hasRed);// se imprime el resultado
 
        
        System.out.println("********* DECLARATIVO ***********");
        // se declara una lista de tipo String y se inicializa con los valores del arreglo "colors" 
        List<String> coloresLista = Arrays.asList(colors);
        System.out.println("¿El color es rojo?:" + coloresLista.contains("rojo"));// se imprime el resultado
    } 
    
}                                                                           
