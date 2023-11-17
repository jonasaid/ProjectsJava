/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1ejercicio3;

import java.util.Scanner;// permite leer datos desde ficheros de texto o incluso desde teclado.
//Math.floorMod() esta definido en java.lang.Math que es un paquete que se carga automáticamente.
/**
 *
 * @author jona-
 */
public class Practica1Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Practica 1 ejercicio 3, obtener el modulo en base 2 de un numero.
        //19 Marzo 2021, Java 8 net beans 12.1, Jonathan Gómez Marbán y Rogelio Hernández Vázquez 
        
        
        Scanner scan = new Scanner(System.in); //Se crea el objeto scan, de la clase Scanner, se ocupa en ambos paradigmas 
        int dividendo;// se declara una variable que se ocupa en imperativo y declaratvo
        
        System.out.println("***********IMPERATIVO***********");
        //se declara las variables para ocupar la formula dividendo = divisor * cociente + residuo
        int cociente, residuo;
        System.out.println("Introduce un número: "); //se solicita un numero
        dividendo = scan.nextInt(); //se lee y guarda ese numero
        cociente = dividendo/2; //se realiza la división para obtener el cociente
        residuo = dividendo - cociente*2;//se despeja residuo de la formula y se hacen las operaciones
        System.out.println(dividendo + " mod 2 es igual a: " + residuo);//se imprime el resultado
        
        System.out.println("***********DECLARATIVO***********");
        System.out.println("Introduce un número: ");
        dividendo = scan.nextInt();
        System.out.println(dividendo + " mod 2 es igual a: " + Math.floorMod(dividendo, 2)); //se usa la funcion Math.floorMod para obtener el modulo
    }
    
}
