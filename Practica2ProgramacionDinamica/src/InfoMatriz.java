/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jona-
 */
public class InfoMatriz {
    //Valor de la celda
    public int numero; 
     //La etiqueta de la celda (Diagonal, Superior o Izquierda)
    public String etiqueta; 
    //Que inicialicemos este atributo así, significa que, el color será negro.
    public String color = ""; 
    //Vector de posiciones i j, dentro de cada posición de este vector esta el par de coordenadas ij
    public PosicionesIJ[] posicionesIJ;
    
    //Sobreescribimos el método toString para que cuando se made a imprimir, se muestre 
    //el numero y la etiqueta de la celda y no la dirección del objeto
    @Override
    public String toString() {
        return  "["+numero + "-"+etiqueta+"]";
    }
}

