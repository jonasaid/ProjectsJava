/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jona-
 */
public class EstudianteIntercambio extends Estudiante{
    protected String pais, ciudad;

    public EstudianteIntercambio(String nombre, String siglas_esc, String carrera, int semestre, String pais, String ciudad) {
        super(nombre, siglas_esc, carrera, semestre);
        this.pais = pais;
        this.ciudad = ciudad;
    }

    public String get_Pais() {
        return pais;
    }

    public void set_Pais(String pais) {
        this.pais = pais;
    }

    public String get_Ciudad() {
        return ciudad;
    }

    public void set_Ciudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    
}
