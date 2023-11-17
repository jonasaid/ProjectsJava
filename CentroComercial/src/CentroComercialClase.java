
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jona-
 */
public class CentroComercialClase {
    //Creamos los atributos de la clase principal
    private String domicilio, nombre;
    private double superficie;
    private Estacionamiento estac = new Estacionamiento(); // usamos el constructor de Estacionamiento (COMPUESTO)
    private TiendaDepartamental tienda = new TiendaDepartamental("",""); // usamos el constructor de TiendaDepartamental (COMPUESTO)
    private Restaurante restaurante; // creamos una variable de restaurante
   
    CentroComercialClase(Restaurante restaurante){} //El constructor de esta clase solo recibe un objeto de la clase Restaurante
    
    //Obtenemos el domicilio
    public String getDomicilio() {
        return domicilio;
    }

    //Modficamos el valor del atributo domiclio    
    public void setDomicilio(String dom) {
        domicilio = dom;
    }

    //Obtenemos el valor del atributo nombre
    public String getNombre() {
        return nombre;
    }

    
    //Modficamos el valor del atributo Nombre
    public void setNombre(String nom) {
        nombre = nom;
    }
    
    //Obtenemos el valor del atributo superficie
    public double getSuperficie() {
        return superficie;
    }

    
    //Modficamos el valor del atributo superficie
    public void setSuperficie(double metros2) {
        superficie = metros2;
    }

    //Obtenemos el objeto estac
    public Estacionamiento getEstac() {
        return estac;
    }

    //Obtenemos el objeto tienda
    public TiendaDepartamental getTienda() {
        return tienda;
    }
    
    //Obtenemos el objeto restaurante
    public Restaurante getRestaurante() {
        return restaurante;
    }

    //Imprimimos todos los valores de los atributos del objeto que mande a llamar este metodo
    public void imprimirCM(){
        System.out.println("\nEl nombre del centro comercial: " + nombre + "\nEl domicilio es: " + domicilio + " y abarca " + superficie  + " m^2");
        System.out.println("El estacionamiento tiene " + estac.getSuperficie() + " m^2" +", hay "+ estac.getNumCarros() + " carros. Recuerda que los primeros " + estac.getMinutos() + " minutos son gratis y el estacionamiento esta disponible de " + estac.getHorario()+ "\n");
        System.out.println("La tienda departamental es: " + tienda.getNomTienda() + " su giro es " + tienda.getProducto() + ", el horario que maneja es de " + tienda.getHorario() + " y solo puede haber " + tienda.getCupoMaximo()+" personas en la tienda debido a la pandemia");
    }
    
}
