/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jona-
 */
public class Main {
    public static void main(String[] args) {
        //instanciamos los objetos con sus respectivos constructores
        Mascota mascota = new Mascota();
        Perro perrito = new Perro();
        Gato gatito = new Gato();
        
        mascota.producirSonido();
        mascota = gatito;
        mascota.producirSonido();
        perrito.producirSonido();
        gatito.producirSonido();
    }
}
