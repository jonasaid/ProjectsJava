/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jona-
 */
import java.time.LocalTime;//Atributo horario
import java.util.ArrayList;//Constructor time (polimorfica)
import java.util.List;//Atributo horario y time
import java.util.Random;//Objeto rnd

public class Pelicula {
    //Creamos los atributos de la clase Padre
    protected int duracionMin;//Hemos decidido cambiar este atributo a un simple entero, debido a que las peliculas normalmente solo se miden en minutos
    protected List <LocalTime> horario;//Se ha decidido hacer una lista de tipo LocalTime en vez de que solo fuera un valor de LocalTime
    protected String director;
    protected double precio;
    protected String nombre;
    
    //Con este metodo podemos rellenar la lista de horarios (aleatorios) de una pelicula
    //Este metodo regresa una Lista de tipo LocalTime y recibe un entero, el cual representa el numero de horarios
    //que deseamos generar
    public List<LocalTime> llenarLista (int apariciones){
        List<LocalTime> time = new ArrayList<>();//Esta es una accion polimorfica        
        Random rnd = new Random();//El objeto que permitira generar numeros aleatorios
        for(int i=0; i<apariciones; i++){       
            int horas= rnd.nextInt(14)+8;//Generamos un numero aleatorio que tenga como rango desde 8 y su limite sea 22
            int min = rnd.nextInt(5)*10;//Generamos un numero aleatorio que tenga como rango desde 0 y su limite sea 59
            time.add(LocalTime.of(horas, min));//vamos añadiendo a la lista los valores aleatorios obtenidos.
        }
        return time;
    }
 
    //Este es el constructor de la clase
    //Requiere el nombre de la pelicula, la duracion en minutos, cuantos horarios tiene y el nombre del director
    Pelicula(String nombre, int duracionMin,int apariciones,String director){
        this.nombre = nombre;
        this.duracionMin = duracionMin;
        this.horario = llenarLista(apariciones);
        this.director = director;
    }
    
    //Este metodo me permite vender entradas para la pelicula
    //Requiere la calidad de la pelicula (nivel) y cuantos boletos serán (personas)
    //Regresa el total de lo vendido
    //En este metodo tambien damos valor a el atributo precio
    double venderEntrada(double nivel, int personas){
        double precioBase = 8.5;
        this.precio = (int)(precioBase*nivel);
        return (int)(precio*personas);
    }

    //Con este metodo convertimos el valor del atributo duracionMin en un tipo de dato LocalTime
    //Calculando cuanto equivalen los minutos totales en horas.
    //Regresa un LocalTime (HH:MM) y recibe un entero (minutos totales).
    LocalTime convertirHoras(int minutos){
        int horas=0;
        //Iniciamos el for con el valor introducido en el constructor
        //La condicion que se tiene que cumplir es que sea mayor o igual a 59 min
        //El paso será de -60 y esto se le restara al atributo duracionMin, ya que, 
        //Si se cumple la condicion significa que hay mas de 1 hora en la cantidad total de minutos
        //Por lo que, sumaremos 1 al valor de horas.
        for( this.duracionMin = minutos; this.duracionMin>=59; this.duracionMin-=60){
            horas++;
        }
        //Asignamos la variable horas y el atributo duracionMin a una variable LocalTime
        LocalTime duracionPeli = LocalTime.of(horas, this.duracionMin);
        return duracionPeli;
    }
    
    //Imprime los atributos de la clase pelicula
    void imprimirPelicula(){
        System.out.println("El nombre de la peli: "+nombre+"\nDirigida por: "+director+"\nLos horarios en la que esta diponible: "+horario+"\nUn solo boleto cuesta: "
                            +precio+"\nDuración: "+convertirHoras(duracionMin)+" hrs.");
    }
}
