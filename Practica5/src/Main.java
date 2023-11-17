
import java.util.ArrayList;
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
public class Main {
    
    public static void main(String[] args) {
        //Aqui estan los 3 constructores de las 3 clases hijas (Comedia, Terro y Accion), recordemos que la clase padre es Pelicula}
        //Recordemos que la estructura del constructor sería algo como: Genero(nombre, duracion de la pelicula en minutos, cuantos horarios tiene, director, los siguientes datos dependiendo de que clase se trabaje).
        Comedia comedia = new Comedia("El dictador", 99, 3,"Larry Charles", 10, 45);
        Terror terror = new Terror("El conjuro", 112, 7,"James Wan", "Balak");
        Accion accion = new Accion("Django", 165, 10,"Quentin Tarantino", 4, 3);
        
        //Creamos una Lista de la clase Pelicula a la cual vamos agregando los objetos instanciados anteriormente
        //Notemos que estos objetos se comportan polimorficamente, ya que, a pesar de haber sido instanciados como un Genero en especifico
        //los estamos añadiendo a una Lista de tipo Pelicula, es decir, los objetos para este caso se comportan como un objeto de la clase Pelicula. 
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(comedia);
        peliculas.add(terror);
        peliculas.add(accion);
        
        //Aqui tenemos el constructor del Cine el cual recordemos esta agregado con la clase Pelicula
        Cine cine = new Cine("Cinemex", "Las Americas, Ecatepec de Morelos, Edo. Mex.",peliculas);
        
        //En el primer parametro del metodo venderEntrada() donde introducimos el valor del atributo double de todas las clases hijas (nivelFelicidad, nivelMiedo y nivelViolencia)
        //En el segundo parametro introducimos cuantos boletos se venderán.
        //Notese que cada metodo tiene una implementación distinta y dependiendo por el objeto que sea llamado el metodo estará implementado de manera distinta, similar en el procedimiento, 
        //pero en los valores que recibe y que regresa son distintos, a lo que se le denomina que el método está sobre escrito, tambien podemos decir que este es un método polimorfico,
        //ya que, se comporta diferente dependiendo de su contexto.
        //Este método recordemos que nos regresa un double (que representa cuanto se vendió en total de cada peli), este lo asignamos a una variable para posteriormente imprimirlo
        double vendidoC = comedia.venderEntrada(8.7, 5);
        double vendidoT = terror.venderEntrada(7.9, 2);
        double vendidoA = accion.venderEntrada(9, 10);
        
        //Imprimimos la informacion del cine con el metodo que implementamos (nombre y ubicacion).
        cine.imprimirCine();
        //Utilizamos el método de impresion que existe en cada clase, cada objeto llama al método de impresion resprectivo de su clase, por lo que se dice que se está sobre escribiendo el método de su clase padre.
        System.out.println("************************************** CARTELERA *****************************************\n");
        comedia.imprimirPelicula();
        terror.imprimirPelicula();
        accion.imprimirPelicula();
        
        //Imprimimos los valores de las variables donde hemos guardado cuanto se vendió en total de cada peli
        System.out.println("************************************** GANANCIAS *****************************************");
        System.out.println("Se vendió "+vendidoC+" pesos de la pelicula de Comedia");
        System.out.println("Se vendió "+vendidoT+" pesos de la pelicula de Terror");
        System.out.println("Se vendió "+vendidoA+" pesos de la pelicula de Accion");
    }
    
}
