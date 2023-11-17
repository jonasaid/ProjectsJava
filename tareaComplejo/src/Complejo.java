/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jona-
 */
public class Complejo {
    private int re;// Parte real; solo la clase tiene acceso
    private int im; // Parte imaginaria;"""
    // Primer constructor 
    Complejo( ){
        re = 1;
        im = 1;
    }            
    //Segundo constructor
    Complejo(int r,int i){
        re = r;
        im = i;
    }
    //Terce r constructor
    Complejo(Complejo var){
        re = var.re;// var.re es la parte real del objeto var 
        im = var.im; // var.im es l a pa rte imaginaria del
    }//objeto var
    
    //Continuación de la elase Complejo
    // Definición de los métodos de suma
    Complejo sumar(Complejo var ){
        Complejo var1 = new Complejo();
        var1.re = this.re + var.re;
        var1.im = this.im + var.im;
        return var1;
    }
    
    void sumar(Complejo var1, Complejo var2 ){
        re = var1.re + var2.re;
        im = var1.im + var2.im;
    }
    

    
    // Definición de los métodos de resta
    void restar(Complejo var){
        re = re - var.re;
        im = im - var.im;
    }    
    
    //Conti nuación de la clase Complejo
    // Continuación de la definición de los método de resta
    void restar(Complejo var1, Complejo var2 ){
        re  = var1.re - var2.re;
        im = var1.im - var2. im;
    }
    
    // Definición del método imprimir que despliega los
    //valores de la parte real e imaginaria de un objeto
    
    void imprimir( ){
        System .out.println("re = "+ re + " im = "+ im);
    }
    
    //Metodo igualQue, permite saber si un numero Complejo 
    //es igual a otro o no.
     boolean igualQue(Complejo var){
        boolean igual=false;
        if(var.re == re)
            if (var.im == im) {
                igual=true;
            }
        return igual;
    }
    
}// Fin de l a clase Complejo

 
