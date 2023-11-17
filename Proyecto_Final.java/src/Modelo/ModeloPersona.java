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
public abstract class ModeloPersona{    
    private String nombre;
    private int id;

    public ModeloPersona(){}

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
    
    public abstract boolean validarNombre();
        
}
