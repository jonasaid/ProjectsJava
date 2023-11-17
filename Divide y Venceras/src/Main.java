/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jona-
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;

public class Main {
    
    String x,y;        
    
    public String convertirEnteroCadena(int numero){
        return String.valueOf(numero);
    }
    
    public int longitudNumero(int numero){
        String numeroC = convertirEnteroCadena(numero);
        return numeroC.length();
    }
    
    public int faltanCeros(int numero){
        int ceros=0;
        if (numero <= 2)
            return ceros;
        int i = 2;
        int longitud = longitudNumero(numero);
        while(i < longitud){
            i *= 2;
        }
        ceros = i - longitud;
        return ceros;
    }           
    
    public String agregarCeros(int numero){
        String numeroCompleto = "";
        int i,cerosAgregar = faltanCeros(numero);
        String numeroIncompleto = convertirEnteroCadena(numero);
        for(i = 0; i < cerosAgregar; i++){
            numeroCompleto = numeroCompleto + "0";
        }
        return numeroCompleto + numeroIncompleto;
    }
    
    public String agregarCeros(String numero, int ceros){
        String numeroCompleto = "";
        int i;
        for(i = 0; i < ceros; i++){
            numeroCompleto = numeroCompleto + "0";
        }
        return numeroCompleto + numero;
    }
    
    public void igualarLongitud(String numero1, String numero2, int base){
        int x = Integer.valueOf(numero1,base);
        int y = Integer.valueOf(numero2,base);
                
        int longitudX = longitudNumero(x), longitudY = longitudNumero(y);
        int max = Integer.max(x,y);
        int longitudMax = Integer.max(longitudX, longitudY);
        
        String maxC = agregarCeros(max);
        this.x = convertirEnteroCadena(x);
        this.y = convertirEnteroCadena(y);  
        
        if(longitudMax == longitudX){
            this.y = agregarCeros(this.y, maxC.length() - longitudY);
            this.x = maxC;
        }else if(longitudMax == longitudY){
            this.x = agregarCeros(this.x, maxC.length() - longitudX);
            this.y = maxC;
        }      
        //System.out.println(this.x+" y " +this.y);
    }
    
    public String productoNormal(String x, String y){
        int nuevaX = Integer.parseInt(x);
        int nuevaY = Integer.parseInt(y);
        int valor = nuevaX * nuevaY;
        //System.out.println(x+" y "+ y);
        String producto = String.valueOf(valor);
        return producto;
    }
    
    public String dividir(String numero, String lado, int base){
        int i, longitudM = numero.length()/2;
        StringBuffer valores = new StringBuffer();
        
        if("i".equals(lado.toLowerCase())){
            for(i=0; i < longitudM; i++){
                valores.insert(i, numero.charAt(i));
            }    
        }else if ("d".equals(lado.toLowerCase())){
            int t=0;
            for(i=longitudM; i < numero.length(); i++){ 
                valores.insert(t, numero.charAt(i));
                t++;
            }
        }else{
            return "ERROR";
        }
        
        String numeroDiv = String.valueOf(valores);        
        return numeroDiv;        
    }
    
    public String multiplica(String x, String y, int n, int base){     
        x = agregarCeros(x,n - x.length());   
        y = agregarCeros(y,n - y.length());
        
        if(x.length()==1 && y.length()==1){
            return productoNormal(x,y);
        }
        String xi = dividir(x,"i",base);
        String xd = dividir(x,"d",base);
        String yi = dividir(y,"i",base);
        String yd = dividir(y,"d",base);
        
        String p1 = multiplica(xi, yi, n/2, base);             
        String p2 = multiplica(String.valueOf(Integer.parseInt(xi) + Integer.parseInt(xd)), String.valueOf(Integer.parseInt(yi) + Integer.parseInt(yd)), n/2, base);            
        String p3 = multiplica(xd, yd, n/2, base); 

        int producto1 = Integer.parseInt(p1);
        int producto2 = Integer.parseInt(p2);
        int producto3 = Integer.parseInt(p3);

        int resultado = (int) ((Math.pow(base, n) * producto1) + (Math.pow(base, n/2) * (producto2 - producto1 - producto3)) + producto3);
        String nuevoResultado;
        
        if(base == 16){
            nuevoResultado = Integer.toHexString(resultado);
        }else if(base == 2){
            nuevoResultado = Integer.toBinaryString(resultado);
        }else{            
            nuevoResultado = String.valueOf(resultado);
        }
        return nuevoResultado;
    }
        
    public static void main(String[] args) {
        Main main = new Main();
        main.igualarLongitud("1","9876",10);
        System.out.println(main.x +" y "+main.y);
        String resultado = main.multiplica(main.x, main.y, main.x.length(), 10);
        System.out.println(resultado);
    }
    
}
