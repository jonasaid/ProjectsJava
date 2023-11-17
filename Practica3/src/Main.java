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
    public static void main(String [] args){
        //Instanciamos un objeto de la clase que creamos (CuentaInversion)
        CuentaInversion ci1 = new CuentaInversion("1","Roger",1000,.05);//=> id="1", nombre="Roger", balance=1000, tarifa=.05
        
        //Usamos el método Deposito, la cantidad que pasemos como argumento se sumará 
        //con el atributo balance => 1000+100=1100. Balance = 1100
        ci1.Deposito(100);
        
        //Usamos el metodo Retiro que regresa un boolean, si el valor de retorno es igual a false
        //significa que se intenta retirar más dinero del que se tiene en el balance, por lo tanto,
        //manda un mensaje de error. Si el valor de retorno del método es verdadero se le resta la  
        //cantidad recibida al balance => 1100-500=600. Balance = 600
        if(ci1.Retiro(500) == false){
            System.out.println("No es posible retirar el dinero");
        }
        
        //Este método obtiene el interés, a través de la multiplicacién de la tarifa por el balance
        //Después, el interés obtenido se suma con el balance. Este método regresa el interés calculado.
        //600(.05)=30 => Interes = 30 y Balance=630
        ci1.CalcularIntereses();
        
        //Imprimimos el resultado, esto lo hacemos a través del método ObtenerBalance que nos regresa el
        //balance => Balance = 630
        System.out.println("El balance es: " + ci1.ObtenerBalance());
        
        
        
        //Instanciamos un segundo objeto de la clase que creamos (CuentaInversion)
        CuentaInversion ci2 = new CuentaInversion("2","Jona",255.5,.2);//=> id="2", nombre="Jona", balance=255.5, tarifa=.2
        
        //255.5+300=555.5 => balance = 555.5
        ci2.Deposito(300);
        
        
        //555.5-600 = la operacion no procede, por lo que, el valor de balance sigue siendo el mismo. balance=555.5
        if(ci2.Retiro(600) == false){
            System.out.println("No es posible retirar el dinero");
        }
        
        
        //555.5(.2)=111.1 => Interes = 111.1. Balance=666.6
        ci1.CalcularIntereses();
        
        //Imprimimos el resultado, esto lo hacemos a través del método ObtenerBalance que nos regresa el
        //balance => Balance = 666.6
        System.out.println("El balance es: " + ci2.ObtenerBalance());
    }
}
