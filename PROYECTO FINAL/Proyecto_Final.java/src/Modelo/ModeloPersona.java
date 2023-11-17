/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author jona-
 */
public abstract class ModeloPersona {    
    private String nombre;
    private int id;

    public ModeloPersona() {}

    public ModeloPersona(String nombre) {
        this.nombre = nombre;
    }
    
    
    public String getNombrePersona() {
        return nombre;
    }

    public void setNombrePersona(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public boolean validarNombre(){
        boolean validar=true;
        if(nombre.contains("0")||nombre.contains("1")||nombre.contains("2")||nombre.contains("3")||
        nombre.contains("4")||nombre.contains("5")||nombre.contains("6")||nombre.contains("7")||
        nombre.contains("8")||nombre.contains("9")){
            
        validar = false;
        }
        return validar;
    }
        
}
