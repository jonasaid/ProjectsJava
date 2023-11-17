/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jona-
 */
public class PosicionesIJ {
    //Representa la posición i y el otro la j.
    public int posicionI, posicionJ;
    
    //Sobreescribimos el método toString para que cuando se made a imprimir, se muestre 
    //la posición i y j, en vez de la dirección del objeto.
    @Override
    public String toString() {
        return  "["+posicionI + ","+posicionJ+"]";
    }
}
