/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 *
 * @author jona-
 */
public class Practica2Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Practica 2 ejercicio 2, encontrar en una lista de 100 números el numero indicado así como la posición en donde se encontró.
        //29 Marzo 2021, Java 8 net beans 12.1, Jonathan Said Gómez Marbán y Rogelio Hernández Vázquez.
        
        List<Integer> numeros = new ArrayList<>();//Declaramos una lista tipo Integer, esta lista contendrá los 100 numeros
        Random rnd = new Random();//Creamos un objeto de la clase Random, nos permitrá generar numeros aleatorios 
        Scanner scan = new Scanner(System.in);//Creamos un objeto de la clase Scanner que nos permitirá leer lo que introduzca el usuario
        
        /*Creamos un objeto de la clase IntStream, que genera un flujo de una secuencia fija de números a partir de un valor inicial hasta 
        un valor final (que es de 0 a 99 en nuestro caso), donde cada número es un incremento de 1 por encima del anterior*/
        IntStream rango = IntStream.rangeClosed(0, 99);
       
        //Utilizamos el objeto de IntStream que nos permite iterar 100 veces con el forEach
        //Luego, con expresion lambda con la que vamos dandole valores a la lista, cuantos valores 
        //podran ingresarse estara determinada por "rango" que en este caso va de 0 a 99.
        //Los numeros que se iran guardando en la lista estaran determinada por el metodo nextInt
        rango.forEach(x -> {
            numeros.add(rnd.nextInt(1000)); //añadimos a la lista el valor que regrese la funcion nextInt que va desde 0 hasta 1000
        });
        System.out.println("La lista es: " + numeros);//mostramos cuales son los 100 elementos que contiene la lista
        int valor = scan.nextInt();//leemos el valor  que introduce el usuario
        /*Buscaremos si el valor que introdujo el usuario esta en la lista y regresaremos la poscion en la que este.Todo esto 
        lo permite el metodo indexOf, que comparara la posicion en la que se esta iterando con el valor que se le pasa como argumento
        y me regresara un valor entero que será, ya sea la posicion donde se encuentra dentro de la lista o sino esta regresa un -1 */
        System.out.println("Se encuentra en la posicion " + numeros.indexOf(valor));
        
    }
    
}
