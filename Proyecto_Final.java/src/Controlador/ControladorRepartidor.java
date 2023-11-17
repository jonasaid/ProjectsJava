/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloRepartidor;
import java.util.ArrayList;
import java.util.List;

public class ControladorRepartidor{
    private List<ModeloRepartidor> repartidores = new ArrayList();  
    
    public void agregarRepartidor(String transporte, int edad, String tiempoEstimado, String nombre,  int score){
        ModeloRepartidor repartidor = new ModeloRepartidor(transporte, edad, tiempoEstimado, nombre, score);        
        repartidores.add(repartidor);
    }
    
    public void agregarRepartidor(ModeloRepartidor r){    
        repartidores.add(r);
    }

    public List<ModeloRepartidor> getRepartidores() {
        return repartidores;
    }
   
}
