/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jona-
 */
public class Estudiante extends Escuela{
    protected String carrera;
    protected int semestre;

    public Estudiante(String nombre, String siglas_esc, String carrera, int semestre) {
        super(nombre, siglas_esc);
        this.carrera = carrera; 
        this.semestre = semestre; 
    }

    public String get_Carrera() {
        return carrera;
    }

    public void set_Carrera(String carrera) {
        this.carrera = carrera;
    }

    public int get_Semestre() {
        return semestre;
    }

    public void set_Semestre(int semestre) {
        this.semestre = semestre;
    }
    
}
