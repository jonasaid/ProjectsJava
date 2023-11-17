/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jona-
 */
public class UsoComplejo {
    public static void main(String [] args){
    //Creamos tres instancias de la clase Complejo
    //usando los tres constructores.
    //Las varia bles A, B, y C son referencias a un Complejo.
    //El operador new genera la memoria para la
    //instancia de la clase Complejo.
    
    // Primer constructor sin argumentos
    Complejo A = new Complejo( );
    
    //Segundo constructor con dos argumentos enteros
    Complejo B = new Complejo(5, 8);
    
    //Tercer constructor con argumento tipo Complejo
    // C es inicializado con los valores de B 
    Complejo C = new Complejo(B);
    
    
    // Uso de los métodos.                            
    // Imprimimos el contenido de cada objeto
    // mediante el método im primir( )
    A.imprimir( ); 
    B.imprimir( ); 
    C.imprimir( );
    
    //Ahora sumamos A con B, esto es:A = A + B"
    A.sumar(B);
    
    //Comproba mos la suma con el método impri mir( ) 
    //A.imprimir( );
    
    //Ahora sumamos A con B y asignamos el resultado al
    //objeto C, esto es: C = A + B"
    //C.sumar(A, B);
 
    //Comprobamos la suma con el método imprimir( ) 
    C.imprimir( );
    
    if(A.igualQue(A)){
        System.out.println("Los complejos son iguales");
    }else{
        System.out.println("Los complejos no son iguales");
    }

    Complejo D = C.sumar(B);
    D.imprimir();
    
    }//fin del metodo main()    
}//fin de la clase UsoComplejo
    
