/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jona-
 */
public class CuentaInversion {
    //Definimos los atributos que tendra la clase. 
    String id, nombre;
    double balance, tarifa; 
    
    //Creamos el constructor que usaremos. 
    CuentaInversion(String id, String nombre, double balance, double tarifa){
        this.id = id;
        this.nombre = nombre;
        this.balance = balance;
        this.tarifa = tarifa;
    }
    
    //Devuelve el interés calculado, además de que el balance es modificado 
    //sumandole el interés.
    double CalcularIntereses(){
        double interes = balance * tarifa;
        balance += interes;
        return interes;
    }
    
    //Regresa el valor que tiene balance
    double ObtenerBalance(){
        return balance; 
    }
    
    //Suma al balance la cantidad que se pase como argumento
    void Deposito(double cantidad){
      balance += cantidad;  
    }
    
    //
    boolean Retiro(double cantidad){
        boolean operacion = false; 
        if(cantidad < balance){
            balance -= cantidad;
            operacion = true;
        }
            
        return operacion; 
    }
    
}
