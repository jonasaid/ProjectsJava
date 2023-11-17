/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jona-
 */
public class Estacionamiento {
    //Declaramos los atributos de la clase compuesta Estacionamiento
    private int numCarros, minutos;
    private double superficie;
    private String horario;

    Estacionamiento(){}//Este es el constructor de Estacionamiento 
    
    //Obtenemos el valor del atributo numCarros
    public int getNumCarros() {
        return numCarros;
    }

    //Obtenemos el valor del atributo superficie
    public double getSuperficie() {
        return superficie;
    }

    
    //Modificamos el valor del atributo numCarros
    public void setNumCarros(int numCarro) {
        numCarros = numCarro;
    }

    
    //Modificamos el valor del atributo superficie
    public void setSuperficie(double superficiem2) {
        superficie = superficiem2;
    }
    
    //Agregamos los carros que queremos al estacionamiento, el numero que recibe como parametro, 
    //es la cantidad que aumenta
    void ingresarCarro(int num){
        numCarros += num;
    }

    //Obtenemos el valor del atributo minutos
    public int getMinutos() {
        return minutos;
    }

    //Modificamos el valor del atributo minutos    
    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    //Obtenemos el valor del atributo horario
    public String getHorario() {
        return horario;
    }
    
    //Modificamos el valor del atributo horario
    public void setHorario(String horario) {
        this.horario = horario;
    }

    
}
