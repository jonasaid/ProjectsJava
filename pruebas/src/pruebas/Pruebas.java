/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.function.Supplier;

/**
 *
 * @author jona-
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
         
        // Declaracion de los valores para las operaciones cuad y division
        evaluacion (3,1,0);
    }
    //Metodo encargado de elevar un numero al cuadrado 
    public static int cuad(int x){
        return x*x;
    }

    //Metodo que engloba las dos evaluaciones Lazy y Eager
    //Recibe tres parametros de tipo entero(3,1,0)
    public static void evaluacion( int a, int b, int c){
        //Se imprime el resultado de Lazy y realiza la operacion de division
        System.out.println("Lazy: " + lazyEvaluatorPrim(cuad(a),() -> b/c));
        //Se imprime el resultado de Eager y realiza la operacion de division
        //En este caso nos maracara un error de compilacion porque no esta definida la division
        System.out.println("Eager: " + eagerEvaluatorPrim(cuad(a), 1/0));
    }
   //Se encargara de jerarquizar las operaciones que fungen como parametros 
   public static int lazyEvaluatorPrim( int x, final Supplier<Integer> y){
       return x;
   }
   //Se encargara de jerarquizar las operaciones que fungen como parametros 
   public static int eagerEvaluatorPrim( final int x, final int y){
       return x;
   
        
    }
    
}
