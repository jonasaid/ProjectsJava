/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


public class ModeloRepartidor extends ModeloPersona{    
    private String transporte, tiempoEstimado;
    int edad, score;
         
    public ModeloRepartidor(String transporte, int edad, String tiempoEstimado, String nombre,  int score) {
        super(nombre);
        this.transporte = transporte;
        this.tiempoEstimado = tiempoEstimado;
        this.edad = edad;
        this.score = score; 
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    public String getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(String tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }
    
}
