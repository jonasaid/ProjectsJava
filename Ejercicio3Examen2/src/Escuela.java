/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jona-
 */
public class Escuela {
    protected String nombre, siglas_esc;
    private String direccion; 
    
    Escuela(String nombre,String siglas_esc){
        this.nombre = nombre;
        this.siglas_esc= siglas_esc;
    }

    public String get_Nombre() {
        return nombre;
    }

    public void set_Nombre(String nombre) {
        this.nombre = nombre;
    }

    public String get_Siglas_esc() {
        return siglas_esc;
    }

    public void set_Siglas_esc(String siglas_esc) {
        this.siglas_esc = siglas_esc;
    }

    public String get_Direccion() {
        return direccion;
    }

    public void set_Direccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
